package SerwerPodchody.ObslugaAdmin;


import SerwerPodchody.Kernel.Kernel;
import SerwerPodchody.Kernel.Punkt;
import SerwerPodchody.Kernel.Stan;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jasyn
 */
public class StanTworzeniaGry implements Stan
{
    private Admin admin;
    
    WidokTworzenieGry widokTworzeniaGry = new WidokTworzenieGry();
    public StanTworzeniaGry()
    {
    }

    StanTworzeniaGry(Admin admin)
    {
        this.admin = admin;
    }

    @Override
    public void obsluzZadanie(HttpServletRequest request)
    {
        widokTworzeniaGry.edycjaFormularza(request);
        List<Punkt> punkty = widokTworzeniaGry.getPunkty(request); 
        int liczbaGraczy = widokTworzeniaGry.getliczbaGraczy(request);
        if(liczbaGraczy>0)
        {
            Kernel.StworzGre(punkty,liczbaGraczy);
            admin.stan = new StanAdministrowaniaGra();
        }
    }

    @Override
    public void generujOdpowiedz(HttpServletResponse response)
    {
        widokTworzeniaGry.response(response);
    }
    
}
