package com.ahmrh.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KthLargest {
    List<Integer> arrayList = new ArrayList<Integer>();

    int kIndex;

    public KthLargest(int k, int[] nums) {
        for(int num: nums) arrayList.add(num);
        sortArrayList();
        kIndex = k;
    }

    public int add(int val) {
        arrayList.add(val);
        sortArrayList();
        return arrayList.get(arrayList.size() - kIndex);
    }

    private void sortArrayList(){
        Collections.reverse(arrayList);
    }
    private void printArrayList(){
        System.out.println("Printing Array List");
        for(int num: arrayList){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
