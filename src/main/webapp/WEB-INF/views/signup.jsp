<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jstl tag --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MyBlogSpace</title>
    
    <!-- Bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

	<!-- mycss -->
    <link href="<c:url value="/resources/css/signup.css" />" rel="stylesheet" >
    
     <!--favicon-->
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/images/favicon.ico" />">
	
  </head>
    <body class="text-center">
    
    <main class="form-signup m-auto">

        <div class="modal modal-sheet position-static d-block" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
              <div class="modal-content rounded-4 shadow">
    
                <div class="modal-header p-5 pb-4 border-bottom-0">
                  <h1 class="fw-bold mb-0 fs-2">Sign up</h1>
                </div>
          
                <div class="modal-body p-5 pt-0">
                
                  <form class="" action="processsignupform" method="post" >
                  
                    <div class="form-floating mb-3">
                      <input type="text" 
                      class="form-control rounded-3" 
                      id="floatingInput"
                      name="user_name"
                      placeholder="paresh">
                      <label for="floatingInput">Username</label>
                    </div>
                    
                    <div class="form-floating mb-3">
                      <input type="password" 
                      class="form-control rounded-3" 
                      id="floatingPassword"
                      name="user_password"
                      placeholder="Password">
                      <label for="floatingPassword">Password</label>
                    </div>
                    
                    <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit">Sign up</button>
                    
                    <div class="p-2">
                    	<p>Already an user? <a href="<c:url value="/login" />">Login</a></p>
                    	<a href="<c:url value="/" />">Home</a>
                    </div>
                    
                  </form>
                </div>
              </div>
            </div>
          </div>

    </main>

	<!-- bootstrap js -->
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" 
    crossorigin="anonymous"></script>

    </body>
    
</html>