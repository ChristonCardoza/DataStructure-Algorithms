package Arrays;

import java.util.*;

public class Arrays09UnionAndIntersectionSorted {

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 2, 2, 3, 3, 4, 5};
        int[] arr2 = {2, 3, 3, 4, 4, 5, 6};

        System.out.println(String.format("The bruteforce approach for  array1 %s  array2 %s union %s ", Arrays.toString(arr1), Arrays.toString(arr2), Arrays.toString(bruteforceUnion(arr1, arr2))));
        System.out.println(String.format("The optimized approach for  array1 %s  array2 %s union %s ", Arrays.toString(arr1), Arrays.toString(arr2), Arrays.toString(optimizedUnion(arr1, arr2))));

        System.out.println(String.format("The bruteforce approach for  array1 %s  array2 %s intersection %s ", Arrays.toString(arr1), Arrays.toString(arr2), Arrays.toString(bruteforceIntersection(arr1, arr2))));
        System.out.println(String.format("The optimized approach for  array1 %s  array2 %s intersection %s ", Arrays.toString(arr1), Arrays.toString(arr2), Arrays.toString(optimizedIntersection(arr1, arr2))));

    }

    private static int[] bruteforceUnion(int[] arr1, int[] arr2) {

        Set<Integer> union = new HashSet<>();

        for(int ele: arr1){
            union.add(ele);
        }

        for(int ele: arr2) {
            union.add(ele);
        }

        int[] ans = new int[union.size()];
        int i = 0;

        for(int ele: union){
            ans[i++] = ele;
        }

        return ans;
    }

    private static int[] bruteforceIntersection(int[] arr1, int[] arr2){

        boolean[] visited = new boolean[arr2.length];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr1.length; i++) {

            for(int j=0; j<arr2.length; j++) {

                if((arr1[i]== arr2[j]) && !visited[j]) {

                    list.add(arr1[i]);

                    visited[j] = true;
                    break;
                }
            }
        }

        int[] ans = new int[list.size()];

        int i =0;
        for(int e : list) {
            ans[i++] = e;
        }

        return ans;

    }

    private static int[] optimizedUnion(int[] arr1, int[] arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;

        List<Integer> list = new ArrayList<>();

        while( i < n1  && j < n2) {

            if(arr1[i] <= arr2[j]) {

                if(list.isEmpty() || list.get(list.size() - 1) != arr1[i]){
                    list.add(arr1[i]);
                }

                i++;

            } else {

                if(list.size() == 0 || list.get(list.size() - 1) != arr2[j]){
                    list.add(arr2[j]);
                }

                j++;
            }
        }

        while(i < n1){
            if(list.isEmpty() || list.get(list.size() - 1) != arr1[i]){
                list.add(arr1[i]);
            }
            i++;
        }

        while(j < n2){
            if(list.isEmpty() || list.get(list.size() - 1) != arr2[j]){
                list.add(arr2[j]);
            }
            j++;
        }


        int[] ans = new int[list.size()];

        int a = 0;
        for(int ele: list){
            ans[a++] = ele;
        }

        return ans;
    }

    private static int[] optimizedIntersection(int[] arr1, int[] arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;

        List<Integer> list = new ArrayList<>();

        while( i < n1  && j < n2) {

            if(arr1[i] < arr2[j]) {
                i++;
            } else if(arr2[j] < arr1[i]) {
                j++;
            } else {
                list.add(arr1[i]);
                i++;
                j++;
            }
        }

        int[] ans = new int[list.size()];
        int a = 0;

        for(int ele: list){
            ans[a++] = ele;
        }

        return ans;
    }
}
