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
    public int minTime(Node root, int target) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        buildGraph(root,null,graph);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        visited.add(target);
        q.offer(target);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean burn = false;
            for(int i = 0;i<size;i++){
                int node = q.poll();
                for(int neighbour : graph.getOrDefault(node,new ArrayList<>())){
                    if(visited.add(neighbour)){
                        q.offer(neighbour);
                        burn = true;
                    }
                }
            }
            if(burn){
                time++;
            }
        }
        
        return time;
    }
    private void buildGraph(Node child,Node Parent,Map<Integer,List<Integer>> graph){
        if(child == null) return;
        if(Parent != null){
            graph.computeIfAbsent(child.data,k -> new ArrayList<>()).add(Parent.data);
            graph.computeIfAbsent(Parent.data,k -> new ArrayList<>()).add(child.data);
        }
        buildGraph(child.left,child,graph);
        buildGraph(child.right,child,graph);
    }
}
