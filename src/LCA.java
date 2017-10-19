
public class LCA<Key extends Comparable<Key>, Value>{
    private Node root;

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private Node parent;        // parent of node

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

}
