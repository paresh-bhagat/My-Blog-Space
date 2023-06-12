<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl tag -->
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
      <a class="navbar-brand" href="home.html">MyBlogSpace</a>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" 
      aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">

        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="home.html">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="userhome.html">MyBlogs</a>
          </li>
        </ul>
        
      </div>
    </div>
  </nav>
</header>

<main>

  <div class="container marketing">

    <div class="mb-3 p-5">
        <label for="exampleFormControlInput1" class="form-label">Title</label>
        <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
    </div>

    <div class="mb-3 p-5">
        <label for="exampleFormControlTextarea1" class="form-label">Content</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="16"></textarea>
    </div>

    <div class="mb-3 p-5">
        <label for="formFile" class="form-label">Choose image</label>
        <input class="form-control" type="file" id="formFile">
    </div>

    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5">
        <button type="button" class="btn btn-success btn-lg px-4">Save</button>
      </div>
    
  </div>

</main>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" 
 integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
      
 </body>
</html>