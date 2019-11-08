package no.kristiania.Sorts.InsertionSort;

import no.kristiania.Sorts.MySort;

public class InsertionSort implements MySort {
    @Override
    public <T extends Comparable <T>> void sort(T[] array) {

        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
                else {
                    break;
                }
            }
        }

    }

}



