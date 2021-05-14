package ru.devray.study.atmmachine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ATMMechanics {

    private static final Logger log = LogManager.getRootLogger();

    //получено от пользователя, список купюр в купюроприемнике
    private  List<Banknote> inputBanknotes;

    //контейнер инкассации
    private final List<Banknote> incassationContainer;

    //контейнер отбракованных купюр
    private final List<Banknote> rejectedContainer;

    //поддельные банкноты, внесенные текущим пользователем
    private final List<Banknote> currentlyRejectedBanknotes;

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
     *
     * @param inputBanknotes
     */
    public void acceptBanknotes(List<Banknote> inputBanknotes) {
        this.inputBanknotes = inputBanknotes;
    }

    /**
     * Сортируем купюры в обратном порядке по номиналу
     */
    public void sortBanknotes() {
        inputBanknotes.sort((b1, b2) -> {
            int banknoteNominal1 = b1.getValue().getNominal();
            int banknoteNominal2 = b2.getValue().getNominal();
            return Integer.compare(banknoteNominal2, banknoteNominal1);
        });
        log.info(String.format("Купюры отсортированы в обратном порядке: %s",inputBanknotes));
    }

    /**
     * проверку на отсутствие физических повреждений и на подлинность (наличие водных знаков)
     */
    public int processBanknotes() {
        int sum = 0;
        for (Banknote b : inputBanknotes) {
            log.trace(String.format("на данной итерации обрабатывается купюра %s",  b));
            //купюра платежеспособна
            if (b.isNotDamaged() && b.isValid()) {

                log.info(String.format("Купюра: %s платежеспособна и учавствует в подсчете суммы", b));
                incassationContainer.add(b);
                sum += b.getValue().getNominal();
            } else {
                //если купюра поддельная
                if (!b.isValid()) {
                    log.warn(String.format("Поддельная купюра! %s",b));
                    currentlyRejectedBanknotes.add(b);
                } else {
                    sum += b.getValue().getNominal();
                }
                rejectedContainer.add(b);
            }
        }
        log.debug(String.format("incassation: %s", incassationContainer));
        log.debug(String.format("rejected: %s", rejectedContainer));
        log.debug(String.format("sum %d $", sum));
        return sum;
    }

    /**
     * сортировка -  в начале списка всегда оказывались поврежденные купюры (при наличии).
     */
    public void sortRejectedBanknotes() {
        rejectedContainer.sort((b1, b2) -> Boolean.compare(b1.isNotDamaged(), b2.isNotDamaged()));
        log.debug("rejectedContainer - " + rejectedContainer);
        log.debug(String.format("rejectedContainer %s", rejectedContainer));
    }
}
