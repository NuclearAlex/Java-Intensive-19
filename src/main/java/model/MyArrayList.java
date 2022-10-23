package model;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

public class MyArrayList<T> {
    private static final int INIT_CAPACITY = 10;

    private int counter = 0;
    private T[] array;

    public MyArrayList() {
        this.array = (T[]) new Object[INIT_CAPACITY];
    }

    public MyArrayList(int initCapacity) {
        if (initCapacity > 0)
            this.array = (T[]) new Object[initCapacity];
        else if (initCapacity == 0)
            this.array = (T[]) new Object[0];
        else
            throw new IllegalArgumentException("Wrong capacity: " + initCapacity);
    }

    public MyArrayList(T[] array) {
        this.array = array;
    }

    public boolean add(T newElem) {
        if (counter >= array.length - 1) {
            T[] newArray = (T[]) new Object[array.length + 10];
            System.arraycopy(array, 0, newArray, 0, counter);
            array = newArray;
        }
        array[counter] = newElem;
        counter++;
        return true;
    }

    public void add(int index, T newElem) {
        System.arraycopy(array, index, array, index + 1, counter - index);
        array[index] = newElem;
        counter++;
    }

    public int size() {
        return counter;
    }

    public T get(int index) {
        if (index >= 0)
            return array[index];
        else
            throw new IllegalArgumentException("Wrong index: " + index);
    }

    private T set(int index, T elem) {
        T oldValue = array[index];
        array[index] = elem;
        return oldValue;
    }

    public void remove(int index) {
        if (counter - index >= 0) {
            System.arraycopy(array, index + 1, array, index, counter - index);
        }
        array[counter] = null;
        counter--;
    }

    public String toString() {
        StringBuilder tempCounter = new StringBuilder();
        if (counter == 0)
            tempCounter.append("[]");
        for (T elem : array)
            if (elem != null)
                tempCounter.append(elem).append(" ");
        return tempCounter.toString();
    }

    public void forEach(Consumer<T> action) {
        for (T elem : array)
            if (elem != null)
                action.accept(elem);
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
        int result = Objects.hash(INIT_CAPACITY, counter);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

                    /** Quick sort methods */
    public <T> void sort(MyArrayList<T> array, int start, int finish) {
        if (start < finish) {
            int index = divide(array, start, finish);
            sort(array, start, index - 1);
            sort(array, index, finish);
        }
    }

    private <T> int divide(MyArrayList<T> array, int start, int finish) {
        int initIndex = start;
        int endIndex = finish;

        T split = array.get(start + (finish - start) / 2);
        while (initIndex <= endIndex) {

            while ((int) array.get(initIndex) < (int) split) {
                initIndex++;
            }
            while ((int) array.get(endIndex) > (int) split) {
                endIndex--;
            }
            if (initIndex <= endIndex) {
                replace(array, endIndex, initIndex);
                initIndex++;
                endIndex--;
            }
        }
        return initIndex;
    }

    private <T> void replace(MyArrayList<T> array, int index1, int index2) {
        T dummy = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, dummy);
    }

}