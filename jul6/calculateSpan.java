class Solution {
    private int[] findPGE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pge = new int[n];
        for(int i = 0;i<n;i++){
            int curr = arr[i];
            while(!st.isEmpty() && arr[st.peek()] <= curr){
                st.pop();
            }
            if(st.isEmpty()){
                pge[i] = -1;
            }else{
                pge[i] = st.peek();
            }
            st.push(i);
        }
        return pge;
        
    }
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int[] PGE = findPGE(arr);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            res.add(i - PGE[i]);
        }
        return res;
    }
}
