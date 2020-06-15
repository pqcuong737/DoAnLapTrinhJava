package GUI;

import DTO.DTO_Phong;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class pnl_DSphong extends javax.swing.JPanel {

    ArrayList<DTO_Phong> arrPhong = new ArrayList<>();
    public static pnl_DSphong form;

    public pnl_DSphong() {
        initComponents();
//        FillPhong(0);
        FillPhong(DAO.DAO_Phong.LayPhong(0));
        form = this;
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(50);//tốc độ cuộn chuột JScrollpane
        BLL.BLL_Phong.Load_cbbTang(cbb_Tang);
        rab_giuongkhac.setSelected(true);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// lấy chiều cao và rộng màn hình hiện tại
        
        
    }
    // public static int MaPhong;

    public void FillPhong(ResultSet rs) {
        arrPhong.clear();
        pnl.removeAll();

//        ResultSet rs = DAO.DAO_Phong.LayPhong(TrangThai);
        try {
            while (rs.next()) {
                DTO.DTO_Phong phong = new DTO_Phong();
                phong.setMaPhong(rs.getString("MaPhong"));
                phong.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                ResultSet rsLoai = DAO.DAO_LoaiPhong.LayLoaiTheoMa(phong.getMaLoaiPhong());
                if (rsLoai.next()) {
                    phong.setTenLoaiPhong(rsLoai.getString("TenLoaiPhong"));
                    phong.setGiaTheoGio(ChuyenDoi.DinhDangSo(rsLoai.getDouble("GiaTheoGio")));
                    phong.setGiaTheoNgay(ChuyenDoi.DinhDangSo(rsLoai.getDouble("GiaTheoNgay")));
                }
                phong.setTinhTrang(rs.getString("TinhTrang"));
                arrPhong.add(phong);
            }
        } catch (SQLException ex) {

        }
        int sapxep = arrPhong.size();
        if (sapxep % 3 == 0) {
            pnl.setLayout(new GridLayout(sapxep / 3, 3, 10, 10));

        } else {
            pnl.setLayout(new GridLayout(sapxep / 3 + 1, 3, 10, 10));

        }
        if (arrPhong != null) {
            JButton[] btn = new JButton[arrPhong.size()];
            for (int i = 0; i < arrPhong.size(); i++) {
                btn[i] = new javax.swing.JButton();
                //  btn[i].setText("Phòng " + String.valueOf(arrPhong.get(i).getMaPhong()) + "(" + arrPhong.get(i).getTenLoaiPhong() + ")");
                //  btn[i].setBackground(Color.decode("#F8E6E0"));
                btn[i].setFont(new java.awt.Font("Tahoma", 1, 13));
//                btn[i].setPreferredSize(new Dimension(200, 200));
                btn[i].setHorizontalTextPosition((int) CENTER_ALIGNMENT);
                btn[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btn[i].setFont(new java.awt.Font("Times New Roman", 1, 20));
                if (arrPhong.get(i).getTinhTrang().trim().equals("trong")) {

                    btn[i].setBackground(Color.decode("#99FF00"));
                    String MaPhong = String.valueOf(arrPhong.get(i).getMaPhong());
                    String GiaTheoGio = arrPhong.get(i).getGiaTheoGio();
                    String GiaTheoNgay = arrPhong.get(i).getGiaTheoNgay();
                    String a = ("<html><div style=\"text-align: center;\">Phòng " + String.valueOf(arrPhong.get(i).getMaPhong()) + "<br>(" + arrPhong.get(i).getTenLoaiPhong() + ")<br>" + "Sẵn sàng cho thuê...</div></html>");
                    btn[i].setText(a);
                    btn[i].setMaximumSize(new Dimension(200, 200));
                    btn[i].setToolTipText(a);

                    btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Trong.png")));
                    btn[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frm_ThuePhong frm = new frm_ThuePhong();
                            frm.setVisible(true);
                            frm_ThuePhong.MaPhong = MaPhong;
                            frm_ThuePhong.GiaTheoGio = GiaTheoGio;
                            frm_ThuePhong.GiaTheoNgay = GiaTheoNgay;
                        }
                    });
                }
                if (arrPhong.get(i).getTinhTrang().trim().equals("sudung")) {

                    btn[i].setBackground(Color.decode("#99FFFF"));
                    String MaPhong = arrPhong.get(i).getMaPhong();
                    String b = ("<html><div style=\"text-align: center;\">Phòng " + String.valueOf(arrPhong.get(i).getMaPhong()) + "<br>(" + arrPhong.get(i).getTenLoaiPhong() + ")<br>" + "Đang sử dụng...</div></html>");
                    btn[i].setText(b);
                    btn[i].setToolTipText(b);
                    btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_SuDung.png")));
                    btn[i].setForeground(Color.white);

                    btn[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

//                            int nutbam = JOptionPane.showConfirmDialog(form, "Phòng đang sử dụng \n Bạn có muốn chuyển tới chi tiết", "", JOptionPane.OK_CANCEL_OPTION);
//                            if (nutbam == JOptionPane.OK_OPTION) {
                                OpenDSThuePhong(MaPhong);
                                pnl_DSThuePhong.form.SelectedDP(MaPhong);
                             
                                System.out.println("mã phòng" + MaPhong);

//                            } else {
//                            }
//                            System.out.println(MaPhong);
//                            frm_ThuePhong frm = new frm_ThuePhong();
//                            frm.setVisible(true);
//                            frm_ThuePhong.MaPhong = MaPhong;
                        }
                    });
                }
                if (arrPhong.get(i).getTinhTrang().trim().equals("dondep")) {

                    btn[i].setBackground(Color.decode("#FF6633"));
                    String MaPhong = arrPhong.get(i).getMaPhong();
                    String c = ("<html><div style=\"text-align: center;\">Phòng " + String.valueOf(arrPhong.get(i).getMaPhong()) + "<br>(" + arrPhong.get(i).getTenLoaiPhong() + ")<br>" + "Dọn dẹp...</div></html>");
                    btn[i].setText(c);
                    btn[i].setToolTipText(c);
                    btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_DonDep.png")));
                    btn[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int nutbam = JOptionPane.showConfirmDialog(form, "Phòng dọn dẹp \n Bạn có muốn hoàn thành dọn dẹp", "Tùy chọn", JOptionPane.OK_CANCEL_OPTION);
                            if (nutbam == JOptionPane.OK_OPTION) {
                                System.out.println("ma phong " + MaPhong);
//                                frm_QLPhong frm = new frm_QLPhong();
//                                frm.setVisible(true);
                                DAO.DAO_Phong.UpdateHoanThanhDonDep(MaPhong);
                                //tải lại form 
                                frm_QuanLyChinh frm = frm_QuanLyChinh.b;
                                frm.tab.remove(pnl_DSphong.form);
                                pnl_DSphong pnl = new pnl_DSphong();
                                frm.tab.add("Danh sách phòng", pnl);
                                frm.tab.setSelectedComponent(pnl);
                            } else {
                            }
//                            System.out.println(MaPhong);
//                            frm_ThuePhong frm = new frm_ThuePhong();
//                            frm.setVisible(true);
//                            frm_ThuePhong.MaPhong = MaPhong;
                        }
                    });
                }
                if (arrPhong.get(i).getTinhTrang().trim().equals("dattruoc")) {
                    btn[i].setBackground(Color.white);
                    String MaPhong = arrPhong.get(i).getMaPhong();
                    String c = ("<html><div style=\"text-align: center;\">Phòng " + String.valueOf(arrPhong.get(i).getMaPhong()) + "<br>(" + arrPhong.get(i).getTenLoaiPhong() + ")<br>" + "Đặt trước...</div></html>");
                    btn[i].setText(c);
                    btn[i].setToolTipText(c);
                    btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Booking.png")));
                    btn[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int nutbam = JOptionPane.showConfirmDialog(form, "Phòng đặt trước \n Bạn có muốn tiến hành thuê ngay\nYES: THUÊ PHÒNG\nCANCEL: HỦY ĐẶT PHONG\nNO: THOÁT", "Tùy chọn", JOptionPane.YES_NO_CANCEL_OPTION);
                            if (nutbam == JOptionPane.YES_OPTION) {
                                DAO.DAO_ThuePhong.UpdateNgayThue(MaPhong);//update lại ngày thuê thành hiện tại khi cho thuê chính thức
                                DAO.DAO_ThuePhong.UpdateDatTruocThanhThue("Chưa thanh toán",MaPhong);                                
                                                                  
                                LoadLai();
                            } else if (nutbam==JOptionPane.CANCEL_OPTION) {//nếu hủy đặt phòng thì sẽ thanh toán đặt phòng và làm phòng trống
                                DAO.DAO_ThuePhong.UpdateDatTruocThanhThue("Đã thanh toán",MaPhong);
                                DAO.DAO_Phong.UpdateHoanThanhDonDep(MaPhong);
                                LoadLai();
                            }

                        }
                    });
                } else {
                }

                pnl.add(btn[i]);
                pnl.updateUI();
            }

        } else {
        }

    }

    private void OpenDSThuePhong(String MaP) {
        frm_QuanLyChinh frm = frm_QuanLyChinh.b;

        try {
            frm.tab.setSelectedComponent(pnl_DSThuePhong.form);
        } catch (Exception e) {
            pnl_DSThuePhong pnl = new pnl_DSThuePhong();
            frm.tab.add("Danh sách thuê phòng", pnl);
            frm.tab.setSelectedComponent(pnl);
        }

    }

    private void LoadLai() {//tải lại form danh sách phòng
        frm_QuanLyChinh frm = frm_QuanLyChinh.b;
        frm.tab.remove(pnl_DSphong.form);
        pnl_DSphong pnl = new pnl_DSphong();
        frm.tab.add("Danh sách phòng", pnl);
        frm.tab.setSelectedComponent(pnl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_TrangThaiTrong = new javax.swing.JButton();
        btn_TrangThaiSuDung = new javax.swing.JButton();
        btn_TrangThaiDon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnl = new javax.swing.JPanel();
        btn_DatTruoc = new javax.swing.JButton();
        pnl2 = new javax.swing.JPanel();
        lbl_Tang = new javax.swing.JLabel();
        cbb_Tang = new javax.swing.JComboBox<>();
        rab_giuongdon = new javax.swing.JRadioButton();
        rab_2giuongdon = new javax.swing.JRadioButton();
        rab_giuongdoi = new javax.swing.JRadioButton();
        rab_giuongkhac = new javax.swing.JRadioButton();
        btn_Loc = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btn_TrangThaiTrong.setBackground(new java.awt.Color(135, 255, 0));
        btn_TrangThaiTrong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_TrangThaiTrong.setText("Phòng trống");
        btn_TrangThaiTrong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_TrangThaiTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TrangThaiTrongActionPerformed(evt);
            }
        });

        btn_TrangThaiSuDung.setBackground(new java.awt.Color(153, 255, 255));
        btn_TrangThaiSuDung.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_TrangThaiSuDung.setText("Đang sử dụng");
        btn_TrangThaiSuDung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_TrangThaiSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TrangThaiSuDungActionPerformed(evt);
            }
        });

        btn_TrangThaiDon.setBackground(new java.awt.Color(255, 102, 51));
        btn_TrangThaiDon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_TrangThaiDon.setText("Đang dọn");
        btn_TrangThaiDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_TrangThaiDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TrangThaiDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnl);

        btn_DatTruoc.setBackground(new java.awt.Color(255, 255, 255));
        btn_DatTruoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_DatTruoc.setText("Đặt trước");
        btn_DatTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DatTruocActionPerformed(evt);
            }
        });

        pnl2.setBackground(new java.awt.Color(255, 255, 255));
        pnl2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_Tang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Tang.setText("Tầng");

        buttonGroup1.add(rab_giuongdon);
        rab_giuongdon.setText("1 Giường đơn");
        rab_giuongdon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        buttonGroup1.add(rab_2giuongdon);
        rab_2giuongdon.setText("2 giường đơn");
        rab_2giuongdon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        buttonGroup1.add(rab_giuongdoi);
        rab_giuongdoi.setText("1 giường đôi");
        rab_giuongdoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        buttonGroup1.add(rab_giuongkhac);
        rab_giuongkhac.setText("Khác");
        rab_giuongkhac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_Loc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Loc.png"))); // NOI18N
        btn_Loc.setText("LỌC");
        btn_Loc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Tang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbb_Tang, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rab_giuongdon)
                .addGap(18, 18, 18)
                .addComponent(rab_2giuongdon)
                .addGap(18, 18, 18)
                .addComponent(rab_giuongdoi)
                .addGap(18, 18, 18)
                .addComponent(rab_giuongkhac)
                .addGap(18, 18, 18)
                .addComponent(btn_Loc)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rab_giuongdoi)
                    .addComponent(rab_2giuongdon)
                    .addComponent(rab_giuongdon)
                    .addComponent(cbb_Tang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Tang)
                    .addComponent(rab_giuongkhac)
                    .addComponent(btn_Loc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_TrangThaiTrong)
                        .addGap(18, 18, 18)
                        .addComponent(btn_TrangThaiSuDung)
                        .addGap(18, 18, 18)
                        .addComponent(btn_TrangThaiDon)
                        .addGap(18, 18, 18)
                        .addComponent(btn_DatTruoc)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_TrangThaiSuDung)
                    .addComponent(btn_TrangThaiTrong)
                    .addComponent(btn_TrangThaiDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_DatTruoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TrangThaiTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TrangThaiTrongActionPerformed
        arrPhong.clear();
        pnl.removeAll();
//        FillPhong(1);
        FillPhong(DAO.DAO_Phong.LayPhong(1));
    }//GEN-LAST:event_btn_TrangThaiTrongActionPerformed

    private void btn_TrangThaiSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TrangThaiSuDungActionPerformed
        arrPhong.clear();
        pnl.removeAll();
