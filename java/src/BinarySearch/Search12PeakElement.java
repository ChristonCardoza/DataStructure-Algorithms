package BinarySearch;

public class Search12PeakElement {
/*
    arr[] = {1, 2, 3, 4, 5, 5, 7, 8, 5, 1} => 8
    arr[] = {1, 2, 1, 3, 6, 4} => 2 and 6
    arr[] = {5, 4, 3, 2, 1} => 5

    arr[i-1] < arr[i] > arr[i+1]

    Peak can be:
        Equals to Middle
        Right side of Middle
        Left side of Middle
        Either side of Middle
*/
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 5, 7, 8, 5, 1};
        int[] arr2 = {1, 2, 1, 3, 6, 4};
        int[] arr3 = {5, 4, 3, 2, 1};

        System.out.println("Bruteforce Approach:");
        System.out.println(bruteforce(arr1));
        System.out.println(bruteforce(arr2));
        System.out.println(bruteforce(arr3));

        System.out.println("BinarySearch Approach:");
        System.out.println(getPeak(arr1));
        System.out.println(getPeak(arr2));
        System.out.println(getPeak(arr3));
    }

    public static int bruteforce(int[] nums){

        for(int i=0; i<nums.length; i++){

            if((i==0 || nums[i] > nums[i-1]) && (i == nums.length-1 || nums[i] > nums[i+1])){
                return nums[i];
            }
        }
        return -1;
    }

    public static int getPeak(int[] nums){

        int n = nums.length;

        // Only 1 element exists
        if(n == 1) return nums[0];

        // First is peak
        if(nums[0] > nums[1]) return nums[0];

        // Last is peak
        if(nums[n-1] > nums[n-2]) return nums[n-1];

        int low = 1, high = n-2;

        while(low<=high){

            int mid =  low + (high-low)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                // mid is peak
                return nums[mid];

            } else if(nums[mid] > nums[mid-1]){
                // peak can be in right side
                low = mid + 1;

            } else {
                // peak can in left side
                high = mid - 1;
            }
        }

        return -1;
    }
}
