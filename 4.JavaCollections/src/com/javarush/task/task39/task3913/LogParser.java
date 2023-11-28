package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private List<LogEntity> logEntities = new ArrayList<>();
    private DateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy H:m:s");

    public LogParser(Path logDir) {
        this.logDir = logDir;
        readLogs();
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                result.add(logEntities.get(i).getIp());
            }
        }
        return result;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getUser().equals(user)) {
                    result.add(logEntities.get(i).getIp());
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(event)) {
                    result.add(logEntities.get(i).getIp());
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getStatus().equals(status)) {
                    result.add(logEntities.get(i).getIp());
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            result.add(logEntities.get(i).getUser());
        }
        return result;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                result.add(logEntities.get(i).getUser());
            }
        }
        return result.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getUser().equals(user)) {
                    result.add(logEntities.get(i).getEvent());
                }
            }
        }
        return result.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getIp().equals(ip)) {
                    result.add(logEntities.get(i).getUser());
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.LOGIN)) {
                    result.add(logEntities.get(i).getUser());
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                    result.add(logEntities.get(i).getUser());
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.WRITE_MESSAGE)) {
                    result.add(logEntities.get(i).getUser());
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.SOLVE_TASK)) {
                    result.add(logEntities.get(i).getUser());
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.SOLVE_TASK)
                        && logEntities.get(i).getEventAdditionalParameter() == task) {
                    result.add(logEntities.get(i).getUser());
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.DONE_TASK)) {
                    result.add(logEntities.get(i).getUser());
                }
            }
        }
        return result;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.DONE_TASK)
                        && logEntities.get(i).getEventAdditionalParameter() == task) {
                    result.add(logEntities.get(i).getUser());
                }
            }
        }
        return result;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getUser().equals(user)
                        && logEntities.get(i).getEvent().equals(event)) {
                    result.add(logEntities.get(i).getDate());
                }
            }
        }
        return result;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getStatus().equals(Status.FAILED)) {
                    result.add(logEntities.get(i).getDate());
                }
            }
        }
        return result;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getStatus().equals(Status.ERROR)) {
                    result.add(logEntities.get(i).getDate());
                }
            }
        }
        return result;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getUser().equals(user)
                        && logEntities.get(i).getEvent().equals(Event.LOGIN)) {
                    set.add(logEntities.get(i).getDate());
                }
            }
        }
        if (set.size() == 0) {
            return null;
        }
        Date minDate = set.iterator().next();
        for (Date date : set) {
            if (date.getTime() < minDate.getTime())
                minDate = date;
        }
        return minDate;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getUser().equals(user)
                        && logEntities.get(i).getEvent().equals(Event.SOLVE_TASK)
                        && logEntities.get(i).getEventAdditionalParameter() == task) {
                    set.add(logEntities.get(i).getDate());
                }
            }
        }
        if (set.size() == 0) {
            return null;
        }
        Date minDate = set.iterator().next();
        for (Date date : set) {
            if (date.getTime() < minDate.getTime())
                minDate = date;
        }
        return minDate;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getUser().equals(user)
                        && logEntities.get(i).getEvent().equals(Event.DONE_TASK)
                        && logEntities.get(i).getEventAdditionalParameter() == task) {
                    set.add(logEntities.get(i).getDate());
                }
            }
        }
        if (set.size() == 0) {
            return null;
        }
        Date minDate = set.iterator().next();
        for (Date date : set) {
            if (date.getTime() < minDate.getTime())
                minDate = date;
        }
        return minDate;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getUser().equals(user)
                        && logEntities.get(i).getEvent().equals(Event.WRITE_MESSAGE)) {
                    result.add(logEntities.get(i).getDate());
                }
            }
        }
        return result;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getUser().equals(user)
                        && logEntities.get(i).getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                    result.add(logEntities.get(i).getDate());
                }
            }
        }
        return result;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                result.add(logEntities.get(i).getEvent());
            }
        }
        return result;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getIp().equals(ip)) {
                    result.add(logEntities.get(i).getEvent());
                }
            }
        }
        return result;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getUser().equals(user)) {
                    result.add(logEntities.get(i).getEvent());
                }
            }
        }
        return result;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getStatus().equals(Status.FAILED)) {
                    result.add(logEntities.get(i).getEvent());
                }
            }
        }
        return result;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> result = new HashSet<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getStatus().equals(Status.ERROR)) {
                    result.add(logEntities.get(i).getEvent());
                }
            }
        }
        return result;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int quantity = 0;
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.SOLVE_TASK)
                        && logEntities.get(i).getEventAdditionalParameter() == task) {
                    quantity++;
                }
            }
        }
        return quantity;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int quantity = 0;
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.DONE_TASK)
                        && logEntities.get(i).getEventAdditionalParameter() == task) {
                    quantity++;
                }
            }
        }
        return quantity;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.SOLVE_TASK)) {
                    int task = logEntities.get(i).getEventAdditionalParameter();
                    Integer count = result.containsKey(task) ? result.get(task) : 0;
                    result.put(task, count + 1);
                }
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < logEntities.size(); i++) {
            if (dateBetweenDates(logEntities.get(i).getDate(), after, before)) {
                if (logEntities.get(i).getEvent().equals(Event.DONE_TASK)) {
                    int task = logEntities.get(i).getEventAdditionalParameter();
                    Integer count = result.containsKey(task) ? result.get(task) : 0;
                    result.put(task, count + 1);
                }
            }
        }
        return result;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> result = new HashSet<>();
        String field1;
        String field2 = null;
        String value1 = null;
        Pattern pattern = Pattern.compile("get (ip|user|date|event|status)"
                + "( for (ip|user|date|event|status) = \"(.*?)\")?");
        Matcher matcher = pattern.matcher(query);
        matcher.find();
        field1 = matcher.group(1);
        if (matcher.group(2) != null) {
            field2 = matcher.group(3);
            value1 = matcher.group(4);
        }

        if (field2 != null && value1 != null) {
            for (int i = 0; i < logEntities.size(); i++) {
                if (field2.equals("date")) {
                    try {
                        if (logEntities.get(i).getDate().getTime() == simpleDateFormat.parse(value1).getTime()) {
                            result.add(getCurrentValue(logEntities.get(i), field1));
                        }
                    } catch (ParseException e) {
                    }
                } else {
                    if (value1.equals(getCurrentValue(logEntities.get(i), field2).toString())) {
                        result.add(getCurrentValue(logEntities.get(i), field1));
                    }
                }
            }
        } else {
            for (int i = 0; i < logEntities.size(); i++) {
                result.add(getCurrentValue(logEntities.get(i), field1));
            }
        }

        return result;
    }

    private void readLogs() {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(logDir)) {
            for (Path file : directoryStream) {
                if (file.toString().toLowerCase().endsWith(".log")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            String[] params = line.split("\t");

                            if (params.length != 5) {
                                continue;
                            }

                            String ip = params[0];
                            String user = params[1];
                            Date date = readDate(params[2]);
                            Event event = readEvent(params[3]);
                            int eventAdditionalParameter = -1;
                            if (event.equals(Event.SOLVE_TASK) || event.equals(Event.DONE_TASK)) {
                                eventAdditionalParameter = readAdditionalParameter(params[3]);
                            }
                            Status status = readStatus(params[4]);

                            LogEntity logEntity = new LogEntity(ip, user, date, event, eventAdditionalParameter, status);
                            logEntities.add(logEntity);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Date readDate(String lineToParse) {
        Date date = null;
        try {
            date = simpleDateFormat.parse(lineToParse);
        } catch (ParseException e) {
        }
        return date;
    }

    private Event readEvent(String lineToParse) {
        Event event = null;
        if (lineToParse.contains("SOLVE_TASK")) {
            event = Event.SOLVE_TASK;
        } else if (lineToParse.contains("DONE_TASK")) {
            event = Event.DONE_TASK;
        } else {
            switch (lineToParse) {
                case "LOGIN": {
                    event = Event.LOGIN;
                    break;
                }
                case "DOWNLOAD_PLUGIN": {
                    event = Event.DOWNLOAD_PLUGIN;
                    break;
                }
                case "WRITE_MESSAGE": {
                    event = Event.WRITE_MESSAGE;
                    break;
                }
            }
        }
        return event;
    }

    private int readAdditionalParameter(String lineToParse) {
        if (lineToParse.contains("SOLVE_TASK")) {
            lineToParse = lineToParse.replace("SOLVE_TASK", "").replaceAll(" ", "");
            return Integer.parseInt(lineToParse);
        } else {
            lineToParse = lineToParse.replace("DONE_TASK", "").replaceAll(" ", "");
            return Integer.parseInt(lineToParse);
        }
    }

    private Status readStatus(String lineToParse) {
        Status status = null;
        switch (lineToParse) {
            case "OK": {
                status = Status.OK;
                break;
            }
            case "FAILED": {
                status = Status.FAILED;
                break;
            }
            case "ERROR": {
                status = Status.ERROR;
                break;
            }
        }
        return status;
    }

    private boolean dateBetweenDates(Date current, Date after, Date before) {
        if (after == null) {
            after = new Date(0);
        }
        if (before == null) {
            before = new Date(Long.MAX_VALUE);
        }
        return current.after(after) && current.before(before);
    }

    private Object getCurrentValue(LogEntity logEntity, String field) {
        Object value = null;
        switch (field) {
            case "ip": {
                Command method = new GetIpCommand(logEntity);
                value = method.execute();
                break;
            }
            case "user": {
                Command method = new GetUserCommand(logEntity);
                value = method.execute();
                break;
            }
            case "date": {
                Command method = new GetDateCommand(logEntity);
                value = method.execute();
                break;
            }
            case "event": {
                Command method = new GetEventCommand(logEntity);
                value = method.execute();
                break;
            }
            case "status": {
                Command method = new GetStatusCommand(logEntity);
                value = method.execute();
                break;
            }
        }
        return value;
    }

    private class LogEntity {
        private String ip;
        private String user;
        private Date date;
        private Event event;
        private int eventAdditionalParameter;
        private Status status;

        public LogEntity(String ip, String user, Date date, Event event, int eventAdditionalParameter, Status status) {
            this.ip = ip;
            this.user = user;
            this.date = date;
            this.event = event;
            this.eventAdditionalParameter = eventAdditionalParameter;
            this.status = status;
        }

        public String getIp() {
            return ip;
        }

        public String getUser() {
            return user;
        }

        public Date getDate() {
            return date;
        }

        public Event getEvent() {
            return event;
        }

        public int getEventAdditionalParameter() {
            return eventAdditionalParameter;
        }

        public Status getStatus() {
            return status;
        }
    }

    private abstract class Command {
        protected LogEntity logEntity;

        abstract Object execute();
    }

    private class GetIpCommand extends Command {
        public GetIpCommand(LogEntity logEntity) {
            this.logEntity = logEntity;
        }

        @Override
        Object execute() {
            return logEntity.getIp();
        }
    }

    private class GetUserCommand extends Command {
        public GetUserCommand(LogEntity logEntity) {
            this.logEntity = logEntity;
        }

        @Override
        Object execute() {
            return logEntity.getUser();
        }
    }

    private class GetDateCommand extends Command {
        public GetDateCommand(LogEntity logEntity) {
            this.logEntity = logEntity;
        }

        @Override
        Object execute() {
            return logEntity.getDate();
        }
    }

    private class GetEventCommand extends Command {
        public GetEventCommand(LogEntity logEntity) {
            this.logEntity = logEntity;
        }

        @Override
        Object execute() {
            return logEntity.getEvent();
        }
    }

    private class GetStatusCommand extends Command {
        public GetStatusCommand(LogEntity logEntity) {
            this.logEntity = logEntity;
        }

        @Override
        Object execute() {
            return logEntity.getStatus();
        }
    }
}