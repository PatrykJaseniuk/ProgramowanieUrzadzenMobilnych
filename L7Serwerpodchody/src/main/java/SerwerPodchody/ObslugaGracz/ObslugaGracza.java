/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SerwerPodchody.ObslugaGracz;

import SerwerPodchody.Kernel.Gracz;
import SerwerPodchody.Kernel.Kernel;
import SerwerPodchody.Kernel.Punkt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jasyn
 */
@WebServlet(name = "ObslugaGracza", urlPatterns =
{
    "/ObslugaGracza"
})
public class ObslugaGracza extends HttpServlet
{
    ObslugaGracza()
    {
        List<Punkt> lp = new LinkedList<Punkt>();
        
        Punkt p = new Punkt();
        p.wskazowkaLokalizacji="kieruj ie na poludnie";
        p.pytanie="ile wazy kilo kurzej siersci";
        p.wspolrzedneDlugosc=(float)1;
        p.wspolrzedneSzerokosc=(float)1;
        p.prawidlowaOdpowiedz=1;
        List<String> lo =new LinkedList<String>();
        lo.add("kilo");
        lo.add("kura nie ma siersci");
        p.opcjeOdpowiedzi=lo;
        
         lp.add(p);
         
         p = new Punkt();
        p.wskazowkaLokalizacji="Kieruj sie na polnoc";
        p.pytanie="Byc albo nie byc";
        p.wspolrzedneDlugosc=(float)10;
        p.wspolrzedneSzerokosc=(float)10;
        p.prawidlowaOdpowiedz=0;
        lo =new LinkedList<String>();
        lo.add("byc");
        lo.add("nie byc");
        p.opcjeOdpowiedzi=lo;       
        
       lp.add(p);
        Kernel.StworzGre(lp, 5);
    }
    Api api = new Api();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        obsluzZadanie(request);
        generujOdpowiedz(response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

    private void obsluzZadanie(HttpServletRequest request)
    {
        int idGracz = api.getIdGracza(request);        
        float szerokosc = api.getSzerokosc(request);
        float dlugosc = api.getDlugosc(request);        
        int nrOdpowiedzi = api.getNrOdpowiedzi(request);
        
        Gracz obslugiwanyGracz = Kernel.gracze.get(idGracz);
        if(obslugiwanyGracz!=null)
        {
            obslugiwanyGracz.getOdpowiedz(request, api);     
        }
        else
        {
            api.nieprawidloweId();
        }
           
    }

    private void generujOdpowiedz(HttpServletResponse response)
    {
        api.response(response);
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.print(jsonOdpowiedz);
//        } catch (Exception e) {
//        }
    }

}
