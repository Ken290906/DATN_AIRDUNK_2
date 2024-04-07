/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package b1.View;

import ViewModelHD.HoaDon;
import ViewModelSP.sanphamchitietviewmodel;
import b1.View.chucnang.khachhangbanhang;
import b1.View.chucnang.quetmaqr;
import b1.View.intefacee.interfacesp;
import b1.View.intefacee.iterface2;
import b1.entity.GiamGia1;
import b1.entity.HoaDonBH;
import b1.entity.PTTT;
import b1.entity.hangsanxuat;
import b1.services.GiamGiaService;

import b1.services.HoaDonBHService;
import b1.services.HoaDonService;
import b1.services.PTTTservuces;
import b1.services.chitietsanphamp2services;
import b1.services.hangsxservices;
import com.itextpdf.text.pdf.qrcode.ByteArray;
import com.itextpdf.text.pdf.qrcode.QRCode;
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
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import net.glxn.qrgen.image.ImageType;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

/**
 *
 * @author DELL
 */
public class banhhang extends javax.swing.JInternalFrame {
//Table

    private DefaultTableModel dtmHoaDon = new DefaultTableModel();
    private DefaultTableModel bangsanpham = new DefaultTableModel();
    private DefaultTableModel dtmGiohang = new DefaultTableModel();
//Combobox
    private DefaultComboBoxModel comboHang = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbGiamgia = new DefaultComboBoxModel();
    private DefaultComboBoxModel comboPTTT = new DefaultComboBoxModel();

//list
    private List<sanphamchitietviewmodel> listsp = new ArrayList<>();
    private List<hangsanxuat> listhang = new ArrayList<>();
    private List<HoaDonBH> listBH = new ArrayList<>();
    private List<GiamGia1> listVCH = new ArrayList<>();
    private List<PTTT> listPTTT = new ArrayList<>();

//ITF
    interfacesp itf = new iterface2() {
    };
    //Services
    private chitietsanphamp2services sps = new chitietsanphamp2services();
    private hangsxservices hsxs = new hangsxservices();
    private HoaDonBHService srhd = new HoaDonBHService();
    private GiamGiaService srvch = new GiamGiaService();
    private PTTTservuces pttts = new PTTTservuces();

    DecimalFormat VND = new DecimalFormat("#,##0 đ");

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form gd1
     */
    public banhhang() {
        int a = 0;
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        //Combobox PTTT
        comboPTTT = (DefaultComboBoxModel) cbbPTTT.getModel();
        listPTTT = pttts.getall();
        showcombobxPTTT(listPTTT);

        //bang hoa don
        dtmHoaDon = (DefaultTableModel) tblhoadon.getModel();
        listBH = srhd.getAll();
        showHoaDonBH(listBH);
        //bangsanpham
        bangsanpham = (DefaultTableModel) tbldanhsachsanpham.getModel();
        listsp = sps.getall();
        showdata(listsp);
        //
        dtmGiohang = (DefaultTableModel) tblgiohang.getModel();
        listsp = sps.getall();
        tbldanhsachsanpham.setDefaultEditor(Object.class, null);
        //comboGiamgia
        cbbGiamgia = (DefaultComboBoxModel) cbbgiamrgia.getModel();
        listVCH = srvch.cbbBH();
        showCbbVCH(listVCH);
        //combohang
        comboHang = (DefaultComboBoxModel) cbbhang.getModel();
        listhang = hsxs.getall();
        Combobox(listhang);
        txtSearchHD.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                srhd.searchHDBH(txtSearchHD.getText() + "");
                listBH = srhd.searchHDBH(txtSearchHD.getText());
                showHoaDonBH(listBH);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                srhd.searchHDBH(txtSearchHD.getText() + "");
                listBH = srhd.searchHDBH(txtSearchHD.getText());
                showHoaDonBH(listBH);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                srhd.searchHDBH(txtSearchHD.getText() + "");
                listBH = srhd.searchHDBH(txtSearchHD.getText());
                showHoaDonBH(listBH);
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
        //searchhang
        cbbhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timkiem = cbbhang.getSelectedItem().toString();
                if (!timkiem.isEmpty()) {
                    List<sanphamchitietviewmodel> searchedList = searchHang(timkiem);
                    showdata(searchedList);
                } else {
                    // If no manufacturer is selected, reload all products                 
                    sanphamshow();

                }
            }

        });
        getkh(txtTenKH.getText(), txtMaKH.getText());

        cbbgiamrgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chonphieugiamgia = (String) cbbgiamrgia.getSelectedItem();

                double tongTien = Double.parseDouble(txttongtien.getText().replaceAll("[^0-9]", ""));

                int TienTong = Integer.parseInt(txttong.getText().replaceAll("[^0-9]", ""));
                double giamGia = 0;

                if (TienTong <= 40000000 && chonphieugiamgia.equals("NGHÈO")) {
                    JOptionPane.showMessageDialog(null, "Khi chọn sản phẩm giá trên 40000000 mới được PGG này ");
                    return;
                }
                if (TienTong > 40000000 && chonphieugiamgia.equals("NGHÈO")) {
                    giamGia = tongTien * 0.2;
                    dudkphieugiamgia();
                }
                if (TienTong <= 70000000 && chonphieugiamgia.equals("THƯỜNG")) {
                    JOptionPane.showMessageDialog(null, "Khi chọn sản phẩm giá trên 70000000 mới được PGG này ");
                    return;
                }
                if (TienTong > 70000000 && chonphieugiamgia.equals("THƯỜNG")) {
                    giamGia = tongTien * 0.5;
                    dudkphieugiamgia();
                }
                if (TienTong <= 90000000 && chonphieugiamgia.equals("VIP")) {
                    JOptionPane.showMessageDialog(null, "Khi chọn sản phẩm giá trên 90000000 mới được PGG này ");
                    return;
                }
                if (TienTong > 90000000 && chonphieugiamgia.equals("VIP")) {
                    giamGia = tongTien * 1.0;
                    dudkphieugiamgia();
                }

