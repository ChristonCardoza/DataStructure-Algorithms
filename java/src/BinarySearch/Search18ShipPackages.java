package BinarySearch;

public class Search18ShipPackages {
 /*
    You are the owner of a Shipment company. You use conveyor belts to ship packages from one port to another. The packages must be shipped within 'd' days.
    The weights of the packages are given in an array 'of weights'. The packages are loaded on the conveyor belts every day in the same order as they appear in the array.
    The loaded weights must not exceed the maximum weight capacity of the ship.
    Find out the least-weight capacity so that you can ship all the packages within 'd' days.

            weights[] = {1, 2, 3, 4, 5, 6, 7, 8, 9,10} days = 5

                                1            2          3         4        5
            capacity = 15  [1,2,3,4,5]     [6,7]       [8]       [9]      [10]  => possible

                                1            2          3         4        5        6
            capacity = 14  [1,2,3,4]       [5,6]       [7]       [8]      [9]     [10]  => not possible

    Here ,
        minimum capacity at least to be Max(weights)
        maximum capacity at most Sum(weights)
*/

    public static void main(String[] args) {

        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
        int days = 5;

        System.out.println("Bruteforce Approach:");
        System.out.println(bruteforce(weights, days));

        System.out.println("BinarySearch Approach:");
        System.out.println(binarySearch(weights, days));

    }

    public static int[] getMaxAndSum(int[] arr){

        int max = Integer.MIN_VALUE, sum = 0;

        for(int ele: arr){
            max = Math.max(ele, max);
            sum += ele;
        }

        return new int[] {max, sum};
    }

    public static int getDays(int[] weights, int capacity){
        int load = 0, day = 1;

        for(int weight: weights){

            if(load + weight <= capacity){
                load += weight;
            } else {
                load = weight;
                day ++;
            }
        }

        return day;
    }

    public static int bruteforce(int[] weights, int days){

        int[] maxSum = getMaxAndSum(weights);

        for(int capacity=maxSum[0]; capacity<=maxSum[1]; capacity++){

            if(getDays(weights, capacity) <= days){
                return capacity;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] weights, int days){

        int[] maxSum = getMaxAndSum(weights);

        int low = maxSum[0], high = maxSum[1], minCapacity = -1;

        while(low<=high){

            int mid = low + (high - low)/2;

            if(getDays(weights, mid) <= days){
                minCapacity = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return minCapacity;
    }
}
