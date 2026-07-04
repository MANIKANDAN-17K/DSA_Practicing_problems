class Solution {
    static int lis(int arr[]) {
        int n = arr.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for(int i = 1;i<n;i++){
            if(arr[i] > temp.get(temp.size() - 1)){
                temp.add(arr[i]);
            }else{
                int idx = Collections.binarySearch(temp,arr[i]);
                if(idx < 0) idx = -(idx + 1);
                temp.set(idx,arr[i]);
            }
        }
        return temp.size();
    }
}
