

package Arayuz;

import javax.swing.JFrame;


public class NasilOynanir extends JFrame
{

    public NasilOynanir()
    {
        super("Pişti Nasıl Oynanır ?");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        jTextPane1.setText(Text);
    }

   
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables


    private String Text="Pişti Nasıl Oynanır?\n\nPişti, 52 kağıtlık tek bir desteyle oynanan bir kağıt oyunudur. " +
            "Programımızda Pişti oyunu 2 kişiyle oynanmaktadır.  Oyuna başlamak için yere 3 kapalı, 1 açık kağıt konur. " +
            "Her oyuncuya da 4’er kağıt dağıtılır. İlk oyuncunun elinden bir kağıt atmasıyla oyun başlar. " +
            "Oyuncular sırasıyla ellerindeki bir kağıdı yerdekinin üstüne atarlar, elinde en üstte bulunan kağıdın aynısından bulunan " +
            "oyuncu onu atarak yerdeki bütün kağıtları alır. Vale her zaman atılabilen ve yerdeki bütün kağıtları alan bir kağıttır.  " +
            "Boş yere atılan kağıdın üstüne aynısından atan oyuncu pişti yapmış olur. Yerdeki kağıtları alır ve oyun diğer oyuncunun " +
            "attığı kağıtla devam eder. İki oyuncunun elindeki kağıtlar bitince yeniden 4’er kağıt dağıtılır. " +
            "Bütün kağıtlar bitene kadar oyun aynı şekilde devam eder.\n\n" +
            "Puanlama \n\nOyunun sonunda oyuncuların ellerindeki kağıtlar sayılır. Her piştinin değeri 10 puandır. " +
            "Bunun dışında As’lar 1’er puan, Vale’ler 1’er puan, Sinek İkilisi 2 puan, Karo Onlusu 3 puan değerindedir. " +
            "Önce her oyuncunun elindeki puanlar sayılır, ardından kimin elinde daha fazla kağıt varsa ona artı 3 puan daha verilir." +
            " Oyunu en çok puan alan oyuncu kazanır. ";
;

}
