/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    private void buildGraph(Map<Integer,ArrayList<Integer>> graph,Node node,Node parent){
        if(node == null) return;
        if(parent != null){
            graph.computeIfAbsent(node.data,K->new ArrayList<>()).add(parent.data);
            graph.computeIfAbsent(parent.data,K->new ArrayList<>()).add(node.data);
        }
        buildGraph(graph,node.left,node);
        buildGraph(graph,node.right,node);
    }
    
    public int minTime(Node root, int target) {
        Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
        buildGraph(graph,root,null);
        Set<Integer> visited = new HashSet<>();
        visited.add(target);
        Queue<Integer> q = new LinkedList<>();
        q.offer(target);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean burn = false;
            for(int i = 0;i<size;i++){
                int node = q.poll();
                for(int nbr : graph.getOrDefault(node,new ArrayList<>())){
                    if(!visited.contains(nbr)){
                        visited.add(nbr);
                        q.offer(nbr);

                        burn = true;
                    }
                }
            }
            if(burn) time++;
        }
        return time;
    }
}
