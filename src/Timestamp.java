import java.util.HashMap;

public class Timestamp implements ITestConstants{
    private int time;
    private HashMap<String, State> states;
    private int distance;
    private int amount_ants;
    private boolean finish_sending_ants;

    public Timestamp(int pTime, int pGroundTime, int pTreeTime,int pDistance, int pAmount_ants, boolean pFinish_sending_ants){
        this.time = pTime;
        this.distance = pDistance;
        this.amount_ants = pAmount_ants;
        this.finish_sending_ants = pFinish_sending_ants;
        create_states(pGroundTime, pTreeTime);
    }

    private void create_states(int groundTime, int treeTime) {
        states = new HashMap<>();
        states.put("Ready", new State(0,1));
        states.put("Walking", new State(0, groundTime));
        states.put("Up", new State(0, groundTime + treeTime ));
        states.put("Down", new State(0, groundTime + treeTime * 2)) ;
        states.put("Returning", new State( 0, groundTime * 2 + treeTime * 2));
    }


    public void calculate_states(){

        System.out.println("cantidad de hormigas: " + amount_ants);
       /* for(int loop = time / distance; loop > 0;loop--){

        }*/
        int ants_in_other_states = calculate_ants_in_state("Ready", amount_ants,false);
        ants_in_other_states = calculate_ants_in_state("Walking", ants_in_other_states,false);
        ants_in_other_states = calculate_ants_in_state("Up", ants_in_other_states,false);
        ants_in_other_states = calculate_ants_in_state("Down", ants_in_other_states,false);
        ants_in_other_states = calculate_ants_in_state("Returning", ants_in_other_states,false);
        if(ants_in_other_states != 0){
            System.out.println("Entre");
            if(finish_sending_ants){
                System.out.println("cantidad de hormigas devueltas : " + ants_in_other_states);
                AntHill.getInstance().return_ants_to_hill(ants_in_other_states);
                states.get("Ready").setAmount_of_ants(states.get("Ready").getAmount_of_ants() + ants_in_other_states);
            }
            ants_in_other_states = calculate_ants_in_state("Ready",ants_in_other_states,true);
            ants_in_other_states = calculate_ants_in_state("Walking", ants_in_other_states,true);
            ants_in_other_states = calculate_ants_in_state("Up", ants_in_other_states,true);
            ants_in_other_states = calculate_ants_in_state("Down", ants_in_other_states,true);
            calculate_ants_in_state("Returning", ants_in_other_states,true);
        }


    }

    public void print_states(){
        System.out.printf("\n TIMESTAMP %d \n", time);
        for(String state : states.keySet()){
            System.out.println(state);
            System.out.printf("Amount of ants: %d \n", states.get(state).getAmount_of_ants() );
        }
    }
    private int calculate_ants_in_state(String state, int previous_state_ants, boolean rearrange){
        int time_temp = time;
        if(time/distance > 0){
            time_temp = time / (time/distance);
        }
        int ants_in_other_states = (int) (SPEED_ANT * ((time_temp) - states.get(state).getTime()));
        if(rearrange) {
            ants_in_other_states = (int) (SPEED_ANT * ((time_temp % distance) - states.get(state).getTime()));
        }
        if(ants_in_other_states < 0){
            if(rearrange){
                int ants = states.get(state).getAmount_of_ants() + previous_state_ants;
                states.get(state).setAmount_of_ants(ants);
            }else{
                states.get(state).setAmount_of_ants(previous_state_ants);
            }
            return 0;
        }
        int ants_in_state = previous_state_ants - ants_in_other_states;
        if(ants_in_state < 0 ){
            states.get(state).setAmount_of_ants(0);
            int temp = states.get(state).getTime() +  (states.get("Returning").getTime() * (int)(time / states.get("Returning").getTime()));
            return previous_state_ants;
        }
        if(rearrange){
            int ants = states.get(state).getAmount_of_ants() + ants_in_state;
            states.get(state).setAmount_of_ants(ants);
        }else{
            states.get(state).setAmount_of_ants(ants_in_state);
        }

        return  ants_in_other_states;
    }


    public HashMap<String, State> getStates() {
        return states;
    }


    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
