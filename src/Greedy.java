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

/*
    public int timeForTree(TestTree tree){
        System.out.println();
        int ans = 0;
        ans += Max_distance;
        ans += Max_trunk;
        double current = tree.getLength();
        for(int i = 0; i < tree.getLevels(); i++){
            current = current * tree.getGrowth();
            ans += current;
        }
        ans = (ans * 2) + 1;
        return ans;
    }

 */
}
