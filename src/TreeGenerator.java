
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class TreeGenerator {
    private int Max_leaf_size;
    private int Max_trunk;
    private int Max_distance;
    private float Max_growth;
    private int Max_Levels;
    private int Amount_of_trees;
    private ArrayList<Tree> List_of_trees;
    private TreeMap<Float, Tree> Sorted_Scores = new TreeMap<Float, Tree>();
    private TreeMap<Float, Tree> Sorted_Distances = new TreeMap<Float, Tree>();

    public TreeGenerator(int p_max_leaf_size, int p_max_trunk, int p_max_distance, float p_max_growth,int p_levels, int p_amount_of_trees) {
        List_of_trees = new ArrayList<>();
        this.Max_leaf_size = p_max_leaf_size;
        this.Max_trunk = p_max_trunk;
        this.Max_distance = p_max_distance;
        this.Max_growth = p_max_growth;
        this.Max_Levels = p_levels;
        this.Amount_of_trees = p_amount_of_trees;
        generate_trees();
        printTrees();
    }

    public void generate_trees(){
        for (int tree_index = 0; tree_index < Amount_of_trees; tree_index++) {
            float leaf_size =  (float)(Math.random()*((Max_leaf_size-1)+1))+1;
            Random r = new Random();
            int distance = r.nextInt(Max_distance - 1) + 1;
            int trunk = r.nextInt(Max_leaf_size - 1) + 1;
            float growth = (float)(Math.random());
            int levels = (int)(Math.random()*((Max_Levels - 1) + 1)) + 1;
            Tree tree = new Tree(leaf_size, distance, trunk, growth, levels);
            viability_of_tree(tree);
        }
    }

    public void viability_of_tree(Tree p_tree){
        float viability;
        float currentDistance = p_tree.getDistance() / Max_distance;     //Menor = mejor
        float currentLeaf = 1 - (p_tree.getLeaf_size() / (Max_leaf_size + 1));     //Mayor = mejor
        float currentTrunk = p_tree.getTrunk() / Max_trunk;              //Menor = mejor
        float currentGrowth = p_tree.getGrowth();                    //Mayor = mejor
        float currentLevels = (float)(1 - (p_tree.getLevels() / (18 + 1)));   //Mayor = mejor
        viability = currentDistance * currentLeaf * currentTrunk * currentGrowth * currentLevels;
        p_tree.setScore(viability);
        List_of_trees.add(p_tree);
    }

    public void printTrees(){
        for(Tree tree : List_of_trees){
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

    public void sortByScore(){
        for(Tree tree : List_of_trees){
            Sorted_Scores.put(tree.getScore(), tree);
        }
    }

    public void sortByDistance(){
        for(Tree tree : List_of_trees){
            Sorted_Distances.put(tree.getDistance(), tree);
        }
    }

    public int getMax_leaf_size() {
        return Max_leaf_size;
    }

    public void setMax_leaf_size(int max_leaf_size) {
        Max_leaf_size = max_leaf_size;
    }

    public int getMax_trunk() {
        return Max_trunk;
    }

    public void setMax_trunk(int max_trunk) {
        Max_trunk = max_trunk;
    }

    public int getMax_distance() {
        return Max_distance;
    }

    public void setMax_distance(int max_distance) {
        Max_distance = max_distance;
    }

    public float getMax_growth() {
        return Max_growth;
    }

    public void setMax_growth(float max_growth) {
        Max_growth = max_growth;
    }

    public int getMax_Levels() {
        return Max_Levels;
    }

    public void setMax_Levels(int max_Levels) {
        Max_Levels = max_Levels;
    }

    public int getAmount_of_trees() {
        return Amount_of_trees;
    }

    public void setAmount_of_trees(int amount_of_trees) {
        Amount_of_trees = amount_of_trees;
    }

    public ArrayList<Tree> getList_of_trees() {
        return List_of_trees;
    }

    public void setList_of_trees(ArrayList<Tree> list_of_trees) {
        List_of_trees = list_of_trees;
    }
}
