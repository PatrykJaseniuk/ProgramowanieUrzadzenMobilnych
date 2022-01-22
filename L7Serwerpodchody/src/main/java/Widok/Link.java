/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Widok;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jasyn
 */
public class Link extends Element
{
    static int liczbaLinkow =0;
    
    private String url = "";
    private String text = "";
    private String id = "";

    public Link(String opisLinku, String adres)
    {
        this.text = opisLinku;
        this.url = adres; 
        
        this.id = "idLink"+url+liczbaLinkow;
        liczbaLinkow++;
    }

    @Override
    public String getHtml()
    {
        String html = "<a href =\"" + url +"?"+id+ "=true\">" + text + "</a>";

        return html;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public boolean isClicked(HttpServletRequest request)
    {
        String text = request.getParameter(id);
        if ("true".equals(text))
        {
            return true;
        } else
        {
            return false;
        }
    }
}
