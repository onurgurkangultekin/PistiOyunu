package Arayuz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class myMenuBar
{


    public myMenuBar()
    {
        JDialog.setDefaultLookAndFeelDecorated(true);
        MenuleriOlustur();
        
    }

    public void MenuleriOlustur()
    {
        menuBar = new JMenuBar();

        menu1 = new JMenu("Oyun");
        menu2 = new JMenu("Yardım");

        item1 = new JMenuItem("yeni oyun");
        YeniOyunEventVer();
        item2 = new JMenuItem("çıkış");
        CikisEventVer(item2);
        item5 = new JMenuItem("İsim Ayarla");
        IsimAyarlaEventVer(item5);
        item3 = new JMenuItem("Hakkında");
        HakkindaEventVer(item3);
        item4 = new JMenuItem("Pişti Nasıl Oynanır ?");
        PistiNasilOynanirEventVer(item4);


        menu1.add(item1);
        menu1.add(item5);
        menu1.add(item2);
        menu2.add(item3);
        menu2.add(item4);

        menuBar.add(menu1);
        menuBar.add(menu2);
    }

    
    public void PencereyeMenuEkle(Pencere p)
    {
        p.setJMenuBar(menuBar);
        p.repaint();
    }

    private void YeniOyunEventVer()
    {
        item1.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                System.gc();
            }
        });
    }

    private void CikisEventVer(JMenuItem item)
    {
        item.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                  Object stringArray[] = { "he :(", "yok la :)" };
                    int cevap=JOptionPane.showOptionDialog(null, "oyundan çıkılsın mı?   :(", "çıkış",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray,
                    stringArray[0]);


                if(cevap==JOptionPane.YES_OPTION)
                {
                    Pencere.PencereOlustur().repaint();
                    System.gc();
                    System.exit(0);
                }
            }
        });
    }

    private void HakkindaEventVer(JMenuItem item)
    {
        item.addActionListener(new ActionListener()
        {

            @SuppressWarnings("empty-statement")
            public void actionPerformed(ActionEvent e)
            {;
                JOptionPane.showMessageDialog(null, "Pişti Oyunu (2010) Onur Gürkan GÜLTEKİN\n         Ödev Danışmanı : Özgür ÇİFTÇİ", "Hakkında", 1);
            }
        });
    }

    private void PistiNasilOynanirEventVer(JMenuItem item)
    {
        item.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                new NasilOynanir();
            }
        });
    }

    JMenuBar menuBar;

    JMenu menu1;
    JMenu menu2;

    JMenuItem item1;
    JMenuItem item2;
    JMenuItem item5;
    JMenuItem item3;
    JMenuItem item4;

    private void IsimAyarlaEventVer(JMenuItem item5)
    {
        item5.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                new IsimDegis();
            }
        });
    }





    
}