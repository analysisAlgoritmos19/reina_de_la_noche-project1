package progra;

import java.util.Random;;

public class Tree {
    double leaf;
    double distance;
    double trunk;
    double growth;
    int levels;
    double amountLeaves;
    
    public Tree(int distance, int leaf, int trunk){
        Random r = new Random();
        this.leaf = r.nextInt(leaf) + 1;
        
        r = new Random();
        this.distance = r.nextInt(distance) + 1;
        
        r = new Random();
        this.trunk = r.nextInt(trunk) + 1;
        
        r = new Random();
        this.growth = (r.nextInt(9) + 1) / 10.0;
        
        r = new Random();
        levels = r.nextInt(18) + 1;
        
        amountLeaves = Math.pow(2, levels);
    }
}
