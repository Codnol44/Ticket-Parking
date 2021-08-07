<%@ page import="fr.eni.bo.Ticket" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Ticket</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
</head>
<body>
    <h1>BIENVENUE AU PARKING "DONNE-TES-SOUS"</h1>

<div class="fond">
    <div>
        <form method="post" action="http://localhost:8080/Ticket_Parking_war_exploded/ticket">
            <div>
                <span class="input-group-text" >Merci de saisir les informations nécessaires à l'édition de votre ticket : <sup class="text-danger"></sup></span><br>
                <label for="numero">Saisissez votre n° de ticket à 5 chiffres svp : </label><input type="text" name="numero" id="numero" required>
                <label for="date_jour">Date : </label><input type="date" name="date_jour" id="date_jour" required>
                <label for="heuredeb">Heure : </label><input type="time" name="heuredeb" id="heuredeb" required>
                <label for="heurefin">Heure : </label><input type="time" name="heurefin" id="heurefin" required>
            </div>
            <button class="btn2" type="submit">Valider</button>
        </form>
    </div>
</div>

</body>
</html>