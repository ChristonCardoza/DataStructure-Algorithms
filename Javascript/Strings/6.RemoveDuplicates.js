const RemoveDuplicates = (str) => {

    const stringSet = new Set();
    let newString ='';

    for( let s=0; s<str.length; s++){
        stringSet.add(str[s])
    }

    for(let ch of stringSet){
        newString = newString + ch;
    }

    return newString;
}

const main = () => {

    const str = 'geeksforgeeks';

    console.log('The given string is: ', str);
    console.log('String after removing duplicates: ', RemoveDuplicates(str));
}

main();