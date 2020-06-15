package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import javafx.scene.layout.Border;

public class frm_QuanLyChinh extends javax.swing.JFrame {

    javax.swing.border.Border a = BorderFactory.createLineBorder(Color.black, 2, true);
    javax.swing.border.Border empty = BorderFactory.createEmptyBorder();
    public static frm_QuanLyChinh b;

    public frm_QuanLyChinh() {
        initComponents();
        showtime();
        b = this;
//        setExtendedState(getExtendedState() | this.MAXIMIZED_BOTH);//Jframe mở toàn màn hình
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// lấy chiều cao và rộng màn hình hiện tại
//        setMaximumSize(screenSize);
    }

    void showtime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                SimpleDateFormat D = new SimpleDateFormat("dd/MM/yyyy");
                lblTime.setText(s.format(d) + "-" + D.format(d));
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        pnlNutBam = new javax.swing.JPanel();
        btnDatPhong = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnDichVu1 = new javax.swing.JButton();
        btnDSHoaDon = new javax.swing.JButton();
        btnDanhSachDP = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        pnl2 = new javax.swing.JPanel();
        tab = new javax.swing.JTabbedPane();
        btn_Dong = new javax.swing.JButton();
        MnuBar = new javax.swing.JMenuBar();
        mnuTK = new javax.swing.JMenu();
        mniDangXuat = new javax.swing.JMenuItem();
        mniDoiMK = new javax.swing.JMenuItem();
        mnuQLChinh = new javax.swing.JMenu();
        mniDSDatPhong = new javax.swing.JMenuItem();
        mniDSKH = new javax.swing.JMenuItem();
        mniDSPhong = new javax.swing.JMenuItem();
        mniDSHoaDon = new javax.swing.JMenuItem();
        mniDichVuPhong = new javax.swing.JMenuItem();
        mnuQLLoai = new javax.swing.JMenu();
        mniLoaiKH = new javax.swing.JMenuItem();
        mniLoaiPhong = new javax.swing.JMenuItem();
        mniDichVu = new javax.swing.JMenuItem();
        mnuQLNV = new javax.swing.JMenu();
        mniDSNhanVien = new javax.swing.JMenuItem();
        mniDSTK = new javax.swing.JMenuItem();
        mniLuongNV = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuThongTin = new javax.swing.JMenu();
        mnu_CaiDat = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/icon-enterprise.png"))); // NOI18N
        lblIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pnlNutBam.setBackground(new java.awt.Color(255, 255, 255));

