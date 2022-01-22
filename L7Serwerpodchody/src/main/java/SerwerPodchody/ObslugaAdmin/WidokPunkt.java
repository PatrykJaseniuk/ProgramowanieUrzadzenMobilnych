package SerwerPodchody.ObslugaAdmin;

import SerwerPodchody.Kernel.Punkt;
import Widok.Element;
import Widok.Form;
import Widok.Header;
import Widok.Input;
import Widok.Link;
import javax.servlet.http.HttpServletRequest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jasyn
 */
class WidokPunkt extends Element
{

    public Input inputWskazowkaLokalizacji;
    public Input inputSzerokosc;
    public Input inputDlugosc;
    public Input inputPytanie;
    public Input inputOpcja1;
    public Input inputOpcja2;
    public Input inputOpcja3;
    public Input inputOpcja4;
    public Input inputPrawidlowaOdpowiedz;

    public int id = 0;
    Header naglowek;
    public Link linkUsun;

    WidokPunkt()
    {

        naglowek = new Header("Punkt nr: " + id);
       add(naglowek);        

        inputWskazowkaLokalizacji = new Input("Wskazowka lokalizacji", "text");
        add(inputWskazowkaLokalizacji);

        inputSzerokosc = new Input("Szerokosc geograficzna", "number");
        add(inputSzerokosc);

        inputDlugosc = new Input("Dlugosc geograficzna", "number");
        add(inputDlugosc);

        inputPytanie = new Input("Pytanie", "text");
        add(inputPytanie);

        inputOpcja1 = new Input("Opcja odpowiedzi 1", "text");
        add(inputOpcja1);

        inputOpcja2 = new Input("Opcja odpowiedzi 2", "text");
        add(inputOpcja2);

        inputOpcja3 = new Input("Opcja odpowiedzi 3", "text");
        add(inputOpcja3);

        inputOpcja4 = new Input("Opcja odpowiedzi 4", "text");
        add(inputOpcja4);

        inputPrawidlowaOdpowiedz = new Input("Numer Prawidlowej odpowiedzi", "number");
        add(inputPrawidlowaOdpowiedz);

        linkUsun = new Link("Usun punkt", "Admin");
        add(linkUsun);

    }

    @Override
    public String getHtml()
    {
        String html = "";

        for (Element element : elementy)
        {
            html += element.getHtml();
        }
        return html;
    }

    void setIndex(int id)
    {
        this.id = id;
        naglowek.setText("Punkt nr: " + id);
    }

    Punkt getPunkt(HttpServletRequest request)
    {
        Punkt nowyPunkt = new Punkt();
        try
        {
            nowyPunkt.wskazowkaLokalizacji = inputWskazowkaLokalizacji.getText(request);
            nowyPunkt.pytanie = inputPytanie.getText(request);
            nowyPunkt.wspolrzedneDlugosc = Float.valueOf(inputDlugosc.getText(request));
            nowyPunkt.wspolrzedneSzerokosc = Float.valueOf(inputSzerokosc.getText(request));
            nowyPunkt.opcjeOdpowiedzi.add(inputOpcja1.getText(request));
            nowyPunkt.opcjeOdpowiedzi.add(inputOpcja2.getText(request));
            nowyPunkt.opcjeOdpowiedzi.add(inputOpcja3.getText(request));
            nowyPunkt.opcjeOdpowiedzi.add(inputOpcja4.getText(request));
            nowyPunkt.prawidlowaOdpowiedz = Integer.valueOf(inputPrawidlowaOdpowiedz.getText(request));
        } catch (Exception e)
        {

        }
return nowyPunkt;
    }
}
