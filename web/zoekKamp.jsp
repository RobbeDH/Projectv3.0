<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 12/10/2020
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="stijl.css">
    <title>Kamp zoeken</title>
</head>
<header>
    <nav>
        <ul>
            <li><a href="Servlet?command=home"> Home </a></li>
            <li><a href="Servlet?command=overzicht"> Overzicht </a></li>
            <li><a href="toevoegen.jsp"> Toevoegen </a></li>
            <li class="active"><a href="zoekKamp.jsp"> Zoek Kamp</a></li>
        </ul>
    </nav>
</header>
<body>
<h1>Kamp zoeken</h1>
<form method="GET" action="Servlet">
    <p>
        <label for="jaar"> Jaar </label>
        <input id="jaar" name="jaar">
        <input type="hidden" name="command" value="zoekKamp">
    </p>
    <p>
        <button type="submit">Zoek</button>
    </p>
</form>
</body>
</html>
