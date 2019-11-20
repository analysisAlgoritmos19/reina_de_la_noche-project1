import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Greedy {

    private ArrayList<TestTree> Sort_trees;
    private int Max_distance;
    private int Max_trunk;
    private TreeMap<Double, TestTree> map = new TreeMap<Double, TestTree>();

    public Greedy(ArrayList<TestTree> pTrees){
        for(TestTree tree : pTrees){
            map.put(tree.getScore(), tree);
        }
    }

}
