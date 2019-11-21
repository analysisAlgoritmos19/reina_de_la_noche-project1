import java.util.ArrayList;

public class Prob {

    private ArrayList<TestTree> list_of_trees;
    private long leaf_counter;
    private float percentage_leaf;

    public Prob() {
        this.list_of_trees = new ArrayList<>();
        this.leaf_counter = 0;
        this.percentage_leaf = (float) 0.0;
    }

    public void setPercentage_leaf(float percentage_leaf) {
        this.percentage_leaf = percentage_leaf;
    }
    public ArrayList<TestTree> getList_of_trees() {
        return list_of_trees;
    }

    public long getLeaf_counter() {
        return leaf_counter;
    }

    public void add_to_counter(long leaves_add){
        this.leaf_counter += leaves_add;
    }

    public void add_tree(TestTree tree){
        list_of_trees.add(tree);
    }

    public float getPercentage_leaf() {
        return percentage_leaf;
    }
}
