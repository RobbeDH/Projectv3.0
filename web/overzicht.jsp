<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="stijl.css">
    <title>Kampen | Overzicht</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="overzicht"/>
</jsp:include>
<main>
    <h1>Kampen</h1>

    <table>
        <thead>
        <th>Jaar</th>
        <th>Plaats</th>
        <th>Kampthema</th>
        <th>Score</th>
        <th>Verwijder</th>
        <th>Bewerk</th>
        </thead>
        <c:forEach var="kamp" items="${alleKampen}">
        <tbody>
        <tr>
            <td>${kamp.jaar}</td>
            <td>${kamp.plaats}</td>
            <td>${kamp.thema}</td>
            <td>${kamp.score}</td>
            <td><a href="Servlet?command=verwijder&jaar=${kamp.jaar}&thema=${kamp.thema}"> verwijderen </a></td>
            <td><a href="Servlet?command=bewerkForm&jaar=${kamp.jaar}&thema=${kamp.thema}"> bewerken </a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>Aantal kampen: ${aantal}</p>
    <p>Gemiddelde score kampen: ${score} </p>
</main>
</body>
</html>