package Oyuncu;

import Kart.Kart;
import Oyun.Oyun;
import javax.swing.JOptionPane;


// singleton design pattern & factory design pattern
public class Oyuncu1 extends OyuncuBase
{
    private static Oyuncu1 oyuncu1=null;

    private Oyuncu1(String ad)
    {
        super(ad);
    }

    public static Oyuncu1 Oyuncu1Olustur(String ad)
    {
        synchronized(Oyuncu1.class)
        {
            if(oyuncu1==null)
                oyuncu1=new Oyuncu1(ad);
        }

        return oyuncu1;
    }



    @Override
    public void KartAtti(Kart k)
    {
            oyuncu1.eldekiKartlar.KartSil(k);
            pencere.yerKart.removeAll();
            pencere.yerKart.add(k);

            pencere.repaint();
            pencere.validate();
    }

    @Override
    public void KartKazandi(Kart k)
    {
        for(Kart kk : Oyun.ortaKartlar.deste)
        {
            oyuncu1.kazanilanKartlar.KartEkle(k);
        }

        oyuncu1.eldekiKartlar.KartSil(k);
        pencere.yerKart.removeAll();

        pencere.repaint();
        pencere.validate();
    }


    @Override
    public void PistiYapti(Kart k)
    {
        oyuncu1.pistiKartlar.KartEkle(k);
        pencere.altSol.add(k);
        pencere.altSol.repaint();
        pencere.yerKart.removeAll();
        JOptionPane.showMessageDialog(null, "pişti");
        pencere.repaint();
        pencere.validate();
    }



}
