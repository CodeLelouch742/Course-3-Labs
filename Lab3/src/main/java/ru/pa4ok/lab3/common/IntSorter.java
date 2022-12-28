package ru.pa4ok.lab3.common;

public interface IntSorter
{
    void sort(int[] arr);

    default long sortWithTime(int[] arr) {
        long mills = System.currentTimeMillis();
        sort(arr);
        return System.currentTimeMillis() - mills;
    }
}
