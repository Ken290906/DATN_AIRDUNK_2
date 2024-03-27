/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package b1.View;

import b1.View.banhhang;
import ViewModelHD.HoaDon;
import ViewModelHD.HoaDonChiTiet;
import ViewModelHD.LichSuHD;
import b1.View.chucnang.quetmaqr;
import b1.services.HDCTService;
import b1.services.HoaDonService;
import b1.services.LichsuHDService;
import com.itextpdf.text.BadElementException;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import com.itextpdf.text.Paragraph;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author DELL
 */
public class hoadon extends javax.swing.JInternalFrame {

    private DefaultTableModel dtmHDCT = new DefaultTableModel();
    private HDCTService sr = new HDCTService();
    private List<HoaDonChiTiet> list = new ArrayList<>();

    private DefaultTableModel dtm1 = new DefaultTableModel();
    private HoaDonService hdsr = new HoaDonService();
    private List<HoaDon> listhd = new ArrayList<>();

    private DefaultTableModel dtmLSHD = new DefaultTableModel();
    private LichsuHDService lssr = new LichsuHDService();
    private List<LichSuHD> listLSHD = new ArrayList<>();

    public hoadon() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        getContentPane().setBackground(Color.WHITE);

        listhd = hdsr.getAll();
        dtm1 = (DefaultTableModel) TblHoaDon.getModel();
        showDataHD(listhd);

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                hdsr.searchHoaDon(txtSearch.getText() + "");
                listhd = hdsr.searchHoaDon(txtSearch.getText());
                showDataHD(listhd);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                hdsr.searchHoaDon(txtSearch.getText() + "");
                listhd = hdsr.searchHoaDon(txtSearch.getText());
                showDataHD(listhd);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                hdsr.searchHoaDon(txtSearch.getText() + "");
                listhd = hdsr.searchHoaDon(txtSearch.getText());
                showDataHD(listhd);
            }

        });

        cbbTrangthai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trangthai = (String) cbbTrangthai.getSelectedItem();
                List<HoaDon> hd = searchTrangthai(trangthai);
                showDataHD(hd);
            }
        });

        cbbHTTT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String httt = (String) cbbHTTT.getSelectedItem();
                List<HoaDon> hd = searchHTTT(httt);
                showDataHD(hd);
            }
        });
    }
    
    private String SearchTT(String trangthai) {
        if("0".equalsIgnoreCase(trangthai)) {
            return "Chưa thanh toán";
        } else {
            return "Đã thanh toán";
        }
    }

    private List<HoaDon> searchTrangthai(String trangthai) {
        List<HoaDon> filteredList = new ArrayList<>();

        for (HoaDon hd : listhd) {
            if (SearchTT(String.valueOf(hd.getTrangThai())).equalsIgnoreCase(trangthai)) {
                filteredList.add(hd);
            }
        }

        return filteredList;
    }

    private String getHTTTName(String maHTTT) {
        if ("HTTT-001".equalsIgnoreCase(maHTTT)) {
            return "Chuyển khoản";
        } else {
            return "Tiền mặt";
        }
    }

    private List<HoaDon> searchHTTT(String httt) {
        List<HoaDon> ListTT = new ArrayList<>();

        for (HoaDon hd : listhd) {
            if (getHTTTName(hd.getMaHTTT()).equalsIgnoreCase(httt)) {
                ListTT.add(hd);
            }
        }

        return ListTT;
    }

    public void showDataHDCT(List<HoaDonChiTiet> listHDCT) {
        dtmHDCT.setRowCount(0);
        int i = 0;
        Locale lc = new Locale("vi", "VN");
        NumberFormat currentFormater = NumberFormat.getCurrencyInstance(lc);
        for (HoaDonChiTiet hdct : listHDCT) {
            i++;
            dtmHDCT.addRow(new Object[]{
                i,
                hdct.getMaHD(),
                hdct.getIdCTSP(),
                currentFormater.format(hdct.getDonGia()),
                currentFormater.format(hdct.getThanhTien()),});
        }
    }

    public void showDataLSHD(List<LichSuHD> listlshd) {
        dtmLSHD.setRowCount(0);
        int i = 0;
        for (LichSuHD lshd : listlshd) {
            i++;
            dtmLSHD.addRow(new Object[]{
                i,
                lshd.getMaHD(),
                lshd.getManv(),
                lshd.getNgaytao(),
                lshd.getHanhDong(),
                lshd.getMaLSHD()
            });
        }
    }

    public void showDataHD(List<HoaDon> listHD) {
        dtm1.setRowCount(0);

        int i = 0;
        Locale lc = new Locale("vi", "VN");
        NumberFormat currentFormater = NumberFormat.getCurrencyInstance(lc);
        for (HoaDon hd : listHD) {
            String tt = "";
            if (hd.getTrangThai() == 1) {
                tt = "Đã thanh toán";
            } else {
                tt = "Chưa thanh toán";
            }

            String httt = getHTTTName(hd.getMaHTTT());
            i++;

            dtm1.addRow(new Object[]{
                i,
                hd.getMaHD(),
                hd.getTenKH(),
                httt,
                hd.getDiaChi(),
                "0" + hd.getSdtKH(),
                currentFormater.format(hd.getTongTien()),
                hd.getNgaytaoHD(),
                tt
            });
        }
    }

    public void Show() {
        int index = TblHoaDon.getSelectedRow();

        HoaDon hd = listhd.get(index);

        dtmLSHD = (DefaultTableModel) TblLSHD.getModel();
        listLSHD = lssr.getAll(hd.getMaHD());
        showDataLSHD(listLSHD);

        dtmHDCT = (DefaultTableModel) TblHDCT.getModel();
        list = sr.getAll(hd.getMaHD());
        showDataHDCT(list);
    }

    private void createPDF(String maHD) throws BadElementException, IOException {
        int selectedRowIndex = TblHoaDon.getSelectedRow();
        try {
            Document document = new Document(PageSize.A4, 30, 30, 30, 30); // Giảm lề

            PdfWriter.getInstance(document, new FileOutputStream("C:\\PDF\\" + maHD + ".pdf"));
            document.open();

            // Tiêu đề hóa đơn
            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
            Paragraph title = new Paragraph("Thong tin hoa don - " + maHD, titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(16f);

            // Thông tin hóa đơn
            Font contentFont = new Font(Font.FontFamily.TIMES_ROMAN, 16);
            Paragraph content = new Paragraph();
            content.setFont(contentFont);
            content.setLeading(24f); // Đặt khoảng cách giữa các dòng
            content.add("Ma HD: " + TblHoaDon.getValueAt(selectedRowIndex, 1).toString() + "\n");
            content.add("Ten Khach Hang: " + TblHoaDon.getValueAt(selectedRowIndex, 2).toString() + "\n");
            content.add("Ngay tao: " + TblHoaDon.getValueAt(selectedRowIndex, 7).toString() + "\n");
            content.add("Dia chi: " + TblHoaDon.getValueAt(selectedRowIndex, 4).toString() + "\n");
            content.add("So dien thoai: " + TblHoaDon.getValueAt(selectedRowIndex, 5).toString() + "\n");
            content.add("Tong tien: " + TblHoaDon.getValueAt(selectedRowIndex, 6).toString() + "VND" + "\n");
            content.add("Hinh thuc thanh toan: " + TblHoaDon.getValueAt(selectedRowIndex, 3).toString() + "\n");
            content.add("\n");
            content.add("\n");
            content.add("\n");
            content.add("\n");
            content.add("\n");
            content.add("\n");
            content.add("\n");
            content.add("\n");
            content.add("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

            document.add(title);
            document.add(content);

            // Thêm mã QR dưới cùng và ở giữa
            String qrFilePath = "C:\\QRCode\\" + maHD + ".png";
            Image qrImage = Image.getInstance(qrFilePath);
            qrImage.setAlignment(Element.ALIGN_CENTER);
            qrImage.scaleToFit(300, 300); // Giảm kích thước ảnh QR
            qrImage.setAbsolutePosition((PageSize.A4.getWidth() - qrImage.getScaledWidth()) / 2, 50); // Đặt vị trí ảnh QR ở giữa và dưới cùng
            document.add(qrImage);

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getQRCode() {
        String qrCode = "";
        return qrCode;
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
        panel1 = new b1.View.chucnang.Panel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAddHD = new b1.View.chucnang.ButtonGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblHoaDon = new javax.swing.JTable();
        btnSearchGia = new b1.View.chucnang.ButtonGradient();
        ExportExcel = new b1.View.chucnang.ButtonGradient();
        txtSearch = new b1.View.chucnang.TextField();
        jLabel2 = new javax.swing.JLabel();
        txtMax = new b1.View.chucnang.TextField();
        jLabel3 = new javax.swing.JLabel();
        txtMin = new b1.View.chucnang.TextField();
        btnPDF = new b1.View.chucnang.ButtonGradient();
        QuetQR = new b1.View.chucnang.ButtonGradient();
        cbbTrangthai = new b1.View.Combobox();
        cbbHTTT = new b1.View.Combobox();
        panel2 = new b1.View.chucnang.Panel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblLSHD = new javax.swing.JTable();
        panel3 = new b1.View.chucnang.Panel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblHDCT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAddHD.setBackground(new java.awt.Color(153, 255, 255));
        btnAddHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAddHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/plus.png"))); // NOI18N
        btnAddHD.setColor1(new java.awt.Color(204, 204, 255));
        btnAddHD.setColor2(new java.awt.Color(255, 255, 255));
        btnAddHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHDActionPerformed(evt);
            }
        });

        TblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MÃ HĐ", "TÊN KHÁCH HÀNG", "HÌNH THỨC THANH TOÁN", "ĐỊA CHỈ", "SĐT", "TỔNG TIỀN", "NGÀY TẠO", "TRẠNG THÁI"
            }
        ));
        TblHoaDon.setGridColor(new java.awt.Color(255, 255, 255));
        TblHoaDon.setRowHeight(40);
        TblHoaDon.setSelectionBackground(new java.awt.Color(153, 153, 255));
        TblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblHoaDon);

        btnSearchGia.setBackground(new java.awt.Color(153, 255, 255));
        btnSearchGia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSearchGia.setText("Tìm");
        btnSearchGia.setColor1(new java.awt.Color(204, 204, 255));
        btnSearchGia.setColor2(new java.awt.Color(204, 204, 255));
        btnSearchGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearchGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchGiaActionPerformed(evt);
            }
        });

        ExportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/excel.png"))); // NOI18N
        ExportExcel.setColor1(new java.awt.Color(255, 255, 255));
        ExportExcel.setColor2(new java.awt.Color(255, 255, 255));
        ExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportExcelActionPerformed(evt);
            }
        });

        txtSearch.setLabelText("Tìm kiếm hóa đơn");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Giá từ khoảng");

        txtMax.setLabelText("Nhập giá");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Đến");

        txtMin.setLabelText("Nhập giá");

        btnPDF.setBackground(new java.awt.Color(153, 255, 255));
        btnPDF.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/icons8-bill-26.png"))); // NOI18N
        btnPDF.setText("In ra HĐ");
        btnPDF.setColor1(new java.awt.Color(204, 204, 255));
        btnPDF.setColor2(new java.awt.Color(204, 204, 255));
        btnPDF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        QuetQR.setBackground(new java.awt.Color(153, 255, 255));
        QuetQR.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        QuetQR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/qr-code.png"))); // NOI18N
        QuetQR.setText("QUÉT QR");
        QuetQR.setColor1(new java.awt.Color(102, 255, 102));
        QuetQR.setColor2(new java.awt.Color(102, 255, 102));
        QuetQR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        QuetQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuetQRActionPerformed(evt);
            }
        });

        cbbTrangthai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Đã thanh toán", "Chưa thanh toán" }));
        cbbTrangthai.setLabeText("Trạng thái");

        cbbHTTT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Chuyển khoản", "Tiền mặt" }));
        cbbHTTT.setLabeText("Hình thức thanh toán");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(QuetQR, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addGap(47, 47, 47)
                                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtMax, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchGia, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(ExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddHD, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ExportExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearchGia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(QuetQR, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        TblLSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Mã Nhân Viên", "Ngày tạo", "Hành động", "Mã LSHD"
            }
        ));
        TblLSHD.setGridColor(new java.awt.Color(255, 255, 255));
        TblLSHD.setRowHeight(30);
        TblLSHD.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jScrollPane2.setViewportView(TblLSHD);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel2.addTab("Lịch Sử Hóa Đơn", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        TblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "MÃ HÓA ĐƠN", "MÃ CHI TIẾT SẢN PHẨM", "ĐƠN GIÁ", "THÀNH TIỀN"
            }
        ));
        TblHDCT.setGridColor(new java.awt.Color(255, 255, 255));
        TblHDCT.setRowHeight(30);
        TblHDCT.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jScrollPane3.setViewportView(TblHDCT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel3.addTab("Hóa Đơn Chi Tiết", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel1.addTab("Hóa Đơn", jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("HÓA ĐƠN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(638, 638, 638)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHDActionPerformed
        // TODO add your handling code here:
        banhhang frame = new banhhang();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAddHDActionPerformed

    private void TblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblHoaDonMouseClicked
        // TODO add your handling code here:
        Show();
    }//GEN-LAST:event_TblHoaDonMouseClicked

    private void ExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportExcelActionPerformed

        boolean excel = hdsr.exportToExcel("C:\\ExcelJTable\\ExportJTableToExcel.xlsx");
        if (excel) {
            JOptionPane.showMessageDialog(this, "Xuat cac hoa don thanh cong !");
        } else {
            JOptionPane.showMessageDialog(this, "Xuat cac hoa don khong thanh cong !");
        }
    }//GEN-LAST:event_ExportExcelActionPerformed

    private void btnSearchGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchGiaActionPerformed
        // TODO add your handling code here:
        try {
            int minPrice = Integer.parseInt(txtMin.getText().trim());
            int maxPrice = Integer.parseInt(txtMax.getText().trim());

            // Ensure minPrice is less than or equal to maxPrice
            if (minPrice > maxPrice) {
                JOptionPane.showMessageDialog(this, "Giá tối thiểu phải nhỏ hơn hoặc bằng giá tối đa.");
                return;
            }

            showDataHD(hdsr.searchGia(minPrice, maxPrice));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị số nguyên hợp lệ.");
        }
    }//GEN-LAST:event_btnSearchGiaActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = TblHoaDon.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn để tạo mã QR!");
            return;
        }

        String maHD = TblHoaDon.getValueAt(selectedRowIndex, 1).toString(); // Lấy mã hóa đơn từ bảng
        try {
            ByteArrayOutputStream out = QRCode.from(maHD)
                    .to(ImageType.PNG).stream();

            String fileName = "C:\\QRCode\\" + maHD + ".png"; // Tên file ảnh QRCode

            // Ghi ảnh QR vào file
            FileOutputStream fout = new FileOutputStream(new File(fileName));
            fout.write(out.toByteArray());
            fout.flush();
            createPDF(maHD);
        } catch (BadElementException ex) {
            Logger.getLogger(hoadon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(hoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Xuất hóa đơn thành công");

    }//GEN-LAST:event_btnPDFActionPerformed

    private void QuetQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuetQRActionPerformed
        // TODO add your handling code here:
        quetmaqr qr = new quetmaqr();
        qr.setVisible(true);

        String qrCode = qr.getName();
        if (qrCode != null && !qrCode.isEmpty()) {
            List<HoaDon> listHD = hdsr.searchQR(qrCode);

            showDataHD(listHD);
        }

    }//GEN-LAST:event_QuetQRActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private b1.View.chucnang.ButtonGradient ExportExcel;
    private b1.View.chucnang.ButtonGradient QuetQR;
    private javax.swing.JTable TblHDCT;
    private javax.swing.JTable TblHoaDon;
    private javax.swing.JTable TblLSHD;
    private b1.View.chucnang.ButtonGradient btnAddHD;
    private b1.View.chucnang.ButtonGradient btnPDF;
    private b1.View.chucnang.ButtonGradient btnSearchGia;
    private javax.swing.ButtonGroup buttonGroup1;
    private b1.View.Combobox cbbHTTT;
    private b1.View.Combobox cbbTrangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private b1.View.chucnang.Panel panel1;
    private b1.View.chucnang.Panel panel2;
    private b1.View.chucnang.Panel panel3;
    private b1.View.chucnang.TextField txtMax;
    private b1.View.chucnang.TextField txtMin;
    private b1.View.chucnang.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
