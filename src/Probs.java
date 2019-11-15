import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class Probs {

    LinkedHashMap<Float,ArrayList<Tree>> ratio_table;
    int total_trees;

    public Probs(Float ratio){
        create_ratio_table(ratio);
    }

    public void create_ratio_table(Float ratio){
        ratio_table = new LinkedHashMap<Float, ArrayList<Tree>>();
        for(float range = ratio; range < 1; range += ratio){
            ArrayList<Tree> ratio_tree_list =  new ArrayList<Tree>();
            ratio_table.put(range, ratio_tree_list);
        }

    }

    public void fill_ratio_table(ArrayList<Tree> TreeList) {
        total_trees = TreeList.size();
        for(Tree tree:TreeList) {
            for (Float key : ratio_table.keySet()) {
                if (tree.getScore() <= key) {
                    ratio_table.get(key).add(tree);
                    break;
                }
            }
        }
    }

    public void print_ratio_table(){
        for(Float key : ratio_table.keySet()){
            System.out.println(key);
            System.out.println(ratio_table.get(key).size());
            System.out.println();
        }
    }

    public float select_trees(){
        Random rand = new Random();
        float choice = (float) (rand.nextFloat() * (1.0 - 0.0) + 0.0);
        float accumulator = (float) 0.0;
        float current_key = 0;
        for(Float key : ratio_table.keySet()){
            float probability  = (float) ratio_table.get(key).size()/total_trees;
            if(probability != (float)0.0){
                accumulator += probability;
                current_key = key;
                if(choice < accumulator){
                    //return ratio_table.get(key);
                    return current_key;
                }
            }
        }
        return current_key;
    }



    public static void main(String[] args){
        TreeGenerator l = new TreeGenerator(20,25,1000, (float) 1.0,18,15);
        Probs probs = new Probs((float)0.2);
        probs.fill_ratio_table(l.getList_of_trees());
        probs.print_ratio_table();
        System.out.printf("Entro a : %2f", probs.select_trees());
    }



}
