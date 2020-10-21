<%@ page import="Domain.model.Kamp" %>
<%@ page import="Domain.db.KampDb" %>
<%@ page import="java.util.Collection" %>
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
            <li><a href="Servlet?command=home" > Home </a></li>
            <li class="active"><a href="Servlet?command=overzicht"> Overzicht </a></li>
            <li><a href="toevoegen.jsp"> Toevoegen </a></li>
            <li><a href="zoekKamp.jsp"> Zoek Kamp</a></li>
        </ul>
    </nav>
</header>
<main>
    <h1>Kampen</h1>
    <%
        Collection<Kamp> kampen = (Collection<Kamp>) request.getAttribute("kampen");
    %>
        <table>
            <thead>
                <th>Jaar</th>
                <th>Plaats</th>
                <th>Kampthema</th>
                <th>Score</th>
                <th>Verwijder</th>
            </thead>
            <tbody>
            <% for(Kamp kamp : kampen) { %>
            <tr>
                <td><%=kamp.getJaar()%></td>
                <td><%=kamp.getPlaats()%></td>
                <td><%=kamp.getThema()%></td>
                <td><%=kamp.getScore()%></td>
                <td><a href="Servlet?command=verwijder&jaar=<%=kamp.getJaar()%>&thema=<%=kamp.getThema()%>"> verwijderen </a> </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    <p>Aantal kampen: <%=request.getAttribute("aantal") %></p>
    <p>Gemiddelde score kampen: <%=request.getAttribute("score") %></p>
</main>
</body>
</html>