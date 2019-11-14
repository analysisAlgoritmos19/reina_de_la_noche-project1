import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Logic {
    double leaf;
    double distance;
    double trunk;
    double growth;
    int levels = 18;
    int amount;
    
    Map<Double, Tree> map = new HashMap<>();

    public Logic(int distance, int leaf, int trunk, int amount) {
        this.leaf = leaf;
        this.distance = distance;
        this.trunk = trunk;
        this.amount = amount;
        
        for( int i = 0; i < amount; i++){
            Tree newTree = new Tree(distance, leaf, trunk);
            double value = viability(newTree);
            map.put(value, newTree);
        }
        
        TreeMap<Double, Tree> sorted = new TreeMap<>(map);
        
        sorted.forEach((k, v) -> {
            int time = timeForTree(v);
            System.out.println("Key: " + k + "\n Distance: " + v.distance
            + "\n Trunk size:" + v.trunk + "\n Leaf size: " + v.leaf
            + "\n Growth percentage: " + v.growth + "\n Levels: " + v.levels
            + "\n Time: " + time + "\n");
	});
    }

    
    public double viability(Tree t){
        double ans;
        
        double currentDistance = t.distance / distance;     //Menor = mejor
        double currentLeaf = 1 - (t.leaf / (leaf + 1));     //Mayor = mejor
        double currentTrunk = t.trunk / trunk;              //Menor = mejor
        double currentGrowth = t.growth;                    //Mayor = mejor
        double currentLevels = 1 - (t.levels / (18 + 1));   //Mayor = mejor
        
        ans = currentDistance * currentLeaf * currentTrunk * currentGrowth * currentLevels;
        
        return ans;
    }
    
    public int timeForTree(Tree tree){
        int ans = 0;
        
        ans += distance;
        ans += trunk;
        
        double current = tree.trunk;
        
        for(int i = 0; i < tree.levels; i++){
            //System.out.println("Current: " + current);
            current = current * tree.growth;
            ans += current;
        }
        
        ans = (ans * 2) + 1;
        
        return ans;
    }
}
