const GetShortestPath = (lpath) => {

    let xCordinate = 0;
    let yCordinate = 0;
    let path = '';

    Array.from(lpath).map( direction => {
        switch(direction) {
            case 'N': yCordinate ++;
                      break;
            case 'S': yCordinate --;
                      break;
            case 'E': xCordinate ++;
                      break;
            case 'W': xCordinate --;
                      break;
        }
    });

    if(xCordinate>=0 && yCordinate>=0){
        while(yCordinate!=0) {
            path = path + 'N';
            yCordinate --;
        }
        while(xCordinate!=0) {
            path = path + 'E';
            xCordinate--;
        }
    } else if(xCordinate<0 && yCordinate>=0){
        while(yCordinate!=0) {
            path = path + 'N';
            yCordinate --;
        }
        while(xCordinate!=0) {
            path = path + 'W';
            xCordinate ++;
        }
    } else if(xCordinate<0 && yCordinate<0){
        while(yCordinate!=0) {
            path = path + 'S';
            yCordinate++
        }
        while(xCordinate!=0) {
            path = path + 'W';
            xCordinate ++;
        }
    } else {
        while(yCordinate!=0) {
            path = path + 'S';
            yCordinate++
        }
        while(xCordinate!=0) {
            path = path + 'E';
            xCordinate --;
        }
    }
    return path;

    
}

const main = () => {
    const route = 'SNNNEWE';
    
    const shortestPath =  GetShortestPath(route);
    console.log('Given Longest Route is: ', route);
    console.log('Shortest Path: ', shortestPath);
}

main();