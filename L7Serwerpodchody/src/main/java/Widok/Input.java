package Widok;


import javax.servlet.http.HttpServletRequest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jasyn
 */
public class Input extends Element {

    static int licznik = 0;
    protected String label;
    protected String typ;
    protected String nazwa;
    protected String value="";

    public Input(String label, String typ) {
        this.nazwa = "input" + licznik++;
        this.label = label;
        this.typ = typ;
    }

    @Override
    public String getHtml() {
        String html = "<br><label for=\"" + nazwa + "\">" + label + ":</label><br>\n"
                + "  <input type=\"" + typ + "\" id=\"" + nazwa + "\" name=\"" + nazwa + "\" value=\"" + value +"\"><br>";

        return html;
    }

    public String getText(HttpServletRequest request) {
        String text = request.getParameter(nazwa);
        value =text;
        return text;
    }
}
