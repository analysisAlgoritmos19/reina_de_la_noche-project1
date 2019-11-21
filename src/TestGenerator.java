
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class TestGenerator implements ITestConstants {

	private ArrayList<TestTree>[] tests = new ArrayList[AMOUNT_OF_TESTS];
	
	public TestGenerator() {
		for(int testCount=0; testCount<AMOUNT_OF_TESTS; testCount++) {
			tests[testCount] = new ArrayList<TestTree>();
		}
		
		generateTests();
	}
	
	private void generateTests() {
		for(int testCount=0; testCount<AMOUNT_OF_TESTS; testCount++) {
			for(int ruleIndex=0; ruleIndex<TEST_RULES[testCount].length; ruleIndex++) {
				for(int treeCount=0; treeCount<TEST_RULES[testCount][ruleIndex][TestRanges.QUANTITY.getIndex()]; treeCount++) {
					int posX = TEST_RULES[testCount][ruleIndex][TestRanges.MIN_DISTANCE.getIndex()]+
							(int)(Math.random()*(TEST_RULES[testCount][ruleIndex][TestRanges.MAX_DISTANCE.getIndex()]-TEST_RULES[testCount][ruleIndex][TestRanges.MIN_DISTANCE.getIndex()]));
					
					int length = TEST_RULES[testCount][ruleIndex][TestRanges.MIN_LENGTH.getIndex()]+
							(int)(Math.random()*(TEST_RULES[testCount][ruleIndex][TestRanges.MAX_LENGTH.getIndex()]-TEST_RULES[testCount][ruleIndex][TestRanges.MIN_LENGTH.getIndex()]));

					int levels = TEST_RULES[testCount][ruleIndex][TestRanges.MIN_LEVELS.getIndex()]+
							(int)(Math.random()*(TEST_RULES[testCount][ruleIndex][TestRanges.MAX_LEVELS.getIndex()]-TEST_RULES[testCount][ruleIndex][TestRanges.MIN_LEVELS.getIndex()]));
					
					TestTree test = new TestTree(posX, length, levels);
					viability_of_tree(test,testCount);
					tests[testCount].add(test);
				}
			}
		}		
	}

	public void viability_of_tree(TestTree p_tree, int index_test){

		float distance_value, viability;
		float current_Distance = p_tree.getPosX();
		float current_Trunk = p_tree.getLength();
		float current_Levels = (float) p_tree.getLevels();
		distance_value = current_Distance + current_Trunk * current_Levels;
		float distance_ratio = (float) (distance_value / get_worst_case(index_test));
		BigDecimal bd = new BigDecimal(distance_ratio).setScale(3, RoundingMode.HALF_UP);
		double rounded_viability = bd.doubleValue();
		p_tree.setScore(rounded_viability);
	}


	public double get_worst_case(int index_test){
		return get_max_distance(index_test) + get_max_length(index_test) * get_max_levels(index_test);
	}

	public int get_max_distance(int index_test){
		int max_posX = 0;
		for(int ruleIndex=0; ruleIndex<TEST_RULES[index_test].length; ruleIndex++) {
			for(int treeCount=0; treeCount<TEST_RULES[index_test][ruleIndex][TestRanges.QUANTITY.getIndex()]; treeCount++) {
				int posX = TEST_RULES[index_test][ruleIndex][TestRanges.MAX_DISTANCE.getIndex()];
				if (posX > max_posX) {
					max_posX = posX;
				}
			}
		}
		return max_posX;
	}

	public int get_max_length(int index_test){
		int max_length = 0;
		for(int ruleIndex=0; ruleIndex<TEST_RULES[index_test].length; ruleIndex++) {
			for(int treeCount=0; treeCount<TEST_RULES[index_test][ruleIndex][TestRanges.QUANTITY.getIndex()]; treeCount++) {
				int length = TEST_RULES[index_test][ruleIndex][TestRanges.MAX_LENGTH.getIndex()];
				if (length > max_length) {
					max_length = length;
				}
			}
		}
		return max_length;
	}

	public int get_max_levels(int index_test){
		int max_levels = 0;
		for(int ruleIndex=0; ruleIndex<TEST_RULES[index_test].length; ruleIndex++) {
			for(int treeCount=0; treeCount<TEST_RULES[index_test][ruleIndex][TestRanges.QUANTITY.getIndex()]; treeCount++) {
				int length = TEST_RULES[index_test][ruleIndex][TestRanges.MAX_LEVELS.getIndex()];
				if (length > max_levels) {
					max_levels = length;
				}
			}
		}
		return max_levels;
	}

	public ArrayList<TestTree>[] getTests() {
		return tests;
	}

	public static void main(String args[]) {

		TestGenerator generator = new TestGenerator();

		System.out.println(generator.getTests()[0].size());

		for (TestTree tree: generator.getTests()[0]) {

			tree.printTree();
			System.out.println(" ");
		}
	}
}
