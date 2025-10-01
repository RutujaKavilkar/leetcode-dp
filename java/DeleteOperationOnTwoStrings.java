public class DeleteOperationOnTwoStrings {
    private int f(int i, int j, String s1, String s2) {
        // base case
        if (i < 0 || j < 0) return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + f(i - 1, j - 1, s1, s2);
        }
        return Math.max(f(i - 1, j, s1, s2), f(i, j - 1, s1, s2));
    }

     public int minDistance(String s, String t){
       int m=s.length();
        int n=t.length();
        int LCS=f(m - 1, n - 1, s, t);
        int l1=m-LCS;
        int l2=n-LCS;
        return l1+l2;

    }
}



