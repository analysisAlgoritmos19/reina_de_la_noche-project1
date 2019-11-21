public class OurTimer {

    public static long start_time;
    public static long final_time;

    public static boolean check_run_out_time(){
        return  System.currentTimeMillis() > final_time;
    }
}
