const Compression1 = (str) => {
    let compressedString = str.charAt(0);

    for(let i=1 ; i<str.length; i++){
        const current = str.charAt(i);
        const prev = str.charAt(i-1);

        if(current !==prev) {
            compressedString = compressedString + current;
        }
    }

    return compressedString;
}

const Compression2 = (str) => {
    let compressedString = str.charAt(0);
    let count = 1;

    for(let i=1; i<str.length; i++){
        const current = str.charAt(i);
        const prev = str.charAt(i-1);

        if(current === prev) {
            count = count + 1;
        } else {
            if(count > 1) {
                compressedString = compressedString + count;
                count = 1;
            }
            compressedString = compressedString + current;
        }
    }

    if(count > 1) {
        compressedString = compressedString + count;
    }

    return compressedString;
}

const main =() => {
    const givenString = 'aaabbbbcccccccdddddccccbbbbbbaaaaa';

    console.log('The given string is: ', givenString);
    console.log('First Compression of string is: ', Compression1(givenString));
    console.log('Second Compression of the string is: ', Compression2(givenString));
}

main();