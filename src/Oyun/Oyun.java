package Oyun;


import Arayuz.IlkKartlar;
import Arayuz.Pencere;
import Kart.Kart;
import Kart.KartDestesi;
import Oyuncu.*;
import java.awt.Dimension;

public class Oyun
{
    IlkKartlar ilkKartlar = IlkKartlar.Olustur();
    Pencere pencere = Pencere.PencereOlustur();
    public static KartDestesi kartlar = new KartDestesi();
    public static KartDestesi ortaKartlar = new KartDestesi();
    public static Kart yerKart;

    OyuncuAbstractFactory oyuncu1fabrika = new Oyuncu1Factory();
    OyuncuAbstractFactory oyuncuYapayFabrika = new OyuncuYapayFactory();

    Oyuncu1 oyuncu1 = (Oyuncu1) oyuncu1fabrika.OyuncuEkle("onur gürkan");
    OyuncuYapay oyuncuYapay = (OyuncuYapay) oyuncuYapayFabrika.OyuncuEkle("Bilgisayar");

    
   

    public Oyun()
    {
        OyunBaslat();
        pencere.repaint();
    }

    private void OyunBaslat()
    {
        pencere.resize(1000, 700);
        pencere.repaint();
        pencere.validate();
        pencere.setMinimumSize(new Dimension(955,600));
        kartlar.TumKartlariEkle();
        YerKartlariHazirla();
        YeniEl();
    }

    private void YerKartlariHazirla()
    {
        for(int i=0; i<3; i++)
        {
            Kart k = kartlar.RasgeleKartGetir();
            ortaKartlar.KartEkle(k);
            ilkKartlar.KartEkle(k);
        }

        yerKart = kartlar.RasgeleKartGetir();
        ilkKartlar.KartEkle(yerKart);

        ortaKartlar.KartEkle(yerKart);
        pencere.yerKart.add(yerKart);
        pencere.yerKart.repaint();
        pencere.ortaMerkez.repaint();
        pencere.repaint();
        pencere.validate();
    }

    


    private void YeniEl()
    {
        if(oyuncu1.eldekiKartlar.IcindeKartKalmamis()&& oyuncuYapay.eldekiKartlar.IcindeKartKalmamis())
        {
                 kartlar.YeniElKartDagit( oyuncu1 );
                 kartlar.YeniElKartDagit( oyuncuYapay );
        }
    }


    public static int sayac=0;


}
