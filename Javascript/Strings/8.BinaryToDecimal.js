const BinaryToDecimal = (str) => {

    let decimal = 0;
    let base = 1;

    for( let i=str.length-1; i>=0; i--) {
        if(str[i] === '1'){
            decimal = decimal + base;
        }
        base = base * 2;
    }
    return decimal;
}

const main = () => {
    const binary = '1001'

    console.log('The given Binary Number is:', binary);
    console.log('The Decimal Number is: ', BinaryToDecimal(binary));
}

main();