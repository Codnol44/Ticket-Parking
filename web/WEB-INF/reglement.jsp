<%@ page import="fr.eni.bo.Ticket" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Reglement</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
</head>

<body>

<div id="res">
  <%
    out.print("<div><u>Voici votre monnaie : </u></div></br>");
    request.getAttribute("sommerendue");
  %>
  <div><u> ${sommerendue} Euros.</br></br> Très bonne journée et à bientôt chez nous !</u></div></br>
</div>

<div class="row">
  <div class="col">
    <form action="http://localhost:8080/Ticket_Parking_war_exploded/ticket" method="get">
      <button class="btn" type="submit">Revenir à la page de règlement d'un ticket</button>
    </form>
  </div>
</div>

</body>
</html>
