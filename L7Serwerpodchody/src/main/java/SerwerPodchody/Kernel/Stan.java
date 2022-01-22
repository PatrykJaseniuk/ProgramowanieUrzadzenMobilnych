package SerwerPodchody.Kernel;


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
public interface Stan
{
    public void obsluzZadanie(HttpServletRequest request);

    public void generujOdpowiedz(HttpServletResponse response);    
}