        btnDatPhong.setBackground(new java.awt.Color(255, 255, 255));
        btnDatPhong.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Phong.png"))); // NOI18N
        btnDatPhong.setText("Thuê phòng");
        btnDatPhong.setContentAreaFilled(false);
        btnDatPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDatPhong.setDisabledIcon(null);
        btnDatPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDatPhong.setOpaque(true);
        btnDatPhong.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnDatPhongMouseMoved(evt);
            }
        });
        btnDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDatPhongMouseClicked(evt);
            }
        });
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });

        btnKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        btnKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_KhachHang.png"))); // NOI18N
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.setContentAreaFilled(false);
        btnKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhachHang.setDisabledIcon(null);
        btnKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKhachHang.setOpaque(true);
        btnKhachHang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnKhachHangMouseMoved(evt);
            }
        });
        btnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhachHangMouseClicked(evt);
            }
        });
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnDichVu1.setBackground(new java.awt.Color(255, 255, 255));
        btnDichVu1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnDichVu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_DichVu.png"))); // NOI18N
        btnDichVu1.setText("Dịch vụ ");
        btnDichVu1.setContentAreaFilled(false);
        btnDichVu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDichVu1.setDisabledIcon(null);
        btnDichVu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDichVu1.setOpaque(true);
        btnDichVu1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnDichVu1MouseMoved(evt);
            }
        });
        btnDichVu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDichVu1MouseClicked(evt);
            }
        });
        btnDichVu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDichVu1ActionPerformed(evt);
            }
        });

        btnDSHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        btnDSHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnDSHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_HoaDon.png"))); // NOI18N
        btnDSHoaDon.setText("DShóa đơn");
        btnDSHoaDon.setContentAreaFilled(false);
        btnDSHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDSHoaDon.setDisabledIcon(null);
        btnDSHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDSHoaDon.setOpaque(true);
        btnDSHoaDon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnDSHoaDonMouseMoved(evt);
            }
        });
        btnDSHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDSHoaDonMouseClicked(evt);
            }
        });
        btnDSHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDSHoaDonActionPerformed(evt);
            }
        });

        btnDanhSachDP.setBackground(new java.awt.Color(255, 255, 255));
        btnDanhSachDP.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnDanhSachDP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_HoaDon.png"))); // NOI18N
        btnDanhSachDP.setText("DS thuê phòng");
        btnDanhSachDP.setContentAreaFilled(false);
        btnDanhSachDP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDanhSachDP.setDisabledIcon(null);
        btnDanhSachDP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDanhSachDP.setOpaque(true);
        btnDanhSachDP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnDanhSachDPMouseMoved(evt);
            }
        });
        btnDanhSachDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDanhSachDPMouseClicked(evt);
            }
        });
        btnDanhSachDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachDPActionPerformed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_clock.png"))); // NOI18N

        javax.swing.GroupLayout pnlNutBamLayout = new javax.swing.GroupLayout(pnlNutBam);
        pnlNutBam.setLayout(pnlNutBamLayout);
        pnlNutBamLayout.setHorizontalGroup(
            pnlNutBamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDSHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDichVu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDanhSachDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlNutBamLayout.setVerticalGroup(
            pnlNutBamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNutBamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDanhSachDP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDichVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDSHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTime))
        );

        pnl2.setBackground(new java.awt.Color(0, 102, 255));
        pnl2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btn_Dong.setBackground(new java.awt.Color(255, 255, 255));
        btn_Dong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Dong.setText("X");
        btn_Dong.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_DongMouseMoved(evt);
            }
        });
        btn_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DongActionPerformed(evt);
            }
        });

        MnuBar.setBackground(new java.awt.Color(255, 255, 255));
        MnuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MnuBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        MnuBar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        MnuBar.setMaximumSize(new java.awt.Dimension(66, 500));

        mnuTK.setBackground(new java.awt.Color(0, 51, 255));
        mnuTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Key.png"))); // NOI18N
        mnuTK.setText("Tài khoản");

        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_logout.png"))); // NOI18N
        mniDangXuat.setText("Thoát");
        mniDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangXuatActionPerformed(evt);
            }
        });
        mnuTK.add(mniDangXuat);

        mniDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_DoiMatKhau.png"))); // NOI18N
        mniDoiMK.setText("Đổi mật khẩu");
        mniDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoiMKActionPerformed(evt);
            }
        });
        mnuTK.add(mniDoiMK);

        MnuBar.add(mnuTK);

        mnuQLChinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_QuanLy.jpg"))); // NOI18N
        mnuQLChinh.setText("Quản lý chính");

        mniDSDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_HoaDon2.png"))); // NOI18N
        mniDSDatPhong.setText("Danh sách đặt phòng");
        mniDSDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDSDatPhongActionPerformed(evt);
            }
        });
        mnuQLChinh.add(mniDSDatPhong);

        mniDSKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_HoaDon2.png"))); // NOI18N
        mniDSKH.setText("Danh sách khách hàng");
        mniDSKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDSKHActionPerformed(evt);
            }
        });
        mnuQLChinh.add(mniDSKH);

        mniDSPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_HoaDon2.png"))); // NOI18N
        mniDSPhong.setText("Danh sách phòng");
        mniDSPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDSPhongActionPerformed(evt);
            }
        });
        mnuQLChinh.add(mniDSPhong);

        mniDSHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_HoaDon2.png"))); // NOI18N
        mniDSHoaDon.setText("Danh sách hóa đơn");
        mniDSHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDSHoaDonActionPerformed(evt);
            }
        });
        mnuQLChinh.add(mniDSHoaDon);

        mniDichVuPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_HoaDon2.png"))); // NOI18N
        mniDichVuPhong.setText("Dịch vụ phòng");
        mniDichVuPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDichVuPhongActionPerformed(evt);
            }
        });
        mnuQLChinh.add(mniDichVuPhong);

        MnuBar.add(mnuQLChinh);

        mnuQLLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Loai.png"))); // NOI18N
        mnuQLLoai.setText("Quản lý loại");

        mniLoaiKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Loai2.png"))); // NOI18N
        mniLoaiKH.setText("Loại khách hàng");
        mniLoaiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLoaiKHActionPerformed(evt);
            }
        });
        mnuQLLoai.add(mniLoaiKH);

        mniLoaiPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Loai2.png"))); // NOI18N
        mniLoaiPhong.setText("Loại phòng");
        mniLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLoaiPhongActionPerformed(evt);
            }
        });
        mnuQLLoai.add(mniLoaiPhong);

        mniDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Loai2.png"))); // NOI18N
        mniDichVu.setText("Dịch vụ");
        mniDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDichVuActionPerformed(evt);
            }
        });
        mnuQLLoai.add(mniDichVu);

        MnuBar.add(mnuQLLoai);

        mnuQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_NhanVien.png"))); // NOI18N
        mnuQLNV.setText("Quản lý nhân viên");

        mniDSNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_HoaDon2.png"))); // NOI18N
        mniDSNhanVien.setText("Danh sách nhân viên");
        mniDSNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDSNhanVienActionPerformed(evt);
            }
        });
        mnuQLNV.add(mniDSNhanVien);

        mniDSTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_HoaDon2.png"))); // NOI18N
        mniDSTK.setText("Danh sách tài khoản");
        mniDSTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDSTKActionPerformed(evt);
            }
        });
        mnuQLNV.add(mniDSTK);

        mniLuongNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Tien.png"))); // NOI18N
        mniLuongNV.setText("Lương nhân viên");
        mniLuongNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLuongNVActionPerformed(evt);
            }
        });
        mnuQLNV.add(mniLuongNV);

        MnuBar.add(mnuQLNV);

        mnuThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_ThongKe.png"))); // NOI18N
        mnuThongKe.setText("Thống kê");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_ThongKe2.png"))); // NOI18N
        jMenuItem2.setText("Thống kê doanh thu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuThongKe.add(jMenuItem2);

        MnuBar.add(mnuThongKe);

        mnuThongTin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        mnuThongTin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_ThongTin.png"))); // NOI18N
        mnuThongTin.setText("Thông tin phần mềm");
        mnuThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuThongTinMouseClicked(evt);
            }
        });
        mnuThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuThongTinActionPerformed(evt);
            }
        });
        MnuBar.add(mnuThongTin);

        mnu_CaiDat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_Setting.png"))); // NOI18N
        mnu_CaiDat.setText("Cài đặt");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HinhAnh/Icon_CheckIn.png"))); // NOI18N
        jMenuItem1.setText("Cài đặt thời gian checkin và checkout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnu_CaiDat.add(jMenuItem1);

        MnuBar.add(mnu_CaiDat);

        setJMenuBar(MnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlNutBam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Dong)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlNutBam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
        try {
            tab.setSelectedComponent(pnl_DSphong.form);
        } catch (Exception e) {
            //tab.remove(pnl_DSphong.form);
            pnl_DSphong pnl = new pnl_DSphong();
            tab.add("Danh sách phòng", pnl);
            tab.setSelectedComponent(pnl);
        }

    }//GEN-LAST:event_btnDatPhongActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        pnl_DSphong pnl = new pnl_DSphong();
        tab.add("Danh sách phòng", pnl);
        btnDatPhong.setBorder(a);
        if (!BLL.BLL_DangNhap.quyen.equals("QuanLy")) {
//            mniDSNhanVien.setEnabled(false);
            mnuQLNV.setEnabled(false);
            mnuThongKe.setEnabled(false);
            btnDSHoaDon.setEnabled(false);
            mniDSHoaDon.setEnabled(false);
            mnu_CaiDat.setEnabled(false);
        }
