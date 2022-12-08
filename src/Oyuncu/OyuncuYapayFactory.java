/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Oyuncu;

/**
 *
 * @author onurgurkan
 */

// factory design pattern
public class OyuncuYapayFactory extends OyuncuAbstractFactory
{

    @Override
    public OyuncuBase OyuncuEkle(String ad)
    {
        return OyuncuYapay.OyuncuYapayOlustur(ad);
    }

}
