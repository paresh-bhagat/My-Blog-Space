<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- form tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MyBlogSpace</title>
    
    <!-- Bootstrap css -->
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" 
    crossorigin="anonymous">
	
	<!-- mycss -->
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet" >

  </head>

    <body class="text-center">
    
    <main class="form-login w-100 m-auto">
    
      <form action="processloginform" method="post">
        <img class="mb-4" src="<c:url value="/resources/images/logo.png" />" alt="" width="180" height="140">
        <h1 class="h3 mb-3 fw-normal">Please login</h1>
    
        <div class="form-floating mb-3">
          <input 
          type="text" 
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
        
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
  			Wrong username or password.
  			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
        
        <button class="w-100 btn btn-lg btn-primary" type="submit">Login</button>
        
      </form>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" 
    crossorigin="anonymous"></script>
    </body>

</html>