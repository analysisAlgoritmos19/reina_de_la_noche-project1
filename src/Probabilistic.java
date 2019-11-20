import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class Probabilistic {

    private LinkedHashMap<Float,Prob> ratio_table;
    private int total_trees;
    private int total_leaves;


    public Probabilistic(Float ratio){

        create_ratio_table(ratio);
    }

    public void create_ratio_table(Float ratio){
        ratio_table = new LinkedHashMap<>();
        for(float range = ratio; range <= 1; range += ratio){
            Prob prob = new Prob();
            ratio_table.put(range, prob);
        }

    }

    public void fill_ratio_table(ArrayList<TestTree> TreeList) {
        total_trees = TreeList.size();
        for(TestTree tree:TreeList) {
            for (Float key : ratio_table.keySet()) {
                if (tree.getScore() <= key) {
                    ratio_table.get(key).add_tree(tree);
                    long amount_of_leaves = tree.getAmount_leaves();
                    ratio_table.get(key).add_to_counter(amount_of_leaves);
                    total_leaves += amount_of_leaves;
                    break;
                }
            }
        }
        set_all_percentages();
    }

    public void print_ratio_table(){
        for(Float key : ratio_table.keySet()){
            System.out.println(key);
            System.out.println(ratio_table.get(key).getLeaf_counter());
            System.out.println();
        }
    }

    public void set_all_percentages(){
        for (float key: ratio_table.keySet()) {
            System.out.println("Entre ");
            ratio_table.get(key).calculate_percentage(total_leaves);
        }
    }


    public ArrayList<TestTree> select_trees(){
        Random rand = new Random();
        float choice = (float) (rand.nextFloat() * (1.0 - 0.0) + 0.0);
        System.out.println("This is the choice: "+choice);
        float accumulator = (float) 0.0;
        float current_key = 0;
        for(Float key : ratio_table.keySet()){
            float probability  = ratio_table.get(key).getPercentage_leaf();
            System.out.println("This is probability: "+ probability);
            //if(probability != (float)0.0){
                accumulator += probability;
                current_key = key;
                if(choice < accumulator){
                    System.out.printf("Entro a : %2f \n",current_key);
                    return get_sub_array(ratio_table.get(key).getList_of_trees());
                }
            //}
        }
        System.out.printf("Entro a : %2f \n",current_key);
        return get_sub_array(ratio_table.get(current_key).getList_of_trees());
    }

    private ArrayList<TestTree> get_sub_array(ArrayList<TestTree> tree_arrayList){
        Random rand = new Random();
        ArrayList<TestTree> sub_array = new ArrayList<>();
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



    public static void main(String[] args) {
        TestGenerator testGenerator = new TestGenerator();
        Probabilistic probabilistic = new Probabilistic((float)0.2);
        probabilistic.fill_ratio_table(testGenerator.getTests()[0]);
        System.out.println("Total amount of leaves: "+ probabilistic.total_leaves);
        probabilistic.print_ratio_table();
        ArrayList<TestTree> testTrees = probabilistic.select_trees();
        for (TestTree tree: testTrees) {
            tree.printTree();
        }
    }
}
