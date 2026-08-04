class Solution {
    static boolean canAttend(int[][] arr) {
        Arrays.sort(arr,(a,b) -> Integer.compare(a[1],b[1]));
        for(int i = 1;i<arr.length;i++){
            int end = arr[i-1][1];
            int start = arr[i][0];
            if(start < end){
                return false;
            }
        }
        return true;
    }
}
