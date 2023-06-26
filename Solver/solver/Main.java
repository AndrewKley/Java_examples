public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("adam"));
        System.out.println(solution.longestPalindrome("cbbd"));
        // System.out.println(solution.longestPalindrome("ac"));
        // System.out.println(solution.longestPalindrome("bba"));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String str = sb.reverse().toString();
        String res = str;

        for (int i = 0; i < s.length() - 1; i++) {
            res = str;
            for (int j = s.length(); j > i; j--) {
                System.out.format("res: %s\ti: %d\tj: %d\n", res, i, j);
                if (s.indexOf(res) != -1) {
                    System.out.println("-");
                    return res;
                }
                if (j == res.length())  {
                    res = res.substring(i, j-i);
                    continue;
                }
                res = res.substring(i, j);
            }
        }
        
        return "" + s.charAt(0);
    }
}
