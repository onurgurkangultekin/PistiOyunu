package Arayuz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;




public class myPanel extends JPanel
{

    public myPanel(LayoutManager l)
    {
        super(l);
    }

    public myPanel()
    {
        
    }


    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        this.setBackground(Color.green);
    }

}
