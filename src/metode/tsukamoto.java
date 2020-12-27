/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import java.text.DecimalFormat;
import master.rule;
import java.util.ArrayList;
import master.hotel;
import master.kriteria;
/**
 *
 * @author imam
 */
public class tsukamoto {
    DecimalFormat df = new DecimalFormat("#.##");
    rule r;
    hotel h;
    fungsi_keanggotaan f;
    
    public tsukamoto(){
        r = new rule();
        h = new hotel();
        f = new fungsi_keanggotaan();
    }
    
    public double[][] predikat(double harga, double kelas, double fasilitas, double transportasi){
        ArrayList<m_predikat> tampung = new ArrayList<>();
        String[][] data_rule = r.get_all();
        double hrg, kls, fls, trans;
        String btg;
        
        for (String[] dr : data_rule) {
            switch (dr[1]) {
                case "Murah":
                    hrg = f.miuHargaMurah(harga);
                    break;
                case "Sedang":
                    hrg = f.miuHargaSedang(harga);
                    break;
                default:
                    hrg = f.miuHargaMahal(harga);
                    break;
            }
            
            switch (dr[2]) {
                case "Sedikit":
                    kls = f.miuKelasSedikit(kelas);
                    break;
                default:
                    kls = f.miuKelasBanyak(kelas);
                    break;
            }
            
            switch(dr[3]){
                case "Sedikit":
                    fls = f.miuFasilitasSedikit(fasilitas);
                    break;
                case "Sedang":
                    fls = f.miuFasilitasSedang(fasilitas);
                    break;
                default:
                    fls = f.miuFasilitasBanyak(fasilitas);
                    break;
            }
            
            switch(dr[4]){
                case "Sedikit":
                    trans = f.miuTransportasiSedikit(transportasi);
                    break;
                default:
                    trans = f.miuTransportasiBanyak(transportasi);
                    break;
            }
            
            switch(dr[5]){
                case "Rendah":
                    btg = "Rendah";
                    break;
                default:
                    btg = "Tinggi";
                    break;
            }
            
            tampung.add(new m_predikat(hrg, kls, fls, trans, btg));
        }
        double[][] data = null;
        if(!tampung.isEmpty()){
            data = new double[tampung.size()][7];
            int no = 0;
            for (m_predikat p : tampung) {
                data[no][0] = Double.parseDouble(data_rule[no][0]);
                data[no][1] = p.getHarga();
                data[no][2] = p.getKelas();
                data[no][3] = p.getFasilitas();
                data[no][4] = p.getTransportasi();
                data[no][5] = p.getBintang(); // z_ke[i] pada masing-masing rule
                data[no][6] = p.getPredikat(); // predikat_ke[i] pada masing-masing rule
                no++;
            }
        }
        return data;
    }
    
    public int z(double[][] predikat){
        double pembilang = 0;
        double penyebut = 0;
        for (int i = 0; i < predikat.length; i++) {
             pembilang += predikat[i][5] * predikat[i][6];
             penyebut += predikat[i][6];
        }
        return (int) Math.round(pembilang / penyebut);
    }
    
    public String[][] hitung_masal(){
        String[][] data_hotel = h.get_all();
        String[][] data = new String[data_hotel.length][3];
        for (int i = 0; i < data_hotel.length; i++) {
            System.out.println("Data ke-"+(i+1));
            double harga = Double.parseDouble(data_hotel[i][2]);
            double kelas = Double.parseDouble(data_hotel[i][3]);
            double fasilitas = Double.parseDouble(data_hotel[i][4]);
            double transportasi = Double.parseDouble(data_hotel[i][5]);
            double[][] data_predikat = predikat(harga, kelas, fasilitas, transportasi);
            for (int j = 0; j < data_predikat.length; j++) {
                for (int k = 0; k < data_predikat[0].length; k++) {
                    if(k == 0){
                        System.out.print("R["+(j+1)+"]; ");
                    }else{
                        System.out.print(df.format(data_predikat[j][k])+"; ");
                    }
                }
                System.out.println("");
            }
            int z = z(data_predikat);
            data[i][0] = data_hotel[i][0];
            data[i][1] = String.valueOf(z);
            data[i][2] = data_hotel[i][6];
            System.out.println("");
        }
        return data;
    }
    
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        tsukamoto ts = new tsukamoto();
        master.rule r = new rule();
        master.hotel h = new hotel();
        master.kriteria k = new kriteria();
        
//        String[][] data_rule = r.get_all();
//        for (int i = 0; i < data_rule.length; i++) {
//            for (int j = 0; j < data_rule[i].length; j++) {
//                if (j == 0) {
//                    System.out.print("R["+(i+1)+"]; ");
//                }else{
//                    System.out.print(data_rule[i][j]+"; ");
//                }
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        
//        String[][] data_kriteria = k.get_all();
//        for (int i = 0; i < data_kriteria.length; i++) {
//            for (int j = 0; j < data_kriteria[i].length; j++) {
//                System.out.print(data_kriteria[i][j]+"; ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
//        String[][] data_hotel = h.get_all();
//        for (int i = 0; i < data_hotel.length; i++) {
//            for (int j = 0; j < data_hotel[i].length; j++) {
//                System.out.print(data_hotel[i][j]+"; ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        //243749; 4; 9; 3; 4;
//        double harga = 243749;
//        double kelas = 4;
//        double fasilitas = 9;
//        double transportasi = 3;
//        
//        double[][] data_predikat = ts.predikat(harga, kelas, fasilitas, transportasi);
//        //int z = ts.z(data_predikat);
//        for (int i = 0; i < data_predikat.length; i++) {
//            for (int j = 0; j < data_predikat[0].length; j++) {
//                if(j == 0){
//                    System.out.print("R["+(i+1)+"]; ");
//                }else{
//                    System.out.print(df.format(data_predikat[i][j])+"; ");
//                }
//            }
//            System.out.println("");
//        }
//        double max = 0;
//        for (int i = 0; i < data_predikat.length; i++) {
//            if(max < data_predikat[i][6]){
//                max = data_predikat[i][6];
//            }
//        }
//        double min = max;
//        for (int i = 0; i < data_predikat.length; i++) {
//            if(min > data_predikat[i][6]){
//                min = data_predikat[i][6];
//            }
//        }
//        System.out.println("\n"+min+"; "+max);
        //System.out.println(z);
        String[][] data_hitungMasal = ts.hitung_masal();
        int sama = 0;
        for (String[] ht : data_hitungMasal) {
            if (ht[1].equals(ht[2])) {
                sama++;
            }
            System.out.println(ht[0]+"; "+ht[1]+"; "+ht[2]);
        }
        System.out.println("\n Data Sama : "+sama);
    }
}