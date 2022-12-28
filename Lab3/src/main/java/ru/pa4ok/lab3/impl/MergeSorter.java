package ru.pa4ok.lab3.impl;

import ru.pa4ok.lab3.common.IntSorter;

public class MergeSorter implements IntSorter
{
    @Override
    public void sort(int[] arr)
    {
        sort(arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int left, int right)
    {
        if (right <= left) {
            return;
        }

        int mid = (left+right)/2;
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right)
    {
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;
        int[] leftArray = new int[lengthLeft];
        int[] rightArray = new int[lengthRight];

        for (int i = 0; i < lengthLeft; i++) {
            leftArray[i] = arr[left+i];
        }
        for (int i = 0; i < lengthRight; i++) {
            rightArray[i] = arr[mid+i+1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++)
        {
            if (leftIndex < lengthLeft && rightIndex < lengthRight)
            {
                if (leftArray[leftIndex] < rightArray[rightIndex])
                {
                    arr[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else
                {
                    arr[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < lengthLeft)
            {
                arr[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else if (rightIndex < lengthRight)
            {
                arr[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
