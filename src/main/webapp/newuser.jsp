<%@ include file = "header.jsp" %>
<body>
	<div class="container mt-5">
	<h2 class="text-center">Create your account</h2>
	<div class="row mt-2 d-flex justify-content-center"></div>
	<form class= "m-auto d-flex flex-column justify-content-center align-content-center">
      <div id="username" class="form-text">Please enter your first name, last name, username and password</div>
         
      <div class="mb-3 input-group">
		<div class="input-group-prepend">
			<span class="input-group-text">First name: </span>
		</div>
		<input type="text" class="form-control" aria-label="firstname" aria-describedby="firstname" name="firstname">
	  </div>
	  
	  <div class="mb-3 input-group">
		<div class="input-group-prepend">
			<span class="input-group-text">Last name: </span>
		</div>
		<input type="text" class="form-control" aria-label="lastname" aria-describedby="lastname" name="lastname">
	  </div>
         
	  <div class="mb-3 input-group">
		<div class="input-group-prepend">
			<span class="input-group-text">Username: </span>
		</div>
		<input type="text" class="form-control" aria-label="username" aria-describedby="username" name="username">
	  </div>
	  
	  <div class="mb-3 input-group">
		<div class="input-group-prepend">
			<span class="input-group-text">Password: </span>
		</div>
		<input type="text" class="form-control" aria-label="password" aria-describedby="password" name="password">
	  </div>
	  
	  <div class= "d-flex justify-content-around align-content-center">
  		  <button type="submit" class="btn btn-success col-4" name="action" value="create">Create account</button>
	  </div>
	</form>
</div>
</body>
<%@ include file = "footer.jsp" %>