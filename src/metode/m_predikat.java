/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;


/**
 *
 * @author imam
 */
public class m_predikat {
    fungsi_keanggotaan f;
    double harga;
    double kelas;
    double fasilitas;
    double transportasi;
    double bintang;
    double predikat;
    
    public m_predikat(double harga, double kelas, double fasilitas, double transportasi, String bintang){
        f = new fungsi_keanggotaan();
        this.harga = harga;
        this.kelas = kelas;
        this.fasilitas = fasilitas;
        this.transportasi = transportasi;
        double pre;
        pre = Math.max(harga, kelas);
        pre = Math.max(pre, fasilitas);
        pre = Math.max(pre, transportasi);
        this.predikat = pre;
        if("Rendah".equals(bintang)){
//            this.bintang = Math.round(f.bintangRendah(pre));
            this.bintang = f.bintangRendah(pre);
        }else{
//            this.bintang = Math.round(f.bintangTinggi(pre));
            this.bintang = f.bintangTinggi(pre);
        }
    }

    public double getHarga() {
        return harga;
    }

    public double getKelas() {
        return kelas;
    }

    public double getFasilitas() {
        return fasilitas;
    }

    public double getTransportasi() {
        return transportasi;
    }

    public double getBintang() {
        return bintang;
    }
    
    public double getPredikat(){
        return predikat;
    }
}
