import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class Probabilistic {

    private LinkedHashMap<Float,Prob> ratio_table;

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
            System.out.println(ratio_table.get(key).getPercentage_leaf());
            System.out.println();
        }
    }

    public void set_all_percentages(){
        for (float key: ratio_table.keySet()) {
            long amount_of_leaves_in_ratio = ratio_table.get(key).getLeaf_counter();
            ratio_table.get(key).setPercentage_leaf((float) amount_of_leaves_in_ratio/total_leaves);
        }
    }

    public ArrayList<TestTree> select_trees(){
        Random rand = new Random();
        float choice = (float) (rand.nextFloat() * (1.0 - 0.0) + 0.0);
        float accumulator = (float) 0.0;
        float current_key = 0;
        for(Float key : ratio_table.keySet()){
            double probability  = ratio_table.get(key).getPercentage_leaf();
            accumulator += probability;
            current_key = key;
            if(choice < accumulator){
                return get_sub_array(ratio_table.get(key).getList_of_trees());
            }

        }
        return get_sub_array(ratio_table.get(current_key).getList_of_trees());
    }

    private ArrayList<TestTree> get_sub_array(ArrayList<TestTree> tree_arrayList){
        Random rand = new Random();
        ArrayList<TestTree> sub_array = new ArrayList<>();
        int size_array = tree_arrayList.size();
        int size_of_sample = (int)(size_array * (float) 0.33);
        for(int amount_of_trees = 0; amount_of_trees < size_of_sample; amount_of_trees++){
            int rand_array_index = rand.nextInt(size_array);
            sub_array.add(tree_arrayList.get(rand_array_index));
            tree_arrayList.remove(rand_array_index);
            size_array --;
        }
        return sub_array;
    }

    public static void main(String[] args) {
        TestGenerator testGenerator = new TestGenerator();
        float ratio = (float)0.2;
        Probabilistic probabilistic = new Probabilistic(ratio);
        probabilistic.fill_ratio_table(testGenerator.getTests()[0]);
        for (int i = 0; i < 1; i++) {
            for (TestTree tree: probabilistic.select_trees()) {
                tree.printTree();
                System.out.println(" ");
            }
        }
    }
}
