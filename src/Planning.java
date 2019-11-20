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
        long finish_time = estimated_finish_time(pTree, (ground_time + tree_time) *2, 100);
        int start_time = 0;
        while(finish_time > 0){
            Timestamp timestamp = new Timestamp(start_time, ground_time , tree_time, 100, (int) pTree.getAmount_leaves());
            timestamp.calculate_states();
            timestamp.print_states();
            finish_time -= time_seconds;
            start_time += time_seconds;
        }
    }

    private long estimated_finish_time(TestTree pTree, int total_time, int amount_ants) {
        System.out.println(Math.round((total_time * pTree.getAmount_leaves()) / 100) + 100);
        return Math.round((total_time * pTree.getAmount_leaves()) / 100) + 100;
    }

    private int calculate_tree_time(TestTree pTree){
        float distance_value = pTree.getLength() * pTree.getLevels();
        return Math.round(distance_value/SPEED_ANT);
    }

    private int calculate_ground_time(TestTree pTree){
        return Math.round(pTree.getPosX()/SPEED_ANT);
    }

    public static void main (String[] args){
        TestTree tree = new TestTree(8,10, 8);
        Planning planning =  new Planning();
        planning.Generate_times(tree,10);
    }

}
