package zelictest;

import Baza.DB;
import Baza.Korisnik;
import java.util.List;

public class TestKonekcije {

    public static void main(String[] args) {
        
        List<Korisnik> lista = DB.query("SELECT k FROM Korisnik k WHERE k.korUsername='nikola'");
        for(Korisnik i:lista){
            System.out.println(i.getKorUsername());
        }
    }
    
}
