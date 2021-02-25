<%@ include file = "header.jsp" %>
<body>
	<div class="container mt-5">
		<h2 class="text-center">Welcome!</h2>
		<div class="row mt-2 d-flex justify-content-center"></div>
		<form class= "m-auto d-flex flex-column justify-content-center align-content-center">
          <div id="username" class="form-text">Please enter your username and password</div>
		  <div class="mb-3 input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">Username: </span>
			</div>
			<input type="text" class="form-control" aria-label="username" aria-describedby="username" placeholder="JonnyBonanza72" name="username">
		  </div>
		  <div class="mb-3 input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">Password: </span>
			</div>
			<input type="text" class="form-control" aria-label="password" aria-describedby="password" name="password">
		  </div>
  		  <button type="submit" class="btn btn-success col-3 m-auto">Login</button>	  
		</form>
	</div>
</body>
<%@ include file = "footer.jsp" %>