/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SerwerPodchody.ObslugaAdmin;

import SerwerPodchody.Kernel.Stan;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jasyn
 */
public class StanAdministrowaniaGra implements Stan
{
    

  
    @Override
    public void obsluzZadanie(HttpServletRequest request)
    {        
    }

    @Override
    public void generujOdpowiedz(HttpServletResponse response)
    {
       new WidokAdministrowanieGra().response(response);
    }
    
}
