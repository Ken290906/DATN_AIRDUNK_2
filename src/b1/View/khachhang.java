/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package b1.View;

import b1.services.khachhangService;
import ViewModelKH.khachhangViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author DELL
 */
public class khachhang extends javax.swing.JInternalFrame {

    private List<khachhangViewModel> listkh = new ArrayList<>();
    private khachhangService sv = new khachhangService();
    private DefaultTableModel dtm = new DefaultTableModel();
    DateFormat date = new SimpleDateFormat("yyyy-mm-dd");

    /**
     * Creates new form gd1
     */
    public khachhang() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        dtm = (DefaultTableModel) tblhienthi.getModel();
        listkh = sv.getAll();
        ShowDataTable(listkh);
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchkh();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchkh();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchkh();
            }

        });
    }

    public void ShowDataTable(List<khachhangViewModel> lists) {
        int i = 0;
        dtm.setRowCount(0);
        for (khachhangViewModel list : lists) {
            i++;
            String GT = list.isGioiTinh ? "Nam" : "Nữ";
            dtm.addRow(new Object[]{
                i,
                list.getMaKH(),
                list.getTenKH(),
                list.getSDT(),
                list.getNgaySinh(),
                GT});

        }
    }

    private void searchkh() {
        listkh = sv.Search(txtSearch.getText());
        ShowDataTable(listkh);
    }

    public void Oneclick(int show) {
        khachhangViewModel khModel = listkh.get(show);
        txtmakh.setText(khModel.getMaKH());
        dcNgaySinh.setDate(khModel.getNgaySinh());
        txthoten.setText(khModel.getTenKH());
        txtsdt.setText(khModel.getSDT());
        boolean gt;
        gt = khModel.isGioiTinh;
        if (gt == true) {
            rbtnam.setSelected(true);

        } else {
            rbtnu.setSelected(true);
        }
    }

