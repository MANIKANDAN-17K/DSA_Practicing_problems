class Solution {
    public List<Integer> twoSum(int arr[], int target) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            int compli = target - arr[i];
            if(set.contains(compli)){
                res.add(compli);
                res.add(arr[i]);
                return res;
            }
            set.add(arr[i]);
        }
        return res;
    }
}
