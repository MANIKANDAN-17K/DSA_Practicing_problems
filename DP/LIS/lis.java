class Solution {
    static int longSeq(int[] arr,int idx,int[] dp){
        if(idx == 0) return 1;
        if(dp[idx] != -1) return dp[idx];
        int mx = 1;
        for(int prev = 0;prev < idx;prev++){
            if(arr[idx] > arr[prev]){
                mx = Math.max(mx,longSeq(arr,prev,dp) + 1);
            }
        }
        dp[idx] = mx;
        return dp[idx];
    }
    static int lis(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int res = 1;
        for(int i = 1;i<n;i++){
            res = Math.max(res,longSeq(arr,i,dp));
        }
        return res;
    }
}
/*
Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).
A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

Examples:

Input: arr[] = [5, 8, 3, 7, 9, 1]
Output: 3
Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.

Input: arr[] = [10, 6, 3, 11, 7, 15]
Output: 3
Explanation: One of the possible longest strictly increasing subsequences is [10, 11, 15], which has a length of 3.

Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3.
function lisEndingAtIdx(arr, idx) {

    // Base case
    if (idx === 0)
        return 1;

    // Consider all elements on the left of i,
    // recursively compute LISs ending with
    // them and consider the largest
    let mx = 1;
    for (let prev = 0; prev < idx; prev++) {
        if (arr[prev] < arr[idx]) {
            mx = Math.max(mx,
                          lisEndingAtIdx(arr, prev) + 1);
        }
    }
    return mx;
}

function lis(arr) {
    let n = arr.length;
    let res = 1;
    for (let idx = 1; idx < n; idx++) {
        res = Math.max(res, lisEndingAtIdx(arr, idx));
    }
    return res;
}

let arr = [ 3, 10, 2, 1, 20];
console.log(lis(arr));
*/
