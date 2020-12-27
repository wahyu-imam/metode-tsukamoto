/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import java.util.ArrayList;
import master.kriteria;
import java.util.Arrays;
/**
 *
 * @author imam
 */
public class fungsi_keanggotaan {
    kriteria kriteria;
    public fungsi_keanggotaan(){
        kriteria = new kriteria();
    }
    
    private String[][] get(String nama_kriteria){
        ArrayList<kriteria> tampung = new ArrayList<>();
        String[][] data_kriteria = kriteria.get_all();
        for (String[] dk : data_kriteria) {
            if (nama_kriteria.equals(dk[1])) {
                tampung.add(new kriteria(dk[2], dk[3], dk[4]));
            }
        }
        String[][] data = null;
        if(!tampung.isEmpty()){
            data = new String[tampung.size()][3];
            int no = 0;
            for (kriteria h : tampung) {
                data[no][0] = h.getRentang();
                data[no][1] = h.getMin();
                data[no][2] = h.getMax();
                no++;
            }
        }
        return data;
    }
    
    public double miuHargaMurah(double harga){
        String[][] hrg = get("Harga");
        double b1 = 0, b2 = 0;
        for (String[] h : hrg) {
            if ("Murah".equals(h[0])) {
                b1 = Double.parseDouble(h[1]);
                b2 = Double.parseDouble(h[2]);
            }
        }
        if (harga <= b1) {
            return 1;
        }else if(harga > b1 && harga < b2){
            return (b2 - harga) / (b2 - b1);
        }else{
            return 0;
        }
    }
    
    public double miuHargaSedang(double harga){
        String[][] hrg = get("Harga");
        double b1 = 0, b2 = 0, b3 = 0;
        for (String[] h : hrg) {
            if("Murah".equals(h[0])){
                b1 = Double.parseDouble(h[2]);
            }else if("Sedang".equals(h[0])){
                b2 = Double.parseDouble(h[1]);
                b3 = Double.parseDouble(h[2]);
            }
        }
        if (harga <= b2 || harga >= b3) {
            return 0;
        }else if(harga > b2 && harga < b1){
            return (harga - b2) / (b1 - b2);
        }else{
            return (b3 - harga) / (b3 - b1);
        }
    }
    
    public double miuHargaMahal(double harga){
        String[][] hrg = get("Harga");
        double b1 = 0, b2 = 0;
        for (String[] h : hrg) {
            if("Mahal".equals(h[0])){
                b1 = Double.parseDouble(h[1]);
                b2 = Double.parseDouble(h[2]);
            }
        }
        if(harga <= b1){
            return 0;
        }else if(harga > b1 && harga < b2){
            return (harga - b1) / (b2 - b1);
        }else{
            return 1;
        }
    }
    
    public double miuKelasSedikit(double kelas){
        String[][] kls = get("Jumlah Kelas");
        double b1 = 0, b2 = 0;
        for (String[] k : kls) {
            if("Sedikit".equals(k[0])){
                b1 = Double.parseDouble(k[1]);
                b2 = Double.parseDouble(k[2]);
            }
        }
        if (kelas <= b1) {
            return 1;
        }else if(kelas > b1 && kelas < b2){
            return (b2 - kelas) / (b2 - b1);
        }else{
            return 0;
        }
    }
    
    public double miuKelasBanyak(double kelas){
        String[][] kls = get("Jumlah Kelas");
        double b1 = 0, b2 = 0;
        for (String[] k : kls) {
            if("Banyak".equals(k[0])){
                b1 = Double.parseDouble(k[1]);
                b2 = Double.parseDouble(k[2]);
            }
        }
        if (kelas <= b1) {
            return 0;
        }else if(kelas > b1 && kelas < b2){
            return (kelas - b1) / (b2 - b1);
        }else{
            return 1;
        }
    }
    
    public double miuFasilitasSedikit(double fasilitas){
        String[][] fls = get("Jumlah Fasilitas");
        double b1 = 0, b2 = 0;
        for (String[] f : fls) {
            if ("Sedikit".equals(f[0])) {
                b1 = Double.parseDouble(f[1]);
                b2 = Double.parseDouble(f[2]);
            }
        }
        if (fasilitas <= b1) {
            return 1;
        }else if(fasilitas > b1 && fasilitas < b2){
            return (b2 - fasilitas) / (b2 - b1);
        }else{
            return 0;
        }
    }
    
