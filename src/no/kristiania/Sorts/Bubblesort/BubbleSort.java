package no.kristiania.Sorts.Bubblesort;

public class BubbleSort implements MySort{

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if(array == null) {
            return;
        }
        boolean swapped = true;

        while(swapped) {
            swapped = false;

            for(int i = 0; i < array.length - 1; i++) {
                int j = i + 1;

                if(array[i].compareTo(array[j]) > 0 ){
                    T tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                    swapped = true;
                }
            }
        }
    }
}


