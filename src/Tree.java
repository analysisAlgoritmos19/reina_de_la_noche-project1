


public class Tree implements Comparable<Tree>{

    private float leaf_size;
    private float distance;
    private float trunk;
    private float growth;
    private int levels;
    private double amount_leaves;
    private float score;
    private float total_time;


    public Tree(float leaf_size, float distance, float trunk, float growth, int levels) {
        this.leaf_size = leaf_size;
        this.distance = distance;
        this.trunk = trunk;
        this.growth = growth;
        this.levels = levels;
        this.amount_leaves = Math.pow(2, levels);
    }

    public float getLeaf_size() {
        return leaf_size;
    }

    public float getDistance() {
        return distance;
    }

    public float getTrunk() {
        return trunk;
    }

    public float getGrowth() {
        return growth;
    }

    public int getLevels() {
        return levels;
    }

    public double getAmount_leaves() {
        return amount_leaves;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setTotalTime(float time) {
        this.total_time = time;
    }

    @Override
    public int compareTo(Tree o) {
        if(o.getScore() > score)
            return -1;
        else if(o.getScore() < score)
            return 0;
        else
            return 1;
    }
}
