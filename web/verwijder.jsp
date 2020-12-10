<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="header.jsp"/>
<main>
    <h2>Kamp verwijderen</h2>
    <p>Weet je zeker dat je ${kamp.jaar} ${kamp.thema} wilt verwijderen?</p>
    <form action="Servlet?command=verwijderBevestig" method="post">
        <input type="hidden" name="jaar" value="${kamp.jaar}">
        <input name="submit" class="Button" value="Bevestig" type="submit">
        <input name="submit" class="Button" value="Annuleer" type="submit">
    </form>

</main>
</body>
</html>