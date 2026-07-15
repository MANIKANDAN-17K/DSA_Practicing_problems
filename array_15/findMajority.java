class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int ele1 = -1;
        int ele2 = -1;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int ele : arr){
            if(ele1 == ele) cnt1++;
            else if(ele2 == ele) cnt2++;
            else if(cnt1 == 0) {ele1 = ele;cnt1++;}
            else if(cnt2 == 0) {ele2 = ele;cnt2++;}
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int ele : arr){
            if(ele1 == ele) cnt1++;
            if(ele2 == ele) cnt2++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        if(cnt1 > n/3) res.add(ele1);
        if(cnt2 > n/3 && ele1 != ele2) res.add(ele2);
        if(res.size() == 2 && res.get(0) > res.get(1)){
            Collections.swap(res,0,1);
        }
        return res;
    }
}