//        FillPhong(2);
        FillPhong(DAO.DAO_Phong.LayPhong(2));
    }//GEN-LAST:event_btn_TrangThaiSuDungActionPerformed

    private void btn_TrangThaiDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TrangThaiDonActionPerformed
        arrPhong.clear();
        pnl.removeAll();
//        FillPhong(3);
        FillPhong(DAO.DAO_Phong.LayPhong(3));
    }//GEN-LAST:event_btn_TrangThaiDonActionPerformed

    private void btn_LocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LocActionPerformed
        String tang = cbb_Tang.getSelectedItem().toString();
        System.out.println("tầng" + tang);

        if (rab_giuongdon.isSelected()) {
            arrPhong.clear();
            pnl.removeAll();
            System.out.println("+1 giường đơn");
            FillPhong(DAO.DAO_Phong.LayTheoTangVaGiuongDon(tang, 1));
            return;
        }
        if (rab_2giuongdon.isSelected()) {
            arrPhong.clear();
            pnl.removeAll();
            System.out.println("+2 giường đơn");
            FillPhong(DAO.DAO_Phong.LayTheoTangVaGiuongDon(tang, 2));
            return;
        }
        if (rab_giuongdoi.isSelected()) {
            arrPhong.clear();
            pnl.removeAll();
            System.out.println("+1 giường đôi");
            FillPhong(DAO.DAO_Phong.LayTheoTangVaGiuongDoi(tang, 1));
            return;
        }

        arrPhong.clear();
        pnl.removeAll();
        FillPhong(DAO.DAO_Phong.LayPHongTheoTang(tang));
        return;
    }//GEN-LAST:event_btn_LocActionPerformed

    private void btn_DatTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DatTruocActionPerformed
      arrPhong.clear();
        pnl.removeAll();
//        FillPhong(3);
        FillPhong(DAO.DAO_Phong.LayPhong(4));
    }//GEN-LAST:event_btn_DatTruocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DatTruoc;
    private javax.swing.JButton btn_Loc;
    private javax.swing.JButton btn_TrangThaiDon;
    private javax.swing.JButton btn_TrangThaiSuDung;
    private javax.swing.JButton btn_TrangThaiTrong;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbb_Tang;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Tang;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnl2;
    private javax.swing.JRadioButton rab_2giuongdon;
    private javax.swing.JRadioButton rab_giuongdoi;
    private javax.swing.JRadioButton rab_giuongdon;
    private javax.swing.JRadioButton rab_giuongkhac;
    // End of variables declaration//GEN-END:variables
}
