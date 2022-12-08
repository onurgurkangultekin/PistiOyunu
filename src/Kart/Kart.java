package Kart;



import Arayuz.Pencere;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Oyun.Hareket;
import java.util.Timer;


//BRIDGE DESIGN PATTERN
public class Kart extends JLabel implements IKart
{
    Timer timer=new Timer();
    private Hareket h = Hareket.HareketOlustur();
    public static String yol="src/resim/";
    private int deger;
    private String grup;
    Pencere pencere = Pencere.PencereOlustur();


    public Kart(int deger,String grup,String kartIsmi)
    {
        KartHazirla(deger, grup, kartIsmi);
    }

    private void KartHazirla(int deger, String grup, String kartIsmi)
    {
        this.setDeger(deger);
        this.setGrup(grup);
        this.setIcon(new ImageIcon(yol + kartIsmi + ".png"));
        this.setVisible(true);
        this.repaint();
        EventVer();
    }

    private void EventVer()
    {
        this.addMouseListener(new MouseListener()
        {

            @SuppressWarnings("static-access")
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                    if(e.getComponent().getParent()==pencere.altOrta)
                    {
                        
                        h.KartAt((Kart) e.getComponent());
                        
                    }
                } 
                catch (InterruptedException ex)
                {
                    Logger.getLogger(Kart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
               

            // kullanmadığım kart event'leri
            public void mousePressed(MouseEvent e) {
            }
            public void mouseReleased(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {
            }
        });

    }

    public int getDeger()
    {
        return deger;
    }


    private void setDeger(int deger)
    {
        this.deger = deger;
    }


    public String getGrup()
    {
        return grup;
    }


    private void setGrup(String grup)
    {
        this.grup = grup;
    }

}
