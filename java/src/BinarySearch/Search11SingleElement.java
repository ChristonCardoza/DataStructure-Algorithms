package BinarySearch;

public class Search11SingleElement {
/*
    arr[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6} => 4
             0  1  2  3  4  5  6  7  8  9  10

     Mid is odd then mid-1 is same
     Mid is even then mid+1 is same

    (even, odd) => Left side
    (odd, even) => Right side
*/
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};

        System.out.println(getSingleElement(arr));
    }

    public static int getSingleElement(int[] nums){

        int n = nums.length;

        // Single element is exists
        if(n==1) return nums[0];

        // First element is single
        if(nums[0] != nums[1]) return nums[0];

        // Last element is single
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int low = 1, high = n-2;

        while(low<=high){

            int mid = low + (high-low)/2;

            // Mid element is single
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) {
                return nums[mid];
            }

            if((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid-1])){

                low = mid + 1;

            } else {

                high = mid - 1;
            }

        }

        return -1;
    }
}
