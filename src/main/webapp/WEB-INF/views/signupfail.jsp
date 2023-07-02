<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jstl tag --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored = "false" %>

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
                      name="user_id"
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
                    
                    <c:if test="${error_type == 0}">
    					<div class="alert alert-warning alert-dismissible fade show" role="alert">
  							Fields cannot be empty
  							<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
    				</c:if>
                    
                    <c:if test="${error_type == 1}">
    					 <div class="alert alert-warning alert-dismissible fade show" role="alert">
  							Max 20 characters allowed
  							<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
    				</c:if>
    				
    				 <c:if test="${error_type == 2}">
    					 <div class="alert alert-danger alert-dismissible fade show" role="alert">
  							Username already exist
  							<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
    				</c:if>
                    
                    <button class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit">Sign up</button>
                    
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