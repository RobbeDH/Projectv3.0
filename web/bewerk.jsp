<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="stijl.css">
    <title>Kampen | Bewerken</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <h1>Kamp bewerken</h1>
    <c:if test="${not empty errors}">
        <div class="error">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form method="post" action="Servlet?command=bewerk" novalidate>
        <p>
            <label for="jaar">Jaar</label>
            <input id="jaar" name="jaar" type="text" placeholder="Jaar kamp" readonly="" value="${kamp.jaar}">
        </p>
        <p>
            <label for="kampplaats">Kampplaats</label>
            <input id="kampplaats" name="kampplaats" type="text" placeholder="Kampplaats" required=""
                   value="${kamp.plaats}">
        </p>
        <p>
            <label for="kampthema">Kampthema</label>
            <input id="kampthema" name="kampthema" type="text" placeholder="kampthema" required=""
                   value="${kamp.thema}">
        </p>
        <p>
            <label for="Score">Score</label>
            <input id="Score" name="score" type="number" placeholder="Score op 10" required="" value="${kamp.score}">
        </p>
        <p>
            <button class="Button" type="submit">Update</button>
        </p>
    </form>
    <h2>Recent bewerkte kampen</h2>
    <table>
        <thead>
        <th>Jaar</th>
        <th>Plaats</th>
        <th>Kampthema</th>
        <th>Score</th>
        </thead>
        <c:forEach var="kamp" items="${kampen}">
        <tbody>
        <tr>
            <td>${kamp.jaar}</td>
            <td>${kamp.plaats}</td>
            <td>${kamp.thema}</td>
            <td>${kamp.score}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>
