<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="stijl.css">
    <title>Kampen | Toevoegen</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="voegToe"/>
</jsp:include>
<main>
    <h1>Kamp toevoegen</h1>
    <c:if test="${not empty errors}">
        <div class="error">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form method="post" action="Servlet?command=voegtoe" novalidate>
        <p>
            <label for="jaar">Jaar</label>
            <input id="jaar" name="jaar" type="text" placeholder="Jaar kamp"
                   value="${jaarPreviousValue}">
        </p>
        <p>
            <label for="kampplaats">Kampplaats</label>
            <input id="kampplaats" name="kampplaats" type="text" placeholder="Kampplaats"
                    value="${plaatsPreviousValue}">
        </p>
        <p>
            <label for="kampthema">Kampthema</label>
            <input id="kampthema" name="kampthema" type="text" placeholder="kampthema"
                   value="${themaPreviousValue}">
        </p>
        <p>
            <label for="score">Score</label>
            <input id="score" name="score" type="number" placeholder="Score op 10"
                   value="${scorePreviousValue}">
        </p>
        <p>
            <button class="Button" id="submit" type="submit">Bevestig</button>
        </p>
    </form>
</main>
</body>
</html>