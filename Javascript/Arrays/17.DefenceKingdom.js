const Defkin = (w, h, position) => {
    let maxWidth = 0;
    let maxHeight = 0;

    const widthArray = [];
    const heightArray = [];
    
    // 1. For setting the boundary push 0 and dimension +1 at beginning and end of the array
    widthArray.push(0);
    heightArray.push(0);

    // 2. Extract all Width & Height from position & Sort it
    for(let i=0; i<position.length; i++){
        widthArray.push(position[i][0]);
        heightArray.push(position[i][1]);
    }
    widthArray.push(w+1);
    heightArray.push(h+1);
    widthArray.sort((a,b) => a-b);
    heightArray.sort((a,b) => a-b);

   // 3. Find the Maximum Width and Height difference
    for( let i=0; i< widthArray.length-1; i++) {
        maxWidth = Math.max(maxWidth, widthArray[i+1]-widthArray[i]-1);
        maxHeight = Math.max(maxHeight, heightArray[i+1]-heightArray[i]-1);
    }
    
    // 4. Product of Max width and Max height will be the Max Un-Defended
    return maxWidth * maxHeight;
}

const main = () => {
    const width = 15;
    const height = 8;
    const towerPosition = [[3,8], [11,2], [8,6]];

    console.log("Given Towers Point: ", towerPosition);
    console.log("Width of the Kingdom: ", width);
    console.log("Height of the Kingdom: ", height);

    const notDefended = Defkin(width, height, towerPosition);

    console.log("The largest Un-Defended Size: ", notDefended);
}

main();

/*
    Complexity:
    
        - For setting the boundary push 0 and dimension +1 at beginning and end of the array
        - sort all width and height
        - fined the max width and height difference
        - product of max width and max height will be the unprotected area

        sorting takes O(nlogn)
*/