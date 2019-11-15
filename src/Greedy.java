import java.util.ArrayList;
import java.util.Collections;

public class Greedy {

    private ArrayList<Tree> Sort_trees;
    private int Max_distance;
    private int Max_trunk;

    public Greedy(TreeGenerator pTrees){
        this.Sort_trees = new ArrayList<>(pTrees.getList_of_trees());
        this.Max_distance = pTrees.getMax_distance();
        this.Max_trunk = pTrees.getMax_trunk();
        Collections.sort(this.Sort_trees);
    }

    public void printTrees(){
        for(Tree tree : this.Sort_trees){
            System.out.println("Score: " + tree.getScore());
            System.out.println("Distance: " + tree.getDistance());
            System.out.println("Trunk size: " + tree.getTrunk());
            System.out.println("Levels: " + tree.getLevels());
            System.out.println("Growth: " + tree.getGrowth());
            System.out.println("Leaf size: " + tree.getLeaf_size());
            System.out.println("Amount of leaves: " + tree.getAmount_leaves());
            System.out.println("Time: " + timeForTree(tree) + "\n");
        }
    }

    public int timeForTree(Tree tree){
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
