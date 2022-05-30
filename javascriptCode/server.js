
let words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"];

var findAllConcatenatedWordsInADict = function(words) {
    const ws = words.sort((w1, w2) => w1.length - w2.length);
    const ans = [];
    const list = new Set();
    
    const check = (word, s , occ) => {
        if(s >= word.length) {
            return occ;
        }
        let curr = "";
        let res = 0;
        for(let i = s; i < word.length; i++) {
            curr += word[i];
            if(list.has(curr)) {
                res = Math.max(res, check(word, i + 1, occ + 1))
            }
        }
        return res;
    }
    for(let i = 0; i < ws.length; i++) {
        const word = ws[i];
        if(i >= 1) list.add(ws[i - 1]);
        const n = check(word, 0, 0);
        if(n >= 2) {
            ans.push(word)
        }
    }
    return ans;

};

findAllConcatenatedWordsInADict(words);