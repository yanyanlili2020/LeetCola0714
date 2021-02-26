/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
    if(num == 1) {
        return 1;
    }
    var tmp = num;
    while(num * num > tmp) {
        num = (num + tmp / num) / 2 | 0;// 比num = (num+tmp/num)>>1;快
    }
    return num * num == tmp;
};

