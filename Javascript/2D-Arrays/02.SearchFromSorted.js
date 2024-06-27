const StaircaseSearch = (arr, rowCount, colCount, key) => {

    //  if the element is not present return [-1, -1]
    if(key < arr[0][0] || key > arr[rowCount-1][colCount-1]){
        return [-1,-1];
    }

    // Staircase Search
    let i = 0;
    let j = colCount -1;

    while(i <= rowCount-1 && j>= 0){
        if(arr[i][j] === key){
            return [i,j];
        } else if(arr[i][j] > key){
            j--;
        } else {
            i++;
        }
    }

    return [-1,-1];
}

const main = () => {

    const array = [
        [10,20,30,40],
        [15,25,35,45],
        [27,29,37,48],
        [32,33,39,50]
    ];

    const key = 33;

    const searchResult = StaircaseSearch(array, array.length, array[0].length, key);

    console.log('Given 2D Sorted Array: ', array);
    console.log('Key to Search: ', key);
    console.log('Key found at location: ', searchResult);
}

main()