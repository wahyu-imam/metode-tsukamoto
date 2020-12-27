/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import database.database;
import java.awt.HeadlessException;
import java.sql.SQLException;
import uniqid.uniqid;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 *
 * @author imam
 */
public class kriteria {
    Connection con;
    Statement stm;
    ResultSet rs;
    PreparedStatement pst;
    database db = new database();
    uniqid uniqid = new uniqid();
    
    String rentang;
    String min;
    String max;
    
    public kriteria(){
        
    }
    
    public kriteria(String rentang, String min, String max){
        this.rentang = rentang;
        this.min = min;
        this.max = max;
    }
    
    public String[][] get_all(){
        ArrayList<m_kriteria> tampung = new ArrayList<>();
        String sql = "SELECT * FROM `variabel` ORDER BY nama_variabel ASC";
        try {
            con = db.getKoneksi();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                tampung.add(new m_kriteria(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5)));
            }
            con.close(); stm.close(); rs.close();
        } catch (SQLException e) {
            System.out.println("error : "+e);
        }
        String[][] data = null;
        if(!tampung.isEmpty()){
            data = new String[tampung.size()][5];
            int no = 0;
            for (m_kriteria k : tampung) {
                data[no][0] = k.getKode_variabel();
                data[no][1] = k.getNama_variabel();
                data[no][2] = k.getRentang();
                data[no][3] = k.getMin();
                data[no][4] = k.getMax();
                no++;
            }
        }
        return data;
    }
    
    public String[] getById(String kode_variabel){
        ArrayList<String> tampung = new ArrayList<>();
        String sql = "SELECT * FROM `variabel` WHERE kode_variabel="+kode_variabel;
        try {
            con = db.getKoneksi();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if(rs.next()){
                tampung.add(rs.getString(1)); tampung.add(rs.getString(2)); tampung.add(rs.getString(3));
                tampung.add(rs.getString(4)); tampung.add(rs.getString(5));
            }
            con.close(); stm.close(); rs.close();
        } catch (Exception e) {
            System.out.println("error : "+e);
        }
        String[] data = null;
        if(!tampung.isEmpty()){
            data = new String[tampung.size()];
            for (int i = 0; i < data.length; i++) {
                data[i] = tampung.get(i);
            }
        }
        return data;
    }
    
    public void save(String nama_variabel, String rentang, String min, String max){
        String sql = "INSERT INTO `variabel`(`kode_variabel`, `nama_variabel`, `rentang`, `min`, `max`) "
                + "VALUES (?,?,?,?,?)";
        try {
            con = db.getKoneksi();
            pst = con.prepareStatement(sql);
            pst.setString(1, uniqid.get());
            pst.setString(2, nama_variabel);
            pst.setString(3, rentang);
            pst.setString(4, min);
            pst.setString(5, max);
            pst.execute();
            con.close(); pst.close();
            JOptionPane.showMessageDialog(null, "Berhasil simpan data");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
    }
    
    public void edit(String nama_variabel, String rentang, String min, String max, String kode_variabel){
        String sql = "UPDATE `variabel` SET `nama_variabel`=?,`rentang`=?,`min`=?,`max`=? WHERE `kode_variabel`=?";
        try {
            con = db.getKoneksi();
            pst = con.prepareStatement(sql);
            pst.setString(1, nama_variabel);
            pst.setString(2, rentang);
            pst.setString(3, min);
            pst.setString(4, max);
            pst.setString(5, kode_variabel);
            pst.execute();
            con.close(); pst.close();
            JOptionPane.showMessageDialog(null, "Berhasil simpan data");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error : "+e);
        }
    }
    
    public void hapus(String kode_variabel){
        String sql = "DELETE FROM `variabel` WHERE kode_variabel=?";
        try {
            con = db.getKoneksi();
            pst = con.prepareStatement(sql);
            pst.setString(1, kode_variabel);
            pst.execute();
            con.close(); pst.close();
            JOptionPane.showMessageDialog(null, "Berhasil hapus data");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
    }

    public String getRentang() {
        return rentang;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }
    
    public static void main(String[] args) {
        kriteria k = new kriteria();
        
//        k.save("Harga", "Murah", "200000", "700000");
//        k.save("Harga", "Sedang", "500000", "1000000");
//        k.save("Harga", "Mahal", "700000", "1300000");
//        
//        k.save("Jumlah Kelas", "Sedikit", "2", "5");
//        k.save("Jumlah Kelas", "Banyak", "4", "6");
//        
//        k.save("Jumlah Fasilitas", "Sedikit", "2", "5");
//        k.save("Jumlah Fasilitas", "Sedang", "4", "6");
//        k.save("Jumlah Fasilitas", "Banyak", "6", "9");
//        
//        k.save("Transportasi", "Sedikit", "2", "5");
//        k.save("Transportasi", "Banyak", "3", "7");
//        
//        k.save("Bintang", "Sedikit", "1", "5");
//        k.save("Bintang", "Banyak", "3", "7");
        //k.edit("test 2", "test 2", "1", "2", "6332342022");
        //k.hapus("6332342022");
        String[][] data_kriteria = k.get_all();
        for (int i = 0; i < data_kriteria.length; i++) {
            for (int j = 0; j < data_kriteria[0].length; j++) {
                System.out.print(data_kriteria[i][j]+"; ");
            }
            System.out.println("");
        }
        System.out.println("\nJumlah Record : "+data_kriteria.length);
        //System.out.println(Arrays.toString(k.getById("6238591387")));
    }
}
