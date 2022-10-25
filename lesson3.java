import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class lesson3 {
    public static void main(String[] args) {
        /*
        var AL = getList(15);
        System.out.println(AL);

        deleteEven(AL);
        System.out.println(AL);

        var data = foundData(AL);
        printArr(data);

        int[] arr = new int[AL.size()];
        Iterator<Integer> iter = AL.iterator();
        for(int i = 0; i < arr.length; i++){
            arr[i] = iter.next();
        }
        printArr(arr);

        mergeSort(arr);

        printArr(arr);
         */
    }

    public static ArrayList<Integer> getList(int size) {
        Random rdm = new Random();
        ArrayList<Integer> rdmList = new ArrayList<>(size);

        for(int i = 0; i < size; ++i) {
            rdmList.add(rdm.nextInt(100));
        }

        return rdmList;
    }

    public static void deleteEven(ArrayList<Integer> startList) {
        for(int i = 0; i < startList.size(); ++i) {
            if (startList.get(i) % 2 == 0) {
                startList.remove(i);
                --i;
            }
        }

    }

    public static int[] foundData(ArrayList<Integer> startList) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int average;
        for(average = 0; average < startList.size(); ++average) {
            int currentEl = (Integer)startList.get(average);
            if (currentEl < min) {
                min = currentEl;
            }

            if (currentEl > max) {
                max = currentEl;
            }

            sum += currentEl;
        }

        average = sum / startList.size();
        return new int[]{min, max, average};
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int leftLenght = left.length;
        int rightLenght = right.length;

        int i = 0, j = 0, k = 0;
        while (i < leftLenght && j < rightLenght) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
            }
        }
        while (i < leftLenght) {
            arr[k++] = left[i++];
        }
        while (j < rightLenght) {
            arr[k++] = right[j++];
        }
    }

    public static  void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length - 1)
                System.out.print(", ");
        }
        System.out.println();
    }
}
