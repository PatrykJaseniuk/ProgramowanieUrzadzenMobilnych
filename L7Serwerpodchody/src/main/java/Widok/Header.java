package Widok;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jasyn
 */
public class Header extends Element {
    
    public Header(String text)
    {
        this.text = text;
    }
    private String text="";
    
    @Override
    public String getHtml()
    {
        String html="<h1>"+text+"</h1>";
        
        return html;
    }
    
    public void setText(String text)
    {
        this.text = text;
    }
}
