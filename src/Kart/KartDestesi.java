package Kart;


import Arayuz.Pencere;
import Oyun.Oyun;
import Oyuncu.Oyuncu1;
import Oyuncu.OyuncuBase;
import Oyuncu.OyuncuYapay;
import java.util.Random;
import java.util.Vector;

//BRIDGE DESIGN PATTERN yardımıyla oyuncu base bu sınıf ile köprü kuruyor.

public class KartDestesi extends KartDestesiBase
{
    public Vector<Kart> deste = new Vector<Kart>();
    Pencere pencere = Pencere.PencereOlustur();

    public KartDestesi()
    {

    }


    @Override
    public void TumKartlariEkle()
    {
        DesteyeGrupEkle("kupa");
        DesteyeGrupEkle("maca");
        DesteyeGrupEkle("karo");
        DesteyeGrupEkle("sinek");
    }


    private void DesteyeGrupEkle(String grup)
    {
        for(int i=2; i<=14; i++)
        {
                Oyun.kartlar.KartEkle(new Kart(i, grup, grup+String.valueOf(i)));
        }
    }

    @Override
    public void YeniElKartDagit(OyuncuBase o)
    {
        for(int i=0; i<4; i++)
        {
            if( !Oyun.kartlar.IcindeKartKalmamis() )
            {
                Kart yeniKart = Oyun.kartlar.RasgeleKartGetir();
                o.eldekiKartlar.KartEkle(yeniKart);
                Oyun.kartlar.KartSil(yeniKart);

                if( o.getClass()==Oyuncu1.class)
                {
                    pencere.altOrta.add(yeniKart);
                    pencere.repaint();
                }
                else if( o.getClass() == OyuncuYapay.class)
                {
                    Kart kapaliKart = new Kart(0, "", "kArka1");
                    pencere.ustOrta.add(kapaliKart);
                    pencere.ustOrta.repaint();
                    pencere.repaint();
                }
                pencere.validate();
            }
        }
    }

    

    @Override
    public void KartEkle(Kart k)
    {
        deste.add(k);
    }

    @Override
    public void KartSil(Kart k)
    {
        deste.remove(k);
    }

    @Override
    public void KartSil(int i)
    {
        deste.remove(i);
    }

    @Override
    public Kart KartGetir(int i)
    {
        return deste.get(i);
    }

    @Override
    public Kart RasgeleKartGetir()
    {
        Random rasgele = new Random();
        int m = rasgele.nextInt(KartSayisi());
        Kart k = KartGetir(m);
        KartSil(k);
        return k;
    }


    @Override
    public boolean IcindeKartKalmamis()
    {
        return deste.isEmpty();
    }

    @Override
    public int KartSayisi()
    {
        return deste.size();
    }


}
