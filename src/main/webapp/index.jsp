<%@ include file = "header.jsp" %>
	<div class="container">
		<h2>Welcome! Please Login:</h2>
		<form>
		  <div class="mb-3">
		    <label for="username" class="form-label">Username:</label>
		    <input type="text" class="form-control" id="username" aria-describedby="username">
		    <div id="username" class="form-text">Please enter your username</div>
		  </div>
		  <div class="mb-3">
		    <label for="password" class="form-label">Password</label>
		    <input type="password" class="form-control" id="password">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
<%@ include file = "footer.jsp" %>