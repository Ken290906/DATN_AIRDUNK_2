/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b1.services;

import b1.entity.Chatlieusp;
import b1.entity.Daysp;
import b1.entity.Dodaysp;
import b1.entity.Matdesanpham;
import b1.entity.MauSanPham;
import b1.entity.ThuocTinh;
import b1.entity.hangsanxuat;
import b1.repository.thuoctinhrepo;
import java.util.List;

/**
 *
 * @author DELL
 */
public class thuoctinhservices {

    private thuoctinhrepo ttr = new thuoctinhrepo();

    public List<ThuocTinh> getall() {
        return ttr.getall();
    }

    public boolean add(ThuocTinh tt) {
        return ttr.Add(tt);
    }

    public boolean update(ThuocTinh tt, String update) {
        return ttr.Update(tt, update);
    }

    public boolean xoa(String xoa) {
        return ttr.Xoa(xoa);
    }

    public List<hangsanxuat> gethsx() {
        return ttr.gethsx();
    }

    public List<MauSanPham> getmau() {
        return ttr.getmausp();
    }

    public List<Dodaysp> getdoday() {
        return ttr.getdoday();
    }

    public List<Daysp> getday() {
        return ttr.getday();
    }

    public List<Chatlieusp> getchatlieu() {
        return ttr.getchatlieu();
    }

    public List<Matdesanpham> getmatde() {
        return ttr.getmatde();
    }
    public boolean add(hangsanxuat hsx){
        return ttr.Addhsx(hsx);
    }
    public boolean addcl(Chatlieusp cl){
        return ttr.Addchatlieu(cl);
    }
    public boolean addmatde(Matdesanpham md){
        return ttr.addmd(md);
    }
    public boolean addmau(MauSanPham m){
        return ttr.addmau(m);
    }
    public boolean addday(Daysp day){
        return ttr.addday(day);
    }
    public boolean adddoday(Dodaysp dd){
        return ttr.addoday(dd);
    }
    public boolean xoahsx(String xoa){
        return ttr.Xoahsx(xoa);
    }
    public boolean xoachatlieu(String xoa){
        return ttr.Xoachatlieu(xoa);
    }
    public boolean xoamatde(String xoa){
        return ttr.Xoamatde(xoa);
    }
    public boolean xoadoday(String xoa){
        return ttr.Xoadoday(xoa);
    }
    public boolean xoamau(String xoa){
        return ttr.Xoamau(xoa);
    }
    public boolean xoaday(String xoa){
        return ttr.Xoaday(xoa);
    }
    public boolean updatehsx(String sua,hangsanxuat hsx){
        return ttr.Updatehsx(sua, hsx);
    }
    public boolean updatehsx(String sua,Daysp hsx){
        return ttr.Updatedday(sua, hsx);
    }
    public boolean updatephoimau(String sua,MauSanPham hsx){
        return ttr.Updatemau(sua, hsx);
    }
    public boolean updatechatlieu(String sua,Chatlieusp hsx){
        return ttr.Updatechatlieu(sua, hsx);
    }
    public boolean updatedoday(String sua,Dodaysp hsx){
        return ttr.Updatedoday(sua, hsx);
    }
    public boolean updatematde(String sua,Matdesanpham hsx){
        return ttr.Updatemd(sua, hsx);
    }
}
