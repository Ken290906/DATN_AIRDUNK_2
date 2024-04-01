/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package b1.View.chucnang;

import ViewModelKH.khachhangViewModel;
import b1.View.banhhang;
import b1.View.khachhang;
import b1.services.khachhangService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class khachhangbanhang extends javax.swing.JFrame {
    //List
private List<khachhangViewModel> listkh = new ArrayList<>();
//Services
private khachhangService khs = new khachhangService();
//Table
private DefaultTableModel bangkh = new DefaultTableModel();

    /**
     * Creates new form khachhangbanhang
     */
    public khachhangbanhang() {
        initComponents();
        setLocationRelativeTo(null);
        bangkh = (DefaultTableModel) tbldanhsachkhachhang.getModel();
        listkh = khs.getAll();
        showdataKh(listkh);
        
        txtsearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                Search();
            }
            
        }
            
        );
        
   
        
    }
    public void showdataKh(List<khachhangViewModel> list){
        bangkh.setRowCount(0);
        int stt = 0;
        for (khachhangViewModel viewModel : list) {
         stt++;
          String gioiTinhText = viewModel.isGioiTinh ? "nam" : "nữ";
            bangkh.addRow(new Object[]{stt,viewModel.getMaKH(),viewModel.getTenKH(),viewModel.getSDT(),gioiTinhText});
        }
       
    }
    
    private void Search(){
        listkh = khs.Searchkhachhangbanhang(txtsearch.getText());
        showdataKh(listkh);
    }
    
     public khachhang getformdata() {
        String MAKH = txtMaKH.getText();
        String TKH = txtMaKH.getText();
        String SDT = txtsdt.getText();
        Boolean GT = !rdonam.isSelected();
  
        khachhang kh = new khachhang();
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

        panel1 = new b1.View.chucnang.Panel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldanhsachkhachhang = new javax.swing.JTable();
        txtsearch = new b1.View.chucnang.TextField();
        buttonGradient9 = new b1.View.chucnang.ButtonGradient();
        panel2 = new b1.View.chucnang.Panel();
        jPanel6 = new javax.swing.JPanel();
        txtMaKH = new b1.View.chucnang.TextField();
        btnreseat = new b1.View.chucnang.ButtonGradient();
        btnthem = new b1.View.chucnang.ButtonGradient();
        txtsdt = new b1.View.chucnang.TextField();
        txtTenKH = new b1.View.chucnang.TextField();
        jLabel1 = new javax.swing.JLabel();
        rdonu = new javax.swing.JRadioButton();
        rdonam = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbldanhsachkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "#", "Mã KH", "Tên KH", "Số điện thoại", "Giới Tính"
            }
        ));
        tbldanhsachkhachhang.setGridColor(new java.awt.Color(255, 255, 255));
        tbldanhsachkhachhang.setRowHeight(30);
        tbldanhsachkhachhang.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tbldanhsachkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldanhsachkhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldanhsachkhachhang);

        txtsearch.setLabelText("Tìm kiếm");

        buttonGradient9.setBackground(new java.awt.Color(153, 255, 255));
        buttonGradient9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonGradient9.setForeground(new java.awt.Color(0, 0, 0));
        buttonGradient9.setText("Chọn");
        buttonGradient9.setColor1(new java.awt.Color(204, 204, 255));
        buttonGradient9.setColor2(new java.awt.Color(255, 255, 255));
        buttonGradient9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGradient9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonGradient9MouseClicked(evt);
            }
        });
        buttonGradient9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonGradient9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonGradient9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel1.addTab("Danh sách khách hàng", jPanel4);
        panel1.addTab("", panel2);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMaKH.setLabelText("Mã KH");

        btnreseat.setBackground(new java.awt.Color(153, 255, 255));
        btnreseat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnreseat.setForeground(new java.awt.Color(0, 0, 0));
        btnreseat.setText("Reseat");
        btnreseat.setColor1(new java.awt.Color(204, 204, 255));
        btnreseat.setColor2(new java.awt.Color(255, 255, 255));
        btnreseat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnreseat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnreseatMouseClicked(evt);
            }
        });
        btnreseat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreseatActionPerformed(evt);
            }
        });

        btnthem.setBackground(new java.awt.Color(153, 255, 255));
        btnthem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnthem.setForeground(new java.awt.Color(0, 0, 0));
        btnthem.setText("Thêm");
        btnthem.setColor1(new java.awt.Color(204, 204, 255));
        btnthem.setColor2(new java.awt.Color(255, 255, 255));
        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnthemMouseClicked(evt);
            }
        });
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        txtsdt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtsdt.setLabelText("SDT");

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTenKH.setLabelText("Tên KH");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Giới Tính :");

        rdonu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdonu.setText("Nữ");

        rdonam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdonam.setText("Nam");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(41, 41, 41)
                                .addComponent(rdonu))
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdonam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnreseat, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdonu)
                    .addComponent(rdonam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnreseat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panel1.addTab("Tạo khách hàng", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnreseatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreseatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnreseatActionPerformed

    private void btnreseatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreseatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnreseatMouseClicked

    private void buttonGradient9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient9ActionPerformed
        // TODO add your handling code here:
        int index = tbldanhsachkhachhang.getSelectedRow();
        khachhangViewModel khModel = khs.getAll().get(index);
        String MKH = khModel.getMaKH();
        String TKH = khModel.getTenKH();

        dispose();
    }//GEN-LAST:event_buttonGradient9ActionPerformed

    private void buttonGradient9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGradient9MouseClicked
        // TODO add your handling code here:

        //                    String MCTSP = ctspViewModel.getMctsp();
        //                    String HSX = ctspViewModel.getIdhangsx();
        //                    String DSP = ctspViewModel.getIddongsp();
        //                    String MauSac = ctspViewModel.getIdphoimau();
        //                    String Size = ctspViewModel.getIdsize();
        //                    String doday = ctspViewModel.getIddoday();
        //                    String Chatlieu = ctspViewModel.getIdchatlieu();
        //                    String Matde = ctspViewModel.getIdmatde();
        //                    String day = ctspViewModel.getIdday();
        //                    String GiaB = ctspViewModel.getGiaban() + "";
        //                    String SL = ctspViewModel.getSoluong()+"";
        //
        //                    // Open your ThongTinChiTietSP dialog or perform any other action here
        //                    thongtinsanpham tt = new thongtinsanpham(MCTSP, HSX, DSP, Chatlieu, Size, Matde, GiaB, day, MauSac, doday,SL);
        //                    tt.setVisible(true);
    }//GEN-LAST:event_buttonGradient9MouseClicked

    private void tbldanhsachkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachkhachhangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbldanhsachkhachhangMouseClicked

    private void btnthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnthemMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnthemActionPerformed

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
            java.util.logging.Logger.getLogger(khachhangbanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(khachhangbanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(khachhangbanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(khachhangbanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new khachhangbanhang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private b1.View.chucnang.ButtonGradient btnreseat;
    private b1.View.chucnang.ButtonGradient btnthem;
    private b1.View.chucnang.ButtonGradient buttonGradient9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private b1.View.chucnang.Panel panel1;
    private b1.View.chucnang.Panel panel2;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTable tbldanhsachkhachhang;
    private b1.View.chucnang.TextField txtMaKH;
    private b1.View.chucnang.TextField txtTenKH;
    private b1.View.chucnang.TextField txtsdt;
    private b1.View.chucnang.TextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
