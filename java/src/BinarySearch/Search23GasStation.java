package BinarySearch;

import java.util.*;

public class Search23GasStation {
/*
    You are given a sorted array ‘arr’ of length ‘n’, which contains positive integer positions of ‘n’ gas stations on the X-axis.
    You are also given an integer ‘k’. You have to place 'k' new gas stations on the X-axis.
    You can place them anywhere on the non-negative side of the X-axis, even on non-integer positions.
    Let 'dist' be the maximum value of the distance between adjacent gas stations after adding k new gas stations.

    Find the minimum value of ‘dist’.

    arr[] = {1, 2, 3, 4, 5}    k = 5

    total 5 + 4 => 9 gas station

    {1 2 3 4 5 6 7 8 9} max distance between each 1
     1 2 3 4 5 6 7 8 9

    {1 1.25 1.5 1.75 2 3 4 4.5 5} max distance between each 1
     1  2   3    4   5 6 7  8  9

    {1 1.5 2 2.5 3 3.5 4 4.5 5}  max distance between each 0.5
     1  2  3  4  5  6  7  8  9

     ans = 1
*/

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;

        System.out.println("Bruteforce Approach");
        System.out.println(bruteforceApproach(arr, k));

        System.out.println("Better Solution Approach");
        System.out.println(betterSolution(arr, k));

        System.out.println("BinarySearch Approach");
        System.out.println(binarySearchApproach(arr, k));
    }

    public static double bruteforceApproach(int[] arr, int k){

        int n = arr.length; //size of array.
        int[] howMany = new int[n - 1];

        //Pick and place k gas stations:
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            //Find the maximum section and insert the gas station:
            double maxSection = -1;
            int maxInd = -1;

            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength =
                        diff / (double)(howMany[i] + 1);
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            //insert the current gas station:
            howMany[maxInd]++;
        }

        //Find the maximum distance i.e. the answer:
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength =
                    diff / (double)(howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }

    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static double betterSolution(int[] arr, int k) {
        int n = arr.length; // size of array.
        int[] howMany = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        // insert the first n-1 elements into pq
        // with respective distance values:
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        // Pick and place k gas stations:
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            // Find the maximum section
            // and insert the gas station:
            Pair tp = pq.poll();
            int secInd = tp.second;

            // insert the current gas station:
            howMany[secInd]++;

            double inidiff = arr[secInd + 1] - arr[secInd];
            double newSecLen = inidiff / (double) (howMany[secInd] + 1);
            pq.add(new Pair(newSecLen, secInd));
        }

        return pq.peek().first;
    }

    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length; // size of the array
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }

    public static double binarySearchApproach(int[] arr, int k){
        int n = arr.length; // size of the array
        double low = 0;
        double high = 0;

        //Find the maximum distance:
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
        }

        //Apply Binary search:
        double diff = 1e-6 ;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = numberOfGasStationsRequired(mid, arr);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
