
public class LCA<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private Node parent;        // parent of node

        public Node(Key key, Value val, Node prev) {
            this.key = key;
            this.val = val;
            this.parent = prev;
        }
    }

    //insert key-value pair or update value if key exists
    public void put(Key key, Value val) {
        root = put(root, null, key, val);
    }

    private Node put(Node x, Node prev, Key key, Value val) {
        if (x == null) return new Node(key, val, prev);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, x, key, val);
        else if (cmp > 0) x.right = put(x.right, x, key, val);
        else x.val = val;
        return x;
    }
    //search for a given key
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }
}