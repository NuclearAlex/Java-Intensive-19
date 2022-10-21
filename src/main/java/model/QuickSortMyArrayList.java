package model;

public class QuickSortMyArrayList {
    public void sort(MyArrayList myArrayList, int start, int finish) {
        if (start < finish) {
            int index = divide(myArrayList.getArray(), start, finish);
            sort(myArrayList, start, index - 1);
            sort(myArrayList, index, finish);
        }
    }

    private int divide(int[] array, int start, int finish) {
        int initIndex = start;
        int endIndex = finish;

        int split = array[start + (finish - start) / 2];
        while (initIndex <= endIndex) {

            while (array[initIndex] < split) {
                initIndex++;
            }
            while (array[endIndex] > split) {
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

    private void replace(int[] array, int index1, int index2) {
        int dummy  = array[index1];
        array[index1] = array[index2];
        array[index2] = dummy;
    }
}
