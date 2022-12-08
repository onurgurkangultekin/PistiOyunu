
package Oyun;

import Arayuz.Pencere;

public class Sira
{
    
    private boolean sira; // sira oyuncuda
                        //sira=false;  sira bilgisayarda

    Pencere pencere = Pencere.PencereOlustur();

    public Sira()
    {
        sira=true;
    }

    public void SiraDegisti() throws InterruptedException
    {
        if(isSira())
        {
            sira=false; // sira bilgisayarda
        }
        else
        {
            sira=true; // sira oyuncuda
        }
    }
    

    public boolean isSira()
    {
        return sira;
    }

}
