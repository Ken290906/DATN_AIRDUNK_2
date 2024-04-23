/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package b1.View;

import ViewModelHD.HoaDon;
import ViewModelSP.sanphamviewmodel;
import b1.entity.DongSanPham;
import b1.entity.HoaDonBH;
import b1.entity.chitietsanpham;
import b1.services.HoaDonBHService;
import b1.services.HoaDonService;
import b1.services.chitietsanphamp2services;
import b1.services.chitietsanphamservices;
import b1.services.dspservices;
import com.raven.chart.ModelChart;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Locale;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author DELL
 */
public class thongke extends javax.swing.JInternalFrame {

    private DefaultTableModel bang = new DefaultTableModel();
    private List<HoaDon> hdb = new ArrayList<>();
    private List<sanphamviewmodel> spvm = new ArrayList<>();
    private HoaDonService bhs = new HoaDonService();
    private DefaultTableModel bang2 = new DefaultTableModel();
    private List<DongSanPham> listdsp = new ArrayList<>();
    private dspservices dsps = new dspservices();
    private chitietsanphamservices sps2 = new chitietsanphamservices();
    DecimalFormat VND = new DecimalFormat("#,##0 đ");

    /**
     * Creates new form gd1
     */
    public thongke() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        bang = (DefaultTableModel) tblthongke.getModel();
        hdb = bhs.getAll();
        bang2 = (DefaultTableModel) tblsanphamhot.getModel();
        listdsp = dsps.getall();
        showdatasp(listdsp);
        showdata(hdb);
        getContentPane().setBackground(new Color(250, 250, 250));
        chart1.addLegend("Số Hóa Đơn Đc Giao", new Color(135, 189, 245));
        chart1.addLegend("Số Lượng Bom Hàng", new Color(189, 135, 245));
        chart1.addLegend("Số lượng khách hàng", new Color(139, 229, 222));
        chart1.addData(new ModelChart("T1", new double[]{200, 80, 89}));
        chart1.addData(new ModelChart("T2", new double[]{100, 180, 389}));
        chart1.addData(new ModelChart("T3", new double[]{300, 40, 39}));
        chart1.addData(new ModelChart("T4", new double[]{220, 80, 19}));
        chart1.addData(new ModelChart("T5", new double[]{220, 80, 19}));
        chart1.addData(new ModelChart("T6", new double[]{220, 80, 19}));
        chart1.addData(new ModelChart("T7", new double[]{220, 80, 19}));
        chart1.addData(new ModelChart("T8", new double[]{220, 80, 19}));
        chart1.addData(new ModelChart("T9", new double[]{220, 80, 19}));
        chart1.addData(new ModelChart("T10", new double[]{220, 80, 19}));
        chart1.addData(new ModelChart("T11", new double[]{220, 80, 19}));
        chart1.addData(new ModelChart("T12", new double[]{220, 80, 19}));
        cbbthongke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chon = (String) cbbthongke.getSelectedItem();
                getContentPane().setBackground(new Color(250, 250, 250)); // Setting background color
                VND.applyLocalizedPattern("#,##0 đ");
                // Clear existing legends and data
                // Add legends and data based on selection
                if (chon.equals("T1")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T1", new double[]{200, 180, 380}));
                    txtdoanhthu.setText(VND.format(34300));
                    txthoadongiao.setText("100");
                    txtsoluongbomhang.setText("180");
                    txtslkhachhang.setText("380");

                    chart1.start();
                } else if (chon.equals("T2")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T2", new double[]{100, 150, 350}));
                    txtdoanhthu.setText(VND.format(50000));
                    txthoadongiao.setText("100");
                    txtsoluongbomhang.setText("150");
                    txtslkhachhang.setText("350");
                    chart1.start();
                } else if (chon.equals("T3")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T3", new double[]{350, 50, 400}));
                    txtdoanhthu.setText(VND.format(65000));
                    txthoadongiao.setText("350");
                    txtsoluongbomhang.setText("50");
                    txtslkhachhang.setText("400");
                    chart1.start();
                } // Add more conditions as needed
                else if (chon.equals("T4")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T4", new double[]{ 220, 80, 300}));
                    txtdoanhthu.setText(VND.format(26000));
                     txthoadongiao.setText("220");
                    txtsoluongbomhang.setText("80");
                    txtslkhachhang.setText("300");
                    chart1.start();
                } // Add more conditions as needed
                else if (chon.equals("T5")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T5", new double[]{ 0, 0, 0}));
                    txtdoanhthu.setText(VND.format(0));
                      txthoadongiao.setText("0");
                    txtsoluongbomhang.setText("0");
                    txtslkhachhang.setText("0");
                    chart1.start();
                } // Add more conditions as needed
                else if (chon.equals("T6")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T6", new double[]{ 0, 0, 0}));
                       txtdoanhthu.setText(VND.format(0));
                     txthoadongiao.setText("0");
                    txtsoluongbomhang.setText("0");
                    txtslkhachhang.setText("0");
                    chart1.start();
                } // Add more conditions as needed
                else if (chon.equals("T7")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T7", new double[]{ 0, 0, 0}));
                       txtdoanhthu.setText(VND.format(0));
                     txthoadongiao.setText("0");
                    txtsoluongbomhang.setText("0");
                    txtslkhachhang.setText("0");
                    chart1.start();
                } // Add more conditions as needed
                else if (chon.equals("T8")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T8", new double[]{ 0, 0, 0}));
                       txtdoanhthu.setText(VND.format(0));
                     txthoadongiao.setText("0");
                    txtsoluongbomhang.setText("0");
                    txtslkhachhang.setText("0");
                    chart1.start();
                } // Add more conditions as needed
                else if (chon.equals("T9")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T9", new double[]{ 0, 0, 0}));
                       txtdoanhthu.setText(VND.format(0));
                     txthoadongiao.setText("0");
                    txtsoluongbomhang.setText("0");
                    txtslkhachhang.setText("0");
                    chart1.start();
                } // Add more conditions as needed
                else if (chon.equals("T10")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T10", new double[]{ 0, 0, 0}));
                       txtdoanhthu.setText(VND.format(0));
                     txthoadongiao.setText("0");
                    txtsoluongbomhang.setText("0");
                    txtslkhachhang.setText("0");
                    chart1.start();
                } // Add more conditions as needed
                else if (chon.equals("T11")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T11", new double[]{ 0, 0, 0}));
                       txtdoanhthu.setText(VND.format(0));
                     txthoadongiao.setText("0");
                    txtsoluongbomhang.setText("0");
                    txtslkhachhang.setText("0");
                    chart1.start();
                } // Add more conditions as needed
                else if (chon.equals("T12")) {
                    chart1.clear();
                    chart1.addData(new ModelChart("T12", new double[]{ 0, 0, 0}));
                       txtdoanhthu.setText(VND.format(0));
                     txthoadongiao.setText("0");
                    txtsoluongbomhang.setText("0");
                    txtslkhachhang.setText("0");
                    chart1.start();
                } // Add more conditions as needed
            }
        });
        txtsearchsp.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchsp();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchsp();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchsp();
            }

        });
        txtsearchhd.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                searchhd();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchhd();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchhd();
            }

        });
    }

    private void searchsp() {
        listdsp = dsps.search(txtsearchsp.getText());
        showdatasp(listdsp);
    }

    public void showdata(List<HoaDon> list) {
        bang.setRowCount(0);
        int i = 0;
        for (HoaDon hoaDonBH : list) {
            i++;
            String HD = VND.format(hoaDonBH.getTongTien());
            bang.addRow(new Object[]{i, hoaDonBH.getMaHD(), hoaDonBH.getNgaytaoHD(), HD});
        }
    }

    public void showdatasp(List<DongSanPham> list) {
        bang2.setRowCount(0);
        int i = 0;
        for (DongSanPham object : list) {
            bang2.addRow(new Object[]{i, object.getIDdsp(), object.getTendsp(), object.getSoluong()});
        }
    }

    private void searchhd() {
        hdb = bhs.sreachHDthongke(txtsearchhd.getText());
        showdata(hdb);
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
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtdoanhthu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txthoadongiao = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtslkhachhang = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtsoluongbomhang = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel1 = new b1.View.chucnang.Panel();
        jPanel7 = new javax.swing.JPanel();
        chart1 = new com.raven.chart.Chart();
        buttonGradient1 = new b1.View.chucnang.ButtonGradient();
        cbbthongke = new b1.View.Combobox();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblthongke = new javax.swing.JTable();
        txtsearchhd = new b1.View.chucnang.TextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblsanphamhot = new javax.swing.JTable();
        txtsearchsp = new b1.View.chucnang.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("DOANH THU");

        txtdoanhthu.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtdoanhthu.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(txtdoanhthu)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(txtdoanhthu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(264, 219));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Số Hóa Đơn Đang Giao");

        txthoadongiao.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txthoadongiao.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(67, 67, 67))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(txthoadongiao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(txthoadongiao)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setForeground(new java.awt.Color(255, 153, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(264, 219));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Số Lương Khách Hàng");

        txtslkhachhang.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtslkhachhang.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtslkhachhang)
                        .addGap(110, 110, 110))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(txtslkhachhang)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(191, 170, 231));
        jPanel5.setPreferredSize(new java.awt.Dimension(264, 219));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Số Lượng Bom Hàng");

        txtsoluongbomhang.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtsoluongbomhang.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(69, 69, 69))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(txtsoluongbomhang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(txtsoluongbomhang)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 204));
        jLabel9.setText("THỐNG KÊ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(592, 592, 592))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        buttonGradient1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGradient1.setForeground(new java.awt.Color(0, 0, 0));
        buttonGradient1.setText("Hiện Thị Thống Kê cả năm");
        buttonGradient1.setColor1(new java.awt.Color(204, 204, 255));
        buttonGradient1.setColor2(new java.awt.Color(255, 255, 255));
        buttonGradient1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonGradient1MouseClicked(evt);
            }
        });

        cbbthongke.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12" }));
        cbbthongke.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbthongke.setLabeText("Tháng ");
        cbbthongke.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 1172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(cbbthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(buttonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbbthongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel1.addTab("Biểu Đồ", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tblthongke.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblthongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Ngày Tạo", "Tổng Tiền"
            }
        ));
        tblthongke.setGridColor(new java.awt.Color(255, 255, 255));
        tblthongke.setRowHeight(40);
        tblthongke.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblthongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblthongkeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblthongke);

        txtsearchhd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtsearchhd.setLabelText("Tìm kiếm tt");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1378, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtsearchhd, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(txtsearchhd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel1.addTab("Bảng thông tin", jPanel6);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        tblsanphamhot.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblsanphamhot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số lượng hàng"
            }
        ));
        tblsanphamhot.setGridColor(new java.awt.Color(255, 255, 255));
        tblsanphamhot.setRowHeight(40);
        tblsanphamhot.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tblsanphamhot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsanphamhotMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblsanphamhot);

        txtsearchsp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtsearchsp.setLabelText("Tìm kiếm tt");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1378, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtsearchsp, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(txtsearchsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel1.addTab("Bảng Sản Phảm đang hot", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGradient1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGradient1MouseClicked
        // TODO add your handling code here:
        chart1.clear();
        chart1.addData(new ModelChart("T1", new double[]{200, 180, 89}));
        chart1.addData(new ModelChart("T2", new double[]{100, 180, 389}));
        chart1.addData(new ModelChart("T3", new double[]{300, 40, 39}));
        chart1.addData(new ModelChart("T4", new double[]{220, 80, 19}));
        chart1.addData(new ModelChart("T5", new double[]{0, 0, 0}));
        chart1.addData(new ModelChart("T6", new double[]{0, 0, 0}));
        chart1.addData(new ModelChart("T7", new double[]{0, 0, 0}));
        chart1.addData(new ModelChart("T8", new double[]{0, 0, 0}));
        chart1.addData(new ModelChart("T9", new double[]{0, 0, 0}));
        chart1.addData(new ModelChart("T10", new double[]{0, 0, 0}));
        chart1.addData(new ModelChart("T11", new double[]{0, 0, 0}));
        chart1.addData(new ModelChart("T12", new double[]{0, 0, 0}));
        txtdoanhthu.setText(VND.format(0));
        txthoadongiao.setText("480");
        txtsoluongbomhang.setText("820");
        txtslkhachhang.setText("1040");
        chart1.start();
    }//GEN-LAST:event_buttonGradient1MouseClicked

    private void tblthongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblthongkeMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblthongkeMouseClicked

    private void tblsanphamhotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsanphamhotMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblsanphamhotMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private b1.View.chucnang.ButtonGradient buttonGradient1;
    private javax.swing.ButtonGroup buttonGroup1;
    private b1.View.Combobox cbbthongke;
    private com.raven.chart.Chart chart1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private b1.View.chucnang.Panel panel1;
    private javax.swing.JTable tblsanphamhot;
    private javax.swing.JTable tblthongke;
    private javax.swing.JLabel txtdoanhthu;
    private javax.swing.JLabel txthoadongiao;
    private b1.View.chucnang.TextField txtsearchhd;
    private b1.View.chucnang.TextField txtsearchsp;
    private javax.swing.JLabel txtslkhachhang;
    private javax.swing.JLabel txtsoluongbomhang;
    // End of variables declaration//GEN-END:variables
}
