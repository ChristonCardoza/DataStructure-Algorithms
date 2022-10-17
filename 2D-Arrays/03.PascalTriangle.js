
const GeneratePascal = (levels) => {

    const triangle = [];

    // First level of triangle
    triangle.push([1]);

    for (let level=1; level<levels; level++){

        const currentLevel = [];
        const prevLevel = triangle[level-1];

        // first element at every level is 1
        currentLevel.push(1);

        for(let j=1; j<level; j++){
            currentLevel.push(prevLevel[j-1] + prevLevel[j]);
        }

        // last element at every level is 1
        currentLevel.push(1);
        triangle.push(currentLevel);
    }

    return triangle;
}

const PascalRow = (rowNo) => {
    const psRow = [];
    for(let col=0; col<=rowNo; col++){
        psRow.push(PascalValue(rowNo,col))
    }
    return psRow;
}
const PascalValue  = (row, col) => {
    let value = 0;

    if( col === 0 || row === col) {
        value = 1;
    } else if (col<=row){
         let numerator = 1;
         let denominator = 1;
         let colCounter = col;
         let rowCounter = row;

        while(colCounter > 0 ) {
            numerator = numerator * rowCounter;
            denominator = denominator * colCounter;
            rowCounter --;
            colCounter --;
        }

        value = numerator/denominator;
    }
    return value;
}

const main = () => {

    const level = 5;

    console.log('Number of level needed in pascal triangle: ', 5);
    const pascal = GeneratePascal(level);
    console.log('The Pascal Triangle: ',pascal);
    console.log(PascalValue(4,3));
    console.log(PascalRow(5))
}

main();


/*

[ 
           [ 1 ], 
         [ 1, 1 ], 
       [ 1, 2, 1 ], 
     [ 1, 3, 3, 1 ], 
    [ 1, 4, 6, 4, 1 ] 
]  

    - first level of pascal triangle is 1
    - first and last element of every level is 1
    - next level  values are calculated from  previous level sums
    - the individual element from every level is also find out by  ncr formula
            n C r  = n!/(r!(n-r)!)
            rowNo C columnNo =    rowNo!/(columnNo!(rowNo - columnNo)!)
            4 c 2 = 4 x 3 x 2 x 1 / ((2 x 1)(2 x 1))  = 6

            shortcut for ncr is
                - write only r elements of n! then by r! 
                -  4 c 2 = 4 x 3 / 2 x 1  = 6
                -  4 c 1 = 4  /  1  = 4
                -  4 c 0 = 1 / 1  = 1
*/