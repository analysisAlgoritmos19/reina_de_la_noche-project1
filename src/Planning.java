import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Planning implements ITestConstants {

    String initialTime = "00:00:00";  //La hora con forma de String

    //Hay que agregarle el tipo del return
    public void Generate_times(TestTree pTree, int time_seconds){
        int ground_time = calculate_ground_time(pTree);
        int tree_time = calculate_tree_time(pTree);
        System.out.printf("Ground time: %d   Tree time: %d \n", ground_time, tree_time);


        int distance = (ground_time*2 + tree_time*2);
        int amount_ants = AntHill.getInstance().get_amount_ants(distance);
        int last_ant_time = estimated_time(pTree, amount_ants,distance) ;
        int estimated_time = last_ant_time + amount_ants;
        boolean finished_sending_ants = false;
        /*Timestamp timestamp = new Timestamp(530, ground_time , tree_time, distance, amount_ants, finished_sending_ants);
        timestamp.calculate_states();
        timestamp.print_states();*/
        System.out.println("Estimated time " + estimated_time);
        for(int time = TIMESTAMP_FRECUENCY; time < estimated_time; time += TIMESTAMP_FRECUENCY){
            if(time > last_ant_time){
                finished_sending_ants = true;
            }
            Timestamp timestamp = new Timestamp(time, ground_time , tree_time, distance, amount_ants, finished_sending_ants);
            timestamp.calculate_states();
            timestamp.print_states();
        }

       /*while(finish_time > 0){
            Timestamp timestamp = new Timestamp(start_time, ground_time , tree_time, amount_ants, available_ants, (int) pTree.getAmount_leaves());
            timestamp.calculate_states();
            timestamp.print_states();
            finish_time -= time_seconds;
            start_time += time_seconds;
            available_ants = timestamp.get_ants_ready();
        }*/
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
        TestTree tree = new TestTree(8,10, 8);
        Planning planning =  new Planning();
        planning.Generate_times(tree,10);
    }

}