//        CaiDat frm=new CaiDat();
//        frm.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void btnDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatPhongMouseClicked
        AnBorder();
        btnDatPhong.setBorder(a);
    }//GEN-LAST:event_btnDatPhongMouseClicked

    private void btnDanhSachDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDanhSachDPMouseClicked
        AnBorder();
        btnDanhSachDP.setBorder(a);
    }//GEN-LAST:event_btnDanhSachDPMouseClicked

    private void btnKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhachHangMouseClicked
        AnBorder();
        btnKhachHang.setBorder(a);
    }//GEN-LAST:event_btnKhachHangMouseClicked
    private void btnDSHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSHoaDonMouseClicked
        AnBorder();
        btnDSHoaDon.setBorder(a);
    }//GEN-LAST:event_btnDSHoaDonMouseClicked
    private void AnBorder() {
        btnDatPhong.setBorder(empty);
        btnKhachHang.setBorder(empty);
        btnDichVu1.setBorder(empty);
        btnDSHoaDon.setBorder(empty);
        btnDanhSachDP.setBorder(empty);
//        btnDichVu2.setBorder(empty);
    }
    private void mniDSPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDSPhongActionPerformed
        frm_QLPhong frm = new frm_QLPhong();
        frm.setVisible(true);
    }//GEN-LAST:event_mniDSPhongActionPerformed
    private void btnDichVu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDichVu1MouseClicked
        AnBorder();
        btnDichVu1.setBorder(a);
    }//GEN-LAST:event_btnDichVu1MouseClicked

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        try {
            tab.setSelectedComponent(pnl_KhachHang.form);
        } catch (Exception e) {
            // tab.remove(pnl_KhachHang.form);
            pnl_KhachHang pnl = new pnl_KhachHang();
            tab.add("Khách hàng", pnl);
            tab.setSelectedComponent(pnl);

        }

    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnDichVu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDichVu1ActionPerformed
        try {
            tab.setSelectedComponent(pnl_DichVuPhong.form);
        } catch (Exception e) {
            //tab.remove(pnl_CungCapDichVu.form);
            pnl_DichVuPhong pnl = new pnl_DichVuPhong();
            tab.add("Dịch vụ của phòng", pnl);
            tab.setSelectedComponent(pnl);
        }

    }//GEN-LAST:event_btnDichVu1ActionPerformed

    private void btnDanhSachDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachDPActionPerformed
        try {
            tab.setSelectedComponent(pnl_DSThuePhong.form);
        } catch (Exception e) {
            //tab.remove(pnl_DSThuePhong.form);
            pnl_DSThuePhong pnl = new pnl_DSThuePhong();
            tab.add("Danh sách thuê phòng", pnl);
            tab.setSelectedComponent(pnl);
        }

    }//GEN-LAST:event_btnDanhSachDPActionPerformed

    private void btn_DongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DongActionPerformed
        if (tab.getTabCount() != 1) {
            tab.remove(tab.getSelectedComponent());
        }
    }//GEN-LAST:event_btn_DongActionPerformed

    private void mniLuongNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLuongNVActionPerformed

        try {
            tab.setSelectedComponent(pnl_LoaiLuong.form);
        } catch (Exception e) {
            pnl_LoaiLuong pnl = new pnl_LoaiLuong();
            tab.add("Lương", pnl);
            tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_mniLuongNVActionPerformed

    private void mniDSNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDSNhanVienActionPerformed
        try {
            tab.setSelectedComponent(pnl_NhanVien.form);
        } catch (Exception e) {
            pnl_NhanVien pnl = new pnl_NhanVien();
            tab.add("Nhân viên", pnl);
            tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_mniDSNhanVienActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void btn_DongMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DongMouseMoved
        btn_Dong.setBackground(Color.red);
    }//GEN-LAST:event_btn_DongMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        btn_Dong.setBackground(Color.white);
        btnDatPhong.setBackground(Color.white);
        btnDanhSachDP.setBackground(Color.white);
        btnKhachHang.setBackground(Color.white);
        btnDichVu1.setBackground(Color.white);
//        btnDichVu2.setBackground(Color.white);
        btnDSHoaDon.setBackground(Color.white);
//     .setBackground(Color.white);
    }//GEN-LAST:event_formMouseMoved

    private void btnDatPhongMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatPhongMouseMoved
        btnDatPhong.setBackground(Color.decode("#DA81F5"));
    }//GEN-LAST:event_btnDatPhongMouseMoved

    private void btnDanhSachDPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDanhSachDPMouseMoved
        btnDanhSachDP.setBackground(Color.decode("#DA81F5"));
    }//GEN-LAST:event_btnDanhSachDPMouseMoved

    private void btnKhachHangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhachHangMouseMoved
        btnKhachHang.setBackground(Color.decode("#DA81F5"));
    }//GEN-LAST:event_btnKhachHangMouseMoved

    private void btnDichVu1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDichVu1MouseMoved
        btnDichVu1.setBackground(Color.decode("#DA81F5"));
    }//GEN-LAST:event_btnDichVu1MouseMoved

    private void btnDSHoaDonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSHoaDonMouseMoved
        btnDSHoaDon.setBackground(Color.decode("#DA81F5"));
    }//GEN-LAST:event_btnDSHoaDonMouseMoved

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CaiDat frm = new CaiDat();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            tab.setSelectedComponent(pnl_ThongKe.form);
        } catch (Exception e) {
            pnl_ThongKe pnl = new pnl_ThongKe();
            tab.add("Thống kê doanh thu", pnl);
            tab.setSelectedComponent(pnl);
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mniLoaiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLoaiKHActionPerformed
        try {
            tab.setSelectedComponent(pnl_KhachHang.form);
        } catch (Exception e) {
            pnl_KhachHang pnl = new pnl_KhachHang();
            tab.add("Khách hàng", pnl);
            tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_mniLoaiKHActionPerformed

    private void mniLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLoaiPhongActionPerformed
        frm_QLPhong frm = new frm_QLPhong();
        frm.setVisible(true);

//       frm.tab.setSelectedComponent(pnl_LoaiPhong.form);
    }//GEN-LAST:event_mniLoaiPhongActionPerformed

    private void mniDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDichVuActionPerformed
        try {
            tab.setSelectedComponent(pnl_CungCapDichVu.form);
        } catch (Exception e) {
            pnl_CungCapDichVu pnl = new pnl_CungCapDichVu();
            tab.add("Cung cấp dịch vụ", pnl);
            tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_mniDichVuActionPerformed

    private void mniDSDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDSDatPhongActionPerformed
        try {
            tab.setSelectedComponent(pnl_DSThuePhong.form);
        } catch (Exception e) {
            //tab.remove(pnl_DSThuePhong.form);
            pnl_DSThuePhong pnl = new pnl_DSThuePhong();
            tab.add("Danh sách thuê phòng", pnl);
            tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_mniDSDatPhongActionPerformed

    private void mniDSKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDSKHActionPerformed
        try {
            tab.setSelectedComponent(pnl_KhachHang.form);
        } catch (Exception e) {
            // tab.remove(pnl_KhachHang.form);
            pnl_KhachHang pnl = new pnl_KhachHang();
            tab.add("Khách hàng", pnl);
            tab.setSelectedComponent(pnl);

        }
    }//GEN-LAST:event_mniDSKHActionPerformed

    private void mniDSHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDSHoaDonActionPerformed
        try {
            tab.setSelectedComponent(pnl_ThongKe.form);
        } catch (Exception e) {
            pnl_ThongKe pnl = new pnl_ThongKe();
            tab.add("Thống kê doanh thu", pnl);
            tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_mniDSHoaDonActionPerformed

    private void mniDichVuPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDichVuPhongActionPerformed
        try {
            tab.setSelectedComponent(pnl_DichVuPhong.form);
        } catch (Exception e) {
            //tab.remove(pnl_CungCapDichVu.form);
            pnl_DichVuPhong pnl = new pnl_DichVuPhong();
            tab.add("Dịch vụ của phòng", pnl);
            tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_mniDichVuPhongActionPerformed

    private void mniDSTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDSTKActionPerformed
        try {
            tab.setSelectedComponent(pnl_NhanVien.form);
        } catch (Exception e) {
            pnl_NhanVien pnl = new pnl_NhanVien();
            tab.add("Nhân viên", pnl);
            tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_mniDSTKActionPerformed

    private void btnDSHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDSHoaDonActionPerformed
        try {
            tab.setSelectedComponent(pnl_ThongKe.form);
        } catch (Exception e) {
            pnl_ThongKe pnl = new pnl_ThongKe();
            tab.add("Thống kê doanh thu", pnl);
            tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_btnDSHoaDonActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void mniDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoiMKActionPerformed
        frm_DoiMatKhau frm = new frm_DoiMatKhau();
        frm.setVisible(true);
        b.setVisible(false);
    }//GEN-LAST:event_mniDoiMKActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int nutbam = JOptionPane.showConfirmDialog(this, "bạn chắc chắn muốn thoát", "THOÁT", JOptionPane.OK_CANCEL_OPTION);
        if (nutbam == JOptionPane.OK_OPTION) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_formWindowClosing

    private void mnuThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuThongTinActionPerformed
    
    }//GEN-LAST:event_mnuThongTinActionPerformed

    private void mnuThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuThongTinMouseClicked
     try {                     
            Desktop.getDesktop().browse(new File("C:/DU_AN1/truongtqpk01404_duan1_QLKhachSan/bounty/bounty/index.html").toURI());             
        } catch (IOException ex) {
           
        }
    }//GEN-LAST:event_mnuThongTinMouseClicked

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
            java.util.logging.Logger.getLogger(frm_QuanLyChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_QuanLyChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_QuanLyChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_QuanLyChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_QuanLyChinh().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MnuBar;
    private javax.swing.JButton btnDSHoaDon;
    private javax.swing.JButton btnDanhSachDP;
    private javax.swing.JButton btnDatPhong;
    private javax.swing.JButton btnDichVu1;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btn_Dong;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblTime;
    private javax.swing.JMenuItem mniDSDatPhong;
    private javax.swing.JMenuItem mniDSHoaDon;
    private javax.swing.JMenuItem mniDSKH;
    private javax.swing.JMenuItem mniDSNhanVien;
    private javax.swing.JMenuItem mniDSPhong;
    private javax.swing.JMenuItem mniDSTK;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDichVu;
    private javax.swing.JMenuItem mniDichVuPhong;
    private javax.swing.JMenuItem mniDoiMK;
    private javax.swing.JMenuItem mniLoaiKH;
    private javax.swing.JMenuItem mniLoaiPhong;
    private javax.swing.JMenuItem mniLuongNV;
    private javax.swing.JMenu mnuQLChinh;
    private javax.swing.JMenu mnuQLLoai;
    private javax.swing.JMenu mnuQLNV;
    private javax.swing.JMenu mnuTK;
    private javax.swing.JMenu mnuThongKe;
    private javax.swing.JMenu mnuThongTin;
    private javax.swing.JMenu mnu_CaiDat;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnlNutBam;
    public javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
