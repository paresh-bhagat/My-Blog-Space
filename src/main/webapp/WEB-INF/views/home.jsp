<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jstl tag -->
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.111.3">
    <title>MyBlogSpace</title>
    
    <!--bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    
     <!-- mycss -->
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet" >

  </head>
  <body>
    
<header data-bs-theme="dark">
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="<c:url value="/" />" >MyBlogSpace</a>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" 
      aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">

        <span class="navbar-toggler-icon"></span>
      </button>
      
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
        
           <li class="nav-item">
           		<a class="nav-link" aria-current="page" href="#">Welcome ${user_id}</a>
           </li>
           
          <li class="nav-item">
          		<a class="nav-link" href="<c:url value="/myblogs" />">MyBlogs</a>
          </li>
          

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Topics</a>
            
            <ul class="dropdown-menu">
            
              <li><a class="dropdown-item" href="#">

                <div class="form-check">
                  <input class="form-check-input" type="radio" name="flexRadioDefault" value="all" id="flexRadioDefault1" checked>
                  <label class="form-check-label" for="flexRadioDefault1">All topics</label>
                </div>
				</a>
			 </li>
			 
			 <!-- divider -->
			 
			<li><hr class="dropdown-divider"></li>
			
			<!--  blog topics as radio buttons -->
			
			<c:forEach items="${blogs}" var="entry"> 
			
              <li>
              	<a class="dropdown-item" href="#">
                <div class="form-check">
                	<input class="form-check-input" type="radio" name="flexRadioDefault" value="${entry.key}" id="flexRadioDefault1">
                	<label class="form-check-label" for="flexRadioDefault1">${entry.key}</label>
                </div>
              	</a>
              </li>

           </c:forEach>
	
			<!-- -end here -->
			
            </ul>
          </li>

        </ul>
        
         <a class="btn btn-outline-secondary" href="<c:url value="/" />" role="button">LogOut</a>
        
      </div>
    </div>
  </nav>
</header>

<main>

  <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" 
        focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <div class="container">
          <div class="carousel-caption text-start">
            <h1>Example headline.</h1>
            <p>Some representative placeholder content for the first slide of the carousel.</p>
            <p><a class="btn btn-lg btn-primary" href="#">Sign up today</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" 
        focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <div class="container">
          <div class="carousel-caption">
            <h1>Another example headline.</h1>
            <p>Some representative placeholder content for the second slide of the carousel.</p>
            <p><a class="btn btn-lg btn-primary" href="#">Learn more</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" 
        focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <div class="container">
          <div class="carousel-caption text-end">
            <h1>One more for good measure.</h1>
            <p>Some representative placeholder content for the third slide of this carousel.</p>
            <p><a class="btn btn-lg btn-primary" href="#">Browse gallery</a></p>
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>

  <div class="container marketing">

	<!-- for loop for each section -->
	
	<c:forEach items="${blogs}" var="entry">        
            
      <section id="section1" class="section ${entry.key} box">

      <div class="container py-5" id="custom-cards">
        <h2 class="pb-2 border-bottom">${entry.key}</h2>
    
        <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
    		
    	<!-- for loop for blogs  -->
    	<c:if test="${empty entry.value}">
    		<p class="lead"> Oops! No blogs found at the moment</p>
    	</c:if>
    
    	<!-- collection is not empty below if condition will be executed -->
    	<c:if test="${not empty entry.value}">
    		<c:forEach items="${entry.value}" var="blog">
    	  
          <div class="col">
          
            <div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg"
             style="background-image: url('<c:url value="/resources/images/${blog[0]}.jpg"/>');">
        
              <div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
                <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold"><c:out value="${blog[1]}"/></h3>
                <ul class="d-flex list-unstyled mt-auto">
                  <!--
                  <li class="me-auto">
                    <img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" 
                    class="rounded-circle border border-white">
                  </li>  
                  -->
                  <li class="d-flex align-items-center me-3">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>
                    <small><c:out value="${blog[2]}"/></small>
                  </li>
                  <li class="d-flex align-items-center">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>
                    <small><c:out value="${blog[3]}"/></small>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          
          </c:forEach>
    	</c:if>
    	  
        </div>
      </div>
      
      
    </section>
            
    </c:forEach>
    <!--section1--> 

  </div>
  
  <!-- /.container -->


  <!-- FOOTER -->
  <footer class="container">
    <p class="float-end"><a href="#">Back to top</a></p>
    <p>&copy; 2023-2024 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
  </footer>

</main>

<!-- bootstrap js -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- my js -->
<script src="<c:url value="/resources/js/home.js" />"></script>

  </body>
</html>