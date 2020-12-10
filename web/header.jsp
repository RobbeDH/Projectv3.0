<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 17/11/2020
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav>
        <ul>
            <li ${param.actual eq 'Home'?"class = active":""}>
                <a href="Servlet?command=home">Home</a></li>
            <li ${param.actual eq 'voegToe'?"class = active":""}>
                <a href="Servlet?command=voegtoeForm">Voeg Toe</a></li>
            <li ${param.actual eq 'Overzicht'?"class = active":""}>
                <a href="Servlet?command=overzicht">Overzicht</a></li>
            <li ${param.actual eq 'zoekForm'?"class = active":""}>
                <a href="Servlet?command=zoekKampForm">Zoek</a></li>
        </ul>
    </nav>
</header>
