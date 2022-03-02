package com.example.springtask.service;

public class ElementService {

    public int findElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                boolean condition = arr[i] == arr[j] && i != j;
                if (condition) {
                    break;
                }
            }


        }
        return 1;
    }

    public int findElementStream(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                boolean condition = arr[i] == arr[j] && i != j;
                if (condition) {
                    break;
                }
            }


        }
        return 1;
    }
}
