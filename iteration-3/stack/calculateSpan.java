class Solution {
    private int[] PEG(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] temp = PEG(arr);
        for(int i = 0;i<arr.length;i++){
            res.add(i - temp[i]);
        }
        return res;
    }
}
