


package Oyun;


import Kart.Kart;
import Oyuncu.OyuncuBase;


public class SkorHesapla
{
    private int _oyuncuSkor;

    public SkorHesapla()
    {
        setOyuncuSkor(0);
    }

    public int SkorHesapla(OyuncuBase o)
    {
        for(int i=0; i<o.pistiKartlar.KartSayisi(); i++)
            _oyuncuSkor+=10;

        if(o.kazanilanKartlar.KartSayisi()>26)
            _oyuncuSkor+=3;

        for(Kart k : o.kazanilanKartlar.deste)
        {
            if(k.getDeger()==14 || k.getDeger()==11)
            {
                _oyuncuSkor++;
            }

            else if(k.getDeger()==2 && k.getGrup().equals("sinek"))
            {
                _oyuncuSkor+=2;
            }

            else if(k.getDeger()==10 && k.getGrup().equals("kupa"))
            {
                _oyuncuSkor+=3;
            }

        }

        o.kazanilanKartlar.deste.removeAllElements();
        return getOyuncuSkor();
    }




    private int getOyuncuSkor()
    {
        return _oyuncuSkor;
    }



    public void setOyuncuSkor(int oyuncuSkor)
    {
        this._oyuncuSkor = oyuncuSkor;
    }

}
