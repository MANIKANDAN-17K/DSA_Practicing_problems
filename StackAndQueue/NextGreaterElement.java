class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack();
        int n = arr.length;
        for(int i = 0;i<n;i++) res.add(-1);
        for(int i = n - 1;i >= 0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            if(!st.isEmpty()) res.set(i,st.peek());
            st.push(arr[i]);
        }
        return res;
    }
}
