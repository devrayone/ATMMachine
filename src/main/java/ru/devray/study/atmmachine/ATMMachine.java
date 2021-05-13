package ru.devray.study.atmmachine;

import java.util.List;

/**
 * Класс, описывающий банкомат, работающий с долларовыми купюрами
 */
public class ATMMachine {

    private ATMUserInterface ui;
    private ATMMechanics mechanics;

    public ATMMachine() {
        this.ui = new ATMUserInterface();
        this.mechanics = new ATMMechanics();
    }

    public void putMoneyOnBalance(List<Banknote> banknotes){
        //пользователь вставляет купюры в купюроприемник
        mechanics.acceptBanknotes(banknotes);
        //TODO обработка и подсчет купюр
        //купюры сортируются по номиналу, по убыванию
        mechanics.sortBanknotes();
        int sum = mechanics.processBanknotes();

        ui.printBalance(sum);
    }
}
