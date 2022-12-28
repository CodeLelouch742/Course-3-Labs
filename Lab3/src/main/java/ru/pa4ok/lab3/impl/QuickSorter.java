package ru.pa4ok.lab3.impl;

import ru.pa4ok.lab3.common.IntSorter;

/**
 * min: O(n log(n))
 * max: O(n^2)
 * avg: O(n log(n))
 */
public class QuickSorter implements IntSorter
{
    public static final QuickSorter INSTANCE = new QuickSorter();

    @Override
    public void sort(int[] arr)
    {
        sort(arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int begin, int end)
    {
        if (begin < end)
        {
            int partitionIndex = partition(arr, begin, end);
            sort(arr, begin, partitionIndex-1);
            sort(arr, partitionIndex+1, end);
        }
    }

    private int partition(int[] arr, int begin, int end)
    {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
