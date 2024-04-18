/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GioHangViewModel;

/**
 *
 * @author Huanh
 */
public class GioHangViewMD {
    private String mctsp;
    private String maHD;
    private String maHDCT;
    private String idhangsx;
    private String iddongsp;
    private String idphoimau;
    private String idsize;
    private String iddoday;
    private String idchatlieu;
    private String idmatde;
    private String idday;
    private int giaban;
    private int soluong;

    public GioHangViewMD() {
    }

    public GioHangViewMD(String mctsp, String maHD, String maHDCT, String idhangsx, String iddongsp, String idphoimau, String idsize, String idchatlieu, String idday, int giaban, int soluong) {
        this.mctsp = mctsp;
        this.maHD = maHD;
        this.maHDCT = maHDCT;
        this.idhangsx = idhangsx;
        this.iddongsp = iddongsp;
        this.idphoimau = idphoimau;
        this.idsize = idsize;
        this.idchatlieu = idchatlieu;
        this.idday = idday;
        this.giaban = giaban;
        this.soluong = soluong;
    }

    public String getMctsp() {
        return mctsp;
    }

    public void setMctsp(String mctsp) {
        this.mctsp = mctsp;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getIdhangsx() {
        return idhangsx;
    }

    public void setIdhangsx(String idhangsx) {
        this.idhangsx = idhangsx;
    }

    public String getIddongsp() {
        return iddongsp;
    }

    public void setIddongsp(String iddongsp) {
        this.iddongsp = iddongsp;
    }

    public String getIdphoimau() {
        return idphoimau;
    }

    public void setIdphoimau(String idphoimau) {
        this.idphoimau = idphoimau;
    }

    public String getIdsize() {
        return idsize;
    }

    public void setIdsize(String idsize) {
        this.idsize = idsize;
    }

    public String getIddoday() {
        return iddoday;
    }

    public void setIddoday(String iddoday) {
        this.iddoday = iddoday;
    }

    public String getIdchatlieu() {
        return idchatlieu;
    }

    public void setIdchatlieu(String idchatlieu) {
        this.idchatlieu = idchatlieu;
    }

    public String getIdmatde() {
        return idmatde;
    }

    public void setIdmatde(String idmatde) {
        this.idmatde = idmatde;
    }

    public String getIdday() {
        return idday;
    }

    public void setIdday(String idday) {
        this.idday = idday;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "GioHangViewMD{" + "mctsp=" + mctsp + ", maHD=" + maHD + ", maHDCT=" + maHDCT + ", idhangsx=" + idhangsx + ", iddongsp=" + iddongsp + ", idphoimau=" + idphoimau + ", idsize=" + idsize + ", iddoday=" + iddoday + ", idchatlieu=" + idchatlieu + ", idmatde=" + idmatde + ", idday=" + idday + ", giaban=" + giaban + ", soluong=" + soluong + '}';
    }
    
    
}
