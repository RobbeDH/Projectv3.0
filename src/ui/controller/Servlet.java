package ui.controller;

import Domain.db.KampDb;
import Domain.model.DomainException;
import Domain.model.Kamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private KampDb kampen = new KampDb();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            command = "";
        }
        String destination;
        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "voegtoe":
                destination = voegToe(request, response);
                break;
            case "voegtoeForm":
                destination = voegtoeForm(request, response);
                break;
            case "overzicht":
                destination = overzicht(request, response);
                break;
            case "verwijder":
                destination = verwijder(request, response);
                break;
            case "verwijderBevestig":
                destination = verwijderBevestig(request, response);
                break;
            case "zoekKamp":
                destination = zoekKamp(request, response);
                break;
            case "zoekKampForm":
                destination = zoekKampForm(request, response);
                break;
            case "bewerkForm":
                destination = bewerkForm(request, response);
                break;
            case "bewerk":
                destination = bewerk(request, response);
                break;
            default:
                destination = home(request, response);
        }

        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String bewerk(HttpServletRequest request, HttpServletResponse response) {
        String jaar = request.getParameter("jaar");
        String kampplaats = request.getParameter("kampplaats");
        String kampthema = request.getParameter("kampthema");
        String scoreform = request.getParameter("score");
        int score = Integer.parseInt(scoreform);

        kampen.vindKamp(jaar).bewerkKamp(kampplaats, kampthema, score);

        request.setAttribute("alleKampen", kampen.getKampen());
        request.setAttribute("aantal", kampen.getAantalKampen());
        request.setAttribute("score", kampen.getGemiddeldeScore());
        return "overzicht.jsp";
    }

    private String bewerkForm(HttpServletRequest request, HttpServletResponse response) {
        String jaar = request.getParameter("jaar");

        request.setAttribute("kamp", kampen.vindKamp(jaar));
        return "bewerk.jsp";
    }


    private String zoekKampForm(HttpServletRequest request, HttpServletResponse response) {
        return "zoekKamp.jsp";
    }

    private String voegtoeForm(HttpServletRequest request, HttpServletResponse response) {
        return "toevoegen.jsp";
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }

    private String voegToe(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Kamp kamp = new Kamp();
        setJaar(kamp, request, errors);
        setPlaats(kamp, request, errors);
        setThema(kamp, request, errors);
        setScore(kamp, request, errors);

        if (errors.size() == 0) {
            try {
                kampen.voegToe(kamp);
                return overzicht(request, response);
            } catch (DomainException e) {
                errors.add(e.getMessage());
            }
        }

        request.setAttribute("errors", errors);
        return "toevoegen.jsp";
    }

    public void setScore(Kamp kamp, HttpServletRequest request, ArrayList<String> errors) {
        String score = request.getParameter("score");
        try {
            kamp.setScore(Integer.parseInt(score));
            request.setAttribute("scorePreviousValue", score);
        } catch (DomainException e) {
            errors.add(e.getMessage());
        } catch (NumberFormatException e) {
            errors.add("Vul een score tussen 0 en 10 in!");
        }
    }

    public void setThema(Kamp kamp, HttpServletRequest request, ArrayList<String> errors) {
        String thema = request.getParameter("kampthema");
        try {
            kamp.setThema(thema);
            request.setAttribute("themaPreviousValue", thema);
        } catch (DomainException e) {
            errors.add(e.getMessage());
        }
    }

    public void setJaar(Kamp kamp, HttpServletRequest request, ArrayList<String> errors) {
        String jaar = request.getParameter("jaar");
        try {
            kamp.setJaar(jaar);
            request.setAttribute("jaarPreviousValue", jaar);
        } catch (DomainException e) {
            errors.add(e.getMessage());
        }
    }

    public void setPlaats(Kamp kamp, HttpServletRequest request, ArrayList<String> errors) {
        String plaats = request.getParameter("kampplaats");
        try {
            kamp.setPlaats(plaats);
            request.setAttribute("plaatsPreviousValue", plaats);
        } catch (DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private String overzicht(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("alleKampen", kampen.getKampen());
        request.setAttribute("aantal", kampen.getAantalKampen());
        request.setAttribute("score", kampen.getGemiddeldeScore());
        return "overzicht.jsp";
    }

    private String verwijder(HttpServletRequest request, HttpServletResponse response) {
        String jaar = request.getParameter("jaar");

        request.setAttribute("kamp", kampen.vindKamp(jaar));
        return "verwijder.jsp";
    }

    private String verwijderBevestig(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("submit").equals("Bevestig")) {
            String jaar = request.getParameter("jaar");
            Kamp kamp = kampen.vindKamp(jaar);

            kampen.verwijderKamp(kamp);
            return overzicht(request, response);
        } else {
            return home(request, response);
        }
    }

    private String zoekKamp(HttpServletRequest request, HttpServletResponse response) {
        //Cookie opvragen
        Cookie zoekCount = getCookieWithKey(request, "zoekCount");

        //Cookie aanmaken als niet bestaat
        if (zoekCount == null) {
            zoekCount = new Cookie("zoekCount", "1");
        } else {
            //Aantal verhogen
            int aantalZoekopdrachten = Integer.parseInt(zoekCount.getValue()) + 1;

            zoekCount.setValue(Integer.toString(aantalZoekopdrachten));
        }

        //Waarde doorsturen
        response.addCookie(zoekCount);

        //Waarde vragen
        request.setAttribute("zoekCount", zoekCount.getValue());

        ArrayList<String> errors = new ArrayList<>();
        try {
            String jaar = request.getParameter("jaar");
            Kamp kamp = kampen.vindKamp(jaar);
            if (kamp != null) {
                request.setAttribute("kamp", kamp);
                return "gevonden.jsp";
            } else {
                return "nietGevonden.jsp";
            }
        } catch (DomainException e) {
            errors.add(e.getMessage());
            request.setAttribute("errors", errors);
            return "zoekKamp.jsp";
        }
    }

    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(key))
                return cookie;
        }
        return null;
    }
}