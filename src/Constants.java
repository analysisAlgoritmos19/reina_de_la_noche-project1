

//Clase enum por si se utiliza
/*
public enum Constants {

    SPEED_ANT,
    RANGE,
    SNAPSHOT_FRECUENCY,

}*/

public final class Constants {

    private Constants() {
        // restrict instantiation
    }

    public static final int SPEED_ANT = 1;
    public static final double RANGE = 0.2;
    public static final int TIMESTAMP_FRECUENCY = 10;
}

