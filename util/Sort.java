package util;

public class Sort {
    public int[] selectionSort(int[] arr,boolean direction) {
        int t=0;
        int size=arr.length;
        for(int i=0;i<size-1;i++) {
            for(int j=i+1;j<size;j++) {
                if(direction) {
                    if(arr[i]<arr[j]) {
                        t=arr[i];
                        arr[i]=arr[j];
                        arr[j]=t;
                    }
                }else {
                    if(arr[i]>arr[j]) {
                        t=arr[i];
                        arr[i]=arr[j];
                        arr[j]=t;
                    }
                }
            }
        }
        return arr;
    }
    public int[] bubbleSort(int[] arr,boolean direction) {
        int t=0;
        int size=arr.length;
        for(int i=0;i<size-1;i++) {
            for(int j=0;j<size-i-1;j++) {
                if(direction) {
                    if(arr[j-1]<arr[j]) {
                        t=arr[j-1];
                        arr[j-1]=arr[j];
                        arr[j]=t;
                    }
                }else {
                    if(arr[j-1]>arr[j]) {
                        t=arr[j-1];
                        arr[j-1]=arr[j];
                        arr[j]=t;
                    }
                }
            }
        }
        return arr;
    }
}
