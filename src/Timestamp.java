import java.util.HashMap;

public class Timestamp implements ITestConstants{
    private int time;
    private static int amount_ants = 100;
    private int amount_leaves;
    private HashMap<String, State> states;

    public Timestamp(int pTime, int pGroundTime, int pTreeTime, int pAmount_ants, int pAmount_leaves){
        this.time = pTime;
        //this.amount_ants = pAmount_ants;
        this.amount_leaves = pAmount_leaves;
        create_states(pGroundTime, pTreeTime);

    }

    private void create_states(int groundTime, int treeTime) {
        states = new HashMap<>();
        states.put("Ready", new State(amount_ants, 1));
        states.put("Walking", new State(0, groundTime));
        states.put("Up", new State(0, groundTime + treeTime ));
        states.put("Down", new State(0, groundTime + treeTime * 2)) ;
        states.put("Returning", new State( 0, groundTime * 2 + treeTime * 2));
    }

    public void calculate_states(){
        int ants_in_other_states = calculate_ants_in_state("Ready", amount_ants);
        ants_in_other_states = calculate_ants_in_state("Walking", ants_in_other_states);
        ants_in_other_states = calculate_ants_in_state("Up", ants_in_other_states);
        ants_in_other_states = calculate_ants_in_state("Down", ants_in_other_states);
        ants_in_other_states = calculate_ants_in_state("Returning", ants_in_other_states);
        if(ants_in_other_states != 0){
            states.get("Ready").setAmount_of_ants(states.get("Ready").getAmount_of_ants() + ants_in_other_states);
        }
    }

    public void print_states(){
        System.out.printf("TIMESTAMP %d \n", time);
        for(String state : states.keySet()){
            System.out.println(state);
            System.out.printf("Amount of ants: %d \n", states.get(state).getAmount_of_ants() );
        }
    }

    private int calculate_ants_in_state(String state, int previous_state_ants){
        int ants_in_other_states = SPEED_ANT * (time - states.get(state).getTime());
        /*if(amount_leaves - ants_in_other_states <= 0 || amount_ants -ants_in_other_states <= 0){
            ants_in_other_states = 100;
            states.get(state).setAmount_of_ants(0);
        }*/
        if(ants_in_other_states < 0){
            states.get(state).setAmount_of_ants(previous_state_ants);
            return 0;
        }
        int ants_in_state = previous_state_ants - ants_in_other_states;
        states.get(state).setAmount_of_ants(ants_in_state);
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
