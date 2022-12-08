package Oyuncu;


//FACTORY DESIGN PATTERN
public class Oyuncu1Factory extends OyuncuAbstractFactory
{
    @Override
    public OyuncuBase OyuncuEkle(String ad)
    {
        return Oyuncu1.Oyuncu1Olustur(ad);
    }
}
