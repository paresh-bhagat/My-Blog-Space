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
    <link href="<c:url value="/resources/css/blogedit.css" />" rel="stylesheet" >

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
  	
  	<form action="processnewblogform" method="post" enctype="multipart/form-data">

    <div class="mb-3 pt-5 pb-2">
        <label 
        for="exampleFormControlInput1" class="form-label">Title</label>
        <input name="blog_title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="name">
    </div>
    
    <div class="mb-3 pb-2">
      <label for="exampleFormControlInput1" class="form-label">Choose Topic</label>
      <select class="form-select" aria-label="Default select example" 
      name="blog_topic">
        <option selected value="Other">Other</option>
        <option value="Technology">Technology</option>
        <option value="Movies">Movies</option>
        <option value="Health">Health</option>
        <option value="Food">Food</option>
        <option value="Science">Science</option>
        <option value="Music">Music</option>
        <option value="Books">Books</option>
        <option value="Travel">Travel</option>
        <option value="Business">Business</option>
        <option value="Politics">Politics</option>
        <option value="Fashion">Fashion</option>
      </select>
    </div>

    <div class="mb-3 pb-2">
        <label for="exampleFormControlTextarea1" class="form-label">Content</label>
        <textarea name="blog_content" class="form-control" id="exampleFormControlTextarea1" rows="16"></textarea>
    </div>

    <div class="mb-3 pb-2">
        <label for="formFile" class="form-label">Choose image</label>
        <input name="blog_postimage" class="form-control" type="file" id="formFile">
    </div>

    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5">
    
    	<a href="<c:url value="/myblogs" />">
            <button type="button" class="btn btn-succces btn-lg px-4">Back</button>
        </a>
        
        <button class="btn btn-warning btn-lg px-4" type="reset" >Reset</button>
        <button class="btn btn-success btn-lg px-4" type="submit" >Post</button>
        
    </div>
    	
    </form>
    
  </div>

</main>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" 
 integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
      
 </body>
</html>