import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Fractal extends JPanel {
    private ArrayList<TestTree> trees = new ArrayList<TestTree>();
    int max_height;
    int max_length;
    private BufferedImage image;
    private BufferedImage dirt;
    private BufferedImage anthill;

    public Fractal(ArrayList<TestTree> trees, int max_height, int max_length) {
        this.trees = trees;
        this.max_height = max_height;
        this.max_length = max_length;
        try{
            image = ImageIO.read(new File("sky.jpg"));
            dirt = ImageIO.read(new File("dirt.png"));
            anthill = ImageIO.read(new File("anthill.jpg"));
        }
        catch(IOException ex){

        }
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        int branchArmLength = 0;
        if (depth < 10) {
            branchArmLength = (int) random(0, depth);
        }
        else {
            branchArmLength = (int) random((depth - 10), (depth - 8));
        }
        if (depth != 0){
            int x2 = x1 + (int)(Math.cos(angle*(Math.PI/180.0)) * depth * branchArmLength);
            int y2 = y1 + (int)(Math.sin(angle*(Math.PI/180.0)) * depth * branchArmLength);
            g.setColor(Color.decode("#593A00"));
            g.drawLine(x1, y1, x2, y2);
            drawTree(g, x2, y2, angle - random(15, 20), depth - 1);
            drawTree(g, x2, y2, angle + random(15, 20), depth - 1);
        }
        else{
            String leafColorArray[] = {"#88ba09","#009900"};
            int x2 = x1 + (int) (Math.cos(angle*(Math.PI/180.0)) * depth * branchArmLength);
            int y2 = y1 + (int) (Math.sin(angle*(Math.PI/180.0)) * depth * branchArmLength);
            String randColor = leafColorArray[(int)random(0, 1)];
            g.setColor(Color.decode(randColor));
            int size = (int) random(10,15);
            g.fillArc(x2 - (int) size/2, y2 - (int) size/2, size, size, 90, 90);
        }
    }

    private double random(int min, int max){
        return min + Math.floor(Math.random() * (max + 1 - min));
    }

    @Override
    public void paintComponent(Graphics g) {
        Image rescaled = image.getScaledInstance(2048, 900, Image.SCALE_SMOOTH);
        g.drawImage(rescaled, 0, 0, this);

        Image newDirt = dirt.getScaledInstance(2048, 124, Image.SCALE_SMOOTH);
        g.drawImage(newDirt, 0, 900, this);

        Image newAnthill = anthill.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        g.drawImage(newAnthill, 0, 900, this);

        g.setColor(Color.white);
        drawDashedLined(g,25, 935, 1900, 935);
        drawDashedLined(g,1900, 975, 25, 975);
        drawDashedLined(g,1900, 935, 1900, 975);

        for(TestTree tree : trees){
            float percentage = (float) tree.getLength() / (float) max_length;
            System.out.println("Percentage: " + percentage);
            int current_width = Math.round(percentage * 2048);
            int branchArmLength = tree.getLevels();
            drawTree(g, current_width, 910, -90, branchArmLength);
        }
    }

    private void drawDashedLined(Graphics g, int x1, int y1, int x2, int y2){
        Graphics g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        ((Graphics2D) g2d).setStroke(dashed);
        g2d.drawLine(x1, y1, x2, y2);
        g2d.dispose();
    }

    public static void main(String... args) {
        final JFrame frame = new JFrame("Porfa pásenos :'(");
        TestGenerator testGenerator = new TestGenerator();
        int max_length = testGenerator.get_max_length(1);
        int max_height = testGenerator.get_max_distance(1);
        System.out.println("Max_length: " + max_length);
        System.out.println("Max_height: " + max_height);
        ArrayList<TestTree> trees = testGenerator.getTests()[1];
        Greedy greedy = new Greedy(trees);
        ArrayList<TestTree> testTrees = greedy.get_sorted_list();
        for(TestTree tree : testTrees){
            tree.printTree();
        }
        Fractal fract = new Fractal(testTrees, max_height, max_length);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setContentPane(new Fractal(testTrees, max_height, max_length));
                frame.setSize(2048, 1024);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }
}