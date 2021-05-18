package ru.devray.study.atmmachine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Launcher {

    public static final Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        //пачка купюр, которую пользователь вносит в банкомат
        //количество купюр, которые вносит клиент
        int count = 20;
        List<Banknote> money = generateBanknotes(count);
        log.debug("Внесенные купюры: " + money);

        ATMMachine atm = new ATMMachine();

        atm.putMoneyOnBalance(money);

        log.debug(money);
    }

    //Генератор рандомных купюр
    private static List<Banknote> generateBanknotes(int count) {
        int size = Values.values().length;
        Random random = new Random();
        List<Banknote> money = new ArrayList<>();
        for (int i = 0; i < count; i++){
            money.add(new Banknote(Values.values()[random.nextInt(size)], random.nextBoolean(), random.nextBoolean()));
        }
        return money;
    }


}
