import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Greedy {

    private ArrayList<Tree> Sort_trees;
    private int Max_distance;
    private int Max_trunk;
    private TreeMap<Double, Tree> map = new TreeMap<Double, Tree>();

    public Greedy(ArrayList<Tree> pTrees){
        for(Tree tree : pTrees){
            map.put(tree.getScore(), tree);
        }
        printTrees();
    }

    public void printTrees(){
        System.out.println("__________________________________________________________________________-");
        map.forEach((k, v) -> {
            System.out.print("Key / Score: " + k + "\n");
            System.out.print("Trunk size: " + v.getTrunk() + "\n");
            System.out.print("Levels: " + v.getLevels() + "\n");
            System.out.print("Growth: " + v.getGrowth() + "\n");
            System.out.print("Leaf size: " + v.getLeaf_size() + "\n");
            System.out.print("Amount leaves: " + v.getAmount_leaves() + "\n");
            System.out.println("Distance" + v.getDistance() + "\n");
        });
    }

    public int timeForTree(Tree tree){
        System.out.println();
        int ans = 0;
        ans += Max_distance;
        ans += Max_trunk;
        double current = tree.getTrunk();
        for(int i = 0; i < tree.getLevels(); i++){
            current = current * tree.getGrowth();
            ans += current;
        }
        ans = (ans * 2) + 1;
        return ans;
    }
}
