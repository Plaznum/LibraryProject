<div class="container login">
	<h2 class="text-center">Welcome!</h2>
	<div class="row mt-2 d-flex justify-content-center"></div>
	<form class= "m-auto d-flex flex-column justify-content-center align-content-center" method="POST" action=LibrarianServlet>
         <div id="username" class="form-text">Please enter your username and password</div>
	  <div class="mb-3 input-group">
		<span class="input-group-text">Username: </span>
		<input type="text" class="form-control" aria-label="username" aria-describedby="username" placeholder="JonnyBonanza72" name="username">
	  </div>
	  <div class="mb-3 input-group">
		<span class="input-group-text">Password: </span>
		<input type="password" class="form-control" aria-label="password" aria-describedby="password" name="password">
	  </div>
	  <div class= "d-flex justify-content-around align-content-center">
  		  <button type="submit" class="btn btn-success col-4" name="action" value="login">Login</button>	
  		  <button type="submit" class="btn btn-success col-4" name="action" value="new">New User</button>
	  </div>
	</form>
  	
</div>