package Oyuncu;


import Arayuz.Pencere;
import Kart.Kart;
import Kart.KartDestesi;
import Oyun.Oyun;

//FACTORY DESIGN PATTERN
public abstract class OyuncuBase
{
    public String ad;
    Pencere pencere = Pencere.PencereOlustur();

    public KartDestesi eldekiKartlar = new KartDestesi();   // KartDestesi ile 1.köprü kuruldu
    public KartDestesi kazanilanKartlar = new KartDestesi(); // KartDestesi ile 2.köprü kuruldu
    public KartDestesi pistiKartlar = new KartDestesi(); // KartDestesi ile 3. köprü kuruldu.

    public OyuncuBase(String ad)
    {
        this.ad=ad;
    }



    public abstract void KartAtti(Kart k);
    public abstract void KartKazandi(Kart k);
    public abstract void PistiYapti(Kart k);

    public boolean KartKazandiMi(Kart k)
    {
        if(Oyun.yerKart.getDeger()==k.getDeger())
            return true;
        else if(k.getDeger()==11)
            return true;
        else
            return false;
    }

    public boolean PistiYaptiMi(Kart k)
    {
        if(Oyun.ortaKartlar.deste.size()==1)
        {
            if(k.getDeger()==Oyun.yerKart.getDeger())
            {
                return true;
            }

        }

        return false;
    }


}