//                else if (TienTong >= 60000000 && TienTong < 90000000 && chonphieugiamgia.equals("THƯỜNG")) {
//                    giamGia = tongTien * 0.3;
//                    dudkphieugiamgia();
//                } else if (TienTong >= 90000000 && chonphieugiamgia.equals("VIP")) {
//                    giamGia = tongTien * 0.5;
//                    dudkphieugiamgia();
//                } else {
//                    dkphieugiamgia();
//                }
                int tongTienSauGiamGia = (int) (tongTien - giamGia);

                txttongtien.setText(VND.format(tongTienSauGiamGia));
                cbbPTTT.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            String selectedValue = (String) cbbPTTT.getSelectedItem();
                            if (selectedValue.equals("Tiền Mặt")) {
                                txtchuyenkhoan.setEditable(false);
                                txtchuyenkhoan.setText("");
                                txtkhachdua.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int khachDua = Integer.valueOf(txtkhachdua.getText());
                                        int tongTien = tongTienSauGiamGia;
                                        int thoiLai = tongTienSauGiamGia - khachDua;
                                        txttongtien.setText(VND.format(thoiLai));

                                    }
                                });
                            } else {
                                txtchuyenkhoan.setEditable(true);
                            }
                        }
                    }
                });
                cbbPTTT.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            String selectedValue = (String) cbbPTTT.getSelectedItem();
                            if (selectedValue.equals("Chuyển khoản")) {
                                txtkhachdua.setEditable(false);
                                txtkhachdua.setText("");
                                txtchuyenkhoan.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int khachDua = Integer.valueOf(txtchuyenkhoan.getText());
                                        int tongTien = tongTienSauGiamGia;
                                        int thoiLai = tongTienSauGiamGia - khachDua;
                                        txttongtien.setText(VND.format(thoiLai));

                                    }
                                });
                            } else {
                                txtkhachdua.setEditable(true);
                            }
                        }
                    }
                });
            }

        });
        tbldanhsachsanpham.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int selectedRow = tbldanhsachsanpham.getSelectedRow();
                    String maSP = tbldanhsachsanpham.getValueAt(selectedRow, 1).toString();
                    String tenSanPham = tbldanhsachsanpham.getValueAt(selectedRow, 2).toString();
                    String hang = tbldanhsachsanpham.getValueAt(selectedRow, 3).toString();
                    String mau = tbldanhsachsanpham.getValueAt(selectedRow, 4).toString();
                    String size = tbldanhsachsanpham.getValueAt(selectedRow, 5).toString();
                    String chatlieu = tbldanhsachsanpham.getValueAt(selectedRow, 6).toString();
                    String day = tbldanhsachsanpham.getValueAt(selectedRow, 7).toString();
                    String giaBan = tbldanhsachsanpham.getValueAt(selectedRow, 9).toString();

                    int soLuong = nhapSoLuong();

                    for (sanphamchitietviewmodel object : listsp) {
                        if (object.getMctsp().equals(maSP)) {
                            object.setSoluong(object.getSoluong() - soLuong);
                        }
                    }

                    addToCart(maSP, tenSanPham, hang, mau, size, chatlieu, day, soLuong, giaBan);

                    // Hiển thị lại dữ liệu trong bảng giỏ hàng
                    showdata(listsp);
                    rowCount++;
                    String giaBanStr = giaBan.replaceAll("[^\\d]", ""); // Loại bỏ tất cả các ký tự không phải là số
                    int giaBanInt = Integer.parseInt(giaBanStr); // Chuyển đổi chuỗi thành số nguyên
                    int thanhTien = soLuong * giaBanInt; // Tính toán tổng tiền

                    txttongtien.setText(String.valueOf(VND.format(thanhTien))); // Cập nhật giá trị của txttongtien
                    txttong.setText(String.valueOf(VND.format(thanhTien))); // Cập nhật giá trị của txttongtien
                }

            }
        });

    }

    //ComboboxPTTT
    public void showcombobxPTTT(List<PTTT> list) {
        comboPTTT.removeAllElements();
        for (PTTT pttt : list) {
            comboPTTT.addElement(pttt.getKieuthanhtoan());
        }
    }

    public void dkphieugiamgia() {
        JOptionPane.showMessageDialog(this, "Số tiền không đủ để áp dụng phiếu giảm giá này");
        return;
    }

    public void dudkphieugiamgia() {
        JOptionPane.showMessageDialog(this, "Đã giảm giá thành công");
        return;
    }

    public void showHoaDonBH(List<HoaDonBH> listHDBH) {
        dtmHoaDon.setRowCount(0);
        int i = 0;
        String trangthai = "";

        for (HoaDonBH hoaDonBH : listHDBH) {
            i++;
            if (hoaDonBH.isTrangthai() == false) {
                trangthai = "Chờ thanh toán";
            } else {
                trangthai = "Đã thanh toán";
            }
            dtmHoaDon.addRow(new Object[]{
                i,
                hoaDonBH.getMaHD(),
                hoaDonBH.getNgaytao(),
                hoaDonBH.getMaNV(),
                hoaDonBH.getSoluong(),
                trangthai
            });
        }

    }

    private void tuhienhoadon() {
        showHoaDonBH(listBH);
    }

    public void getkh(String ten, String makh) {
        txtTenKH.setText(ten);
        txtMaKH.setText(makh);
    }

    public void showCbbVCH(List<GiamGia1> ListGG) {
        cbbGiamgia.removeAllElements();

        for (GiamGia1 gg : ListGG) {
            cbbGiamgia.addElement(gg.getMaGiamGia());
        }
    }

    private int rowSTT = 0;

    public HoaDonBH getFormData() {
        rowSTT++;
        String maHD = "HD-000" + rowSTT; // Tạo mã hóa đơn duy nhất
        String maNV = "NV-001";
        Date ngayTao = new Date();
        int soluongSP = 0;
        boolean trangThai = false;

        HoaDonBH hd = new HoaDonBH(maHD, ngayTao, maNV, soluongSP, trangThai);
        txtMaHD.setText(maHD);
        txtNgayTT.setText(dateFormat.format(ngayTao));

        return hd;

    }

    public void sanphamshow() {
        listsp = sps.getall();
        showdata(listsp);
        JOptionPane.showMessageDialog(this, "Không có sản phẩm nào được tìm thấy giống ?");
    }

    private void SearchBanhang() {
        listsp = sps.Searchbanhang(txtsearch.getText());
        showdata(listsp);
    }

    //showdata
    public void showdata(List<sanphamchitietviewmodel> sanpham) {
        bangsanpham.setRowCount(0);
        int i = 0;
        Locale lc = new Locale("vi", "VN");
        NumberFormat currentFormater = NumberFormat.getCurrencyInstance(lc);
        for (sanphamchitietviewmodel sp : sanpham) {
            i++;
            bangsanpham.addRow(new Object[]{i, sp.getMctsp(), sp.getIddongsp(), sp.getIdhangsx(), sp.getIdphoimau(), sp.getIdsize(), sp.getIdchatlieu(), sp.getIdday(), sp.getSoluong(), currentFormater.format(sp.getGiaban())});
        }
    }

    private int rowCount = 0;

    private void addToCart(String maSP, String tenSanPham, String hang, String mau, String size, String chatlieu, String day, int soLuong, String giaBan) {
        boolean productExists = false;
        Locale lc = new Locale("vi", "VN");
        NumberFormat currentFormater = NumberFormat.getCurrencyInstance(lc);
        for (int i = 0; i < dtmGiohang.getRowCount(); i++) {
            if (dtmGiohang.getValueAt(i, 1).equals(maSP)) {
                // Sản phẩm đã tồn tại trong giỏ hàng, cập nhật số lượng của nó
                int oldQuantity = (int) dtmGiohang.getValueAt(i, 8);
                int newQuantity = oldQuantity + soLuong;
                dtmGiohang.setValueAt(newQuantity, i, 8); // Cập nhật số lượng

                // Tính lại thành tiền của sản phẩm
                int giaBanValue = parseCurrencyString(giaBan); // Parse giaBan to integer
                int thanhTien = newQuantity * giaBanValue;
                dtmGiohang.setValueAt(currentFormater.format(giaBanValue), i, 9); // Cập nhật giá bán
                dtmGiohang.setValueAt(currentFormater.format(thanhTien), i, 10); // Cập nhật thành tiền
                
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            int giaBanValue = parseCurrencyString(giaBan); // Parse giaBan to integer
            int thanhTien = soLuong * giaBanValue;
            dtmGiohang.addRow(new Object[]{rowCount + 1, maSP, tenSanPham, hang, mau, size, chatlieu, day, soLuong, currentFormater.format(giaBanValue), currentFormater.format(thanhTien)});

            rowCount++;
          
        }
  
    }
// Method to parse currency string to integer
    private int parseCurrencyString(String currencyString) {
        // Remove non-numeric characters from the currency string
        String cleanCurrencyString = currencyString.replaceAll("[^\\d]", "");
        return Integer.parseInt(cleanCurrencyString);
    }

    //showcombboxGiải
    public void Combobox(List<hangsanxuat> hsx) {
        comboHang.removeAllElements();
        for (hangsanxuat object : hsx) {
            comboHang.addElement(object.getTenhang());
        }
    }

    //searchcombobox
    private List<sanphamchitietviewmodel> searchHang(String manufacturerName) {
        List<sanphamchitietviewmodel> filteredList = new ArrayList<>();

        for (sanphamchitietviewmodel product : listsp) {
            if (product.getIdhangsx().equalsIgnoreCase(manufacturerName)) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }

    private int nhapSoLuong() {
        String input = JOptionPane.showInputDialog("Nhập số lượng:");
        if (input != null && !input.isEmpty()) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên dương.");
            }
        }
        return 0; // Trả về 0 nếu không nhập hoặc nhập không hợp lệ
    }

    public HoaDonBH getformdatabanhang() throws ParseException {
        String MaHD = txtMaHD.getText();
        String TT = txttongtien.getText().replaceAll("[, đ]", ""); // Loại bỏ dấu phẩy và ký tự đ
        String MaNV = txtmaNV.getText();
        Date NT = dateFormat.parse(txtNgayTao.getText());
        String MaKH = txtTenKH.getText();
        Date NTT = dateFormat.parse(txtNgayTT.getText());

        // Chuyển đổi chuỗi TT thành một số nguyên
        int tongTien = Integer.valueOf(TT);

        HoaDonBH hd = new HoaDonBH(MaHD, MaKH, tongTien, NT, NTT, MaNV, 0, "HTTT-001");
        return hd;
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
        mahinhbanhang = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        panel4 = new b1.View.chucnang.Panel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTenKH = new b1.View.chucnang.TextField();
        txtMaKH = new b1.View.chucnang.TextField();
        buttonGradient9 = new b1.View.chucnang.ButtonGradient();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtMaHD = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtNgayTT = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txttongtien = new javax.swing.JTextField();
        btnReset = new b1.View.chucnang.ButtonGradient();
        btnUpdateHD = new b1.View.chucnang.ButtonGradient();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtmaNV = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtkhachdua = new javax.swing.JTextField();
        cbbPTTT = new b1.View.chucnang.Combobox();
        jLabel16 = new javax.swing.JLabel();
        txttong = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        cbbgiamrgia = new b1.View.chucnang.Combobox();
        jLabel14 = new javax.swing.JLabel();
        txtchuyenkhoan = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtTenKH1 = new b1.View.chucnang.TextField();
        txtMaKH1 = new b1.View.chucnang.TextField();
        buttonGradient12 = new b1.View.chucnang.ButtonGradient();
        jLabel17 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        txtMaHD1 = new javax.swing.JTextField();
        txtNgayTao1 = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        txtNgayTT1 = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        txttongtien1 = new javax.swing.JTextField();
        btnReset1 = new b1.View.chucnang.ButtonGradient();
        btnUpdateHD1 = new b1.View.chucnang.ButtonGradient();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtmaNV1 = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        cbbPTTT1 = new b1.View.chucnang.Combobox();
        jLabel25 = new javax.swing.JLabel();
        txttong1 = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        cbbgiamrgia1 = new b1.View.chucnang.Combobox();
        jLabel27 = new javax.swing.JLabel();
        txtchuyenkhoan1 = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        panel1 = new b1.View.chucnang.Panel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        buttonGradient4 = new b1.View.chucnang.ButtonGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        btnAddHoaDon = new b1.View.chucnang.ButtonGradient();
        buttonGradient7 = new b1.View.chucnang.ButtonGradient();
        txtSearchHD = new b1.View.chucnang.TextField();
        btnDeleteHD = new b1.View.chucnang.ButtonGradient();
        panel5 = new b1.View.chucnang.Panel();
        panel2 = new b1.View.chucnang.Panel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblgiohang = new javax.swing.JTable();
        buttonGradient10 = new b1.View.chucnang.ButtonGradient();
        txtSearchGH = new b1.View.chucnang.TextField();
        deleteGH = new b1.View.chucnang.ButtonGradient();
        panel3 = new b1.View.chucnang.Panel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldanhsachsanpham = new javax.swing.JTable();
        txtsearch = new b1.View.chucnang.TextField();
        cbbhang = new b1.View.Combobox();
        buttonGradient8 = new b1.View.chucnang.ButtonGradient();

        setBackground(new java.awt.Color(255, 255, 255));

        mahinhbanhang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 204, 204));
        jLabel10.setText("BÁN HÀNG");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Thông Tin Khách Hàng");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtTenKH.setDisabledTextColor(new java.awt.Color(0, 204, 204));
        txtTenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenKH.setLabelText("Tên khách hàng");

        txtMaKH.setDisabledTextColor(new java.awt.Color(0, 204, 204));
        txtMaKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaKH.setLabelText("SDT");

        buttonGradient9.setBackground(new java.awt.Color(153, 255, 255));
        buttonGradient9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonGradient9.setForeground(new java.awt.Color(0, 0, 0));
        buttonGradient9.setText("Chọn");
        buttonGradient9.setColor1(new java.awt.Color(204, 204, 255));
        buttonGradient9.setColor2(new java.awt.Color(255, 255, 255));
        buttonGradient9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGradient9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(buttonGradient9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonGradient9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Thông Tin Hóa Đơn");

        jLabel5.setText("Mã HĐ");

        jLabel6.setText("Ngày Tạo");

        jLabel7.setText("Ngày Thanh Toán");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Tổng Tiền:");

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));

        txtMaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaHD.setText("HD-001");
        txtMaHD.setBorder(null);

        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayTao.setText("03-04-2024");
        txtNgayTao.setBorder(null);

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));

        txtNgayTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayTT.setText("03-04-2024");
        txtNgayTT.setBorder(null);

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));

        txttongtien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txttongtien.setForeground(new java.awt.Color(255, 51, 51));
        txttongtien.setBorder(null);
        txttongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongtienActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(153, 255, 255));
        btnReset.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/delete.png"))); // NOI18N
        btnReset.setColor1(new java.awt.Color(255, 51, 51));
        btnReset.setColor2(new java.awt.Color(255, 0, 0));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUpdateHD.setBackground(new java.awt.Color(153, 255, 255));
        btnUpdateHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnUpdateHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/bill.png"))); // NOI18N
        btnUpdateHD.setColor1(new java.awt.Color(51, 255, 0));
        btnUpdateHD.setColor2(new java.awt.Color(51, 255, 0));
        btnUpdateHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateHDActionPerformed(evt);
            }
        });

        jLabel11.setText("Phiếu giảm giá");

        jLabel13.setText("Mã NV");

        txtmaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtmaNV.setText("NV-001");
        txtmaNV.setBorder(null);

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));

        jLabel15.setText("Tiền Khách Đưa");

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));

        txtkhachdua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtkhachdua.setBorder(null);
        txtkhachdua.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        cbbPTTT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbPTTT.setLabeText("PTTT");

        jLabel16.setText("Tổng ");

        txttong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txttong.setForeground(new java.awt.Color(255, 0, 51));
        txttong.setText("0 đ");
        txttong.setBorder(null);

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));

        jLabel12.setText("PTTT");

        cbbgiamrgia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbgiamrgia.setLabeText("Chọn phiếu giảm giá");

        jLabel14.setText("Chuyển Khoản");

        txtchuyenkhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtchuyenkhoan.setBorder(null);
        txtchuyenkhoan.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addGap(95, 95, 95)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaHD)
                                            .addComponent(jSeparator5)
                                            .addComponent(txtNgayTao)
                                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator6)
                                            .addComponent(txtNgayTT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jSeparator10)
                                                    .addComponent(txtkhachdua, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel13)
                                                        .addGap(109, 109, 109))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel14)
                                                        .addGap(67, 67, 67)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jSeparator11)
                                                        .addComponent(txtchuyenkhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jSeparator9)
                                                        .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbgiamrgia, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jSeparator7)
                                                .addComponent(txttong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(btnUpdateHD, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cbbPTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(152, 152, 152))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNgayTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(0, 0, 0)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cbbgiamrgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbPTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtkhachdua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateHD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtchuyenkhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        cbbPTTT.getAccessibleContext().setAccessibleName("");
        cbbPTTT.getAccessibleContext().setAccessibleDescription("");

        panel4.addTab("Đơn Hàng Offline", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Thông Tin Khách Hàng");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        txtTenKH1.setDisabledTextColor(new java.awt.Color(0, 204, 204));
        txtTenKH1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenKH1.setLabelText("Tên khách hàng");

        txtMaKH1.setDisabledTextColor(new java.awt.Color(0, 204, 204));
        txtMaKH1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaKH1.setLabelText("SDT");

        buttonGradient12.setBackground(new java.awt.Color(153, 255, 255));
        buttonGradient12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonGradient12.setForeground(new java.awt.Color(0, 0, 0));
        buttonGradient12.setText("Chọn");
        buttonGradient12.setColor1(new java.awt.Color(204, 204, 255));
        buttonGradient12.setColor2(new java.awt.Color(255, 255, 255));
        buttonGradient12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGradient12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenKH1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(txtMaKH1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(buttonGradient12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonGradient12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(txtTenKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Thông Tin Hóa Đơn");

        jLabel18.setText("Mã HĐ");

        jLabel19.setText("Ngày Tạo");

        jLabel20.setText("Ngày Thanh Toán");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setText("Tổng Tiền:");

        jSeparator12.setBackground(new java.awt.Color(0, 0, 0));

        txtMaHD1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaHD1.setText("HD-001");
        txtMaHD1.setBorder(null);

        txtNgayTao1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayTao1.setText("03-04-2024");
        txtNgayTao1.setBorder(null);

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));

        txtNgayTT1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayTT1.setText("03-04-2024");
        txtNgayTT1.setBorder(null);

        jSeparator14.setBackground(new java.awt.Color(0, 0, 0));

        txttongtien1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txttongtien1.setForeground(new java.awt.Color(255, 51, 51));
        txttongtien1.setBorder(null);
        txttongtien1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongtien1ActionPerformed(evt);
            }
        });

        btnReset1.setBackground(new java.awt.Color(153, 255, 255));
        btnReset1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/delete.png"))); // NOI18N
        btnReset1.setColor1(new java.awt.Color(255, 51, 51));
        btnReset1.setColor2(new java.awt.Color(255, 0, 0));
        btnReset1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        btnUpdateHD1.setBackground(new java.awt.Color(153, 255, 255));
        btnUpdateHD1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnUpdateHD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/bill.png"))); // NOI18N
        btnUpdateHD1.setColor1(new java.awt.Color(51, 255, 0));
        btnUpdateHD1.setColor2(new java.awt.Color(51, 255, 0));
        btnUpdateHD1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateHD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateHD1ActionPerformed(evt);
            }
        });

        jLabel22.setText("Phiếu giảm giá");

        jLabel23.setText("Mã NV");

        txtmaNV1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtmaNV1.setText("NV-001");
        txtmaNV1.setBorder(null);

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));

        cbbPTTT1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbPTTT1.setLabeText("PTTT");

        jLabel25.setText("Tổng ");

        txttong1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txttong1.setForeground(new java.awt.Color(255, 0, 51));
        txttong1.setText("0 đ");
        txttong1.setBorder(null);

        jSeparator17.setBackground(new java.awt.Color(0, 0, 0));

        jLabel26.setText("PTTT");

        cbbgiamrgia1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbgiamrgia1.setLabeText("Chọn phiếu giảm giá");

        jLabel27.setText("Chuyển Khoản");

        txtchuyenkhoan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtchuyenkhoan1.setBorder(null);
        txtchuyenkhoan1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jSeparator18.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator8)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel17)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttongtien1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel18))
                                        .addGap(95, 95, 95)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaHD1)
                                            .addComponent(jSeparator13)
                                            .addComponent(txtNgayTao1)
                                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator14)
                                            .addComponent(txtNgayTT1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(109, 109, 109))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel27)
                                                .addGap(67, 67, 67)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jSeparator18)
                                                .addComponent(txtchuyenkhoan1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jSeparator15)
                                                .addComponent(txtmaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel22))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jSeparator17)
                                                        .addComponent(txttong1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGap(41, 41, 41)
                                                        .addComponent(btnUpdateHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbbgiamrgia1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(108, 108, 108)
                                        .addComponent(cbbPTTT1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(152, 152, 152))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(0, 0, 0)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNgayTao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNgayTT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(0, 0, 0)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbbgiamrgia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbPTTT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtmaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtchuyenkhoan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttongtien1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panel4.addTab("Đơn Hàng Online", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        buttonGradient4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonGradient4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/qr-code.png"))); // NOI18N
        buttonGradient4.setColor1(new java.awt.Color(51, 255, 51));
        buttonGradient4.setColor2(new java.awt.Color(102, 255, 102));
        buttonGradient4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGradient4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient4ActionPerformed(evt);
            }
        });

        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Mã đơn hàng", "Ngày Tạo", "Mã NV", "Tổng SP", "Trạng Thái"
            }
        ));
        tblhoadon.setGridColor(new java.awt.Color(255, 255, 255));
        tblhoadon.setRowHeight(30);
        tblhoadon.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tblhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblhoadon);

        btnAddHoaDon.setBackground(new java.awt.Color(153, 255, 255));
        btnAddHoaDon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAddHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/icons8-bill-26.png"))); // NOI18N
        btnAddHoaDon.setColor1(new java.awt.Color(204, 204, 255));
        btnAddHoaDon.setColor2(new java.awt.Color(255, 255, 255));
        btnAddHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHoaDonActionPerformed(evt);
            }
        });

        buttonGradient7.setBackground(new java.awt.Color(153, 255, 255));
        buttonGradient7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonGradient7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/undo.png"))); // NOI18N
        buttonGradient7.setColor1(new java.awt.Color(204, 204, 255));
        buttonGradient7.setColor2(new java.awt.Color(255, 255, 255));
        buttonGradient7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGradient7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient7ActionPerformed(evt);
            }
        });

        txtSearchHD.setLabelText("Tìm kiếm");

        btnDeleteHD.setBackground(new java.awt.Color(153, 255, 255));
        btnDeleteHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDeleteHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/delete.png"))); // NOI18N
        btnDeleteHD.setColor1(new java.awt.Color(255, 51, 51));
        btnDeleteHD.setColor2(new java.awt.Color(255, 0, 0));
        btnDeleteHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonGradient4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeleteHD, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGradient7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonGradient4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnDeleteHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonGradient7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        panel1.addTab("Hóa Đơn", jPanel4);
        panel1.addTab("Hóa Đơn Onl", panel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tblgiohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Mã SPCT", "Tên", "Hãng", "Màu", "Size", "Chất Liệu", "Dây", "Số Lượng", "Giá", "Thành Tiền"
            }
        ));
        tblgiohang.setGridColor(new java.awt.Color(255, 255, 255));
        tblgiohang.setRowHeight(30);
        tblgiohang.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jScrollPane3.setViewportView(tblgiohang);

        buttonGradient10.setBackground(new java.awt.Color(153, 255, 255));
        buttonGradient10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonGradient10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/undo.png"))); // NOI18N
        buttonGradient10.setColor1(new java.awt.Color(204, 204, 255));
        buttonGradient10.setColor2(new java.awt.Color(255, 255, 255));
        buttonGradient10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGradient10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient10ActionPerformed(evt);
            }
        });

        txtSearchGH.setLabelText("Tìm kiếm");

        deleteGH.setBackground(new java.awt.Color(153, 255, 255));
        deleteGH.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteGH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/delete.png"))); // NOI18N
        deleteGH.setColor1(new java.awt.Color(255, 51, 51));
        deleteGH.setColor2(new java.awt.Color(255, 0, 0));
        deleteGH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(txtSearchGH, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteGH, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonGradient10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteGH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGradient10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtSearchGH, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        panel2.addTab("Giỏ Hàng", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tbldanhsachsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Mã SPCT", "Tên SP", "Hãng", "Màu", "Size", "Chất liệu", "Dây", "Số lượng", "Tổng tiền"
            }
        ));
        tbldanhsachsanpham.setGridColor(new java.awt.Color(255, 255, 255));
        tbldanhsachsanpham.setRowHeight(30);
        tbldanhsachsanpham.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jScrollPane2.setViewportView(tbldanhsachsanpham);

        txtsearch.setLabelText("Tìm kiếm");

        cbbhang.setLabeText("Hãng");

        buttonGradient8.setBackground(new java.awt.Color(153, 255, 255));
        buttonGradient8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonGradient8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b1/khoanh/undo.png"))); // NOI18N
        buttonGradient8.setColor1(new java.awt.Color(204, 204, 255));
        buttonGradient8.setColor2(new java.awt.Color(255, 255, 255));
        buttonGradient8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonGradient8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGradient8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbhang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(buttonGradient8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonGradient8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel3.addTab("Danh Sách Sản Phẩm", jPanel7);

        javax.swing.GroupLayout mahinhbanhangLayout = new javax.swing.GroupLayout(mahinhbanhang);
        mahinhbanhang.setLayout(mahinhbanhangLayout);
        mahinhbanhangLayout.setHorizontalGroup(
            mahinhbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahinhbanhangLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(mahinhbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mahinhbanhangLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(619, 619, 619))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mahinhbanhangLayout.createSequentialGroup()
                        .addGroup(mahinhbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))))
        );
        mahinhbanhangLayout.setVerticalGroup(
            mahinhbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahinhbanhangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mahinhbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mahinhbanhangLayout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mahinhbanhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mahinhbanhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGradient4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient4ActionPerformed
        // Make QR code
        quetmaqr qr = new quetmaqr();
        qr.setVisible(true);

        String qrCode = qr.getName();
        if (qrCode != null && !qrCode.isEmpty()) {
            List<sanphamchitietviewmodel> listSP = sps.searchQR(qrCode);

            showdata(listSP);
        }

    }//GEN-LAST:event_buttonGradient4ActionPerformed

    private void btnAddHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHoaDonActionPerformed
        // TODO add your handling code here:
        srhd.Add(getFormData());
        listBH = srhd.getAll();
        showHoaDonBH(listBH);

    }//GEN-LAST:event_btnAddHoaDonActionPerformed

    private void buttonGradient8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient8ActionPerformed
        // TODO add your handling code here:
        cbbhang.setSelectedIndex(0);
        showdata(listsp);
    }//GEN-LAST:event_buttonGradient8ActionPerformed


    private void buttonGradient10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient10ActionPerformed
        // TODO add your handling code here:

        for (int i = 0; i < dtmGiohang.getRowCount(); i++) {
            String maSP = dtmGiohang.getValueAt(i, 1).toString();
            int soLuong = Integer.parseInt(dtmGiohang.getValueAt(i, 8).toString());
            for (sanphamchitietviewmodel sp : listsp) {
                if (sp.getMctsp().equals(maSP)) {
                    sp.setSoluong(sp.getSoluong() + soLuong);
                    break;
                }
            }
        }

        showdata(listsp);

        dtmGiohang.setRowCount(0);
    }//GEN-LAST:event_buttonGradient10ActionPerformed

    private void btnUpdateHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateHDActionPerformed
        String MVC = (String) cbbgiamrgia.getSelectedItem();
        String MKH = txtTenKH.getText();

        try {
            srhd.UpdateBanhang(getformdatabanhang(), MVC, txtMaHD.getText(), MKH);
            listBH = srhd.getAll();
            showHoaDonBH(listBH);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (ParseException ex) {
            Logger.getLogger(banhhang.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lỗi xảy ra khi thêm dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateHDActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        int dk = JOptionPane.showConfirmDialog(this, "Bạn chắc muốn reseat?");
        if (dk == JOptionPane.YES_OPTION) {
            txtMaKH.setText("");
            txtTenKH.setText("");
            txtNgayTao.setText("");
            txtNgayTT.setText("");
            txtMaHD.setText("");
            txtkhachdua.setText("");
            txtmaNV.setText("");
            txttongtien.setText("");
            txttong.setText("");
        }
        if (dk == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn không");
            return;
        }
        if (dk == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã chọn Cancel");
            return;
        }

    }//GEN-LAST:event_btnResetActionPerformed

    private void txttongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongtienActionPerformed
        cbbhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timkiem = cbbhang.getSelectedItem().toString();
                if (!timkiem.isEmpty()) {
                    List<sanphamchitietviewmodel> searchedList = searchHang(timkiem);
                    showdata(searchedList);
                } else {
                    // If no manufacturer is selected, reload all products
                    sanphamshow();

                }
            }

        });        // TODO add your handling code here:
    }//GEN-LAST:event_txttongtienActionPerformed

    private void buttonGradient9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient9ActionPerformed
        // TODO add your handling code here:
        khachhangbanhang kh = new khachhangbanhang(this);
        kh.setVisible(true);
    }//GEN-LAST:event_buttonGradient9ActionPerformed

    private void deleteGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGHActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_deleteGHActionPerformed

    private void tblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMouseClicked
        // TODO add your handling code here:
        int index = tblhoadon.getSelectedRow();

        HoaDonBH hd = listBH.get(index);

        txtMaHD.setText(hd.getMaHD());
        txtNgayTao.setText(String.valueOf(hd.getNgaytao()));
    }//GEN-LAST:event_tblhoadonMouseClicked

    private void buttonGradient7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient7ActionPerformed
        // TODO add your handling code here:
        dtmGiohang.setRowCount(0);
    }//GEN-LAST:event_buttonGradient7ActionPerformed

    private void btnDeleteHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHDActionPerformed
        // TODO add your handling code here:
        int index = tblhoadon.getSelectedRow();
        HoaDonBH hd = listBH.get(index);
        srhd.Delete(hd.getMaHD());
        listBH = srhd.getAll();
        showHoaDonBH(listBH);
    }//GEN-LAST:event_btnDeleteHDActionPerformed

    private void buttonGradient12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonGradient12ActionPerformed

    private void txttongtien1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongtien1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongtien1ActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnUpdateHD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateHD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateHD1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private b1.View.chucnang.ButtonGradient btnAddHoaDon;
    private b1.View.chucnang.ButtonGradient btnDeleteHD;
    private b1.View.chucnang.ButtonGradient btnReset;
    private b1.View.chucnang.ButtonGradient btnReset1;
    private b1.View.chucnang.ButtonGradient btnUpdateHD;
    private b1.View.chucnang.ButtonGradient btnUpdateHD1;
    private b1.View.chucnang.ButtonGradient buttonGradient10;
    private b1.View.chucnang.ButtonGradient buttonGradient12;
    private b1.View.chucnang.ButtonGradient buttonGradient4;
    private b1.View.chucnang.ButtonGradient buttonGradient7;
    private b1.View.chucnang.ButtonGradient buttonGradient8;
    private b1.View.chucnang.ButtonGradient buttonGradient9;
    private javax.swing.ButtonGroup buttonGroup1;
    private b1.View.chucnang.Combobox cbbPTTT;
    private b1.View.chucnang.Combobox cbbPTTT1;
    private b1.View.chucnang.Combobox cbbgiamrgia;
    private b1.View.chucnang.Combobox cbbgiamrgia1;
    private b1.View.Combobox cbbhang;
    private b1.View.chucnang.ButtonGradient deleteGH;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel mahinhbanhang;
    private b1.View.chucnang.Panel panel1;
    private b1.View.chucnang.Panel panel2;
    private b1.View.chucnang.Panel panel3;
    private b1.View.chucnang.Panel panel4;
    private b1.View.chucnang.Panel panel5;
    private javax.swing.JTable tbldanhsachsanpham;
    private javax.swing.JTable tblgiohang;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHD1;
    private b1.View.chucnang.TextField txtMaKH;
    private b1.View.chucnang.TextField txtMaKH1;
    private javax.swing.JTextField txtNgayTT;
    private javax.swing.JTextField txtNgayTT1;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNgayTao1;
    private b1.View.chucnang.TextField txtSearchGH;
    private b1.View.chucnang.TextField txtSearchHD;
    private b1.View.chucnang.TextField txtTenKH;
    private b1.View.chucnang.TextField txtTenKH1;
    private javax.swing.JTextField txtchuyenkhoan;
    private javax.swing.JTextField txtchuyenkhoan1;
    private javax.swing.JTextField txtkhachdua;
    private javax.swing.JTextField txtmaNV;
    private javax.swing.JTextField txtmaNV1;
    private b1.View.chucnang.TextField txtsearch;
    private javax.swing.JTextField txttong;
    private javax.swing.JTextField txttong1;
    private javax.swing.JTextField txttongtien;
    private javax.swing.JTextField txttongtien1;
    // End of variables declaration//GEN-END:variables
}
