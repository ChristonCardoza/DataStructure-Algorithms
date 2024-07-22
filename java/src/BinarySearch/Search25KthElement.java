package BinarySearch;

public class Search25KthElement {
/*
    arr1[] = {2, 3, 6, 7, 9} arr2[] = {1, 4, 8, 10} k=4

    {1, 2, 3, 4, 6, 7, 8, 9, 10 }

    Ans -> 4
*/

    public static void main(String[] args) {

        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 4;

        System.out.println(kthElement(arr1,arr2, arr1.length, arr2.length,k));

    }

    public static int kthElement(int[] a, int[] b, int m, int n, int k) {

        if (m > n) return kthElement(b, a, n, m, k);

        int left = k; // length of left half

        // apply binary search:
        int low = Math.max(0, k - n), high = Math.min(k, m);

        while (low <= high) {

            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;

            // calculate l1, l2, r1, and r2
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < m) r1 = a[mid1];
            if (mid2 < n) r2 = b[mid2];
            if (mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = b[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            // eliminate the halves:
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; // dummy statement
    }
}
