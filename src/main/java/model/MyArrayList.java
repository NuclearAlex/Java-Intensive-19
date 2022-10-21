package model;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

public class MyArrayList<T> {
    private final int INIT_LENGTH = 10;

    private int[] array = new int[INIT_LENGTH];
    private int counter = 0;

    int getINIT_LENGTH() {
        return INIT_LENGTH;
    }

    int[] getArray() {
        return array;
    }

    public boolean add(int x) {
        if (counter >= array.length - 1) {
            int[] newArray = new int[array.length + 10];
            System.arraycopy(array, 0, newArray, 0, counter);
            array = newArray;
        }
        array[counter] = x;
        counter++;
        return true;
    }

    public void add(int index, int x) {
        System.arraycopy(array, index, array, index + 1, counter - index);
        array[index] = x;
        counter++;
    }

    public int size() {
        return counter;
    }

    public int get(int index) {
        return array[index];
    }

    public void remove(int index) {
        if (counter - index >= 0) {
            System.arraycopy(array, index + 1, array, index, counter - index);
        }
        array[counter] = 0;
        counter--;
    }

    public void forEach(Consumer<Integer> action) {
        for (Integer t : array) {
            action.accept(t);
        }
    }

    public String toString() {
        return "MyArrayList elements: \n" + Arrays.toString(array) + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return counter == that.counter && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(INIT_LENGTH, counter);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}