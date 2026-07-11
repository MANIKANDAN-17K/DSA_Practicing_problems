class Solution {
    
    private void helper(int[] arr,int idx,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> subset){
        res.add(new ArrayList<>(subset));
        for(int i = idx;i<arr.length;i++){
            if(i > idx && arr[i] == arr[i-1]) continue;
            subset.add(arr[i]);
            helper(arr,i+1,res,subset);
            subset.remove(subset.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(arr,0,res,new ArrayList<>());
        return res;
    }
}
