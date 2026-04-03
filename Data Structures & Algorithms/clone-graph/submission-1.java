/*
Definition for a Node.
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
        if(node == null) return null;

        Map<Node, Node> nodeMap = new HashMap<>();

        return helper(node, nodeMap);
    }

    private Node helper(Node node, Map<Node, Node> nodeMap) {
        // If node is already present in the nodeMap, then it has been cloned
        // and we do not want to process it in the dfs again
        if(nodeMap.containsKey(node)) return nodeMap.get(node);

        Node newNode = new Node(node.val);
        nodeMap.put(node, newNode);

        for(Node neighbour:node.neighbors) {
            Node newNeighbour = helper(neighbour, nodeMap);

            newNode.neighbors.add(newNeighbour);
        }

        return newNode;
    }
}