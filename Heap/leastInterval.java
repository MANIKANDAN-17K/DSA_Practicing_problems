class Solution {
    static int leastInterval(int N, int K, char tasks[]) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i = 0;i<N;i++){
            freq.put(tasks[i],freq.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : freq.values()){
            pq.add(val);
        }
        int time = 0;
        while(!pq.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int cycle = K + 1;
            int i = 0;
            while(i < cycle && !pq.isEmpty()){
                int count = pq.poll();
                count--;
                if(count > 0)
                    temp.add(count);
                i++;
                time++;
            }
            for(int val : temp){
                pq.add(val);
            }
            if(!pq.isEmpty()){
                time += (cycle - i);
            }
        }
    return time;
    }
}
