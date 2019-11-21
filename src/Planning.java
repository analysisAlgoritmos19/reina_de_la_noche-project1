import java.util.ArrayList;

public class Planning implements ITestConstants {

    private ArrayList<TestTree> trees;

    public static int leafCounterProb;

    public static int leafCounterGreedy;


    public Planning(ArrayList<TestTree> p_trees){

        this.trees = p_trees;
        leafCounterGreedy = 0;
        leafCounterProb = 0;
    }

    public void generate_times(TestTree pTree){
        if(OurTimer.check_run_out_time()){
            return;
        }
        int ground_time = calculate_ground_time(pTree);
        int tree_time = calculate_tree_time(pTree);
        int distance = (ground_time*2 + tree_time*2);
        int amount_ants = AntHill.getInstance().get_amount_ants(distance);
        if(amount_ants == 0){
            return;
        }
        int last_ant_time = estimated_time(pTree, amount_ants,distance) ;
        int estimated_time = last_ant_time + amount_ants;
        boolean finished_sending_ants = false;
        ArrayList<Timestamp> arr_time_stamps = new ArrayList<>();

        for(int time = TIMESTAMP_FRECUENCY; time < estimated_time; time += TIMESTAMP_FRECUENCY){
            if(time > last_ant_time){
                finished_sending_ants = true;
            }
            Timestamp timestamp = new Timestamp(time, ground_time , tree_time, distance, amount_ants, finished_sending_ants);
            timestamp.calculate_states();
            arr_time_stamps.add(timestamp);
        }
        pTree.setTimestamps(arr_time_stamps);
        AntHill.getInstance().return_ants_to_hill(amount_ants);
    }

    private int estimated_time(TestTree pTree, int amount_ants, int distance){
        return (int) (distance * pTree.getAmount_leaves() / amount_ants);
    }

    private int calculate_tree_time(TestTree pTree){
        float distance_value = pTree.getLength() * pTree.getLevels();
        return Math.round(distance_value/(int)(SPEED_ANT));
    }

    private int calculate_ground_time(TestTree pTree){
        return Math.round((float)pTree.getPosX()/(int)(SPEED_ANT));
    }

    public ArrayList<TestTree> planning_for_greedy(){
        Greedy greedy = new Greedy(trees);
        ArrayList<TestTree> greedy_trees = greedy.get_sorted_list();
        for (TestTree tree: greedy_trees) {
            generate_times(tree);
            if(tree.getTimestamps()!=null){
                leafCounterGreedy += tree.getAmount_leaves();
            }
        }
        return greedy_trees;
    }

    public ArrayList<TestTree> planning_for_probabilistic(){
        Probabilistic probabilistic = new Probabilistic(RANGE);
        probabilistic.fill_ratio_table(trees);
        ArrayList<TestTree> total_trees = new ArrayList<>();
        while (!OurTimer.check_run_out_time()){
            ArrayList<TestTree> sub_trees = probabilistic.select_trees();
            plan_sub_trees(sub_trees);
            total_trees.addAll(sub_trees);
        }
        return total_trees;
    }

    public ArrayList<TestTree> plan_sub_trees(ArrayList<TestTree> sub_trees){
        for (TestTree tree: sub_trees) {
            generate_times(tree);
            if(tree.getTimestamps()!=null){
                leafCounterProb += tree.getAmount_leaves();
            }
        }
        return sub_trees;
    }


}
