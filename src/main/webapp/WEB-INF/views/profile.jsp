<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jstl tag -->
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MyBlogSpace</title>

    <!--bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" 
    crossorigin="anonymous">
	
	<!-- mycss -->
    <link rel="stylesheet" href="<c:url value="/resources/css/profile.css" />">

  </head>
  
  <body>
    
    <header data-bs-theme="dark">
  		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    		<div class="container-fluid">
      			<a class="navbar-brand" href="<c:url value="/" />">MyBlogSpace</a>

      			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" 
      			aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">

        		<span class="navbar-toggler-icon"></span>
      			</button>
      			
      		<div class="collapse navbar-collapse" id="navbarCollapse">
      
        		<ul class="navbar-nav me-auto mb-2 mb-md-0">
        
          			<li class="nav-item">
            			<a class="nav-link" aria-current="page" href="<c:url value="/feed" />">Feed</a>
          			</li>
          
          			<li class="nav-item">
            			<a class="nav-link" aria-current="page" href="<c:url value="/myblogs" />">MyBlogs</a>
          			</li>
          			
          			<li class="nav-item">
                		<a class="nav-link active" aria-current="page" href="#">Profile</a>
           			</li>
          
        		</ul>
        
      		</div>
    	</div>
  		</nav>
	</header>
    
    <main>

        <div class="container pt-5">

            <div class="rounded">
              <div class="py-5">
                <h1 class="display-5 fw-normal">Welcome ${user_name}</h1>
                
                <c:if test="${blogs == 0}">
    				<p class="lead pt-2">No blogs found! </p>
    			</c:if>
    			
    			<c:if test="${blogs > 0}">
    				<p class="lead pt-2">You have posted ${blogs} blog(s)</p>
    			</c:if>
    			
              </div>
            </div>
            
            <a href="<c:url value="/logout" />" style="text-decoration: none">
                <div class="align-items-center p-3 mb-3 text-white rounded shadow-sm logout text-center">
                    <div class="lh-1">
                        <h2 class="m-1 text-white lh-1">Logout</h2>
                    </div>
                </div>
            </a>
            
            <a href="<c:url value="/deleteaccount" />" style="text-decoration: none">
                <div class="align-items-center p-3 text-white rounded shadow-sm deleteaccount text-center">
                    <div class="lh-1">
                        <h2 class="text-white lh-1">Delete Account</h2>
                    </div>
                </div>
            </a>

        </div>
    
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" 
    crossorigin="anonymous"></script>

  </body>
</html>