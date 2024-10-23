<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Demo</title>
    <%@ include file="links.jsp" %>
  </head>
 
  <body>
    <%@ include file="header.jsp" %>
    <div class="container py-4 d-flex flex-column justify-content-center align-items-center">
   <a href="<%= application.getContextPath() %>/feedback.jsp">
    <button class="btn btn-light">Give Feedback</button></a>
    </div>
    <%@ include file="script.jsp" %>
  </body>
</html>
