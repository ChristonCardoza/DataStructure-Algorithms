package BinarySearch;

public class Search17SmallestDivisor {
/*
    You are given an array of integers 'arr' and an integer i.e. a threshold value 'limit'.
    Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it,
    the sum of the division's result is less than or equal to the given threshold value.

    arr[] = {1, 2, 5, 9}, threshold = 6 , take ceil value

            1/d + 2/d + 5/d + 9/d <= 6

    d = 4   1/4 + 2/4 + 5/4 + 9/4 <= 6
             1  +  1  + 2   +  3  != 6

    d = 5   1/5 + 2/5 + 5/5 + 9/5 <= 6
             1  +  1  + 1   +  2  <= 6

*/

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println(bruteforce(nums, threshold));
        System.out.println(binarySearch(nums, threshold));
    }

    public static int[] getMaxMin(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int ele: arr){
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }

        return new int[] {min, max};
    }

    public static int getSumDivision(int[] nums, int divisor){

        int sum = 0;

        for(int num: nums){
            sum = sum + (int)Math.ceil((double) num / divisor);
        }

        return sum;
    }

    public static int bruteforce(int[] nums, int threshold){

        int[] minMax = getMaxMin(nums);

        for(int i=1; i<=minMax[1]; i++){

            if( getSumDivision(nums, i) <= threshold){
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] nums, int threshold){

        int[] minMax = getMaxMin(nums);

        int low = 1, high = minMax[1], divisor = -1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(getSumDivision(nums, mid) <= threshold){
                divisor = mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return divisor;
    }
}
