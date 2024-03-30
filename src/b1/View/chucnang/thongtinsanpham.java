/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package b1.View.chucnang;

import ViewModelSP.sanphamchitietviewmodel;
import b1.View.intefacee.interfacesp;
import b1.View.intefacee.iterface2;
import b1.View.sanpham;
import b1.entity.Chatlieusp;
import b1.entity.Daysp;
import b1.entity.Dodaysp;
import b1.entity.DongSanPham;
import b1.entity.Matdesanpham;
import b1.entity.MauSanPham;
import b1.entity.SizeSanPham;
import b1.entity.chitietsanpham;
import b1.entity.hangsanxuat;
import b1.services.chatlieuservices;
import b1.services.dayservices;
import b1.services.dodayservices;
import b1.services.dspservices;
import b1.services.hangsxservices;
import b1.services.matdeservices;
import b1.services.sizeservices;
import b1.services.tenmauservices;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class thongtinsanpham extends javax.swing.JFrame {

    private DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel combo2 = new DefaultComboBoxModel();
    private DefaultComboBoxModel combo3 = new DefaultComboBoxModel();
    private DefaultComboBoxModel combo4 = new DefaultComboBoxModel();
    private DefaultComboBoxModel combo5 = new DefaultComboBoxModel();
    private DefaultComboBoxModel combo6 = new DefaultComboBoxModel();
    private DefaultComboBoxModel combo7 = new DefaultComboBoxModel();
    private DefaultComboBoxModel combo8 = new DefaultComboBoxModel();
    private List<hangsanxuat> listhsx = new ArrayList<>();
    private hangsxservices hsxs = new hangsxservices();
    private List<DongSanPham> listdsp = new ArrayList<>();
    private dspservices dsps = new dspservices();
    private List<MauSanPham> listmsp = new ArrayList<>();
    private tenmauservices ms = new tenmauservices();
    private List<Dodaysp> listddsp = new ArrayList<>();
    private dodayservices dds = new dodayservices();
    private List<Chatlieusp> clsp = new ArrayList<>();
    private chatlieuservices cls = new chatlieuservices();
    private List<Matdesanpham> listmdsp = new ArrayList<>();
    private matdeservices mds = new matdeservices();
    private List<Daysp> listdaysp = new ArrayList<>();
    private dayservices ds = new dayservices();
    private List<SizeSanPham> listsize = new ArrayList<>();
    private sizeservices ss = new sizeservices();
    interfacesp itf = new iterface2() {
    };
    private List<sanphamchitietviewmodel> listvmd = new ArrayList<>();

    private void somemothod() {
        sanpham sp = new sanpham();
        sp.setOtherFrame(this);
        List<sanphamchitietviewmodel> listspvm = new ArrayList<>();

    }

    /**
     * Creates new form thongtinsanpham
     */
    public thongtinsanpham(String MSPCT, String Hsx, String tensanpham, String cl, String size, String matde, String gia, String day, String mau, String doday,String SL) {
        initComponents();
        setLocation(361, 200);
        combo1 = (DefaultComboBoxModel) cbbhang.getModel();
        listhsx = hsxs.getall();
        showcombobox1(listhsx);
        cbbhang.setSelectedItem(Hsx);
        //
        combo2 = (DefaultComboBoxModel) cbbten.getModel();
        listdsp = dsps.getall();
        showcombobox2(listdsp);
        cbbten.setSelectedItem(tensanpham);
        //
        combo3 = (DefaultComboBoxModel) cbbmau.getModel();
        listmsp = ms.getall();
        showcombobox3(listmsp);
        cbbmau.setSelectedItem(mau);
        //
        txtmasp.setText(MSPCT);
        //
        txtgia.setText(gia);
        //
        combo5 = (DefaultComboBoxModel) cbbdoday.getModel();
        listddsp = dds.getall();
        showcombo5(listddsp);
        cbbdoday.setSelectedItem(doday);
        //
        combo6 = (DefaultComboBoxModel) cbbchatlieu.getModel();
        clsp = cls.getall();
        showcombo6(clsp);
        cbbchatlieu.setSelectedItem(cl);
        //
        combo7 = (DefaultComboBoxModel) cbbmatde.getModel();
        listmdsp = mds.getall();
        showcombo7(listmdsp);
        cbbmatde.setSelectedItem(matde);
        //
        combo8 = (DefaultComboBoxModel) cbbday.getModel();
        listdaysp = ds.getall();
        showcombo8(listdaysp);
        cbbday.setSelectedItem(day);
        //
        txtsize.setText(size);
        txtsoluong.setText(SL);

    }

    public void showcombobox1(List<hangsanxuat> listhsx) {
        combo1.removeAllElements();
        for (hangsanxuat object : listhsx) {
            combo1.addElement(object.getTenhang());
        }

    }

    public void showcombobox2(List<DongSanPham> listdsp) {
        combo2.removeAllElements();
        for (DongSanPham dongSanPham : listdsp) {
            combo2.addElement(dongSanPham.getTendsp());
        }

    }

    public void showcombobox3(List<MauSanPham> listmau) {
        combo3.removeAllElements();
        for (MauSanPham mauSanPham : listmau) {
            combo3.addElement(mauSanPham.getTenmau());
        }

    }

    public void showcombo4(List<SizeSanPham> listsize) {
        combo4.removeAllElements();
        for (SizeSanPham sizeSanPham : listsize) {
            combo4.addElement(sizeSanPham.getMasize());
        }

    }

    public void showcombo5(List<Dodaysp> listdoday) {
        combo5.removeAllElements();
        for (Dodaysp dodaysp : listdoday) {
            combo5.addElement(dodaysp.getDoday());
        }
    }

    public void showcombo6(List<Chatlieusp> listchatlieu) {
        combo6.removeAllElements();
        for (Chatlieusp chatlieusp : listchatlieu) {
            combo6.addElement(chatlieusp.getChatlieusp());
        }

    }

    public void showcombo7(List<Matdesanpham> listmd) {
        combo7.removeAllElements();
        for (Matdesanpham matdesanpham : listmd) {
            combo7.addElement(matdesanpham.getMatde());
        }

    }

    public void showcombo8(List<Daysp> listday) {
        combo8.removeAllElements();
        for (Daysp daysp : listday) {
            combo8.addElement(daysp.getDaysp());
        }

    }

    public chitietsanpham getformdata() {
        String IDHSX = (String) cbbhang.getSelectedItem();
        String IDDSP = (String) cbbten.getSelectedItem();
        String IDPM = (String) cbbmau.getSelectedItem();
        String IDS = txtsize.getText();
        String IDDD = (String) cbbdoday.getSelectedItem();
        String IDCL = (String) cbbchatlieu.getSelectedItem();
        String IDMD = (String) cbbmatde.getSelectedItem();
        String IDD = (String) cbbday.getSelectedItem();
        String GB = txtgia.getText();
        String SL = txtsoluong.getText();

        chitietsanpham ctsp1 = new chitietsanpham(IDHSX, IDDSP, IDPM, IDS, IDDD, IDCL, IDMD, IDD, Integer.valueOf(GB), 0,Integer.valueOf(SL));
        return ctsp1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtmasp = new b1.View.chucnang.TextField();
        cbbhang = new b1.View.chucnang.Combobox();
        cbbten = new b1.View.chucnang.Combobox();
        cbbdoday = new b1.View.chucnang.Combobox();
        cbbmatde = new b1.View.chucnang.Combobox();
        cbbchatlieu = new b1.View.chucnang.Combobox();
        cbbmau = new b1.View.chucnang.Combobox();
        txtgia = new b1.View.chucnang.TextField();
        cbbday = new b1.View.chucnang.Combobox();
        txtsize = new b1.View.chucnang.TextField();
        btnsua = new b1.View.chucnang.ButtonGradient();
        btnback = new b1.View.chucnang.ButtonGradient();
        txtsoluong = new b1.View.chucnang.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1460, 680));

        txtmasp.setLabelText("MSP");

        cbbhang.setLabeText("HSX");

        cbbten.setLabeText("DSP");

        cbbdoday.setLabeText("Độ Dày");

        cbbmatde.setLabeText("Mặt Đế");

        cbbchatlieu.setLabeText("Chất Liệu");

        cbbmau.setLabeText("Màu");

        txtgia.setLabelText("Gía");

        cbbday.setLabeText("Dây");

        txtsize.setLabelText("Size");

        btnsua.setBackground(new java.awt.Color(153, 255, 255));
        btnsua.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnsua.setForeground(new java.awt.Color(255, 51, 51));
        btnsua.setText("Sửa");
        btnsua.setColor1(new java.awt.Color(204, 204, 255));
        btnsua.setColor2(new java.awt.Color(255, 255, 255));
        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsuaMouseClicked(evt);
            }
        });
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnback.setBackground(new java.awt.Color(153, 255, 255));
        btnback.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnback.setForeground(new java.awt.Color(255, 51, 51));
        btnback.setText("BACK");
        btnback.setColor1(new java.awt.Color(204, 204, 255));
        btnback.setColor2(new java.awt.Color(255, 255, 255));
        btnback.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackMouseClicked(evt);
            }
        });
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        txtsoluong.setLabelText("Số lượng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtgia, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtsize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmasp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(230, 230, 230)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbmau, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(cbbchatlieu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(cbbhang, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbmatde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbdoday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(295, 295, 295))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbmau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbdoday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbchatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbmatde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(128, 128, 128)
                        .addComponent(cbbday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1437, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsuaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsuaMouseClicked

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        int dk = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa?");
        if (dk == JOptionPane.YES_OPTION) {
            itf.Update(getformdata(), txtmasp.getText());
            listvmd = itf.getall();
            sanpham sp = new sanpham();
            sp.showdata2(listvmd);
            JOptionPane.showMessageDialog(this, "Đã Update thành công");
        }
        if (dk == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã bỏ qua");
            return;
        }
        if (dk == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn Cancel");
            return;
        }


    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbackMouseClicked

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:

        sanpham sp = new sanpham();
        JPanel panelCTSP = sp.getPanelSPCT(); // Sử dụng instance hiện tại của ViewSanPham
        JPanel viewThemThuocTinhSP = jPanel1;
        viewThemThuocTinhSP.removeAll();
        viewThemThuocTinhSP.add(panelCTSP);
        viewThemThuocTinhSP.setLayout(new BorderLayout());
        viewThemThuocTinhSP.add(panelCTSP, BorderLayout.CENTER);
        viewThemThuocTinhSP.revalidate();
        viewThemThuocTinhSP.repaint();


    }//GEN-LAST:event_btnbackActionPerformed

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
            java.util.logging.Logger.getLogger(thongtinsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thongtinsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thongtinsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thongtinsanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private b1.View.chucnang.ButtonGradient btnback;
    private b1.View.chucnang.ButtonGradient btnsua;
    private b1.View.chucnang.Combobox cbbchatlieu;
    private b1.View.chucnang.Combobox cbbday;
    private b1.View.chucnang.Combobox cbbdoday;
    private b1.View.chucnang.Combobox cbbhang;
    private b1.View.chucnang.Combobox cbbmatde;
    private b1.View.chucnang.Combobox cbbmau;
    private b1.View.chucnang.Combobox cbbten;
    private javax.swing.JPanel jPanel1;
    private b1.View.chucnang.TextField txtgia;
    private b1.View.chucnang.TextField txtmasp;
    private b1.View.chucnang.TextField txtsize;
    private b1.View.chucnang.TextField txtsoluong;
    // End of variables declaration//GEN-END:variables
}
