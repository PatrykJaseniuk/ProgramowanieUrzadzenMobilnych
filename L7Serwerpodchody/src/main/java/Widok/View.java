package Widok;


import java.io.PrintWriter;
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
public class View extends Element {

    public void response(HttpServletResponse response) {
        String html = getHtml();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(html);
        } catch (Exception e) {
        }
    }

    void request(HttpServletRequest request) {
       
    }

    @Override
    public String getHtml() {
        String html = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<body>\n";

        for (Element element : elementy) {
            html += element.getHtml();
        }

        html += "</body>\n"
                + "</html>";

        return html;
    }
}
