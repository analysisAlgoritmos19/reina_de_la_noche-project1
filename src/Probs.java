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
        for(float range = ratio; range <= 1; range += ratio){
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

    public ArrayList<Tree> select_trees(){
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
                    System.out.printf("Entro a : %2f \n",current_key);
                    return get_sub_array(ratio_table.get(key));
                }
            }
        }
        System.out.printf("Entro a : %2f \n",current_key);
        return get_sub_array(ratio_table.get(current_key));
    }

    private ArrayList<Tree> get_sub_array(ArrayList<Tree> tree_arrayList){
        Random rand = new Random();
        ArrayList<Tree> sub_array = new ArrayList<>();
        int size_array = tree_arrayList.size();
        float percentage = (float) (rand.nextFloat() * (0.5 - 0.3) + 0.3);
        for(int amount_of_trees = Math.round(size_array * percentage);amount_of_trees > 0; amount_of_trees--){
            int array_index = rand.nextInt(size_array);
            sub_array.add(tree_arrayList.get(array_index));
            tree_arrayList.remove(array_index);
            size_array--;
        }
        return sub_array;
    }



    public static void main(String[] args){
        TreeGenerator l = new TreeGenerator(45,50,10000, (float) 1.0,18,10);
        Probs probs = new Probs((float)0.2);
        probs.fill_ratio_table(l.getList_of_trees());
        probs.print_ratio_table();
        ArrayList<Tree> sub_array = probs.select_trees();
        for(Tree tree : sub_array){
            tree.printTree();
        }
        System.out.println(sub_array.size());
    }



}
