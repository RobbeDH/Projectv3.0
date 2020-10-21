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
<header>
    <nav>
        <ul>
            <li><a href="Servlet?command=home" > Home </a></li>
            <li><a href="Servlet?command=overzicht"> Overzicht </a></li>
            <li class="active"><a href="toevoegen.jsp"> Toevoegen </a></li>
            <li><a href="zoekKamp.jsp"> Zoek Kamp</a></li>
        </ul>
    </nav>
</header>
<main>
    <h1>Kamp toevoegen</h1>
    <form method="post" action="Servlet?command=voegtoe">
        <p>
            <label for="jaar">Jaar</label>
            <input id="jaar" name="jaar" type="text" placeholder="Jaar kamp" required="">
        </p>
        <p>
            <label for="kampplaats">Kampplaats</label>
            <input id="kampplaats" name="kampplaats" type="text" placeholder="Kampplaats" required="">
        </p>
        <p>
            <label for="kampthema">Kampthema</label>
            <input id="kampthema" name="kampthema" type="text" placeholder="kampthema" required="">
        </p>
        <p>
            <label for="Score">Score</label>
            <input id="Score"  name="score" placeholder="Score op 10" required="">
        </p>
        <p>
            <button type="submit">Bevestig</button>
        </p>
    </form>
</main>
</body>
</html>