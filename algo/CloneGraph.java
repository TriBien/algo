// Ref: https://leetcode.com/problems/clone-graph/description/?envType=study-plan-v2&envId=top-interview-150

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) return null;
        if (node.neighbors.size() == 0) return new Node(node.val);

        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node nodeQ = queue.poll();
            List<Node> neighbors = nodeQ.neighbors;
            for (Node n: neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    queue.add(n);
                }

                map.get(nodeQ).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }
}