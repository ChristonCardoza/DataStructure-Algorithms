package BinarySearch;

public class Search19KthMissing {
/*
    You are given a strictly increasing array ‘vec’ and a positive integer 'k'. Find the 'kth' positive integer missing from 'vec'.

    arr[] = {2, 3, 4, 7, 11}  k = 5

    1  2  3  4  5  6  7  8  9  10  11
    -  x  x  x  -  -  x  -  -   -   x
    1           2  3     4  5   6

    Kth missing number = 9
 */

    public static void main(String[] args) {

        int [] arr = {2, 3, 4, 7, 11};
        int k = 5;

        System.out.println("Bruteforce Approach 1: ");
        System.out.println(bruteforce1(arr, k));

        System.out.println("Bruteforce Approach 2: ");
        System.out.println(bruteforce2(arr, k));

        System.out.println("Binary Approach: ");
        System.out.println(binarySearch(arr, k));
    }

    public static int bruteforce1(int[] arr, int k){

        int missingNo = 0;
        int index = 0;

        for(int i=1; i<=arr[arr.length-1]; i++){

            if(arr[index] != i){
                missingNo ++;
            } else {
                index ++;
            }

            if(missingNo == k){
                return i;
            }
        }

        return arr.length;
    }

    public static int bruteforce2(int[] arr, int k){
        // possible answer is k but as soon as we get some entry then that means
        // there is one entry so k++ is possible ans
        for(int ele: arr){

            if(ele <=k) k++;

            else break;
        }

        return k;
    }

    public static int binarySearch(int[] arr, int k){

        /*
           arr[] = {2, 3, 4, 7, 11} k=5
                    0  1  2  3  4

           missing no till i  -> a[i] - i+1 // index start from 0 and natural no start from 1

                    2-1, 3-22, 4-3, 7-4, 11-5
                     1    1     1    3     6

                     once search space is completed we are at index high
                     high = 3 , arr[high] = 7, missingCount = 3, k=5

                          k = missing + x
                          x = k - missing // 2

                     Kth missing = arr[high] + x
                                   arr[high] + k - missing
                                   arr[high] + k -  (a[high] - high+1)
                                   high + 1 + k
                                 = low + k // 9

         */
        int low = 0, high = arr.length-1;

        while(low<=high){

            int mid = low + (high-low)/2;

            int totalMissingMid = arr[mid] - (mid + 1);

            if(totalMissingMid < k){
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }

        return k + low;
    }
}
