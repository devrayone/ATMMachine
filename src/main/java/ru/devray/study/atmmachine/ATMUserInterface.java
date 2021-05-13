package ru.devray.study.atmmachine;

import java.util.List;

/**
 * Пользовательский интерфейс, дисплей, на котором отражается информация
 */
public class ATMUserInterface {
    public void printBalance(int balance){
        System.out.println("=============================");
        System.out.println(String.format("Было внесено %d долларов на счет.", balance));
        System.out.println("=============================");
    }
}
