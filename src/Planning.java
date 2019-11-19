import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Planning {

    String initialTime = "00:00:00";  //La hora con forma de String

    public ArrayList<Tree> planning_function(ArrayList<Tree> pList_of_tree) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
        Date date = sdf.parse(this.initialTime); //Se hace parse de la fecha para guardarla

        for(int tree = 0; tree < pList_of_tree.size(); tree++){
            Generate_times(pList_of_tree.get(tree), 0);
        }

    return pList_of_tree;  //Por ahora se coloco return solo para evitar error
    }


    //Hay que agregarle el tipo del return
    public void Generate_times(Tree pTree, int time_seconds){
        System.out.printf("Ground time: %d   Tree time: %d \n", calculate_ground_time(pTree), calculate_tree_time(pTree));
        Timestamp timestamp = new Timestamp(time_seconds, calculate_ground_time(pTree) , calculate_tree_time(pTree), 100);
        timestamp.calculate_states();
        timestamp.print_states();
    }

    private int calculate_tree_time(Tree pTree){
        float distance_value = 0;
        float current = pTree.getTrunk();
        for(int i = 0; i < pTree.getLevels(); i++){
            distance_value += current;
            current = current * pTree.getGrowth();
        }
        int tronco_a_hoja = Math.round(distance_value/Constants.SPEED_ANT);
        return tronco_a_hoja;
    }

    private int calculate_ground_time(Tree pTree){
        int hormiguero_a_arbol = Math.round(pTree.getDistance()/Constants.SPEED_ANT);
        return hormiguero_a_arbol;
    }

    public static void main (String[] args){
        Tree tree = new Tree(10,8,10, (float) 0.33,9);
        Planning planning =  new Planning();
        planning.Generate_times(tree,40);
    }

}