    public double miuFasilitasSedang(double fasilitas){
        String[][] fls = get("Jumlah Fasilitas");
        double b1 = 0, b2 = 0, b3 = 0;
        for (String[] f : fls) {
            if ("Sedikit".equals(f[0])) {
                b1 = Double.parseDouble(f[2]);
            }else if("Sedang".equals(f[0])){
                b2 = Double.parseDouble(f[1]);
                b3 = Double.parseDouble(f[2]);
            }
        }
        if (fasilitas <= b2 || fasilitas >= b3) {
            return 0;
        }else if(fasilitas > b2 && fasilitas < b1){
            return (fasilitas - b2) / (b1 - b2);
        }else{
            return (b3 - fasilitas) / (b3 - b1);
        }
    }
    
    public double miuFasilitasBanyak(double fasilitas){
        String[][] fls = get("Jumlah Fasilitas");
        double b1 = 0, b2 = 0;
        for (String[] f : fls) {
            if ("Banyak".equals(f[0])) {
                b1 = Double.parseDouble(f[1]);
                b2 = Double.parseDouble(f[2]);
            }
        }
        if(fasilitas <= b1){
            return 0;
        }else if(fasilitas > b1 && fasilitas < b2){
            return (fasilitas - b1) / (b2 - b1);
        }else{
            return 1;
        }
    }
    
    public double miuTransportasiSedikit(double transportasi){
        String[][] trans = get("Transportasi");
        double b1 = 0, b2 = 0;
        for (String[] t : trans) {
            if ("Sedikit".equals(t[0])) {
                b1 = Double.parseDouble(t[1]);
                b2 = Double.parseDouble(t[2]);
            }
        }
        if (transportasi <= b1) {
            return 1;
        }else if(transportasi > b1 && transportasi < b2){
            return (b2 - transportasi) / (b2 - b1);
        }else{
            return 0;
        }
    }
    
    public double miuTransportasiBanyak(double transportasi){
        String[][] trans = get("Transportasi");
        double b1 = 0, b2 = 0;
        for (String[] t : trans) {
            if ("Banyak".equals(t[0])) {
                b1 = Double.parseDouble(t[1]);
                b2 = Double.parseDouble(t[2]);
            }
        }
        if(transportasi <= b1){
            return 0;
        }else if(transportasi > b1 && transportasi < b2){
            return (transportasi - b1) / (b2 - b1);
        }else{
            return 1;
        }
    }
    
    public double bintangRendah(double pre){
        String[][] bintang = get("Bintang");
        double b1 = 0, b2 = 0;
        for (String[] b : bintang) {
            if ("Rendah".equals(b[0])) {
                b1 = Double.parseDouble(b[1]);
                b2 = Double.parseDouble(b[2]);
            }
        }
        return b2 - pre * (b2 - b1);
    }
    
    public double bintangTinggi(double pre){
        String[][] bintang = get("Bintang");
        double b1 = 0, b2 = 0;
        for (String[] b : bintang) {
            if ("Tinggi".equals(b[0])) {
                b1 = Double.parseDouble(b[1]);
                b2 = Double.parseDouble(b[2]);
            }
        }
        return pre * (b2 - b1) + b1;
    }
    
//    public static void main(String[] args) {
//        fungsi_keanggotaan f = new fungsi_keanggotaan();
//        
////        String[][] data_kriteria = f.get("Bintang");
////        for (int i = 0; i < data_kriteria.length; i++) {
////            for (int j = 0; j < data_kriteria[0].length; j++) {
////                System.out.print(data_kriteria[i][j]+"; ");
////            }
////            System.out.println("");
////        }
////        double transportasi = 7;
////        System.out.println(f.miuTransportasiSedikit(transportasi));
////        System.out.println(f.miuTransportasiBanyak(transportasi));
////          double harga = 200000;
////          System.out.println(f.miuHargaSedang(harga));
////          System.out.println(f.miuHargaMahal(harga));
////          System.out.println(f.miuHargaMurah(harga));
//        double fasilitas = 9;
//        System.out.println(f.miuFasilitasSedikit(fasilitas));
//        System.out.println(f.miuFasilitasSedang(fasilitas));
//        System.out.println(f.miuFasilitasBanyak(fasilitas));
//    }
}
