class Solution {
    private void helper(int[] arr,int remSum,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> curr,int idx){
        if(remSum == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(remSum < 0 || idx >= arr.length) return;
        curr.add(arr[idx]);
        helper(arr,remSum - arr[idx],res,curr,idx);
        curr.remove(curr.size() - 1);
        helper(arr,remSum,res,curr,idx + 1);
    }
    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(arr,target,res,new ArrayList<>(),0);
        return res;
    }
}
