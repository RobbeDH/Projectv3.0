package ui.controller;

import Domain.db.KampDb;
import Domain.model.Kamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    KampDb kampen = new KampDb();

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
            default:
                destination = home(request, response);
        }

        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }

    private String voegToe(HttpServletRequest request, HttpServletResponse response) {
        String jaar = request.getParameter("jaar");
        String kampplaats = request.getParameter("kampplaats");
        String kampthema = request.getParameter("kampthema");
        String scoreform = request.getParameter("score");
        int score = Integer.parseInt(scoreform);

        Kamp kamp = new Kamp(kampplaats, kampthema, score, jaar);
        kampen.voegToe(kamp);
        request.setAttribute("kampen", kampen.getKampen());
        request.setAttribute("aantal", kampen.getAantalKampen());
        request.setAttribute("score", kampen.getGemiddeldeScore());
        return "overzicht.jsp";
    }

    private String overzicht(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("kampen", kampen.getKampen());
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
        String jaar = request.getParameter("jaar");
        Kamp kamp = kampen.vindKamp(jaar);

        kampen.verwijderKamp(kamp);
        request.setAttribute("kampen", kampen.getKampen());
        request.setAttribute("aantal", kampen.getAantalKampen());
        request.setAttribute("score", kampen.getGemiddeldeScore());
        return "overzicht.jsp";
    }

    private String zoekKamp(HttpServletRequest request, HttpServletResponse response) {
        String jaar = request.getParameter("jaar");
        Kamp kamp = kampen.vindKamp(jaar);
        if (kamp != null) {
            request.setAttribute("kamp", kamp);
            return "gevonden.jsp";
        } else {
            return "nietGevonden.jsp";
        }
    }
}