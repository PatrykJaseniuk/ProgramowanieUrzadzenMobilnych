package Widok;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jasyn
 */
public class Form extends Element {

    private String action;
    private String method;

    public Form(String action,String method) {
        this.action = action;
        this.method = method;
    }

    @Override
    public String getHtml() {
         
        String html = "<form method=\""+method+"\"  action=\"" + action + "\">\n";

        for (Element element : elementy) {
            html += element.getHtml();
        }

        html
                += "  <input type=\"submit\" value=\"Submit\">\n"
                + "</form> ";
        return html;
    }
}
