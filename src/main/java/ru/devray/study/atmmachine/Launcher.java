package ru.devray.study.atmmachine;

import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        //пачка купюр, которую пользватель вносит в банкомат
        List<Banknote> money = new ArrayList<Banknote>();
        money.add(new Banknote(Values.FIFTY, true, true));
        money.add(new Banknote(Values.TWENTY, true, true));
        money.add(new Banknote(Values.TWENTY, false, true));
        money.add(new Banknote(Values.HUNDRED, false, false));
        money.add(new Banknote(Values.HUNDRED, true, false));
        money.add(new Banknote(Values.HUNDRED, false, false));
        money.add(new Banknote(Values.TEN, true, true));
        money.add(new Banknote(Values.TEN, true, false));
        money.add(new Banknote(Values.FIVE, true, true));

        ATMMachine atm = new ATMMachine();

        atm.putMoneyOnBalance(money);
        System.out.println(money);
    }
}
