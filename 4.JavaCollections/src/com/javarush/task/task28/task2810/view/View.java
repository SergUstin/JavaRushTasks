package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

public interface View {

    void update(List<Vacancy> vacancies);

    void setController(Controller controller);
}
