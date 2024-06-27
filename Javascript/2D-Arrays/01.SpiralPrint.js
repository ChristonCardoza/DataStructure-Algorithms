
const SpiralPrint = (arr, rowCount, colCount) => {
    const spiralResult = [];
    // 4 variables
    let startRow = 0;
    let endRow = rowCount -1;
    let startCol = 0;
    let endCol = colCount -1;

    // Outer loop (Traverse array boundary)
    while(startCol<=endCol && startRow<=endRow){

        // Start Row
        for( let col = startCol; col<=endCol; col++){
            console.log(arr[startRow][col]);
            spiralResult.push(arr[startRow][col]);
        }

        // End Col
        for( let row = startRow + 1; row<=endRow; row++){
            console.log(arr[row][endCol]);
            spiralResult.push(arr[row][endCol]);
        }

        // end Row
        for( let col = endCol -1; col>=startCol; col--){
            // Avoid Duplicate Printing of elements
            if(startRow ===endRow){
                break;
            }
            console.log(arr[endRow][col]);
            spiralResult.push(arr[endRow][col]);
        }

        // End Col
        for( let row = endRow-1; row>=startRow +1; row--){
            // Avoid Duplicate Printing of elements
            if(startCol ===endCol){
                break;
            }
            console.log(arr[row][startCol]);
            spiralResult.push(arr[row][startCol]);
        }

        // Update the variables to point to inner spiral

        startRow++;
        endRow--;
        startCol++;
        endCol--;
    }

    return spiralResult;
}

const main = () => {

    const array = [
        [1,2,3,4],
        [5,6,7,8],
        [9,10,11,12],
        [13,14,15,16]
    ]

    console.log('The given array is: ', array);
    console.log('Spiral print of it', SpiralPrint(array, array.length, array[0].length))
}
 
main();