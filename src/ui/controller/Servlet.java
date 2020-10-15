package ui.controller;

import Domain.model.Kamp;

import java.io.IOException;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String jaar = request.getParameter("jaar");
        String kampplaats = request.getParameter("kampplaats");
        String kampthema = request.getParameter("kampthema");
        String scoreform = request.getParameter("score");
        int score = Integer.parseInt(scoreform);

        Kamp kamp = new Kamp(kampplaats,kampthema,score,jaar);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
