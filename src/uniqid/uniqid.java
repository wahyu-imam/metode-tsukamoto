package uniqid;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imam
 */
public class uniqid {
    
    private char buatKarakterAcak(char karakter1, char karakter2){ 
        return (char)(karakter1 + Math.random() * (karakter2 - karakter1 + 1)); 
    } 
    
    private char buatKarakterDigitAngkaAcak(){ 
        return buatKarakterAcak('0', '9'); 
    }
    
    public String get(){
        String kode ="";
        for(int i = 0; i < 10; i++){ 
        char karakter = buatKarakterDigitAngkaAcak(); 
        if((i + 1) % 10 == 0){ 
            kode += karakter; 
        } 
        else kode += karakter; 
        }
        return kode;
    }
    
    public static void main(String[] args) {
        uniqid uniqid = new uniqid();
        System.out.println(uniqid.get());
    }
}
