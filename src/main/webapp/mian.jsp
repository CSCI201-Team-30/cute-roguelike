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
		
		
		 
		.checked {
		  color: orange;
		}
		
		.container {
		  display: flex;
		  justify-content: center;
		  align-items: center;
		  /* height: 100vh; */
		  padding-top: 50px;
		  padding-bottom: 50px;
		  margin-top: 10px;
		  margin-bottom: 10px;
		}
		
		.app .card {
		  width: 90vw;
		  height: auto;
		  background: #da5767;
		  border-radius: 10px;
		  box-sizing: border-box;
		  padding: 30px;
		}
		
		.app .card .title {
		  color: #ffffff;
		  font-size: 22px;
		  margin-left: 35px;
		}
		
		.app .card .search-wrapper {
		  position: relative;
		  display: flex;
		  justify-content: center;
		  align-items: center;
		}
		
		.app .card .search-wrapper img {
		  width: 23px;
		  height: 23px;
		  position: absolute;
		  left: 50px;
		  color: #8c8aa7;
		}
		
		.app .card input[type="text"] {
		  width: 80%;
		  height: 70px;
		  background: white;
		  border: 1px solid #49485d;
		  border-radius: 10px;
		  margin: 18px 0px;
		  box-sizing: border-box;
		  padding-left: 55px;
		  font-size: 18px;
		  color: #8c8aa7;
		  cursor: text;
		}
		
		.app .card input[type="text"]:focus {
		  outline: none !important;
		}
		
		.app .card .reviews-list {
		  display: flex;
		  flex-direction: column;
		  justify-content: center;
		  align-items: center;
		}
		
		.app .card .reviews-list .review-card {
		  display: flex;
		  flex-direction: column;
		  justify-content: space-around;
		  width: 80%;
		  margin: 20px 0px;
		}
		
		.app .card .reviews-list .review-card .review-header {
		  display: flex;
		  flex-direction: row;
		  justify-content: space-between;
		  align-items: center;
		  margin-bottom: 10px;
		}
		
		.app .card .reviews-list .review-card .review-header .name-group {
		  display: flex;
		  flex-direction: row;
		  align-items: center;
		}
		
		.app .card .reviews-list .review-card .review-header .name-group .initials {
		  width: 50px;
		  height: 50px;
		  background: #8780f8;
		  border-radius: 50%;
		  display: flex;
		  justify-content: center;
		  align-items: center;
		  color: #ffffff;
		  font-size: 20px;
		  margin-right: 10px;
		}
		
		.app .card .reviews-list .review-card .review-header .name-group p {
		  font-size: 18px;
		  color: Black;
		  margin: 0px;
		}
		
		.app .card .reviews-list .review-card .review-header .rating {
		font-size: 24px;
		}
		
		.app .card .reviews-list .review-card .review-header .rating {
		color: #f1c40f;
		}
		
		
		.review-card {
		  background-color: white;
		  border-radius: 10px;
		  padding: 20px;
		  color: black;
		}
    	
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <div class="app">
            <div class="card">
                <div class="title">Reviews</div>
                <div class="search-wrapper">
                    <img id="search-icon" src="https://assets.codepen.io/1839803/search-icon.svg" />
                    <input id="search-field" type="text" placeholder="Search reviews" />
                </div>
               
                <div class="reviews-list">
                    <div class="review-card">
                        <div class="review-header">
                            <div class="name-group">
                                <div class="initials">M</div>
                                <p>Marco Papa</p>
                            </div>
                            <div class="rating">
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star"></span>
                                <span class="fa fa-star"></span>
                            </div>
                        </div>
                        <div class="review-description">
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </div>
                        <div class="review-details">
                            <div class="review-date">April 14, 2023</div>
                        </div>
                    </div>
                    <div class="review-card">
                        <div class="review-header">
                            <div class="name-group">
                                <div class="initials">V</div>
                                <p>Victor Adamchikp</p>
                            </div>
                            <div class="rating">
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                            </div>
                        </div>
                        <div class="review-description">
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </div>
                        <div class="review-details">
                            <div class="review-date">April 14, 2023</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
      
    
	
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"></script>
      
</body>
</html>
