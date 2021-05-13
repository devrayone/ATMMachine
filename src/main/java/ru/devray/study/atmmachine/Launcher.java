package ru.devray.study.atmmachine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Launcher {

    //local
    public static String serverUrl;
    public static String serverPort;
    public static String dbUrl;


    public static void loadProperties(){
        Properties properties = new Properties();

        try {
            InputStream is = new FileInputStream("src/main/resources/stand-configuration.properties");
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        serverUrl = properties.getProperty("serverUrl");
        serverPort = properties.getProperty("serverPort");
        dbUrl = properties.getProperty("dbUrl");

        System.out.println(serverUrl + " " + serverPort + " " + dbUrl );
    }

    public static void main(String[] args) {
        //инциализируем переменные конфигурации стенда
        loadProperties();


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
