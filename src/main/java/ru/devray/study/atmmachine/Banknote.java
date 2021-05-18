package ru.devray.study.atmmachine;

/**
 * Класс банкноты (денежной купюры)
 */
public class Banknote implements Comparable<Banknote> {
    private final Values value;
    private final boolean unharmed;
    private final boolean isValid;

    public Banknote(Values value, boolean unharmed, boolean isValid) {
        this.value = value;
        this.unharmed = unharmed;
        this.isValid = isValid;
    }

    public Values getValue() {
        return value;
    }

    public boolean unharmed() {
        return unharmed;
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public String toString() {
        return "{" + value.getNominal() + "$, OK=" + unharmed +
                ", V=" + isValid + "}";
    }

    @Override
    public int compareTo(Banknote b) {
        return Integer.compare(this.value.getNominal(), b.value.getNominal());
    }
}
