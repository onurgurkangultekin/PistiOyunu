

package Arayuz;

import Kart.Kart;
import java.awt.GridLayout;
import javax.swing.JFrame;
import Oyun.Oyun;


//SINGLETON DESIGN PATTERN
public class IlkKartlar extends JFrame
{
    public myPanel pn = new myPanel(new GridLayout(1, 4));
    private static IlkKartlar ilkKartlar = null;

    private IlkKartlar()
    {
        this.setSize(200, 150);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(pn);
    }
    
    public static IlkKartlar Olustur()
    {
        synchronized(IlkKartlar.class)
        {
            if(ilkKartlar==null)
                ilkKartlar=new IlkKartlar();
        }
        return ilkKartlar;
    }

    public void Goster()
    {
        if(Oyun.sayac==0)
            this.setVisible(true);
    }
    public void Temizle()
    {
        this.pn.removeAll();
    }

    public void KartEkle(Kart k)
    {
        this.pn.add(k);
        this.repaint();
        this.validate();
    }


}
