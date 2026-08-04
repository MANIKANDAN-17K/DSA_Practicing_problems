class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer>  q = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            while(!q.isEmpty() && q.peekFirst() <= i - k){
                q.pollFirst();
            }
            while(!q.isEmpty() && arr[q.peekLast()] < arr[i]){
                q.pollLast();
            }
            q.offerLast(i);
            if(i >= k -1){
                res.add(arr[q.peekFirst()]);
            }
        }
        return res;
    }
}

/* 
Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
Output: [3, 3, 4, 5, 5, 5, 6]
Explanation: 
1st contiguous subarray [1, 2, 3], max = 3
2nd contiguous subarray [2, 3, 1], max = 3
3rd contiguous subarray [3, 1, 4], max = 4
4th contiguous subarray [1, 4, 5], max = 5
5th contiguous subarray [4, 5, 2], max = 5
6th contiguous subarray [5, 2, 3], max = 5

  */
