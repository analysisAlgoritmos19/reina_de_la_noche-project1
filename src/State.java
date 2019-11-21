import java.util.Date;

public class State {
    private int amount_of_ants;
    private int time;

    public State (int pAmount, int pTime){
        this.amount_of_ants = pAmount;
        this.time = pTime;
    }

    public void setAmount_of_ants(int amount_of_ants) {
        this.amount_of_ants = amount_of_ants;
    }

    public int getAmount_of_ants() {
        return amount_of_ants;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
