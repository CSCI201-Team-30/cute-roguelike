<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RMC</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
    <style>
    	@import url('https://fonts.googleapis.com/css?family=PT+Sans');
		
		body {
		  background: #fff;
		  font-family: 'PT Sans', sans-serif;
		}
		.navbar-toggler {
		  margin-left: auto;
		}
		.navbar {
		  background-color: #da5767 !important;
		}
		
		.navbar-nav li a {
		  color: #fff;
		}
		
		.navbar-nav li a:hover {
		  color: 3D405B;
		}
		
		h2 {
		  padding-top: 1.5rem;
		}
		
		a {
		  color: #333;
		}
		
		a:hover {
		  color: #da5767;
		  text-decoration: none;
		}
		
		.card {
		  border: 0.40rem solid #f8f9fa;
		  top: 10%;
		}
		
		.form-control {
		  background-color: #f8f9fa;
		  padding: 20px;
		  padding: 25px 15px;
		  margin-bottom: 1.3rem;
		}
		
		.form-control:focus {
		  color: #000000;
		  background-color: #ffffff;
		  border: 3px solid #da5767;
		  outline: 0;
		  box-shadow: none;
		}
		
		.btn {
		  padding: 0.6rem 1.2rem;
		  background: #da5767;
		  border: 2px solid #da5767;
		}
		
		.btn-primary:hover {
		  background-color: #df8c96;
		  border-color: #df8c96;
		  transition: .3s;
		}
		
		@media only screen and (max-width: 768px) {
		  .navbar-toggler {
		    float: right !important;
		  }
		  .navbar-collapse {
		    text-align: right !important;
		  }
		  .navbar-nav {
		    margin-left: auto;
		  }
		
		}

    	
    </style>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="main.jsp">Rate My Course</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="right-nav">
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="registration.jsp">Register/Login</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </nav>
	<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-5">
      <div class="card">
        <h2 class="card-title text-center">Register </h2>
        <div class="card-body py-md-4">
          <form action="RegisterServlet" method="post">
            <div class="form-group">
              <input type="text" class="form-control" id="name" name="name" placeholder="Name">
            </div>
            <div class="form-group">
              <input type="email" class="form-control" id="email" name="email" placeholder="Email">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" id="confirm-password" name="confirm-password" placeholder="confirm-password">
            </div>
            <div class="d-flex flex-row align-items-center justify-content-between">
              <a href="login.jsp">Login</a>
              <button type="submit" class="btn btn-primary">Create Account</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
