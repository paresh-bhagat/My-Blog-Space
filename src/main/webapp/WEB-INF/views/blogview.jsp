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
    
    <!-- -my js -->
    <link href="<c:url value="/resources/css/blogview.css" />" rel="stylesheet" >

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
        
          <li class="nav-item">${user_id}'s home</li>
          
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="<c:url value="/feed" />">Feed</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="<c:url value="/myblogs" />">MyBlogs</a>
          </li>
        </ul>
        
      </div>
    </div>
  </nav>
</header>

<main>

  <div class="container marketing">

    <div class="px-4 pt-5 my-5">
      <h1 class="display-4 fw-bold text-body-emphasis text-center">${blog[1]}</h1>
      <div class="container px-5 text-center">
        <img src="<c:url value="/resources/images/${blog[0]}.jpg"/>" class="img-fluid border rounded-3 shadow-lg mb-4"
          alt="Example image" width="700" height="500" loading="lazy">
      </div>
      <div class="col-12 mx-auto">
        <p class="lead mb-4">${blog[3]}</p>
          
        <div class="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5">
          
          <a href="<c:url value="/myblogs" />">
          	<button type="button" class="btn btn-danger btn-lg px-4">Back</button>
          </a>
          	
          <a href="<c:url value="/editblog?blog_user_id=${blog[4]}&blog_name=${blog[1]}&blog_topic=${blog[2]}" />"> 
            <button type="button" class="btn btn-info btn-lg px-4">Edit blog</button>
          </a>
          
          <a href="<c:url value="/deleteblog?blog_user_id=${blog[4]}&blog_name=${blog[1]}&blog_topic=${blog[2]}" />">
            <button type="button" class="btn btn-danger btn-lg px-4">Delete</button>
          </a>
          
        </div>
      </div>
  
    </div>
    
  </div><!-- /.container -->

</main>


 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" 
 integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

 </body>
</html>
