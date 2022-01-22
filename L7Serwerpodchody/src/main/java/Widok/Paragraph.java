/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Widok;

/**
 *
 * @author jasyn
 */
public class Paragraph extends Element
{
    public Paragraph(String text)
    {
        this.text = text;
    }
     private String text="";
    
    @Override
    public String getHtml()
    {
        String html="<p>"+text+"</p>";
        
        return html;
    }
    
    public void setText(String text)
    {
        this.text = text;
    }
}
