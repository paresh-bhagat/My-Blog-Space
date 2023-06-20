<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet" >

  </head>

    <body class="text-center">
    
    <main class="form-signin w-100 m-auto">
    
      <form action="processloginform" method="post">
        <img class="mb-4" src="<c:url value="/resources/images/logo.png" />" alt="" width="170" height="140">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
    
        <div class="form-floating mb-3">
          <input 
          type="text" 
          class="form-control rounded-3" 
          id="floatingInput"
          name="user_id"
          placeholder="paresh">
          <label for="floatingInput">UserName</label>
        </div>
        
        <div class="form-floating mb-3">
          <input type="password" 
          class="form-control rounded-3"
          id="floatingPassword"
          name="user_password"
          placeholder="Password">
          <label for="floatingPassword">Password</label>
        </div>
        
        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        
        <p class="mt-5 mb-3 text-body-secondary">&copy; 2023</p>
      </form>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" 
    crossorigin="anonymous"></script>
    </body>

</html>