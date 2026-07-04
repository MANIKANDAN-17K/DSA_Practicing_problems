class Solution {
    public int maxProfit(int[] prices) {
       int minPrice = Integer.MAX_VALUE;
       int MaxProfit = 0;
       for(int price : prices){
           if(price < minPrice) minPrice = price;
           else MaxProfit = Math.max(MaxProfit,price - minPrice);
       }
       return MaxProfit;
    }
}
