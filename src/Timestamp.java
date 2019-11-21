import java.util.HashMap;

public class Timestamp implements ITestConstants{
    private int time;
    private HashMap<String, State> states;
    private int distance;

    public Timestamp(int pTime, int pGroundTime, int pTreeTime){
        this.time = pTime;
        this.distance = (pGroundTime*2 + pTreeTime*2);
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
        int amount_ants = AntHill.getInstance().get_amount_ants(distance);
        System.out.println("cantidad de hormigas: " + amount_ants);
        int ants_in_other_states = calculate_ants_in_state("Ready", amount_ants,false);
        ants_in_other_states = calculate_ants_in_state("Walking", ants_in_other_states,false);
        ants_in_other_states = calculate_ants_in_state("Up", ants_in_other_states,false);
        ants_in_other_states = calculate_ants_in_state("Down", ants_in_other_states,false);
        ants_in_other_states = calculate_ants_in_state("Returning", ants_in_other_states,false);
        if(ants_in_other_states != 0){
            System.out.println("cantidad de hormigas devueltas : " + ants_in_other_states);
            ants_in_other_states = calculate_ants_in_state("Ready",ants_in_other_states,true);
            ants_in_other_states = calculate_ants_in_state("Walking", ants_in_other_states,true);
            ants_in_other_states = calculate_ants_in_state("Up", ants_in_other_states,true);
            ants_in_other_states = calculate_ants_in_state("Down", ants_in_other_states,true);
            ants_in_other_states = calculate_ants_in_state("Returning", ants_in_other_states,true);
            AntHill.getInstance().return_ants_to_hill(ants_in_other_states);
        }
    }

    public int get_ants_ready(){
        return states.get("Ready").getAmount_of_ants();
    }

    public void print_states(){
        System.out.printf("\n TIMESTAMP %d \n", time);
        for(String state : states.keySet()){
            System.out.println(state);
            System.out.printf("Amount of ants: %d \n", states.get(state).getAmount_of_ants() );
        }
    }

    private int calculate_ants_in_state(String state, int previous_state_ants, boolean rearrange){
        int ants_in_other_states = (int) (SPEED_ANT * ((time) - states.get(state).getTime()));
        if(rearrange) {
            ants_in_other_states = (int) (SPEED_ANT * ((time % distance) - states.get(state).getTime()));
        }
        if(ants_in_other_states < 0){
            if(rearrange){
                int ants = states.get(state).getAmount_of_ants() + previous_state_ants;
                states.get(state).setAmount_of_ants(ants);
            }else{
                states.get(state).setAmount_of_ants(previous_state_ants);
            }
            System.out.println("Entre a la primera validacion " + state);

            return 0;
        }
        int ants_in_state = previous_state_ants - ants_in_other_states;
        if(ants_in_state < 0 ){
            System.out.println("Entre a la segunda validacion " + state);
            states.get(state).setAmount_of_ants(0);
            int temp = states.get(state).getTime() +  (states.get("Returning").getTime() * (int)(time / states.get("Returning").getTime()));
            //states.get(state).setTime();
            System.out.println(temp);
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
