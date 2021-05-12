package ru.devray.study.atmmachine;

/**
 * Номиналы долларовых купюр
 */
public enum Values {
    HUNDRED(100),
    FIFTY(50),
    TWENTY(20),
    TEN(10),
    FIVE(5),
    TWO(2),
    ONE(1);

    int nominal;

    Values(int nominal) {
        this.nominal = nominal;
    }
}
