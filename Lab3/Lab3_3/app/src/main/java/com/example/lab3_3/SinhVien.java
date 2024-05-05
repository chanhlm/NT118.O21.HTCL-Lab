package com.example.lab3_3;

public class SinhVien {
    int id;
    String nameSV;

    String lopSV;
    float diemTB;

    public SinhVien() {
    }

    public SinhVien(int id, String nameSV, String lopSV, float diemTB) {
        this.id = id;
        this.nameSV = nameSV;
        this.lopSV = lopSV;
        this.diemTB = diemTB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLopSV() {
        return lopSV;
    }

    public void setLopSV(String lopSV) {
        this.lopSV = lopSV;
    }

    public String getNameSV() {
        return nameSV;
    }

    public void setNameSV(String nameSV) {
        this.nameSV = nameSV;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", nameSV='" + nameSV + '\'' +
                ", lopSV='" + lopSV + '\'' +
                ", diemTB=" + diemTB +
                '}';
    }

    public String getSV() {
        return id + " - " + nameSV + " - " + lopSV + " - " + diemTB;
    }
}
