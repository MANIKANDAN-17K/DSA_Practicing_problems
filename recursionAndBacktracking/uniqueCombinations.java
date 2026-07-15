class Solution {
    private void findUniqueComb(int idx,int rem,int[] arr,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> temp){
        if(rem == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx;i<arr.length;i++){
            if(idx < i && arr[i] == arr[i-1]) continue;
            if(arr[i] > rem) break;
            temp.add(arr[i]);
            findUniqueComb(i+1,rem - arr[i],arr,res,temp);
            temp.remove(temp.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        findUniqueComb(0,target,arr,res,new ArrayList<>());
        return res;
    }
}
