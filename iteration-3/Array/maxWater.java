class Solution {
    public int maxWater(int arr[]) {
        int l = 0;
        int r = arr.length - 1;
        int res = 0;
        while(l < r){
            int max = Math.min(arr[l],arr[r])*(r - l);
            res = Math.max(res,max);
            if(arr[l] <= arr[r]) l++;
            else r--;
        }
        return res;
    }
}
/*
Input: arr[] = [1, 5, 4, 3]
Output: 6
Explanation: 5 and 3 are 2 distance apart. So the size of the base is 2. Height of container = min(5, 3) = 3. So, total area to hold water = 3 * 2 = 6.
  | Step | Left Index | Right Index | Left Value | Right Value | Width | Water = min(L,R) × Width | Max Water | Move    |
| ---- | ---------- | ----------- | ---------- | ----------- | ----- | ------------------------ | --------- | ------- |
| 1    | 0          | 7           | 2          | 5           | 7     | 2 × 7 = 14               | 14        | Left++  |
| 2    | 1          | 7           | 1          | 5           | 6     | 1 × 6 = 6                | 14        | Left++  |
| 3    | 2          | 7           | 8          | 5           | 5     | 5 × 5 = 25               | 25        | Right-- |
| 4    | 2          | 6           | 8          | 5           | 4     | 5 × 4 = 20               | 25        | Right-- |
| 5    | 2          | 5           | 8          | 6           | 3     | 6 × 3 = 18               | 25        | Right-- |
| 6    | 2          | 4           | 8          | 4           | 2     | 4 × 2 = 8                | 25        | Right-- |
| 7    | 2          | 3           | 8          | 6           | 1     | 6 × 1 = 6                | 25        | Right-- |
| End  | 2          | 2           | -          | -           | -     | Stop                     | **25**    |         |
  */
