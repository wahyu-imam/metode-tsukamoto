/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

/**
 *
 * @author imam
 */
public class m_hotel {
    String kode_hotel;
    String nama_hotel;
    String harga_kamar;
    String jml_kelas;
    String jml_fasilitas;
    String transportasi;
    String bintang;
    
    public m_hotel(String kode_hotel, String nama_hotel, String harga_kamar, String jml_kelas, 
            String jml_fasilitas, String transportasi, String bintang){
        this.kode_hotel = kode_hotel;
        this.nama_hotel = nama_hotel;
        this.harga_kamar = harga_kamar;
        this.jml_kelas = jml_kelas;
        this.jml_fasilitas = jml_fasilitas;
        this.transportasi = transportasi;
        this.bintang = bintang;
    }

    public String getKode_hotel() {
        return kode_hotel;
    }

    public String getNama_hotel() {
        return nama_hotel;
    }

    public String getHarga_kamar() {
        return harga_kamar;
    }

    public String getJml_kelas() {
        return jml_kelas;
    }

    public String getJml_fasilitas() {
        return jml_fasilitas;
    }

    public String getTransportasi() {
        return transportasi;
    }

    public String getBintang() {
        return bintang;
    }
}
