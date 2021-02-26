<%@page import="com.cognixia.jump.model.Patron"%>
<%@page import="java.util.List"%>
<%@ include file = "header.jsp" %>
<div class="container librarians">
	<div class="row users mt-5">
		<div class="d-flex justify-content-center align-content-center">
			<div class="col-4">
				<div class="mt-3 input-group">
					<a href= "./editlibrarian.jsp" type="button" class="btn btn-outline-secondary" name="searchBook" value="searchBook">Edit Librarian</a>
			  	</div>
			</div>
			<h1 class="text-center col-4">Users</h1>
			<div class="col-4">
				<div class="mt-3 input-group">
					<span class="input-group-text">Username: </span>
					<input type="text" class="form-control" aria-label="username" aria-describedby="username" placeholder="Username" name="username">
					<button type="button" class="btn btn-outline-primary" name="searchUser" value="searchUser">Search User</button>
			  	</div>
			</div>
		</div>
		<div class="m-auto">
			    <form method="POST" action=LibrarianServlet>
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">First</th>
			      <th scope="col">Last</th>
			      <th scope="col">Username</th>
			      <th scope="col">Status</th>
			      <th scope="col">Tools</th>
			    </tr>
			  </thead>
			  <tbody>
			    <%List<Patron> patrons = (List<Patron>) request.getAttribute("patrons");
			    if (patrons != null){
			    	for (Patron patron: patrons){
			    %>
			    <tr>
			    <th><%=patron.getId() %></th>
			    <td><%=patron.getFirst_name() %></td>
			    <td><%=patron.getLast_name() %></td>
			    <td><%=patron.getUsername() %></td>
			    <td><%=patron.isAccount_frozen()%></td>
			    <td>
			      	<button type="submit" class="btn btn-outline-info" name="changeStatus" value=<%= "\"" +patron.getId()+ "\"" %>><%=patron.isAccount_frozen()?"frozen":"open" %></button>
			      </td>	
			    </tr>
			    
			    <% }
			    	}%>
			  </tbody>
			</table>
			      </form>
		</div>
	</div>
	
	<div class="row users mt-5">
		<div class="d-flex justify-content-center align-content-center">
			<div class="col-4">
				<div class="mt-3 input-group">
					<span class="input-group-text">Add Book</span>
					<a href= "./addbook.jsp" type="button" class="btn btn-outline-primary" name="searchBook" value="searchBook">+</a>
			  	</div>
			</div>
			<h1 class="text-center col-4">Books</h1>
			<div class="col-4">
				<div class="mt-3 input-group">
					<span class="input-group-text">ISBN: </span>
					<input type="text" class="form-control" aria-label="isbn" aria-describedby="isbn" placeholder="ISBN" name="isbn">
					<button type="button" class="btn btn-outline-primary" name="searchBook" value="searchBook">Search Book</button>
			  	</div>
			</div>
		</div>
		<div class="m-auto">
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">ISBN</th>
			      <th scope="col">Title</th>
			      <th scope="col">Description</th>
			      <th scope="col">Available</th>
			      <th scope="col">Date Added</th>
			      <th scope="col">Tools</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th>1</th>
			      <td>1234567890</td>
			      <td>The Great Gatsy</td>
			      <td>A social satire on the glamourous twenties in the US.</td>
			      <td>Yes</td>
			      <td>02/25/2021</td>
			      <td>
			      	<button type="button" class="btn btn-outline-primary" name="edit" value="edit">Edit</button>
			      </td>	
			    </tr>
			    <tr>
			      <th>2</th>
			      <td>1234567891</td>
			      <td>Don Quixote</td>
			      <td>A retired country gentleman lives in an unnamed section of La Mancha with his niece and housekeeper.</td>
			      <td>Yes</td>
			      <td>02/25/2021</td>
			      <td>
			      	<button type="button" class="btn btn-outline-primary" name="edit" value="edit">Edit</button>
			      </td>	
			    </tr>
			    <tr>
			      <th>3</th>
			      <td>1234567892</td>
			      <td>Moby Dick</td>
			      <td>Captain Ahab and his monomaniacal pursuit of the white whale.</td>
			      <td>No</td>
			      <td>02/25/2021</td>
			      <td>
			      	<button type="button" class="btn btn-outline-primary" name="edit" value="edit">Edit</button>
			      </td>
			    </tr>
			  </tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file = "footer.jsp" %>