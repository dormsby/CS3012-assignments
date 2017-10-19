import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LCAtest {


    @Test
    public void testGet(){
        LCA<Integer, Integer> lca = new LCA<Integer, Integer>();
        lca.put(2, 2);
        lca.put(6, 6);
        lca.put(4, 4);
        lca.put(5,5);
        assertEquals("test get node with key 5", (Integer) 5, lca.get(5));
    }

    /**
    @Test
    public void testHeight(){
        LCA<Integer, Integer> bst = new LCA<Integer, Integer>();
        //add nodes
        int height = lca.height(5);     //find h of node with key 5
        assertEquals("Test the height of a node",3, height);

    }

    @Test
    public void testGetParent(){
        LCA<Integer, Integer> bst = new LCA<Integer, Integer>();
        //add nodes
        int parent = lca.getParent(3);
        assertEquals("Test for the  parent of a node", 2, parent);
    }

    @Test
    public void testParents(){
        LCA<Integer, Integer> bst = new LCA<Integer, Integer>();
        //add nodes
        int[] parents = lca.parents(4);
        int[] expected = {1,3};
        Assert.assertArrayEquals(expected, parents);
    }

    @Test
    public void testFindLCA(){
        LCA<Integer, Integer> bst = new LCA<Integer, Integer>();
        //add nodes
        int lca = lca.findLCA(3,7);
        assertEquals("Test for key of LCA of two nodes", 2, lca);
    }*/
}
