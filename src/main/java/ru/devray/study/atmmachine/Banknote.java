package ru.devray.study.atmmachine;

/**
 * Класс банкноты (денежной купюры)
 */
public class Banknote {
    private final Values value;
    private final boolean isNotDamaged;
    private final boolean isValid;

    public Banknote(Values value, boolean isNotDamaged, boolean isValid) {
        this.value = value;
        this.isNotDamaged = isNotDamaged;
        this.isValid = isValid;
    }

    public Values getValue() {
        return value;
    }

    public boolean isNotDamaged() {
        return isNotDamaged;
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public String toString() {
        return "Banknote{" +
                "value=" + value +
                ", isNotDamaged=" + isNotDamaged +
                ", isValid=" + isValid +
                '}';
    }
}
