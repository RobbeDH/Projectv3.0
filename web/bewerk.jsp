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
            <input id="Score" name="score" type="number" placeholder="Score op 10" required="" ${kamp.score}>
        </p>
        <p>
            <button type="submit">Update</button>
        </p>
    </form>
</main>
</body>
</html>
