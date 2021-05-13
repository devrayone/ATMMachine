package ru.devray.study.atmmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ATMMechanics {

    //получено от пользователя, список купюр в купюроприемнике
    List<Banknote> inputBanknotes;

    //контейнер инкассации
    List<Banknote> incassationContainer;

    //контейнер отбракованных купюр
    List<Banknote> rejectedContainer;

    public ATMMechanics() {
        this.incassationContainer = new ArrayList<>();
        this.rejectedContainer = new ArrayList<>();
    }

    /**
     * Приняли купюры в купюроприемник
     * @param inputBanknotes
     */
    public void acceptBanknotes(List<Banknote> inputBanknotes) {
        this.inputBanknotes = inputBanknotes;
    }

    /**
     * Сортируем купюры в обратном порядке по номиналу
     */
    public void sortBanknotes() {
        inputBanknotes.sort((b1, b2)->{
            int banknoteNominal1 = b1.getValue().getNominal();
            int banknoteNominal2 = b2.getValue().getNominal();
            return banknoteNominal1 > banknoteNominal2 ? -1 : banknoteNominal1 == banknoteNominal2 ? 0 : 1;
        });
        System.out.println(inputBanknotes);
    }

    /**
     * проверку на отсутствие физических повреждений и на подлинность (наличие водных знаков)
     */
    public int processBanknotes(){
        int sum = 0;
        for (Banknote b : inputBanknotes) {
            //купюра платежеспособна
            if (b.isNotDamaged() && b.isValid()) {
                incassationContainer.add(b);
                sum += b.getValue().getNominal();
            } else {
                //если купюра поддельная
                if (!b.isValid()){
                    System.err.println("Поддельная купюра! " + b);
                } else {
                    sum += b.getValue().getNominal();
                }
                rejectedContainer.add(b);
            }
        }
        System.out.println("incassation " + incassationContainer);
        System.out.println("rejected " + rejectedContainer);
        System.out.println("sum" + sum + "$");
        return sum;
    }
}
