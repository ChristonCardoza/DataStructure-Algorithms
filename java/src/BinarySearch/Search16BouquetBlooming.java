package BinarySearch;

public class Search16BouquetBlooming {
/*
   You are given 'N’ roses and you are also given an array 'arr'  where 'arr[i]'  denotes that the 'ith' rose will bloom on the 'arr[i]th' day.
   You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.
   Find the minimum number of days required to make at least ‘m' bouquets each containing 'k' roses. Return -1 if it is not possible

   bloomDay[] = { 7, 7, 7, 7, 13, 11, 12, 7} noBouquets = 2, adjacentFlowers = 3

   13th day =>    x x x x  x  x  x x   => possible
   12th day =>    x x x x  -  x  x x   => possible
   11th day =>    x x x x  -  x  - x   => not possible
 */


    public static void main(String[] args) {

        int[] bloomDays = { 7, 7, 7, 7, 13, 11, 12, 7};
        int noBouquets = 2, adjacentFlowers = 3;

        System.out.println("Bruteforce Approach:");
        System.out.println(bruteforce(bloomDays, noBouquets, adjacentFlowers));

        System.out.println("Binary Approach:");
        System.out.println(binarySearch(bloomDays, noBouquets, adjacentFlowers));
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

    public static int getBloomedFlowers(int[] days, int flowerCount, int nthDay){

        int count = 0;
        int noBouquets = 0;

        for(int day : days){

            if(day <= nthDay){
                count ++;
            } else {
                noBouquets = noBouquets + count/flowerCount;
                count = 0;
            }
        }

        noBouquets = noBouquets + count/flowerCount;

        return noBouquets;

    }

    public static int bruteforce(int[] bloomDays, int bouquets, int flowerCount){

        int[] minMax = getMaxMin(bloomDays);

        for(int i=minMax[0]; i<=minMax[1]; i++){

            int totalBouquets= getBloomedFlowers(bloomDays, flowerCount, i);

            if( totalBouquets >= bouquets){

                return  i;
            }
        }

        return minMax[1];
    }

    public static int binarySearch(int[] bloomDays, int bouquets, int flowerCount){

        int[] minMax = getMaxMin(bloomDays);

        int low = minMax[0], high = minMax[1], day = high;

        while(low<=high){

            int mid = low + (high-low)/2;

            int totalBouquets = getBloomedFlowers(bloomDays, flowerCount, mid);

            if(totalBouquets >= bouquets){
                day = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return day;
    }
}
