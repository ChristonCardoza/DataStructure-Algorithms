const InsertionSort = (arr) => {

    let current, prevIndex;

    for(let i =1; i<arr.length; i++){
        current = arr[i];
        prevIndex = i-1;

        while(prevIndex>=0 && arr[prevIndex] > current){
            arr[prevIndex + 1] = arr[prevIndex];
            prevIndex = prevIndex - 1;
        }
        arr[prevIndex + 1] =  current;

    }

}


const main = () => {

    const array = [9,8,7,6,5,4,3,2,1];

    console.log("The Given Array is: ", array);
    InsertionSort(array);
    console.log("The Sorted Array is: ", array);
}

main();

/*
    Complexity:
        array = [9,8,7,6,5,4,3,2,1]
        
        - consider array has 2 part left and right, assume left part is already sorted,
          Index 0 is sorted and 1 to n-1 is unsorted
        - Take the Index 1 value as current element from array and check with the sorted array(outer loop)
        - The previous values is sorted array and compare with current(inner loop)
*/