const Palindrome = ( str ) => {
    let flag = true;
    let start = 0;
    let end = str.length -1;

    while( start<end ) {
        if(str[start] !== str[end]){
            flag = false;
            break;
        }
        start ++;
        end --;
    }

    return flag;
}

const main = () => {
    const givenString = 'racecar';

    console.log('The given string is: ',givenString);
    console.log(`${givenString} is Palindrome: `, Palindrome(givenString));
}

main();