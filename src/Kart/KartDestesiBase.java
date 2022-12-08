package Kart;

import Oyuncu.OyuncuBase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author onurgurkan
 */
//BRIDGE DESIGN PATTERN
public abstract class KartDestesiBase
{
    public abstract void TumKartlariEkle();
    public abstract void KartEkle(Kart k);
    public abstract void KartSil(Kart k);
    public abstract void KartSil(int i);
    public abstract void YeniElKartDagit(OyuncuBase o);
    public abstract boolean IcindeKartKalmamis();
    public abstract int KartSayisi();
    public abstract Kart KartGetir(int i);
    public abstract Kart RasgeleKartGetir();
}
