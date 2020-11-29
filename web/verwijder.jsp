<%@ page import="Domain.model.Kamp" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="stijl.css">
    <title>Kampen | Verwijderen</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="Servlet?command=home" > Home </a></li>
            <li><a href="Servlet?command=overzicht"> Overzicht </a></li>
            <li><a href="toevoegen.jsp"> Toevoegen </a></li>
            <li><a href="zoekKamp.jsp"> Zoek Kamp</a></li>
        </ul>
    </nav>
</header>
<main>
    <h2>Kamp verwijderen</h2>
    <p>Weet je zeker dat je ${kamp.jaar} ${kamp.thema} wilt verwijderen?</p>
    <form action="Servlet?command=verwijderBevestig" method="post">
        <input type="hidden" name="jaar" value="${kamp.jaar}">
        <button type="submit">Bevestig</button>
        <button type="submit">Annuleren</button>
    </form>

</main>
</body>
</html>