/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package b1.View.chucnang;

import GioHangViewModel.GioHangViewMD;
import ViewModelSP.sanphamchitietviewmodel;
import b1.View.banhhang;
import b1.entity.HDChiTiet;
import b1.entity.chitietsanpham;
import b1.services.HoaDonBHService;
import b1.services.chitietsanphamp2services;
import com.beust.ah.A;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Math.random;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class themdanhsachsanpham extends javax.swing.JFrame {

    private DefaultTableModel bangsanpham = new DefaultTableModel();
    private List<sanphamchitietviewmodel> listsp = new ArrayList<>();
    private List<GioHangViewMD> listGH = new ArrayList<>();
    private chitietsanphamp2services sps = new chitietsanphamp2services();
    private HoaDonBHService sr = new HoaDonBHService();
    private Random random = new Random();

    /**
     * Creates new form themdanhsachsanpham
     */
    public themdanhsachsanpham() {
        initComponents();
        bangsanpham = (DefaultTableModel) tbldanhsachsanpham.getModel();
        listsp = sps.getall();
        showdata(listsp);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tbldanhsachsanpham.setDefaultEditor(Object.class, null);
        setLocationRelativeTo(null);
        cbbhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timkiem = cbbhang.getSelectedItem().toString();
                if (!timkiem.isEmpty()) {
                    List<sanphamchitietviewmodel> searchedList = searchHang(timkiem);
                    showdata(searchedList);
                } else {
                    // If no manufacturer is selected, reload all products                 
                    listsp = sps.getall();
                    showdata(listsp);

                }
            }

        });
        cbbday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timkiem = cbbday.getSelectedItem().toString();
                if (!timkiem.isEmpty()) {
                    List<sanphamchitietviewmodel> searchedList = searchDay(timkiem);
                    showdata(searchedList);
                } else {
                    // If no manufacturer is selected, reload all products  
                    listsp = sps.getall();
                    showdata(listsp);

                }
            }

        });
        cbbmau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timkiem = cbbmau.getSelectedItem().toString();
                if (!timkiem.isEmpty()) {
                    List<sanphamchitietviewmodel> searchedList = searchMau(timkiem);
                    showdata(searchedList);
                } else {
                    listsp = sps.getall();
                    showdata(listsp);

                }
            }

        });
        cbbchatlieu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timkiem = cbbchatlieu.getSelectedItem().toString();
                if (!timkiem.isEmpty()) {
                    List<sanphamchitietviewmodel> searchedList = searchCL(timkiem);
                    showdata(searchedList);
                } else {
                    listsp = sps.getall();
                    showdata(listsp);

                }
            }
        });
        txtsearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SearchBanhang();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SearchBanhang();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SearchBanhang();
            }

        });
    }

    private List<sanphamchitietviewmodel> searchHang(String manufacturerName) {
        List<sanphamchitietviewmodel> filteredList = new ArrayList<>();

        for (sanphamchitietviewmodel product : listsp) {
            if (product.getIdhangsx().equalsIgnoreCase(manufacturerName)) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }

    private List<sanphamchitietviewmodel> searchMau(String manufacturerName) {
        List<sanphamchitietviewmodel> filteredList = new ArrayList<>();

        for (sanphamchitietviewmodel product : listsp) {
            if (product.getIdphoimau().equalsIgnoreCase(manufacturerName)) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }

    private List<sanphamchitietviewmodel> searchDay(String manufacturerName) {
        List<sanphamchitietviewmodel> filteredList = new ArrayList<>();

        for (sanphamchitietviewmodel product : listsp) {
            if (product.getIdday().equalsIgnoreCase(manufacturerName)) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }

    private List<sanphamchitietviewmodel> searchCL(String manufacturerName) {
        List<sanphamchitietviewmodel> filteredList = new ArrayList<>();

        for (sanphamchitietviewmodel product : listsp) {
            if (product.getIdchatlieu().equalsIgnoreCase(manufacturerName)) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }

    public void showdata(List<sanphamchitietviewmodel> sanpham) {
        bangsanpham.setRowCount(0);
        int i = 0;
        Locale lc = new Locale("vi", "VN");
        NumberFormat currentFormater = NumberFormat.getCurrencyInstance(lc);
        for (sanphamchitietviewmodel sp : sanpham) {
            i++;
            bangsanpham.addRow(new Object[]{i, sp.getMctsp(), sp.getIddongsp(), sp.getIdhangsx(), sp.getIdphoimau(), sp.getIdsize(), sp.getIdchatlieu(), sp.getIdday(), sp.getSoluong(), sp.getGiaban()});
        }
    }

    private void SearchBanhang() {
        listsp = sps.Searchbanhang(txtsearch.getText());
        showdata(listsp);
    }

    private String generateMaHD() {
        String maHD = "HD-00" + String.format("%03d", random.nextInt(1000));
        return maHD;

    }

    private int nhapSoLuong() {
        String input = JOptionPane.showInputDialog("Nhập số lượng:");

        if (input != null && !input.isEmpty()) {
            try {
                int soLuong = Integer.parseInt(input);
                return soLuong;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên dương.");
            }
        }
        return 0; // Trả về 0 nếu không nhập hoặc nhập không hợp lệ
    }
    
    public HDChiTiet getformdata() {
        banhhang bh = new banhhang();
        int selectedRow = tbldanhsachsanpham.getSelectedRow();

        String maHDCT = generateMaHD();
        String maHD = bh.getFormData().getMaHD();
        String maCTSP = (String) tbldanhsachsanpham.getValueAt(selectedRow, 1);
        String donGiaStr = tbldanhsachsanpham.getValueAt(selectedRow, 9).toString();
        float donGia = Float.parseFloat(donGiaStr.replace(".", "").replaceAll("[^\\d]", ""));
        int soLuong = nhapSoLuong();

        float thanhTien = donGia * soLuong; // tính giá trị thanhTien

        HDChiTiet hdct = new HDChiTiet(maHDCT, maHD, maCTSP, donGia, thanhTien, soLuong);
        return hdct;
    }

//    public chitietsanpham getFormDataSP() {
//        int selectedRow = tbldanhsachsanpham.getSelectedRow();
//
//        String masp = (String) tbldanhsachsanpham.getValueAt(selectedRow, 1);
//        String iddongsp = (String) tbldanhsachsanpham.getValueAt(selectedRow, 2);
//        String idhangsx = (String) tbldanhsachsanpham.getValueAt(selectedRow, 3);
//        String idphoimau = (String) tbldanhsachsanpham.getValueAt(selectedRow, 4);
//        String idsize = (String) tbldanhsachsanpham.getValueAt(selectedRow, 5);
//        String idchatlieu = (String) tbldanhsachsanpham.getValueAt(selectedRow, 6);
//        String idday = (String) tbldanhsachsanpham.getValueAt(selectedRow, 7);
//        String donGiaStr = tbldanhsachsanpham.getValueAt(selectedRow, 9).toString();
//        int donGia = Integer.parseInt(donGiaStr.replace(".", "").replaceAll("[^\\d]", ""));
//        int soLuong = (int) tbldanhsachsanpham.getValueAt(selectedRow, 8);
//
//        chitietsanpham ctsp = new chitietsanpham(masp, iddongsp, idhangsx, idphoimau, idsize, idchatlieu, idday, donGia, soLuong);
//        return ctsp;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldanhsachsanpham = new javax.swing.JTable();
        buttonGradient4 = new b1.View.ButtonGradient();
        txtsearch = new b1.View.chucnang.TextField();
        cbbmau = new b1.View.Combobox();
        cbbchatlieu = new b1.View.Combobox();
        cbbday = new b1.View.Combobox();
        cbbhang = new b1.View.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbldanhsachsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Mã SPCT", "Tên SP", "Hãng", "Màu", "Size", "Chất liệu", "Dây", "Số lượng", "Giá tiền"
            }
        ));
        tbldanhsachsanpham.setGridColor(new java.awt.Color(255, 255, 255));
        tbldanhsachsanpham.setRowHeight(30);
        tbldanhsachsanpham.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jScrollPane2.setViewportView(tbldanhsachsanpham);

        buttonGradient4.setText("ADD");
        buttonGradient4.setColor1(new java.awt.Color(51, 255, 255));
        buttonGradient4.setColor2(new java.awt.Color(0, 204, 255));
        buttonGradient4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGradient4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient4ActionPerformed(evt);
            }
        });

        txtsearch.setLabelText("Tìm kiếm");

        cbbmau.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Xanh", "Đỏ", "Xanh nhạt", "Xanh Lá", "Nâu", "Hồng", "Cam", "Xám", "Đen", "Nau Do" }));
        cbbmau.setLabeText("Màu");

        cbbchatlieu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Da", "Vải" }));
        cbbchatlieu.setLabeText("Chất Liệu");

        cbbday.setMaximumRowCount(90);
        cbbday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Dây Xanh", "Dây Trắng", "Dây Đen", "Dây Trắng lai Đen", "Dây Đỏ", "Dây 2light", "Dây Đỏ lai Xanh", "Dây Xám", "Dây Phát Xám", "Dây Hồng" }));
        cbbday.setLabeText("Dây");

        cbbhang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Nike", "Adidas", "Puma", "Rebook", "Convert", "Vans." }));
        cbbhang.setLabeText("Hãng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonGradient4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(cbbmau, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbday, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbhang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbmau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGradient4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGradient4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        sr.AddSPGH(getformdata());
        banhhang bh = new banhhang();
        bh.setVisible(true);
        bh.showGioHang(listGH);
    }//GEN-LAST:event_buttonGradient4ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(themdanhsachsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(themdanhsachsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(themdanhsachsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(themdanhsachsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new themdanhsachsanpham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private b1.View.ButtonGradient buttonGradient4;
    private b1.View.Combobox cbbchatlieu;
    private b1.View.Combobox cbbday;
    private b1.View.Combobox cbbhang;
    private b1.View.Combobox cbbmau;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbldanhsachsanpham;
    private b1.View.chucnang.TextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
