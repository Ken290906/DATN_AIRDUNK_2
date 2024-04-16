package print_model;

import java.io.InputStream;
import java.util.List;

public class ParametReportPayment {
    String maHD;
    String maNV;
    int tongTien;
    InputStream maqr;
    List<FieldReportPayment> fileds;

    public ParametReportPayment() {
    }

    public ParametReportPayment(String maHD, String maNV, int tongTien, InputStream maqr, List<FieldReportPayment> fileds) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.maqr = maqr;
        this.fileds = fileds;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public InputStream getMaqr() {
        return maqr;
    }

    public void setMaqr(InputStream maqr) {
        this.maqr = maqr;
    }

    public List<FieldReportPayment> getFileds() {
        return fileds;
    }

    public void setFileds(List<FieldReportPayment> fileds) {
        this.fileds = fileds;
    }
    
    
}
