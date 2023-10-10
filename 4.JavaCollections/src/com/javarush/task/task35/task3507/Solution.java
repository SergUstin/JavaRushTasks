package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + "/";
        File dir = new File(pathToAnimals);
        String[] pathes = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir1, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });
        for (String p : pathes) {
            try {
                final String finalPathToAnimals = pathToAnimals;
                boolean hasInterface = false;
                boolean hasConstructor = false;

                ClassLoader loader = new ClassLoader() {
                    @Override
                    public Class<?> findClass(String className) throws ClassNotFoundException {
                        try {
                            byte[] b = fetchClassFromFS(finalPathToAnimals + className + ".class");
                            return defineClass(null, b, 0, b.length);
                        } catch (FileNotFoundException ex) {
                            return super.findClass(className);
                        } catch (IOException ex) {
                            return super.findClass(className);
                        }
                    }
                };
                String className = p.substring(0, p.length() - 6);
                Class clazz = loader.loadClass(className);

                Class[] interfaces = clazz.getInterfaces();
                for (Class i : interfaces) {
                    if (Animal.class == i) {
                        hasInterface = true;
                        break;
                    }
                }
                if (!hasInterface) continue;

                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors) {
                    if (c.getParameterTypes().length == 0) {
                        hasConstructor = true;
                        break;
                    }
                }
                if (!hasConstructor) continue;
                result.add((Animal) clazz.newInstance());
            } catch (Exception e) {
            }
        }
        return result;
    }


    private static byte[] fetchClassFromFS(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        // Get the size of the file
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}
