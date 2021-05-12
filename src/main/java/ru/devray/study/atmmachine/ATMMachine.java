package ru.devray.study.atmmachine;

import java.util.List;

/**
 * Класс, описывающий банкомат, работающий с долларовыми купюрами
 */
public class ATMMachine {

    private ATMUserInterface ui;
    private ATMMechanics mechanics;

    public ATMMachine(ATMUserInterface ui, ATMMechanics mechanics) {
        this.ui = ui;
        this.mechanics = mechanics;
    }

    public void putMoneyOnBalance(List<Banknote> banknotes){
        mechanics.acceptBanknotes(banknotes);
    }
}
