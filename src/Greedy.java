import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Greedy {

    private ArrayList<TestTree> Sort_trees;
    private TreeMap<Double, TestTree> map = new TreeMap<Double, TestTree>();
    private ArrayList<TestTree> testTrees = new ArrayList<TestTree>();

    public Greedy(ArrayList<TestTree> pTrees){
        for(TestTree tree : pTrees){
            map.put(tree.getScore(), tree);
        }
        treeMap_to_ArrayList();
    }


    private void treeMap_to_ArrayList() {
        for (Map.Entry<Double, TestTree> entry : map.entrySet()) {
            testTrees.add(entry.getValue());
        }
    }

    public TestTree get_Best_Tree(){
        return map.firstEntry().getValue();
    }

    public TestTree get_worst_Tree(){
        return map.lastEntry().getValue();
    }

    public ArrayList<TestTree> get_sorted_list(){
        return testTrees;
    }

    public static void main(String[] args) {
        TestGenerator testGenerator = new TestGenerator();
        ArrayList<TestTree> trees = testGenerator.getTests()[0];
        Greedy greedy = new Greedy(trees);
        ArrayList<TestTree> testTrees = greedy.get_sorted_list();
        for(TestTree tree : testTrees){
            tree.printTree();
        }

        TestTree worst = greedy.get_worst_Tree();
        worst.printTree();

        TestTree best = greedy.get_Best_Tree();
        best.printTree();
    }
}

