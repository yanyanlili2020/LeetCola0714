/** 108
 * @param {string} s
 * @return {character}
 */
var firstUniqChar = function(s) {
    if(s.length === 0) {
        return " "
    }
    let hash = new Array(256).fill(0);
    for(let i = 0; i < s.length; i++) {
        hash[s.charCodeAt(i)]++;
    }
    for(let i = 0; i < s.length; i++) {
        if(hash[s.charCodeAt(i)] === 1) {
            return s[i]
        }
    }
    return " "
};
/** 124
 * @param {string} s
 * @return {character}
 */
var firstUniqChar = function(s) {
    const map = new Map()
    for(let i = 0; i < s.length; i++) {
        map.set(s[i], (map.get(s[i]) || 0) + 1)
    }
    for(const [k, v] of [...map.entries()]) {
        if(v === 1) {
            return k
        }
    }
    return ' '
};

