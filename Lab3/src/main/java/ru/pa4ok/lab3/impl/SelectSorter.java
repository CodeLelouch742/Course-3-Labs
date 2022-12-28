package ru.pa4ok.lab3.impl;

import ru.pa4ok.lab3.common.IntSorter;

/**
 * min: O(n^2)
 * max: O(n^2)
 * avg: O(n^2)
 */
public class SelectSorter implements IntSorter
{
    public static final SelectSorter INSTANCE = new SelectSorter();

    @Override
    public void sort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int min = arr[i];

            int minId = i;
            for (int j = i+1; j < arr.length; j++)
            {
                if (arr[j] < min)
                {
                    min = arr[j];
                    minId = j;
                }
            }

            int temp = arr[i];
            arr[i] = min;
            arr[minId] = temp;
        }
    }
}
