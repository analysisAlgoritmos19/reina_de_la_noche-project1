import java.util.ArrayList;

public class Prob {

    private ArrayList<TestTree> list_of_trees;
    private long leaf_counter;
    private float percentage_leaf;

    public Prob() {
        this.list_of_trees = new ArrayList<>();
        this.leaf_counter = 0;
        this.percentage_leaf = 0;
    }

    public ArrayList<TestTree> getList_of_trees() {
        return list_of_trees;
    }

    public long getLeaf_counter() {
        return leaf_counter;
    }

    public void add_to_counter(long add){
        this.leaf_counter += add;
    }
    public void add_tree(TestTree tree){
        list_of_trees.add(tree);
    }

    public void calculate_percentage(long total_amount_leaves){
        this.percentage_leaf = (float)(leaf_counter/total_amount_leaves);
    }

    public float getPercentage_leaf() {
        return percentage_leaf;
    }
}
