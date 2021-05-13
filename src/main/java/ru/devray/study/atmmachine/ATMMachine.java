package ru.devray.study.atmmachine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Класс, описывающий банкомат, работающий с долларовыми купюрами
 */
public class ATMMachine {

    public static final Logger log = LogManager.getRootLogger();

    private ATMUserInterface ui;
    private ATMMechanics mechanics;

    public ATMMachine() {
        this.ui = new ATMUserInterface();
        this.mechanics = new ATMMechanics();
    }


    public void putMoneyOnBalance(List<Banknote> banknotes){
        //пользователь вставляет купюры в купюроприемник
        mechanics.acceptBanknotes(banknotes);

        //купюры сортируются по номиналу, по убыванию
        mechanics.sortBanknotes();

        //получение суммы обработанных платежеспособных банкнот
        int sum = mechanics.processBanknotes();

        //вывод баланса пользователю
        ui.printBalance(sum);
        mechanics.sortRejectedBanknotes();

        List<Banknote> invalidBanknotes = mechanics.getCurrentlyRejectedBanknotes();
        ui.printRejectedBanknotes(invalidBanknotes);
    }
}
