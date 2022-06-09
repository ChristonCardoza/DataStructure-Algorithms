const SelectionSort = (arr) => {

    let minIndex;

    for(let i = 0; i<arr.length-1; i++) {

        minIndex = i;

        for(let j=i; j < arr.length ; j++) {
            if(arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        [arr[i], arr[minIndex]] = [ arr[minIndex], arr[i]];
    
    }

}


const main = () => {

    const array = [9,8,7,6,5,4,3,2,1];

    console.log("The Given Array is: ", array);
    SelectionSort(array);
    console.log("The Sorted Array is: ", array);
}

main();

/*
    Complexity:
        array = [9,8,7,6,5,4,3,2,1]
        
        - Repeatedly find the minimum element from unsorted part and putting it at the beginning

        two nested loops O(n^2)
*/