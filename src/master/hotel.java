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
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import uniqid.uniqid;
/**
 *
 * @author imam
 */
public class hotel{
    Connection con;
    Statement stm;
    ResultSet rs;
    PreparedStatement pst;
    database db = new database();
    uniqid uniqid = new uniqid();
    
    public String[][] get_all(){
        ArrayList<m_hotel> tampung = new ArrayList<>();
        String sql = "SELECT * FROM `hotel` ORDER BY nama_hotel ASC";
        try {
            con = db.getKoneksi();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                tampung.add(new m_hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            con.close(); stm.close(); rs.close();
        } catch (SQLException e) {
            System.out.println("error : "+e);
        }
        String[][] data = null;
        if(!tampung.isEmpty()){
            data = new String[tampung.size()][7];
            int no = 0;
            for (m_hotel mh : tampung) {
                data[no][0] = mh.getKode_hotel();
                data[no][1] = mh.getNama_hotel();
                data[no][2] = mh.getHarga_kamar();
                data[no][3] = mh.getJml_kelas();
                data[no][4] = mh.getJml_fasilitas();
                data[no][5] = mh.getTransportasi();
                data[no][6] = mh.getBintang();
                no++;
            }
        }
        return data;
    }
    
    public String[] getById(String kode_hotel){
        ArrayList<String> tampung = new ArrayList<>();
        String sql = "SELECT `kode_hotel`, `nama_hotel`, `harga_kamar`, `jml_kelas`, `jml_fasilitas`, "
                + "`transportasi`, `bintang` FROM `hotel` WHERE kode_hotel="+kode_hotel;
        try {
            con = db.getKoneksi();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if(rs.next()){
                tampung.add(rs.getString(1)); tampung.add(rs.getString(2)); tampung.add(rs.getString(3));
                tampung.add(rs.getString(4)); tampung.add(rs.getString(5)); tampung.add(rs.getString(6));
                tampung.add(rs.getString(7));
            }
            con.close(); stm.close(); rs.close();
        } catch (SQLException e) {
            System.out.println("error :"+e);
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
    
    public void save(String nama_hotel, String harga_kamar, String jml_kelas, 
            String jml_fasilitas, String transportasi, String bintang){
        String sql = "INSERT INTO `hotel`(`kode_hotel`, `nama_hotel`, `harga_kamar`, `jml_kelas`, "
                + "`jml_fasilitas`, `transportasi`, `bintang`) VALUES (?,?,?,?,?,?,?)";
        try {
            con = db.getKoneksi();
            pst = con.prepareStatement(sql);
            pst.setString(1, uniqid.get());
            pst.setString(2, nama_hotel);
            pst.setString(3, harga_kamar);
            pst.setString(4, jml_kelas);
            pst.setString(5, jml_fasilitas);
            pst.setString(6, transportasi);
            pst.setString(7, bintang);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil simpan data");
            con.close(); pst.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error :"+e);
        }
    }
    
    public void edit(String nama_hotel, String harga_kamar, String jml_kelas, 
            String jml_fasilitas, String transportasi, String bintang, String kode_hotel){
        String sql = "UPDATE `hotel` SET `nama_hotel`=?,`harga_kamar`=?,`jml_kelas`=?,`jml_fasilitas`=?,"
                + "`transportasi`=?,`bintang`=? WHERE `kode_hotel`=?";
        try {
            con = db.getKoneksi();
            pst = con.prepareStatement(sql);
            pst.setString(1, nama_hotel);
            pst.setString(2, harga_kamar);
            pst.setString(3, jml_kelas);
            pst.setString(4, jml_fasilitas);
            pst.setString(5, transportasi);
            pst.setString(6, bintang);
            pst.setString(7, kode_hotel);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil simpan data");
            con.close(); pst.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error :"+e);
        }
    }
    
    public void hapus(String kode_hotel){
        String sql = "DELETE FROM `hotel` WHERE kode_hotel=?";
        try {
            con = db.getKoneksi();
            pst = con.prepareStatement(sql);
            pst.setString(1, kode_hotel);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil hapus data");
            con.close(); pst.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error : "+e);
        }
    }
    
    public static void main(String[] args) {
        hotel h = new hotel();
        
        //h.save("test", "1", "1", "1", "1", "1");
        //h.edit("test 2", "1", "1", "1", "1", "1", "5892308692");
        //h.hapus("5892308692");
        String[][] data_hotel = h.get_all();
        for (int i = 0; i < data_hotel.length; i++) {
            for (int j = 0; j < data_hotel[0].length; j++) {
                System.out.print(data_hotel[i][j]+"; ");
            }
            System.out.println("");
        }
        System.out.println("\nJumlah Record : "+data_hotel.length);
        System.out.println(Arrays.toString(h.getById("0077391404")));
    }
}
