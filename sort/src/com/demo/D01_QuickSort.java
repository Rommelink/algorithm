package com.demo;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author linhonghao@youcheyihou.com
 * @date 2021/4/30 下午4:45
 */
public class D01_QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 5, 9, 2, 15, 16};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int arr[], int left, int right) {
        if (arr.length == 0) {
            return;
        }
        if (left < right) {
            //返回的middle是对应索引已经排好序了
            int middle = adjustArr(arr, left, right);
            //采用分治算法
            quickSort(arr, 0, middle - 1);
            quickSort(arr, middle + 1, right);
        }
    }

    /**
     * 调整数组
     *
     * @return 返回基准数的索引
     */
    private static int adjustArr(int arr[], int left, int right) {
        int i = left, j = right;
        //1.找基准数,默认保存第一个元素，此时相当于在被保存的元素对应的位置挖坑
        int target = arr[left];
        while (i < j) {
            //从右往左遍历，直到找到第一个小于target值的数，填到左边的坑
            while (i < j && target < arr[j]) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            //从左往右遍历，直到找到第一个大于或等于target值的数，填到右边的坑
            while (i < j && target >= arr[i]) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        //当i==j时，跳出循环
        arr[i] = target;
        return i;
    }
}
