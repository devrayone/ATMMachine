package ru.devray.study.atmmachine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Пользовательский интерфейс, дисплей, на котором отражается информация
 */
public class ATMUserInterface {

    public static final Logger log = LogManager.getRootLogger();

    public void printBalance(int balance){
        log.info("=============================");
        log.info(String.format("Было внесено %d долларов на счет.", balance));
        log.info("=============================");
    }

    public void printRejectedBanknotes(List<Banknote> banknotes){
        log.info("Следующие банкноты поддельные!");
        log.info(banknotes);
    }
}
