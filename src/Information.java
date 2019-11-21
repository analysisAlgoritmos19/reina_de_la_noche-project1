
public class Information extends javax.swing.JFrame {
    public Information() {
        initComponents();
    }

    public Information(int time, int readyV, int walk, int upV, int downV, int returningV){
        timestamp.setText(String.valueOf(time));
        ready.setText(String.valueOf(readyV));
        walking.setText(String.valueOf(walk));
        up.setText(String.valueOf(upV));
        down.setText(String.valueOf(downV));
        returning.setText(String.valueOf(returningV));
    }

    public void setTimestamp(int value){
        timestamp.setText(String.valueOf(value));
    }

    public void setReady(int value){
        ready.setText(String.valueOf(value));
    }

    public void setWalking(int value){
        walking.setText(String.valueOf(value));
    }

    public void setUpL(int value){
        up.setText(String.valueOf(value));
    }

    public void setDown(int value){
        down.setText(String.valueOf(value));
    }

    public void setReturning(int value){
        returning.setText(String.valueOf(value));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        returning = new javax.swing.JLabel();
        down = new javax.swing.JLabel();
        up = new javax.swing.JLabel();
        walking = new javax.swing.JLabel();
        ready = new javax.swing.JLabel();
        timestamp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        returning.setText("jLabel12");

        down.setText("jLabel11");

        up.setText("jLabel10");

        walking.setText("jLabel9");

        ready.setText("jLabel8");

        timestamp.setText("jLabel7");

        jLabel1.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel1.setText("Timestamp");

        jLabel2.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel2.setText("Ready");

        jLabel3.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel3.setText("Walking");

        jLabel4.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel4.setText("Up");

        jLabel5.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel5.setText("Down");

        jLabel6.setFont(new java.awt.Font("Felix Titling", 0, 12)); // NOI18N
        jLabel6.setText("Returning");

        jLabel7.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        jLabel7.setText("Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6))
                                                .addGap(41, 41, 41)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(ready)
                                                                .addGap(7, 7, 7))
                                                        .addComponent(returning)
                                                        .addComponent(timestamp)
                                                        .addComponent(walking)
                                                        .addComponent(up)
                                                        .addComponent(down)))
                                        .addComponent(jLabel7))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(timestamp)
                                                .addGap(18, 18, 18)
                                                .addComponent(ready)
                                                .addGap(18, 18, 18)
                                                .addComponent(walking)
                                                .addGap(18, 18, 18)
                                                .addComponent(up)
                                                .addGap(18, 18, 18)
                                                .addComponent(down)
                                                .addGap(18, 18, 18)
                                                .addComponent(returning))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6)))
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

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
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Information().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel down;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel ready;
    private javax.swing.JLabel returning;
    private javax.swing.JLabel timestamp;
    private javax.swing.JLabel up;
    private javax.swing.JLabel walking;
    // End of variables declaration
}
