<%@ page import="Domain.model.Kamp" %>
<%@ page import="Domain.db.KampDb" %>
<% KampDb kampDb = new KampDb(); %>
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
<header>
    <nav>
        <ul>
            <li><a href="index.html" > Home </a></li>
            <li class = "active"><a href="overzicht.jsp"> Overzicht </a></li>
            <li><a href="toevoegen.html"> Toevoegen </a></li>
        </ul>
    </nav>
</header>
<main>
    <h1>Kampen</h1>
        <table>
            <thead>
                <th>Jaar</th>
                <th>Plaats</th>
                <th>Kampthema</th>
                <th>Score</th>
                <th>Verwijder</th>
            </thead>
            <tbody>
            <% for(Kamp kamp : kampDb.getKampen()) { %>
            <tr>
                <td><%=kamp.getJaar()%></td>
                <td><%=kamp.getPlaats()%></td>
                <td><%=kamp.getThema()%></td>
                <td><%=kamp.getScore()%></td>
                <td><a href="verwijder.html"> verwijderen </a> </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    <p>Aantal kampen: <%=kampDb.getAantalKampen() %></p>
    <p>Gemiddelde score kampen: <%=kampDb.getGemiddeldeScore() %></p>
</main>
</body>
</html>