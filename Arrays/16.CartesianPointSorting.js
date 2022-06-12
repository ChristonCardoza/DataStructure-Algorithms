const CartesianSort = (arr) => {
   
    for( let i=0; i< arr.length -1; i++) {
        for( let j=0; j< arr.length -1-i; j++) {
            if(arr[j][0] > arr[j+1][0]) {
                [arr[j], arr[j+1]] = [arr[j+1], arr[j]];
            }

            if( arr[j][0] === arr[j+1][0]) {
                if (arr[j][1]  > arr[j+1][1]) {
                    [arr[j], arr[j+1]] = [arr[j+1], arr[j]];
                }
            }
           
        }
    }
}

const main = () => {
    const cartesianArray = [[3,4], [2,3], [3,7], [1,5], [3,4]];

    console.log("Given Cartesian Point: ", cartesianArray);

    CartesianSort(cartesianArray);

    console.log("Sorted Cartesian Point: ", cartesianArray);
}

main()

/*
    Complexity:
        Bubble sort

        - sort first element(x) using bubble sort.
        - when first element(x) is equal then then compare with second(y)

        2 nested loops O(n^2)
*/