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
    	<h3>Fill the FeedBack Form</h3>
    	<form action="<%=application.getContextPath() %>/feedback" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" name ="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text text-white" >We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Phone Number</label>
    <input type="text" name ="PhoneNumber" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Your FeedBack Message</label>
    <textarea rows="10" name="feedbackMessage" class="form-control" cols=""></textarea>
  </div>
  <div class="container text-center">
    <button type="submit" class="btn btn-warning">Submit</button>
     <button type="submit" class="btn btn-light">Reset</button>
  </div>

</form>
    </div>
    <%@ include file="script.jsp" %>
  </body>
</html>