//    public b1.entity.khachhang getformdata() throws ParseException {
//        String MAKH = txtmakh.getText();
//        String HT = txthoten.getText();
//        String SDT = txtsdt.getText();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date NS = dateFormat.parse(dcNgaySinh.getDate()+"");
//        Boolean GT = !rbtnam.isSelected();
//        int Deleted = 0 ;
//        b1.entity.khachhang kh = new b1.entity.khachhang(MAKH, HT, SDT, NS, GT,Deleted);
//        return kh;
//    }
    public b1.entity.khachhang getformdata() throws ParseException {
        String MAKH = txtmakh.getText();
        String HT = txthoten.getText();
        String SDT = txtsdt.getText();
        Date NS = dcNgaySinh.getDate(); // Get the date directly from the JDateChooser
        Boolean GT = !rbtnam.isSelected();
        int Deleted = 0;

        if (MAKH.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng hãy điền mã KH");
            return null;
        }
        if (HT.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng hãy điền mã KH");
            return null;
        }
        if (SDT.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng hãy điền sdt KH");
            return null;
        }
        if (SDT.matches("[A-Z a-z]+")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không điền chữ vào SDT");
            return null;
        }
        if (NS == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng hãy nhập ngày sinh khách hàng");
            return null;
        }
        if (buttonGroup1 == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng hãy chọn giới tính");
            return null;
        }
        b1.entity.khachhang kh = new b1.entity.khachhang(MAKH, HT, SDT, NS, GT, Deleted);
        return kh;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        panel1 = new b1.View.chucnang.Panel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhienthi = new javax.swing.JTable();
        buttonGradient1 = new b1.View.chucnang.ButtonGradient();
        txtSearch = new textfield.TextField();
        panel2 = new b1.View.chucnang.Panel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        hoten = new javax.swing.JLabel();
        gioitinh = new javax.swing.JLabel();
        sdt = new javax.swing.JLabel();
        nsinh = new javax.swing.JLabel();
        txtmakh = new javax.swing.JTextField();
        txthoten = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtsdt = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        rbtnu = new javax.swing.JRadioButton();
        rbtnam = new javax.swing.JRadioButton();
        Them = new b1.View.chucnang.ButtonGradient();
        Xoa = new b1.View.chucnang.ButtonGradient();
        Sua = new b1.View.chucnang.ButtonGradient();
        ma = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        dcNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblhienthi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblhienthi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KH", "HỌ VÀ TÊN", "SĐT", "ĐỊA CHỈ", "GIỚI TÍNH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblhienthi.setGridColor(new java.awt.Color(255, 255, 255));
        tblhienthi.setRowHeight(30);
        tblhienthi.setSelectionBackground(new java.awt.Color(51, 255, 204));
        tblhienthi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhienthiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblhienthi);

        buttonGradient1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/excel.png"))); // NOI18N
        buttonGradient1.setColor1(new java.awt.Color(255, 255, 255));
        buttonGradient1.setColor2(new java.awt.Color(255, 255, 255));

        txtSearch.setLabelText("Tìm kiếm thông tin khách hàng");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1383, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(buttonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel1.addTab("Thông Tin khách hàng", jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        hoten.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hoten.setText("Họ và Tên");

        gioitinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gioitinh.setText("Giới Tính");

        sdt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sdt.setText("SĐT");

        nsinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nsinh.setText("Ngày Sinh ");

        txtmakh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtmakh.setBorder(null);
        txtmakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmakhActionPerformed(evt);
            }
        });

        txthoten.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txthoten.setBorder(null);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));

        txtsdt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtsdt.setBorder(null);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        rbtnu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnu);
        rbtnu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbtnu.setText("Nữ");

        rbtnam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnam);
        rbtnam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbtnam.setText("Nam");

        Them.setBackground(new java.awt.Color(153, 255, 255));
        Them.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/add-user.png"))); // NOI18N
        Them.setColor1(new java.awt.Color(204, 204, 255));
        Them.setColor2(new java.awt.Color(255, 255, 255));
        Them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        Xoa.setBackground(new java.awt.Color(153, 255, 255));
        Xoa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/delete.png"))); // NOI18N
        Xoa.setColor1(new java.awt.Color(204, 204, 255));
        Xoa.setColor2(new java.awt.Color(255, 255, 255));
        Xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaActionPerformed(evt);
            }
        });

        Sua.setBackground(new java.awt.Color(153, 255, 255));
        Sua.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/undo.png"))); // NOI18N
        Sua.setColor1(new java.awt.Color(204, 204, 255));
        Sua.setColor2(new java.awt.Color(255, 255, 255));
        Sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaActionPerformed(evt);
            }
        });

        ma.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ma.setText("Mã KH");

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));

        dcNgaySinh.setDateFormatString("dd-MM-YYYY");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ma)
                            .addComponent(hoten))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator5)
                            .addComponent(txtmakh, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(txthoten, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sdt)
                            .addComponent(nsinh))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator3)
                            .addComponent(txtsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(dcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(180, 180, 180))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(gioitinh)
                        .addGap(31, 31, 31)
                        .addComponent(rbtnu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnam)
                        .addGap(105, 105, 105)
                        .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ma)
                            .addComponent(sdt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nsinh)
                            .addComponent(hoten))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gioitinh)
                            .addComponent(rbtnu)
                            .addComponent(rbtnam))
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Them, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panel2.addTab("Thiết Lập Thông Tin Khách Hàng", jPanel2);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 204));
        jLabel8.setText("KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(568, 568, 568))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm?");

        if (check == JOptionPane.YES_OPTION) {
            try {
                JOptionPane.showMessageDialog(this, sv.add(getformdata()));
                listkh = sv.getAll();
                ShowDataTable(listkh);
            } catch (ParseException ex) {
                Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (check == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn không");
            return;
        }
        if (check == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn cancel");
            return;
        }

    }//GEN-LAST:event_ThemActionPerformed

    private void tblhienthiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhienthiMouseClicked
        int show = tblhienthi.getSelectedRow();
        Oneclick(show);
    }//GEN-LAST:event_tblhienthiMouseClicked

    private void txtmakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmakhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmakhActionPerformed

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        // TODO add your handling code here:

        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");

        if (check == JOptionPane.YES_OPTION) {
            int xoa = tblhienthi.getSelectedRow();
            khachhangViewModel khvm = listkh.get(xoa);
            sv.xoa(khvm.getMaKH());
            listkh = sv.getAll();
            ShowDataTable(listkh);
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        }
        if (check == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn không");
            return;
        }
        if (check == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn cancel");
            return;
        }
    }//GEN-LAST:event_XoaActionPerformed

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
//        int sua = tblhienthi.getSelectedRow();
//        khachhangViewModel khvm = listkh.get(sua);
//        try {
//            sv.sua(getformdata(), khvm.getMaKH());
//        } catch (ParseException ex) {
//            Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        listkh = sv.getAll();
//        ShowDataTable(listkh);

        //
        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa?");

        if (check == JOptionPane.YES_OPTION) {
            int sua = tblhienthi.getSelectedRow();
            khachhangViewModel khvm = listkh.get(sua);
            try {
                sv.sua(getformdata(), khvm.getMaKH());
                JOptionPane.showMessageDialog(this, "Sửa thành công");
            } catch (ParseException ex) {
                Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
            }
            listkh = sv.getAll();
            ShowDataTable(listkh);
        }
        if (check == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn không");
            return;
        }
        if (check == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn cancel");
            return;
        }
    }//GEN-LAST:event_SuaActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private b1.View.chucnang.ButtonGradient Sua;
    private b1.View.chucnang.ButtonGradient Them;
    private b1.View.chucnang.ButtonGradient Xoa;
    private b1.View.chucnang.ButtonGradient buttonGradient1;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dcNgaySinh;
    private javax.swing.JLabel gioitinh;
    private javax.swing.JLabel hoten;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel ma;
    private javax.swing.JLabel nsinh;
    private b1.View.chucnang.Panel panel1;
    private b1.View.chucnang.Panel panel2;
    private javax.swing.JRadioButton rbtnam;
    private javax.swing.JRadioButton rbtnu;
    private javax.swing.JLabel sdt;
    private javax.swing.JTable tblhienthi;
    private textfield.TextField txtSearch;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmakh;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
