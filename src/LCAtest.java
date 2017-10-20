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

    @Test
    public void testGetParentKey(){
        LCA<Integer, Integer> lca = new LCA<Integer, Integer>();
        lca.put(7, 7);   //        _7_
        lca.put(8, 8);   //      /     \
        lca.put(3, 3);   //    _3_      8
        lca.put(1, 1);   //  /     \
        lca.put(2, 2);   // 1       6
        lca.put(6, 6);   //  \     /
        lca.put(4, 4);   //   2   4
        lca.put(5, 5);   //        \
                         //         5
        assertEquals("test get node with key 5", (Integer) 1, lca.getParentKey(2));
    }

    @Test
    public void testNumberOfAncestors(){
        LCA<Integer, Integer> lca = new LCA<Integer, Integer>();
        lca.put(7, 7);   //        _7_
        lca.put(8, 8);   //      /     \
        lca.put(3, 3);   //    _3_      8
        lca.put(1, 1);   //  /     \
        lca.put(2, 2);   // 1       6
        lca.put(6, 6);   //  \     /
        lca.put(4, 4);   //   2   4
        lca.put(5, 5);   //        \
                        //         5
        assertEquals("Test the height of a node",4, lca.numberOfAncestors(5) );

    }
    /**
    @Test
    public void testParents(){
        LCA<Integer, Integer> lca = new LCA<Integer, Integer>();
        //add nodes
        int[] parents = lca.parents(4);
        int[] expected = {1,3};
        Assert.assertArrayEquals(expected, parents);
    }

    @Test
    public void testFindLCA(){
        LCA<Integer, Integer> lca = new LCA<Integer, Integer>();
        //add nodes
        int lca = lca.findLCA(3,7);
        assertEquals("Test for key of LCA of two nodes", 2, lca);
    }*/
}
