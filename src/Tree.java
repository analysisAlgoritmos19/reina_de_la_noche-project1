
import java.util.Random;

public class Tree {
    double leaf;
    double distance;
    double trunk;
    double growth;
    static int counter;

    public Tree(double distance, double leaf, double trunk, double growth){
        Random r = new Random();
        this.leaf = leaf * r.nextDouble();

        r = new Random();
        this.distance = distance * r.nextDouble();

        r = new Random();
        this.trunk = trunk * r.nextDouble();

        r = new Random();
        this.growth = growth * r.nextDouble();
    }
}
