package no.kristiania.Sorts.Bubblesort;

public interface MySort {

    <T extends Comparable<T>> void sort(T[] array);
}
