import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalTime;
import java.sql.Time;
import java.util.Date;

public class Planning {

    String initialTime = "00:00:00";  //La hora con forma de String

    public ArrayList<Tree> planning_function(ArrayList<Tree> pList_of_tree) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
        Date date = sdf.parse(this.initialTime); //Se hace parse de la fecha para guardarla

        for(int tree = 0; tree < pList_of_tree.size(); tree++){
            Generate_times(pList_of_tree.get(tree), date);
        }

    return pList_of_tree;  //Por ahora se coloco return solo para evitar error
    }


    //Hay que agregarle el tipo del return
    public void Generate_times(Tree pTree, Date pDate){

    }

}
