package ru.devray.study.atmmachine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static final Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        //пачка купюр, которую пользватель вносит в банкомат
        List<Banknote> money = new ArrayList<>();
        money.add(new Banknote(Values.FIFTY, true, true));
        money.add(new Banknote(Values.TWENTY, true, true));
        money.add(new Banknote(Values.TWENTY, false, true));
        money.add(new Banknote(Values.HUNDRED, false, false));
        money.add(new Banknote(Values.HUNDRED, true, false));
        money.add(new Banknote(Values.HUNDRED, false, false));
        money.add(new Banknote(Values.TEN, true, true));
        money.add(new Banknote(Values.TEN, true, false));
        money.add(new Banknote(Values.FIVE, true, true));
        money.add(new Banknote(Values.TWO, true, true));
        money.add(new Banknote(Values.TWO, true, false));
        money.add(new Banknote(Values.ONE, true, true));

        ATMMachine atm = new ATMMachine();

        atm.putMoneyOnBalance(money);

        log.debug(String.format("%s",money));
    }
}
