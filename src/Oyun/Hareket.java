package Oyun;


import Arayuz.IlkKartlar;
import Arayuz.Pencere;
import Kart.Kart;
import Oyuncu.Oyuncu1;
import Oyuncu.Oyuncu1Factory;
import Oyuncu.OyuncuAbstractFactory;
import Oyuncu.OyuncuYapay;
import Oyuncu.OyuncuYapayFactory;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


//SINGLETON DESIGN PATTERN
public class Hareket
{
    private Sira sira = new Sira();
    private static Hareket h=null;
    Pencere pencere;
    private IlkKartlar ilkKartlar = IlkKartlar.Olustur();

    private SkorHesapla oyuncu1Skor= new SkorHesapla();
    private SkorHesapla oyuncuYapaySkor = new SkorHesapla();

    OyuncuAbstractFactory oyuncu1fabrika = new Oyuncu1Factory();
    OyuncuAbstractFactory oyuncuYapayFabrika = new OyuncuYapayFactory();

    Oyuncu1 oyuncu1 = (Oyuncu1) oyuncu1fabrika.OyuncuEkle("onur");
    OyuncuYapay oyuncuYapay = (OyuncuYapay) oyuncuYapayFabrika.OyuncuEkle("Bilgisayar");


    private Hareket()
    {
        pencere = Pencere.PencereOlustur();
    }


    public static Hareket HareketOlustur()
    {
        synchronized(Hareket.class)
        {
            if(h==null)
            {
                h = new Hareket();
            }

            return h;
        }
    }

    private class OynatveBeklet implements Runnable
    {

        private Kart k;
        private Sira sira;


        public OynatveBeklet(Kart k,Sira sira)
        {
            this.k = k;
            this.sira = sira;
        }

        @Override
        public void run()
        {
           if(k != Oyun.yerKart)
            {
                Oyun.ortaKartlar.KartEkle(k); // ortaya kart atıldı.

                if(sira.isSira()) // sıra oyuncu1 de ise
                {
                    k.getParent().remove(k);

                    if(oyuncu1.PistiYaptiMi(k))
                    {
                        oyuncu1.PistiYapti(k);
                    }

                    else if(oyuncu1.KartKazandiMi(k))
                    {
                        oyuncu1.KartKazandi(k);
                        ilkKartlar.Goster();
                        if(!ilkKartlar.isVisible())
                            ilkKartlar.Temizle();
                        Oyun.sayac++;
                    }
                    else
                    {
                        oyuncu1.KartAtti(k);
                    }

                    pencere.yerKart.repaint();
                    pencere.ortaMerkez.repaint();
                    pencere.masa.repaint();
                    pencere.repaint();

                    pencere.validate();
                    try
                    {
                        Thread.sleep(500);
                        sira.SiraDegisti();
                        oyuncuYapay.KartAt();
                    }
                    catch (InterruptedException ex)
                    {
                        Logger.getLogger(Hareket.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }

            else // sira bilgisayarda ise
            {

                try
                {
                    pencere.ustOrta.remove(pencere.ustOrta.getComponentCount()-1);
                }
                catch(Exception hata)
                {}

                if(oyuncuYapay.PistiYaptiMi(k))
                {
                    oyuncuYapay.PistiYapti(k);
                }

                else if(oyuncuYapay.KartKazandiMi(k))
                {
                    oyuncuYapay.KartKazandi(k);
                    ilkKartlar.Goster();

                    if(!ilkKartlar.isVisible())
                        ilkKartlar.Temizle();

                    Oyun.sayac++;
                }
                else
                {
                    oyuncuYapay.KartAtti(k);
                }

                try
                {
                    sira.SiraDegisti();
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(Hareket.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Dagit();
            }

           }
        }

    }

    public void KartAt(Kart k) throws InterruptedException
    {
        new Thread(new OynatveBeklet(k,sira)).start();
    }



    @SuppressWarnings("static-access")
    private void Dagit()
    {
        if( (!Oyun.kartlar.IcindeKartKalmamis()) && oyuncu1.eldekiKartlar.IcindeKartKalmamis()&&oyuncuYapay.eldekiKartlar.IcindeKartKalmamis())
        {
            oyuncu1.eldekiKartlar.YeniElKartDagit(oyuncu1);
            oyuncuYapay.eldekiKartlar.YeniElKartDagit( oyuncuYapay);


        }

        if( (Oyun.kartlar.IcindeKartKalmamis()) && oyuncu1.eldekiKartlar.IcindeKartKalmamis()&&oyuncuYapay.eldekiKartlar.IcindeKartKalmamis())
        {
            o1Skor =oyuncu1Skor.SkorHesapla(oyuncu1);
            JLabel lblSkor1=new JLabel(String.valueOf(o1Skor));
            lblSkor1.setForeground(Color.blue);

            oYSkor =oyuncuYapaySkor.SkorHesapla(oyuncuYapay);
            JLabel lblSkor2=new JLabel(String.valueOf(oYSkor));
            lblSkor2.setForeground(Color.blue);

            if(h.sayac<5)
            {
                Oyun o = new Oyun();
                h.sayac++;
                pencere.yerKart.removeAll();
                JOptionPane.showMessageDialog(null,sayac-1+".el\n" +Pencere.lblisim1.getText()+ " puanı : "+o1Skor+
                        "\n"+Pencere.lblisim2.getText()+" puanı : "+oYSkor);
                pencere.SkorEkle(lblSkor1, lblSkor2);
            }
            else
            {
                if(o1Skor>oYSkor)
                    JOptionPane.showMessageDialog(pencere, "tebrikler "+ pencere.lblisim1.getText() + " kazandın !!!    =)");
                else
                    JOptionPane.showMessageDialog(pencere, "ah be"+pencere.lblisim1.getText() + " kaybettin...      =(");
            }
        }

    }

    private int o1Skor;
    private int oYSkor;
    private int sayac=1;
}
