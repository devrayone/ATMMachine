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
        mechanics.acceptBanknotes(banknotes);
        //TODO обработка и подсчет купюр
        //купюры сортируются по номиналу, по убыванию
        mechanics.sortBanknotes(banknotes);
        mechanics.processBanknotes(banknotes);
    }
}
