package ru.devray.study.atmmachine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ATMMechanics {

    public static final Logger log = LogManager.getRootLogger();

    //получено от пользователя, список купюр в купюроприемнике
    List<Banknote> inputBanknotes;

    //контейнер инкассации
    List<Banknote> incassationContainer;

    //контейнер отбракованных купюр
    List<Banknote> rejectedContainer;

    //поддельные банкноты, внесенные текущим пользователем
    List<Banknote> currentlyRejectedBanknotes;

    public ATMMechanics() {
        this.incassationContainer = new ArrayList<>();
        this.rejectedContainer = new ArrayList<>();
        this.currentlyRejectedBanknotes = new ArrayList<>();
    }

    public List<Banknote> getCurrentlyRejectedBanknotes() {
        return currentlyRejectedBanknotes;
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
        inputBanknotes.sort((b1, b2)->
                Integer.compare( b2.getValue().getNominal(), b1.getValue().getNominal()) );
        log.debug("Купюры отсортированы в обратном порядке: " + inputBanknotes);
    }

    /**
     * проверку на отсутствие физических повреждений и на подлинность (наличие водных знаков)
     */
    public int processBanknotes(){
        int sum = 0;
        for (Banknote b : inputBanknotes) {
            log.trace("на данной итерации обрабатывается купюра " + b);
            //купюра платежеспособна
            if (b.isNotDamaged() && b.isValid()) {
                log.info("Купюра " + b + " платежеспособна и участвует в подсчете суммы.");
                incassationContainer.add(b);
                sum += b.getValue().getNominal();
            } else {
                //если купюра поддельная
                if (!b.isValid()){
                    log.warn("Поддельная купюра! " + b);
                    currentlyRejectedBanknotes.add(b);
                } else {
                    sum += b.getValue().getNominal();
                }
                rejectedContainer.add(b);
            }
        }
        log.debug("incassation " + incassationContainer);
        log.debug("rejected " + rejectedContainer);
        log.debug("sum" + sum + "$");
        return sum;
    }

    /**
     * сортировка -  в начале списка всегда оказывались поврежденные купюры (при наличии).
     */
    public void sortRejectedBanknotes() {
        rejectedContainer.sort((b1, b2)->Boolean.compare(b1.isNotDamaged(), b2.isNotDamaged()));
        log.debug("rejectedContainer - " + rejectedContainer);
    }
}
