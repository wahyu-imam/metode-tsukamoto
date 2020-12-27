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
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author imam
 */
public class rule {
    Connection con;
    Statement stm;
    ResultSet rs;
    PreparedStatement pst;
    database db = new database();
    uniqid uniqid = new uniqid();
    
    public String[][] get_all(){
        ArrayList<m_rule> tampung = new ArrayList<>();
        String sql = "SELECT * FROM `rule` ORDER BY harga ASC";
        try {
            con = db.getKoneksi();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                tampung.add(new m_rule(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6)));
            }
            con.close(); stm.close(); rs.close();
        } catch (SQLException e) {
            System.out.println("error : "+e);
        }
        String[][] data = null;
        if(!tampung.isEmpty()){
            data = new String[tampung.size()][6];
            int no = 0;
            for (m_rule mr : tampung) {
                data[no][0] = mr.getKode_rule();
                data[no][1] = mr.getHarga();
                data[no][2] = mr.getJml_kelas();
                data[no][3] = mr.getJml_fasilitas();
                data[no][4] = mr.getTransportasi();
                data[no][5] = mr.getBintang();
                no++;
            }
        }
        return data;
    }
    
    public String[] getById(String kode_rule){
        ArrayList<String> tampung = new ArrayList<>();
        String sql = "SELECT * FROM `rule` WHERE kode_rule="+kode_rule;
        try {
            con = db.getKoneksi();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if(rs.next()){
                tampung.add(rs.getString(1)); tampung.add(rs.getString(2)); tampung.add(rs.getString(3));
                tampung.add(rs.getString(4)); tampung.add(rs.getString(5)); tampung.add(rs.getString(6));
            }
            con.close(); stm.close(); rs.close();
        } catch (SQLException e) {
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
    
    public void save(String harga, String jml_kelas, String jml_fasilitas, String transportasi, String bintang){
        String sql = "INSERT INTO `rule`(`kode_rule`, `harga`, `jml_kelas`, `jml_valisitas`, `trasportasi`, `bintang`) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            con = db.getKoneksi();
            pst = con.prepareStatement(sql);
            pst.setString(1, uniqid.get());
            pst.setString(2, harga);
            pst.setString(3, jml_kelas);
            pst.setString(4, jml_fasilitas);
            pst.setString(5, transportasi);
            pst.setString(6, bintang);
            pst.execute();
            con.close(); pst.close();
            //JOptionPane.showMessageDialog(null, "Berhasil simpan data");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error : "+e);
        }
    }
    
    public void edit(String harga, String jml_kelas, String jml_fasilitas, String transportasi, 
            String bintang, String kode_rule){
        String sql = "UPDATE `rule` SET `harga`=?,`jml_kelas`=?,`jml_valisitas`=?,`trasportasi`=?,"
                + "`bintang`=? WHERE kode_rule=?";
        try {
            con = db.getKoneksi();
            pst = con.prepareStatement(sql);
            pst.setString(1, harga);
            pst.setString(2, jml_kelas);
            pst.setString(3, jml_fasilitas);
            pst.setString(4, transportasi);
            pst.setString(5, bintang);
            pst.setString(6, kode_rule);
            pst.execute();
            con.close(); pst.close();
            JOptionPane.showMessageDialog(null, "Berhasil simpan data");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error : "+e);
        }
    }
    
    public void hapus(String kode_rule){
        String sql = "DELETE FROM `rule` WHERE kode_rule=?";
        try {
            con = db.getKoneksi();
            pst = con.prepareStatement(sql);
            pst.setString(1, kode_rule);
            pst.execute();
            con.close(); pst.close();
            JOptionPane.showMessageDialog(null, "Berhasil hapus data");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error : "+e);
        }
    }
    
    public static void main(String[] args) {
        rule r = new rule();
        
//        r.save("Murah", "Sedikit", "Sedikit", "Sedikit", "Rendah");
//        r.save("Murah", "Sedikit", "Sedikit", "Banyak", "Rendah");
//        r.save("Murah", "Sedikit", "Sedang", "Sedikit", "Rendah");
//        r.save("Murah", "Sedikit", "Sedang", "Banyak", "Rendah");
//        r.save("Murah", "Sedikit", "Banyak", "Sedikit", "Rendah");
//        r.save("Murah", "Sedikit", "Banyak", "Banyak", "Rendah");
//        r.save("Murah", "Banyak", "Sedikit", "Sedikit", "Rendah");
//        r.save("Murah", "Banyak", "Sedikit", "Banyak", "Rendah");
//        r.save("Murah", "Banyak", "Sedang", "Sedikit", "Rendah");
//        r.save("Murah", "Banyak", "Sedang", "Banyak", "Rendah");
//        r.save("Murah", "Banyak", "Banyak", "Sedikit", "Rendah");
//        r.save("Murah", "Banyak", "Banyak", "Banyak", "Rendah");
//        r.save("Sedang", "Sedikit", "Sedikit", "Sedikit", "Rendah");
//        r.save("Sedang", "Sedikit", "Sedikit", "Banyak", "Rendah");
//        r.save("Sedang", "Sedikit", "Sedang", "Sedikit", "Rendah");
//        r.save("Sedang", "Sedikit", "Sedang", "Banyak", "Tinggi");
//        r.save("Sedang", "Sedikit", "Banyak", "Sedikit", "Rendah");
//        r.save("Sedang", "Sedikit", "Banyak", "Banyak", "Tinggi");
//        r.save("Sedang", "Banyak", "Sedikit", "Sedikit", "Tinggi");
//        r.save("Sedang", "Banyak", "Sedikit", "Banyak", "Tinggi");
//        r.save("Sedang", "Banyak", "Sedang", "Sedikit", "Tinggi");
//        r.save("Sedang", "Banyak", "Sedang", "Banyak", "Tinggi");
//        r.save("Sedang", "Banyak", "Banyak", "Sedikit", "Tinggi");
//        r.save("Sedang", "Banyak", "Banyak", "Banyak", "Tinggi");
//        r.save("Mahal", "Sedikit", "Sedikit", "Sedikit", "Rendah");
//        r.save("Mahal", "Sedikit", "Sedikit", "Banyak", "Rendah");
//        r.save("Mahal", "Sedikit", "Sedang", "Sedikit", "Rendah");
//        r.save("Mahal", "Sedikit", "Sedang", "Banyak", "Rendah");
//        r.save("Mahal", "Sedikit", "Banyak", "Sedikit", "Rendah");
//        r.save("Mahal", "Sedikit", "Banyak", "Banyak", "Tinggi");
//        r.save("Mahal", "Banyak", "Sedikit", "Sedikit", "Tinggi");
//        r.save("Mahal", "Banyak", "Sedikit", "Banyak", "Tinggi");
//        r.save("Mahal", "Banyak", "Sedang", "Sedikit", "Tinggi");
//        r.save("Mahal", "Banyak", "Sedang", "Banyak", "Tinggi");
//        r.save("Mahal", "Banyak", "Banyak", "Sedikit", "Tinggi");
//        r.save("Mahal", "Sedikit", "Banyak", "Banyak", "Tinggi");
        //r.edit("test 2", "test 2", "test 2", "test 2", "test 2", "7172449586");
        //r.hapus("7172449586");
        String[][] data_rule = r.get_all();
        for (int i = 0; i < data_rule.length; i++) {
            for (int j = 0; j < data_rule[0].length; j++) {
                System.out.print(data_rule[i][j]+"; ");
            }
            System.out.println("");
        }
        System.out.println("\nJumlah Record : "+data_rule.length);
        //System.out.println(Arrays.toString(r.getById("3042162914")));
    }
}
