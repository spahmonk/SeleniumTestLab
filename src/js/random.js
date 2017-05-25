//generate set of random ext-gen elements
/*var Set = Java.type("java.util.HashSet");
var extGenSet=new Set();*/


/*while (extGenSet.size<40){
    extGenSet.add("ext-gen"+(Math.floor((Math.random() * 1000) + 300)));

}*/
/* Creates an array of random integers between the range specified
 len = length of the array you want to generate
 min = min value you require
 max = max value you require
 unique = whether you want unique or not (assume 'true' for this answer)
 */
function _arrayRandom(len, min, max, unique) {
    var len = (len) ? len : 10,
        min = (min !== undefined) ? min : 1,
        max = (max !== undefined) ? max : 100,
        unique = (unique) ? unique : false,
        toReturn = [], tempObj = {}, i = 0;

    if(unique === true) {
        for(; i < len; i++) {
            var randomInt = Math.floor((Math.random() * (max - min)) + min);
            if(tempObj['key_'+ randomInt] === undefined) {
                tempObj['key_'+ randomInt] = randomInt;
                toReturn.push('ext-get'+randomInt);
            } else {
                i--;
            }
        }
    } else {
        for(; i < len; i++) {
            toReturn.push(Math.floor(Math.random() * ((max - min) + min)));
        }
    }

    return toReturn;
}
var extGenSet=_arrayRandom(40,300,1000,true)


var generator={};
for(var i=0;i<5;i++){
    generator['Scenario'+i]=(extGenSet[i]);

}
for(var i=5;i<10;i++){
    generator['Section'+i]=(extGenSet[i]);

}
for(var i=10;i<15;i++){
    generator['Country'+i]=(extGenSet[i]);

}
for(var i=15;i<20;i++){
    generator['Naics'+i]=(extGenSet[i]);

}
for(var i=20;i<40;i++){
    generator['Coverages'+i]=(extGenSet[i]);

}
generator=JSON.stringify(generator);
generator




