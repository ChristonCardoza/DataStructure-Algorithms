const sumOfSubArray = (arr) => {
    let largestSum = 0;
    let currentSum = 0;
    
    for(let i=0; i<arr.length; i++){
        currentSum = currentSum >0 ? currentSum + a[i] : 0;
        largestSum = Math.max(currentSum, largestSum)
    }
    return largestSum;
}

const main = () => {
    const array = [-2,3,4,-1,5,-12,6,1,3];

    console.log('Sum of sub array: ', array);
    const sum = sumOfSubArray(array);
    console.log(sum);
}
main();

/*
    Complexity:
        Kadane's Algorithm:
         - store the cumulative some of array in to array, if  current sum is negative ignore it ie 0
           arr[-2,3,4,-1,5,-12,6,1,3,2]
           cs: 0 3 7 6 11  0  6 7  10 12
           ms: 0 3 7 7 11 11 11 11 11 12

          one independent loop =  linear time = O(n)
*/