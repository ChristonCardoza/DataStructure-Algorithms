package BinarySearch;

public class Search15KokoBanana {
/*
    A monkey is given ‘n’ piles of bananas, whereas the 'ith' pile has ‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.
    Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas. If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.
    Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.

    k=bananas/hour      piles[] = {3, 6, 7, 11}  h=8
    2                              2  3  4   6   15>8  not possible
    3                              1  2  3   4   10>8  not possible
    4                              1  2  2   3    8=8  possible
*/

    public static void main(String[] args) {

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println("Bruteforce Approach:"+ bruteforce(piles, h));
        System.out.println("BinarySearch Approach:"+ getBananaCount(piles, h));
    }

    public static int findMax(int[] arr){

        int max = Integer.MIN_VALUE;

        for(int ele: arr){
            max = Math.max(max, ele);
        }
        return max;
    }

    public static int eatBanana(int[] piles, int banana){

        int hrs = 0;

        for(int pile : piles){
             hrs = (int) (hrs + Math.ceil(((double) pile / banana)));
        }

        return hrs;
    }

    public static int bruteforce(int[] piles, int h){
        int n =  findMax(piles);

        for(int i=1; i<=n; i++){
            int timeReq = eatBanana(piles, i);
            if(timeReq <= h) return i;

        }
        return -1;
    }

    public static int getBananaCount(int[] piles, int h){

        int low =1, high = findMax(piles);
        int ans = high;

        while(low<=high){

            int mid = low + (high-low)/2;
            int timeReq = eatBanana(piles, mid);

            if(timeReq <=h){
                ans = mid;
                high = high-1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
