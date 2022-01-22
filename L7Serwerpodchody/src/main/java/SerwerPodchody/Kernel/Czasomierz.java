/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SerwerPodchody.Kernel;

/**
 *
 * @author jasyn
 */
class Czasomierz
{

    final long milisekundWSekundzie = 1000;
    long koniec;

    Czasomierz()
    {
        koniec = System.currentTimeMillis();
    }

    public int getPozostalyCzasOczekiwania()
    {
        return (int) ((koniec - System.currentTimeMillis()) / milisekundWSekundzie);
    }

    public void czakaj(int iloscSekundOczekiwania)
    {
        koniec = System.currentTimeMillis() + iloscSekundOczekiwania * milisekundWSekundzie;
    }

}
