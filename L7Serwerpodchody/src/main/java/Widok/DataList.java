/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Widok;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jasyn
 */
public class DataList extends Element {

    static int counter = 0;
    private String nazwa;
    private String label;
    List<String> listaOpcji;

    public DataList(List<String> listaOpcji, String label) {
        this.listaOpcji = listaOpcji;
        counter++;
        nazwa = "dataList" + counter;
        this.label = label;
    }

    @Override
    public String getHtml() {
        String html = "<label for=\"" + nazwa + "\">" + label + "</label>\n"
                + "  <input list=\"opcje" + nazwa + "\" name=\"" + nazwa + "\" id=\"" + nazwa + "\">\n"
                + "  <datalist id=\"opcje" + nazwa + "\">\n";

        for (String opcja : listaOpcji) {
            html += "<option value=\"" + opcja + "\">\n";
        }

        html += "  </datalist>\n";
        return html;
    }

    public String getText(HttpServletRequest request) {
        String text = request.getParameter(nazwa);
        return text;
    }
}
