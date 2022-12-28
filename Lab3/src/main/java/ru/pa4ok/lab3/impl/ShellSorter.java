package ru.pa4ok.lab3.impl;

import ru.pa4ok.lab3.common.IntSorter;

public class ShellSorter implements IntSorter
{
    @Override
    public void sort(int[] arr)
    {
        int n = arr.length;

        for (int gap=n/2; gap>0; gap/=2)
        {
            for (int i=gap; i<n; i++)
            {
                int key = arr[i];
                int j = i;

                while (j>=gap && arr[j-gap]>key) {
                    arr[j] = arr[j-gap];
                    j -= gap;
                }

                arr[j] = key;
            }
        }
    }
}
