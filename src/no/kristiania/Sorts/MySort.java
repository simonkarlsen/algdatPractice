package no.kristiania.Sorts;

public interface MySort {

    <T extends Comparable<T>> void sort(T[] array);
}
