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
public class m_kriteria {
    String kode_variabel;
    String nama_variabel;
    String rentang;
    String min;
    String max;
    
    public m_kriteria(String kode_variabel, String nama_variabel, String rentang, String min, String max){
        this.kode_variabel = kode_variabel;
        this.nama_variabel = nama_variabel;
        this.rentang = rentang;
        this.min = min;
        this.max = max;
    }

    public String getKode_variabel() {
        return kode_variabel;
    }

    public String getNama_variabel() {
        return nama_variabel;
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
}
