
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.TreeMap;

public class TreeGenerator {
    private int Max_leaf_size;
    private int Max_trunk;
    private int Max_distance;
    private float Max_growth;
    private int Max_Levels;
    private int Amount_of_trees;
    private int Worst_case;
    private ArrayList<Tree> List_of_trees;
    private TreeMap<Double, Tree> Sorted_Scores = new TreeMap<Double, Tree>();
    private TreeMap<Float, Tree> Sorted_Distances = new TreeMap<Float, Tree>();

    public TreeGenerator(int p_max_leaf_size, int p_max_trunk, int p_max_distance, float p_max_growth,int p_levels, int p_amount_of_trees) {
        List_of_trees = new ArrayList<>();
        this.Max_leaf_size = p_max_leaf_size;
        this.Max_trunk = p_max_trunk;
        this.Max_distance = p_max_distance;
        this.Max_growth = p_max_growth;
        this.Max_Levels = p_levels;
        this.Amount_of_trees = p_amount_of_trees;
        set_Worst_case();
        generate_trees();
        //printTrees();
    }

    public void generate_trees(){
        for (int tree_index = 0; tree_index < Amount_of_trees; tree_index++) {
            Random r = new Random();
            float leaf_size =  r.nextInt(Max_leaf_size) + 1;
            int distance = r.nextInt(Max_distance) + 1;
            int trunk = r.nextInt(Max_leaf_size) + 1;
            float growth = ((float)(r.nextInt(8) + 1)) / 10;
            int levels = r.nextInt(Max_Levels) + 1;
            Tree tree = new Tree(leaf_size, distance, trunk, growth, levels);
            viability_of_tree(tree);
        }
    }

    public void viability_of_tree(Tree p_tree){

        float distance_value, viability;
        float current_Distance = p_tree.getDistance();     //Menor = mejor
        float current_Leaf = p_tree.getLeaf_size();     //Mayor = mejor
        float current_Trunk = p_tree.getTrunk();              //Menor = mejor
        float current_Growth = p_tree.getGrowth();                    //Mayor = mejor
        float current_Levels = (float)p_tree.getLevels();   //Mayor = mejor

        distance_value = current_Distance;
        float current = current_Trunk;
        for(int i = 0; i < current_Levels; i++){
            distance_value += current;
            current = current * current_Growth;
        }


        float leaf_ratio = 1 - (current_Leaf / (Max_leaf_size + 1));
        float distance_ratio = distance_value / Worst_case;
        //System.out.println("Distance ratio: " + distance_ratio);
        //System.out.println("Leaf ratio: " + leaf_ratio + "\n");

        viability = distance_ratio;

        BigDecimal bd = new BigDecimal(viability).setScale(3, RoundingMode.HALF_UP);
        double rounded_viability = bd.doubleValue();
        p_tree.setScore(rounded_viability);
        List_of_trees.add(p_tree);
    }

    public void set_Worst_case(){
        Worst_case = Max_distance;
        double current = Max_trunk;
        for(int i = 0; i < Max_Levels; i++){
            Worst_case += current;
            current = current * 0.9;
        }
        //Worst_case += current;
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
