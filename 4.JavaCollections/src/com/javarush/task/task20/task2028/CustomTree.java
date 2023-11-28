package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    /**
     * Стартовый корень для дерева;
     */
    Entry<String> root;

    /**
     * Коллекция для хранения элементов дерева.
     */
    private transient ArrayList<Entry<String>> queue;

    /**
     * root инициализируется по умолчанию, и становится первым элементом обозначенным как "новый корневой элемент для
     * текущего уровня дерева"; newLineRootElement - всегда крайний левый нижний элемент дерева.
     */
    public CustomTree() {
        root = new Entry<String>(null);
        root.newLineRootElement = true;
        root.lineNumber = 0;
    }

    /**
     * Метод getParent принимает значение String value, ищет в древе Entry c значением elementName эквивалентным
     * значению value, и возвращает значение elementName у найденного Entry (Entry.parent)
     *
     * @param value elementName переданного Entry
     * @return parent.elementName найденного Entry (Entry.parent)
     */
    public String getParent(String value) {
        setValidCollection();
        String s = null;
        for (Entry<String> entry : queue) {
            if (entry.lineNumber != 1) {
                if (entry.elementName.equals(value)) {
                    s = entry.parent.elementName;
                    break;
                }
            }
        }
        return s;
    }

    /**
     * Метод setUpCollection проходит по дереву, начиная с элемента Entry<String> root и перезаписывает все элементы в
     * queue;
     *
     * @param root начальный элемент Entry<String> для вертикального прохода по дереву.
     */
    private void setUpCollection(Entry<String> root) {
        queue = new ArrayList<>();
        Queue<Entry<String>> subQueue = new LinkedList<Entry<String>>();
        queue.add(root);
        subQueue.add(root);
        do {
            if (!subQueue.isEmpty()) {
                root = subQueue.poll();
            }
            if (root.leftChild != null) {
                queue.add(root.leftChild);
                subQueue.add(root.leftChild);
            }
            if (root.rightChild != null) {
                queue.add(root.rightChild);
                subQueue.add(root.rightChild);
            }
        } while (!subQueue.isEmpty());

    }

    /**
     * Метод setValidCollection записывает полную коллекцию элементов дерева, а затем удаляет 1 элемент коллекции,
     * который является изначальным корнем.
     * Используется в методах remove и т.д. для валидного прохода по коллекции.
     */
    private void setValidCollection() {
        setUpCollection(root);
        queue.remove(0);
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    /**
     * Метод add добавляет элемент в дерево. Сначала устанавливается полная коллекция элементов, потом происходит
     * итерация по элементам. При итерации каждый элемент проверяется методом checkChildren на возможность иметь
     * ветви. isAvailableToAddChildren() возвращает true если такая возможность имеется; После чего создается и
     * инициализируется новый элемент Entry<String>, добавляется в коллекцию. После чего коллекция заного
     * проверяется и инициализируется с помощью setValidCollection();
     *
     * @param s строка (String) которую необходимо добавить в коллекцию;
     * @return true после добавления нового элемента;
     */
    @Override
    public boolean add(String s) {
        setUpCollection(root);
        for (Entry<String> entry : queue) {
            entry.checkChildren();
            if (entry.isAvailableToAddChildren()) {
                createChild(entry, s);
                setValidCollection();
                return true;
            }
        }

        return false;
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    /**
     * Доп. метод для подстраховки. При удалении иногда получается 2 элемента newLineRootElement;
     * Этот метод собирает вертикально все такие элементы и снимает флаги newLineRootElement;
     *
     * @param entry Entry<String> со значением true переменной newLineRootElement, которая подлежит
     *              изменению;
     * @return список начиная с Entry<String> entry и заканчивая всеми его parent со значением true
     * переменной newLineRootElement, которая подлежит изменению;
     */
    private List<Entry<String>> getNewLineRootElementsCollection(Entry<String> entry) {
        ArrayList<Entry<String>> list = new ArrayList<>();
        list.add(entry);
        if ((entry.parent != null) && (entry.parent.newLineRootElement)) {
            list.addAll(getNewLineRootElementsCollection(entry.parent));
        }
        return list;
    }

    /**
     * Метод createChild создает новый элемент Entry<String> и устанавливает значение переменной parent
     *
     * @param parent родительский элемент Entry<String>;
     * @param s      значение elementName для нового элемента Entry<String>;
     */
    private void createChild(Entry<String> parent, String s) {
        Entry<String> newOne = new Entry<String>(s);
        newOne.parent = parent;
        newOne.lineNumber = parent.lineNumber + 1;
        setChild(parent, newOne);
    }

    /**
     * Метод setChild присваивает переменным left/rightChild родителя ссылку на элемент Entry<String> child;
     * Если переменная newLineRootElement родителя имела значение true, то это значение передастся ребенку, у
     * родителя изменится на false;
     *
     * @param parent родительский элемент Entry<String>
     * @param child  элемент-потомок Entry<String>
     */
    private void setChild(Entry<String> parent, Entry<String> child) {
        if (parent.availableToAddLeftChildren) {
            parent.leftChild = child;
            parent.availableToAddLeftChildren = false;
            if (parent.newLineRootElement) {
                List<Entry<String>> list = getNewLineRootElementsCollection(parent);
                for (Entry<String> entry : list) {
                    entry.newLineRootElement = false;
                }
                child.newLineRootElement = true;
            }
        } else {
            parent.rightChild = child;
            parent.availableToAddRightChildren = false;
            if (parent.newLineRootElement) {
                List<Entry<String>> list = getNewLineRootElementsCollection(parent);
                for (Entry<String> entry : list) {
                    entry.newLineRootElement = false;
                }
                child.newLineRootElement = true;
            }
        }
    }

    /**
     * Unsupported Operation
     *
     * @param index param
     * @return UnsupportedOperationException();
     */
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * @return Размер коллекции элементов Entry<String>;
     */
    @Override
    public int size() {
        setValidCollection();
        return queue.size();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {

        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        boolean newLineRootElement;
        Entry<T> parent, leftChild, rightChild;

        private Entry(String name) {
            elementName = name;
            newLineRootElement = false;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        private void checkChildren() {
            if (this.leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (this.rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        public boolean isAvailableToAddChildren() {
            return this.availableToAddRightChildren || this.availableToAddLeftChildren;
        }
    }
}
