/**
 * @param {number[]} prices
 * @return {number[]}
 */
var finalPrices = function(prices) {
    var result = []
    for(let i=0;i<prices.length;i++){
        let discount = prices[i]
        for(let j=(i+1);j<prices.length;j++){
            if(prices[j]<=prices[i]){
                discount -= prices[j]
                break;
            }
        }
        result.push(discount)
    }
    return result;
};

var finalPrices = function(prices) {
    let res = []
    let len = prices.length
    for (let i = 0; i < len; i++) {
        let temp = prices.slice(i + 1).find((val) => val <= prices[i])
        if (!temp) {
            res.push(prices[i])
        } else {
            res.push(prices[i] - temp)
        }
    }
    return res
};

var finalPrices = function(prices) {
    var stack = [];
    for(var i = 0; i < prices.length; i++){
        while(stack.length && prices[stack[stack.length-1]]>=prices[i]){
            prices[stack[stack.length-1]] -= prices[i]
            stack.pop();
        }
        stack.push(i);
    }
    return prices;
};
