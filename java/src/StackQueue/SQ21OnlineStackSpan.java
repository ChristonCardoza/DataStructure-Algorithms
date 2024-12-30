package StackQueue;

import java.util.ArrayList;
import java.util.Stack;

/*
The Stock Span problem is to calculate the span of a stock’s price for all days.
The span of a stock's price on a given day is the maximum number of consecutive days
(starting from that day and going backward) for which the stock price was less than or equal to the price on that day.
 */

class BruteforceStack {

    ArrayList<Integer> arr;

    BruteforceStack() {
        arr = new ArrayList<>();
    }

    public int next(int val) {

        arr.add(val);
        int cnt = 1;

        for(int i = arr.size()-2; i>=0; i-- ){
            if(arr.get(i) <=val) cnt ++;
            else break;
        }

        return cnt;
    }
}

class OptimalStock {

    /*
    To calculate the stock span for a given day, you want to determine how many consecutive days (including today)
    the stock price was less than or equal to today’s price. Instead of iterating backward through the list (as in the brute-force approach),
    you use a stack to store the indices of previous days where the stock prices are higher than today’s price.

    The stack helps efficiently find the previous greater element (PGE) for the current stock price.
    This allows you to calculate the span for the current day without repeatedly traversing the array.
     */

    static class Pair<I extends Number, I1 extends Number> {

        int first, second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    Stack<Pair<Integer, Integer>> st;
    int index;

    OptimalStock(){

        this.index = -1;
        this.st = new Stack<>();
    }

    public int next(int val) {

        index = index + 1;

        while(!st.isEmpty() && st.peek().first <= val) {
            st.pop();
        }

        int ans = index - (st.isEmpty() ? -1 : st.peek().second);

        st.push(new Pair<>(val, index));

        return ans;
    }

}
public class SQ21OnlineStackSpan {

    public static void main(String[] args) {
        BruteforceStack bSt = new BruteforceStack();

        System.out.println("Brute Online Stock span: O(no of days * next call count)");

        System.out.println("next(7): "+ bSt.next(7));
        System.out.println("next(2): "+ bSt.next(2));
        System.out.println("next(1): "+ bSt.next(1));
        System.out.println("next(3): "+ bSt.next(3));
        System.out.println("next(3): "+ bSt.next(3));
        System.out.println("next(1): "+ bSt.next(1));
        System.out.println("next(8): "+ bSt.next(8));

        OptimalStock oSt = new OptimalStock();

        System.out.println("Optimal Online Stock span: O(2N)");

        System.out.println("next(7): "+ oSt.next(7));
        System.out.println("next(2): "+ oSt.next(2));
        System.out.println("next(1): "+ oSt.next(1));
        System.out.println("next(3): "+ oSt.next(3));
        System.out.println("next(3): "+ oSt.next(3));
        System.out.println("next(1): "+ oSt.next(1));
        System.out.println("next(8): "+ oSt.next(8));
    }
}
