const BubbleSort = (arr) => {

    let swapped;

    for(let i=0; i<arr.length-1; i++){
        
        swapped = false;

        for(let j=0; j< arr.length-1-i; j++) {
            
            if( arr[j] > arr[j+1]) {
                [arr[j], arr[j+1]] = [arr[j+1], arr[j]]
                swapped = true;
            }
        }

        if(!swapped) {
            break;
        }
    }
}

const main = () => {

    const array = [9,8,7,6,5,4,3,2,1];

    console.log("The Given Array is: ", array);
    BubbleSort(array);
    console.log("The Sorted Array is: ", array);
}

main();

/*
    Complexity:
        array = [9,8,7,6,5,4,3,2,1]
        
        - Here we need to compare each element from left compare with every elements in right;
          at the end largest element is stored at the n-1 index (inner loop)
        - Repeat the steps for all elements (Outer loop)
        - The 2 nested loops : O(n^2)
        - If the array is already sorted, then also it takes O(n^2) times, to break it down introduce boolean and set 
          when the swap happen, if the swap is not happened then break the outer loop: O(n)
*/