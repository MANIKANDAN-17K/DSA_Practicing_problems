class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        long n = arr.length;
        long s = (n * (n + 1))/2;
        long sq = (n * (n + 1) * (2 * n + 1))/6;
        for(int i =0;i<n;i++){
            s -= arr[i];
            sq -= 1L * arr[i] * arr[i];
        }
        long miss= (s + sq / s) / 2;
        long rpt =  miss - s;
        res.add((int)rpt);
        res.add((int)miss);
        return res;
    }
}
