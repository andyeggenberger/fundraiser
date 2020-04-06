package co.agital.fundraiser.model;

import java.util.Objects;

public class Key {

    private String key;

    public Key() {}

    public String getKey() {
        return key;
    }

    public Key(String myKey) {
        key = myKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key k = (Key) o;
        return Objects.equals(key, k.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return key;
    }

}
