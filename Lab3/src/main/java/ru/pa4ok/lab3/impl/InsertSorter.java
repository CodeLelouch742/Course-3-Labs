package ru.pa4ok.lab3.impl;

import ru.pa4ok.lab3.common.IntSorter;

/**
 * min: O(n)
 * max: O(n^2)
 * avg: O(n^2)
 */
public class InsertSorter implements IntSorter
{
    public static final InsertSorter INSTANCE = new InsertSorter();

    @Override
    public void sort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int current = arr[i];
            int j = i - 1;

            while(j >= 0 && current < arr[j])
            {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = current;
        }
    }
}
