package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2750 {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        quickSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int s, int e) {
        if (s >= e)
            return;

        int index = partition(s, e);
        quickSort(s, index - 1);
        quickSort(index + 1, e);
    }

    private static int partition(int s, int e) {
        int pivot_index = (s + e) / 2;
        int pivot = arr[pivot_index];

        int left = s;
        int right = e - 1;
        swap(e, pivot_index);
        while (left <= right) {
            while (left <= right && arr[right] >= pivot) right--;
            while (left <= right && arr[left] <= pivot) left++;

            if (left < right)
                swap(left, right);
        }
        swap(left, e);
        return left;
    }

    private static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
