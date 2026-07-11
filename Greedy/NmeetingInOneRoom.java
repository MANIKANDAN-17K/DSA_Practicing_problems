class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        int n = s.length;
        int[][] arr = new int[n][2];
        for(int i = 0;i<n;i++){
            arr[i][0] = f[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr,(x,y) -> x[0] - y[0]);
        ArrayList<Integer> res = new ArrayList<>();
        int lastF = arr[0][0];
        res.add(arr[0][1]+1);
        for(int i = 1;i<n;i++){
            if(s[arr[i][1]] > lastF){
                lastF = arr[i][0];
                res.add(arr[i][1] + 1);
            }
        }
        Collections.sort(res);
        return res;
    }
}
