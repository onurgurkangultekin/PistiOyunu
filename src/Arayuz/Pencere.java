package Arayuz;

import Kart.Kart;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



//SINGLETON DESIGN PATTERN
public class Pencere extends JFrame
{
    private static Pencere pencere=null;

    private Pencere()
    {
        super("Pişti Oyunu 2010   -   Onur Gürkan GÜLTEKİN b080110064");
        PencereAyarla();
        PanelleriOlustur();
        PanelleriEkle();
        MenuBarEkle();
        KahveEkle();
        PuanEkraniAyarla();

        this.repaint();
        this.validate();
    }



    public static Pencere PencereOlustur()
    {
        synchronized(Pencere.class)
        {
            if(pencere==null)
            {
                pencere=new Pencere();
            }

            return pencere;
        }
    }

    private void PencereAyarla()
    {
        this.setVisible(true);
        this.repaint();
        this.validate();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void PanelleriOlustur()
    {
        masa = new myPanel(new GridLayout(3, 3));
        masa.repaint();
        this.validate();

        

        ustSol=new myPanel();
        ustOrta=new myPanel();
        ustSag=new myPanel();

        ortaSol=new myPanel();
        ortaMerkez=new myPanel();
        ortaSag=new myPanel();

        altSol=new myPanel();
        altOrta=new myPanel();
        altSag= new myPanel();

        yerKart = new myPanel();
        puanEkrani=new myPanel(new GridBagLayout());
    }



    private void PanelleriEkle()
    {
        this.add(masa);

        this.repaint();
        this.validate();

        masa.add(ustSol);
        masa.add(ustOrta);
        masa.add(ustSag);

        masa.add(ortaSol);
        masa.add(ortaMerkez);
        masa.add(ortaSag);

        masa.add(altSol);
        masa.add(altOrta);
        masa.add(altSag);
        masa.repaint();
       
        this.repaint();
        this.validate();
        ortaMerkez.add(yerKart);
        ortaMerkez.repaint();


        ortaSag.add(puanEkrani);
        ortaSag.repaint();
        ortaSol.add(solKartlar);
        ortaSol.repaint();

        this.repaint();
        this.validate();
    }

    private void MenuBarEkle()
    {
        mBar = new myMenuBar();
        mBar.PencereyeMenuEkle(this);
        this.repaint();
        this.validate();
    }

    private void KahveEkle()
    {
        ustSag.add(kahve1);
        altSag.add(kahve2);

        this.validate();
        this.repaint();
    }

     private void PuanEkraniAyarla()
    {
        lblO1Skor.setForeground(Color.blue);
        lblOYSkor.setForeground(Color.blue);
        
        c = new GridBagConstraints();
        
        c.insets= new Insets(5, 20, 5, 20);


        c.gridy=0;
        c.gridx=0;
        puanEkrani.add(lblisim1,c);
        c.gridy=0;
        c.gridx=1;
        puanEkrani.add(lblisim2,c);
        c.gridy=1;
        c.gridx=0;
        puanEkrani.add(lblO1Skor,c);
        c.gridy=1;
        c.gridx=1;
        puanEkrani.add(lblOYSkor,c);
    }

     public void SkorEkle(JLabel lbl1, JLabel lbl2)
     {
         c.gridy++;
         c.gridx=0;

         puanEkrani.add(lbl1,c);

         c.gridx++;
         puanEkrani.add(lbl2,c);

         this.repaint();
         this.validate();

     }

    GridBagConstraints c;

    public myMenuBar mBar;
    public myPanel masa;

    public myPanel ustSol;
    public myPanel ustOrta;
    public myPanel ustSag;
    public myPanel ortaSol;
    public myPanel ortaMerkez;
    public myPanel ortaSag;
    public myPanel altSol;
    public myPanel altOrta;
    public myPanel altSag;
    public myPanel yerKart;
    public myPanel puanEkrani;

    public JLabel lblO1Skor = new JLabel("0");
    public JLabel lblOYSkor=new JLabel("0");

    private JLabel solKartlar=new JLabel(new ImageIcon(Kart.yol+"kartlar.png"));
    private JLabel kahve1=new JLabel(new ImageIcon(Kart.yol+"kahve.png"));
    private JLabel kahve2=new JLabel(new ImageIcon(Kart.yol+"kahve.png"));

    public static JLabel lblisim1 = new JLabel("Onur Gürkan");
    public static JLabel lblisim2 = new JLabel("Bilgisayar");
}