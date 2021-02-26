<div class="container librarians">
	<div class="row users mt-5">
		<div class="d-flex justify-content-center align-content-center">
			<div class="col-4"></div>
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
			    <tr>
			      <th>1</th>
			      <td>Mark</td>
			      <td>Otto</td>
			      <td>Bookworm</td>
			      <td>Frozen</td>
			      <td>
			      	<button type="button" class="btn btn-outline-danger" name="changeStatus" value="changeStatus">Unfreeze</button>
			      </td>
			    </tr>
			    <tr>
			      <th>2</th>
			      <td>Buster</td>
			      <td>Rhymes</td>
			      <td>Buzzter</td>
			      <td>Frozen</td>
			      <td>
			      	<button type="button" class="btn btn-outline-danger" name="changeStatus" value="changeStatus">Unfreeze</button>
			      </td>	 
			    </tr>
			    <tr>
			      <th>3</th>
			      <td>Larry</td>
			      <td>Bird</td>
			      <td>theLegend</td>
			      <td>Open</td>
			      <td>
			      	<button type="button" class="btn btn-outline-info" name="changeStatus" value="changeStatus">Freeze</button>
			      </td>	 
			    </tr>
			  </tbody>
			</table>
		</div>
	</div>
	
	<div class="row users mt-5">
		<div class="d-flex justify-content-center align-content-center">
			<div class="col-4">
				<div class="mt-3 input-group">
					<span class="input-group-text">Add Book</span>
					<button type="button" class="btn btn-outline-primary" name="searchBook" value="searchBook">+</button>
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