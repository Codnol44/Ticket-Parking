<%@ page import="fr.eni.bo.Ticket" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Facture</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
</head>

<body>

<div id="res">
    <%
        out.print("<div><u>Voici votre facture cumulee au sein de notre societe de parking : </u></div></br>");
        List<Ticket> ticketList = (List<Ticket>) request.getAttribute("ticketList");
        for (Ticket item : ticketList) {
            out.print("<div>- Le " + item.getDate_jour() + " entre : " + item.getHeure_deb() + " et : " + item.getHeure_fin() + ", au tarif de : " + item.getMontant() + " Euros.</div></br>");
        }
        int total = (int) request.getAttribute("total");
    %>
    <div><u>Pour un total de ${total} Euros. Merci de régler au plus vite votre note de parking !</u></div></br>
</div>

<div class="row">
    <div class="col">
        <form action="http://localhost:8080/Ticket_Parking_war_exploded/reglement" method="get">
            <div>
                <label for="total">Somme à payer : </label><input type="text" name="total" id="total" required>
                <label for="paiement">Somme versée pour la règlement : </label><input type="text" name="paiement" id="paiement" required>
            </div>
            <button class="btn" type="submit">Payer la facture</button>
        </form>
    </div>
</div>

<div class="row">
    <div class="col">
        <form action="http://localhost:8080/Ticket_Parking_war_exploded/ticket" method="get">
            <button class="btn" type="submit">Retout à la borne "tickets"</button>
        </form>
    </div>
</div>

</body>
</html>
