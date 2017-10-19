import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LCAtest {


    @Test
    public void testGet(){
        //create tree
        assertEquals("test null", null, LCA.get(5));
        //add nodes
        assertEquals("test get node with key 5", (Integer) 5, LCA.get(5));
    }


    @Test
    public void testHeight(){
        //create new tree
        //add nodes
        int height = LCA.height(5);     //find h of node with key 5
        assertEquals("Test the height of a node",3, height);

    }

    @Test
    public void testGetParent(){
        //create new tree
        //add nodes
        int parent = LCA.getParent(3);
        assertEquals("Test for the  parent of a node", 2, parent);
    }

    @Test
    public void testParents(){
        //create new tree
        //add nodes
        int[] parents = LCA.parents(4);
        int[] expected = {1,3};
        Assert.assertArrayEquals(expected, parents);
    }

    @Test
    public void testFindLCA(){
        //create new tree
        //add nodes
        int lca = LCA.findLCA(3,7);
        assertEquals("Test for key of LCA of two nodes", 2, lca);
    }
}
