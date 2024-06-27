const closestPairSum = (arr, value) => {

    let start = 0;
    let end = arr.length - 1;
    let diff = Number.POSITIVE_INFINITY;
    let  absoluteDiff = 0;
    let e1,e2; 

    while(start < end) {
        absoluteDiff = Math.abs( arr[start] + arr[end] - value );
       
        if( absoluteDiff < diff ) {
            e1 = start;
            e2 = end;
            diff = absoluteDiff;
        }

        if(arr[start] + arr[end] > value ) {
             end --;
        } else {
            start ++;
        }
    }

    return [e1, e2];
}

const main = () => {
    const array = [10, 20, 30, 40, 50];
    const sum = 45;

    const pair = closestPairSum(array, sum);

    console.log(`For given array ${array} of sum ${sum} , the closest pair ${pair}`);
}

main();

/*
    Complexity:
        When array is sorted ......
        array = [10, 20, 30, 40, 50]
        sum = 45

        - pair means 2 elements of the array
        - addition of those 2 elements should equal or nearer to given sum
        - when the 2 element sum is grater than the given sum, then change right element else left
        - traversing array from left and right towards the mid , will get best pair 


        its a binary search algorithm : O(n)
*/