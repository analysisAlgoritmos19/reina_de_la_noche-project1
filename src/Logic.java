

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Logic {
    double leaf;
    double distance;
    double trunk;
    double growth;
    int amount;

    Map<Double, Tree> map = new HashMap<>();

    public Logic(double distance, double leaf, double trunk, double growth, int amount) {
        this.leaf = leaf;
        this.distance = distance;
        this.trunk = trunk;
        this.growth = growth;
        this.amount = amount;

        for( int i = 0; i < amount; i++){
            Tree newTree = new Tree(distance, leaf, trunk, growth);
            double value = viability(newTree);
            map.put(value, newTree);
        }

        TreeMap<Double, Tree> sorted = new TreeMap<>(map);

        sorted.forEach((k, v) -> {
            System.out.println("Key: " + k + ", Value: " + v.distance);
            System.out.println("");
        });
    }


    public double viability(Tree t){
        double ans;

        double currentDistance = t.distance / distance;
        double currentLeaf = t.leaf / leaf;
        double currentTrunk = t.trunk / trunk;
        double currentGrowth = t.growth / growth;

        ans = currentDistance * currentLeaf * currentTrunk * currentGrowth;

        return ans;
    }
}
