

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
        else {
            x.val = val;
            x.parent = prev;
        }
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

    public Key getParentKey(Key key) {return getParentKey(root, key);}

    private Key getParentKey(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return getParentKey(x.left, key);
        else if (cmp > 0) return getParentKey(x.right, key);
        else if (x.key == root.key)
            return null;
        else return x.parent.key;
    }

    public int numberOfAncestors (Key key){
        int ancestors =0;
        Key parent = getParentKey(key);
        while(parent != null){
            ancestors++;
            parent = getParentKey(parent);
        }
        return ancestors;
    }

    public int [] ancestorsKeys(Key key){
        int size = numberOfAncestors(key);
        int [] ancestors = new int [size];
        Key parent;
        for(int i =0; i < size; i++) {
            parent = getParentKey(key);
            ancestors[i] = (Integer) parent;
            key = parent;
        }
        return ancestors;
    }


    public int getLCA(Key key1, Key key2){
        int[] ancestors1, ancestors2;
        ancestors1 = ancestorsKeys(key1);
        ancestors2 = ancestorsKeys(key2);

        int lcaKey = -1;
        for(int i =0; i< ancestors1.length;i++){
            for(int j =0; j < ancestors2.length; j++){
                if(ancestors1[i]==ancestors2[j]) {
                    lcaKey = ancestors1[i];
                    return lcaKey;
                }
            }
        }
        return lcaKey;
    }

}