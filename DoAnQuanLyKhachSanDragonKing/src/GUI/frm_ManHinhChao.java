
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.sql.*;


public class frm_ManHinhChao extends javax.swing.JFrame {

   
    public frm_ManHinhChao() {
        initComponents();
        Start();
    }

    private void Start() {
        ProgLoading.setStringPainted(true);
        Timer t = new Timer(8, new ActionListener() {
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                index += 1;
                ProgLoading.setValue(index);
                if (index == 100) {
                    ((Timer) e.getSource()).stop();
                    HienThiDangNhap();
                }
            }

        });
        t.start();
    }

    private void HienThiDangNhap() {
        this.dispose();
        frm_DangNhap frm = new frm_DangNhap();
        frm.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProgLoading = new javax.swing.JProgressBar();
        lblIcon = new javax.swing.JLabel();
        pnlTieuDe = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        lbl_TieuDe0 = new javax.swing.JLabel();
        lblAnhNen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chào mừng");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1022, 680));
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);
        getContentPane().add(ProgLoading);
        ProgLoading.setBounds(0, 650, 1020, 20);

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/icon-enterprise.png"))); // NOI18N
        getContentPane().add(lblIcon);
        lblIcon.setBounds(0, 0, 310, 160);

        pnlTieuDe.setBackground(new java.awt.Color(0, 102, 255));

        lblTieuDe.setFont(new java.awt.Font("VNI-Dur", 0, 40)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(255, 255, 255));
        lblTieuDe.setText("Phaàn meàm quaûn lyù khaùch saïn TQT");

        lbl_TieuDe0.setFont(new java.awt.Font("VNI-Dur", 0, 18)); // NOI18N
        lbl_TieuDe0.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TieuDe0.setText("Chaøo möøng ñeán vôùi");

        javax.swing.GroupLayout pnlTieuDeLayout = new javax.swing.GroupLayout(pnlTieuDe);
        pnlTieuDe.setLayout(pnlTieuDeLayout);
        pnlTieuDeLayout.setHorizontalGroup(
            pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTieuDeLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_TieuDe0)
                    .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlTieuDeLayout.setVerticalGroup(
            pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTieuDeLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(lbl_TieuDe0, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTieuDe)
                .addGap(49, 49, 49))
        );

        getContentPane().add(pnlTieuDe);
        pnlTieuDe.setBounds(270, 0, 750, 160);

        lblAnhNen.setBackground(new java.awt.Color(51, 204, 255));
        lblAnhNen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/AnhNen.jpg"))); // NOI18N
        getContentPane().add(lblAnhNen);
        lblAnhNen.setBounds(0, 0, 1030, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frm_ManHinhChao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_ManHinhChao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_ManHinhChao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_ManHinhChao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_ManHinhChao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgLoading;
    private javax.swing.JLabel lblAnhNen;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lbl_TieuDe0;
    private javax.swing.JPanel pnlTieuDe;
    // End of variables declaration//GEN-END:variables
}
