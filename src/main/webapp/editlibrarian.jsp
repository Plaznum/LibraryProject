<%@ include file = "header.jsp" %>
<body>
	<div class="container mt-5">
	<h2 class="text-center">Edit your account</h2>
	<div class="row mt-2 d-flex justify-content-center"></div>
	<form class= "m-auto d-flex flex-column justify-content-center align-content-center" method="POST" action="LibrarianServlet">
      <div id="username" class="form-text">Please enter your email and password</div>
         
	  <div class="mb-3 input-group">
		<div class="input-group-prepend">
			<span class="input-group-text">Email: </span>
		</div>
		<input type="text" class="form-control" aria-label="username" aria-describedby="username" name="username">
	  </div>
	  
	  <div class="mb-3 input-group">
		<div class="input-group-prepend">
			<span class="input-group-text">Password: </span>
		</div>
		<input type="password" class="form-control" aria-label="password" aria-describedby="password" name="password">
	  </div>
	  
	  <div class= "d-flex justify-content-around align-content-center">
  		  <button type="submit" class="btn btn-success col-4" name="action" value="edit">Edit account</button>
	  </div>
	</form>
</div>
</body>
<%@ include file = "footer.jsp" %>