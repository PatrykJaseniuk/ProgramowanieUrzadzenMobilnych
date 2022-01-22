/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Widok;

import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author jasyn
 */
public class FileInpute extends Input {

    public FileInpute(String label) {
        super("plik","file");    }

    public Part getFile(HttpServletRequest request) {
        try {
            return request.getPart(this.nazwa);           
        } catch (Exception e) {
            
            System.out.println("nie udalo sie wczytac plliku");
        }
        return null;
    }

}
