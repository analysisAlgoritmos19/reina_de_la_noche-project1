public class AntHill implements ITestConstants {

    private static AntHill ourInstance;

    private int Total_ants;

    private int Ants_ready;

    static { ourInstance = new AntHill(); }

    private AntHill() {

        Total_ants = 100;
        Ants_ready = 100;

    }

    public static AntHill getInstance() { return ourInstance; }


    public int getTotal_ants() {
        return Total_ants;
    }


    public int getAnts_ready() {
        return Ants_ready;
    }

    public void return_ants_to_hill(int p_number){

        Ants_ready += p_number;
    }

    public int get_amount_ants(int distance){

        int ants_to_give = (int)(distance/SPEED_ANT);
        if(Ants_ready < ants_to_give) {
            ants_to_give = Ants_ready;
            Ants_ready = 0;
        }else {
            Ants_ready -= ants_to_give;
        }

        return ants_to_give;
    }




}





