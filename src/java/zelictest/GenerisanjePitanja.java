package zelictest;

import Baza.DB;
import Baza.KorPit;
import Baza.Odgovori;
import Baza.Pitanja;
import java.util.List;
import java.util.Set;

public class GenerisanjePitanja {

    public static void main(String[] args) 
    {
        List<Pitanja> list = DB.query("SELECT p FROM Pitanja p");
        for(Pitanja i:list)
        {
            String pitText = i.getPitText();
            System.out.println(pitText);
            Set<Odgovori> odgovoriSet = i.getOdgovoriSet();
            for( Odgovori j:odgovoriSet )
            {
                System.out.println("\t"+j.getOdgText());
            }
        }
    }
    
}
