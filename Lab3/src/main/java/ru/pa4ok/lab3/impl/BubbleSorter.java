package ru.pa4ok.lab3.impl;

import ru.pa4ok.lab3.common.IntSorter;

public class BubbleSorter implements IntSorter
{
    @Override
    public void sort(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
