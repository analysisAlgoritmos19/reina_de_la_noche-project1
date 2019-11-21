import java.util.ArrayList;

public class TestTree {
	private int posX;
	private int length;
	private int levels;
	private double leafLength;
	private double score;
	private long amount_leaves;
	private ArrayList<Timestamp> timestamps;

	public TestTree(int pPosX, int pLength, int pLevels) {
		this.posX = pPosX;
		this.length = pLength;
		this.levels = pLevels;
		this.amount_leaves = (long) Math.pow(2,levels);
		for(leafLength = pLength; --pLevels > 0; leafLength *= ITestConstants.GROW_PERCENTAGE);
	}

	public void setTimestamps(ArrayList<Timestamp> timestamps) { this.timestamps = timestamps; }

	public void printTree(){
		System.out.println("Score: " + score);
		System.out.println("Distance: " + posX);
		System.out.println("Trunk size: " + length);
		System.out.println("Levels: " + levels);
		System.out.println("Amount of leaves: " + amount_leaves);
	}

	public int getPosX() {
		return posX;
	}

	public int getLength() {
		return length;
	}

	public int getLevels() {
		return levels;
	}
	
	public double getGrow_percentage() {
		return ITestConstants.GROW_PERCENTAGE;
	}
	
	public double getLeafLength() {
		return this.leafLength;
	}

	public double getScore() { return score; }

	public void setScore(double score) { this.score = score; }

	public long getAmount_leaves() { return amount_leaves; }
}
