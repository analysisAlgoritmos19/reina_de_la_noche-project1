import java.util.ArrayList;

public class Planning implements ITestConstants {

    public void Generate_times(TestTree pTree){
        int ground_time = calculate_ground_time(pTree);
        int tree_time = calculate_tree_time(pTree);
        System.out.printf("Ground time: %d   Tree time: %d \n", ground_time, tree_time);
        int distance = (ground_time*2 + tree_time*2);
        int amount_ants = AntHill.getInstance().get_amount_ants(distance);
        int last_ant_time = estimated_time(pTree, amount_ants,distance) ;
        int estimated_time = last_ant_time + amount_ants;
        boolean finished_sending_ants = false;
        System.out.println("Estimated time " + estimated_time);
        ArrayList<Timestamp> arr_time_stamps = new ArrayList<>();

        for(int time = TIMESTAMP_FRECUENCY; time < estimated_time; time += TIMESTAMP_FRECUENCY){
            if(time > last_ant_time){
                finished_sending_ants = true;
            }
            Timestamp timestamp = new Timestamp(time, ground_time , tree_time, distance, amount_ants, finished_sending_ants);
            timestamp.calculate_states();
            arr_time_stamps.add(timestamp);
            timestamp.print_states();
        }
        pTree.setTimestamps(arr_time_stamps);
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

    public static void main (String[] args){
        Planning planning =  new Planning();
    }
}
