import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dist = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        leaf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        trunk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        growthBox = new javax.swing.JTextField();
        levelBox = new javax.swing.JTextField();
        NEW_BUTTON = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Reina de la noche (?)");

        jLabel2.setText("Maximum distance");

        jLabel3.setText("Maximum leaf size");

        jLabel4.setText("Maximum trunk size");

        trunk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trunkActionPerformed(evt);
            }
        });

        jLabel6.setText("Tree amount");

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Maximum tree growth");

        jLabel7.setText("Maximum tree levels");

        levelBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelBoxActionPerformed(evt);
            }
        });

        NEW_BUTTON.setText("Random");
        NEW_BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEW_BUTTONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(48, 48, 48))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(100, 100, 100)
                                                .addComponent(amount, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel7))
                                                                .addGap(48, 48, 48)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(levelBox)
                                                                        .addComponent(growthBox)
                                                                        .addComponent(dist, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                                                        .addComponent(leaf)
                                                                        .addComponent(trunk)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(NEW_BUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(leaf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(trunk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(growthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(levelBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(NEW_BUTTON))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int distance, leafSize, trunkSize;
        float growth;
        int quantity, levels;

        try{
            distance = java.lang.Math.abs(Integer.parseInt(dist.getText()));
            leafSize = java.lang.Math.abs(Integer.parseInt(leaf.getText()));
            trunkSize = java.lang.Math.abs(Integer.parseInt(trunk.getText()));
            growth = java.lang.Math.abs(Float.parseFloat(growthBox.getText()));
            levels = java.lang.Math.abs(Integer.parseInt(levelBox.getText()));
            quantity = java.lang.Math.abs(Integer.parseInt(amount.getText()));

            if(growth <= 1){
                System.out.println("Se impirme algo");
                TreeGenerator tree_gen = new TreeGenerator(leafSize, trunkSize, distance, growth, levels, quantity);
                ArrayList<Tree> tree_list = new ArrayList<Tree>(tree_gen.getList_of_trees());
                Greedy test = new Greedy(tree_list);
                test.printTrees();
            }
            else{
                JOptionPane.showMessageDialog(this, "Tree growth should be less than 1", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "All values should be numbers...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void trunkActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void levelBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NEW_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {
        Random r = new Random();
        int leaf_size =  r.nextInt(30) + 1;
        int distance = r.nextInt(100) + 1;
        int trunk = r.nextInt(35) + 1;
        float growth = (float)(r.nextInt(9) + 1) / 10;
        int levels = r.nextInt(18) + 1;
        int amounts = r.nextInt(120) + 1;

        System.out.println("Leaf size: " + leaf_size);
        System.out.println("Trunk size: " + trunk);
        System.out.println("Distance: " + distance);
        System.out.println("Growth: " + growth);
        System.out.println("Max leves: " + levels);
        System.out.println("Amount of trees: " + amounts + "\n");

        TreeGenerator l = new TreeGenerator(leaf_size, trunk, distance, growth, levels, amounts);
        ArrayList<Tree> tree_list = new ArrayList<Tree>(l.getList_of_trees());
        Greedy test = new Greedy(tree_list);
        test.printTrees();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton NEW_BUTTON;
    private javax.swing.JTextField amount;
    private javax.swing.JTextField dist;
    private javax.swing.JTextField growthBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField leaf;
    private javax.swing.JTextField levelBox;
    private javax.swing.JTextField trunk;
    // End of variables declaration
}