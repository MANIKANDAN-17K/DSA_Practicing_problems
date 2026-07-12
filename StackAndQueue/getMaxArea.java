class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int tp;
        int res = 0;
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                tp = st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                res = Math.max(res,arr[tp] * width);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            tp = st.pop();
            int width = st.isEmpty() ? n : n - st.peek() - 1;
            res = Math.max(res,arr[tp] * width);
        }
        return res;
    }
}
