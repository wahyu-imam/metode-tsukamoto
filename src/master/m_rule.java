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
public class m_rule {
    String kode_rule;
    String harga;
    String jml_kelas;
    String jml_fasilitas;
    String transportasi;
    String bintang;
    
    public m_rule(String kode_rule, String harga, String jml_kelas, String jml_fasilitas, 
            String transportasi, String bintang){
        this.kode_rule = kode_rule;
        this.harga = harga;
        this.jml_kelas = jml_kelas;
        this.jml_fasilitas = jml_fasilitas;
        this.transportasi = transportasi;
        this.bintang = bintang;
    }

    public String getKode_rule() {
        return kode_rule;
    }

    public String getHarga() {
        return harga;
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
