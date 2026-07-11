class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int cnt = 1;
        int i = 1;
        int j = 0;
        int n = arr.length;
        int max = 1;
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                cnt++;
                i++;
            }else if(arr[i] > dep[j]){
                cnt--;
                j++;
            }
            max = Math.max(max,cnt);
        }
        return max;
    }
}
