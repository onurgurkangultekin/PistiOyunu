package Oyuncu;

import Kart.Kart;
import Oyun.Hareket;
import Oyun.Oyun;
import java.util.Random;


// singleton design pattern & factory design pattern
public class OyuncuYapay extends OyuncuBase 
{
    public static OyuncuYapay oyuncuYapay = null;
    
    Kart eldeVar=null;


    private OyuncuYapay(String ad)
    {
        super(ad);
    }


    public static OyuncuYapay OyuncuYapayOlustur(String ad)
    {
        synchronized(OyuncuYapay.class)
        {
            if(oyuncuYapay==null)
                oyuncuYapay=new OyuncuYapay(ad);
        }

        return oyuncuYapay;

    }

    @SuppressWarnings("static-access")
    public void KartAt() throws InterruptedException
    {
        Hareket h= Hareket.HareketOlustur();
        BendeVarMi();
        if(eldeVar != null)  // oyunun yapay zeka kısmı :) elinde varsa at yoksa random at :)
        {
            h.KartAt(eldeVar);
            eldeVar=null;
        }
        else
        {
            Random rasgele = new Random();

            int i = (int) rasgele.nextInt(oyuncuYapay.eldekiKartlar.KartSayisi());
            Kart k = oyuncuYapay.eldekiKartlar.KartGetir(i);
            h.KartAt(k);

        }
    }
    public void BendeVarMi()
    {
        for(Kart k: oyuncuYapay.eldekiKartlar.deste)
        {
            if(k.getDeger()==Oyun.yerKart.getDeger())
                oyuncuYapay.eldeVar=k;
        }

    }


    @Override
    public void KartAtti(Kart k)
    {
            oyuncuYapay.eldekiKartlar.KartSil(k);
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
            oyuncuYapay.kazanilanKartlar.KartEkle(kk);
        }

        oyuncuYapay.eldekiKartlar.KartSil(k);
        pencere.yerKart.removeAll();

        pencere.repaint();
        pencere.validate();
    }

    @Override
    public void PistiYapti(Kart k)
    {
        oyuncuYapay.pistiKartlar.KartEkle(k);
        pencere.altSol.add(k);
        pencere.altSol.repaint();
        pencere.yerKart.removeAll();

        pencere.repaint();
        pencere.validate();
    }

}
