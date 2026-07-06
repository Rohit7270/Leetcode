class Solution {       
    public List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList<>();
        generateAll("", n, ans, 0, 0);
        return ans;
    }
    public void generateAll(String curr, int n, List<String> res, int open, int close){
        if(curr.length() == 2*n){
            res.add(curr);
            return;
        }
        if(open < n) generateAll(curr+'(', n, res, open + 1, close);
        if(close < open) generateAll(curr+')', n, res, open, close + 1);
    }
}