class Solution {
    static Boolean func(int[] a,int n,int s,int[][] m){
        if(s == 0) return true;
        if(n <= 0) return false;
        if(m[n][s] != -1) return m[n][s] == 1;
        if(a[n-1] > s)  m[n][s] =  func(a,n-1,s,m)? 1 : 0;
        else  m[n][s] = func(a,n-1,s,m) || func(a,n-1,s - a[n-1],m) ? 1 : 0;
        return m[n][s] == 1;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        int[][] memo = new int[ n + 1][sum + 1];
        for(int[] mem : memo){
            Arrays.fill(mem,-1);
        }
        return func(arr,n,sum,memo);
    }
}
