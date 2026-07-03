class Solution {
    public static String kthPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for(int i = 1;i<n;i++){
            fact *= i;
            nums.add(i);
        }
        nums.add(n);
        StringBuilder sb = new StringBuilder();
        k = k - 1;
        while(true){
            sb.append(nums.get(k/fact));
            nums.remove(k/fact);
            if(nums.isEmpty()) break;
            k = k % fact;
            fact = fact / nums.size();
        }
        return sb.toString();
    }
}
