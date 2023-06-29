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
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    
    <!-- mycss -->
    <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet" >

  </head>

    <body>
    
      <div class="container-fluid home">
        <div class="row row1">
          <div class="col p-4">

            <div class="d-flex text-center h-100">
              
              <div class="cover-container d-flex w-100 h-100 flex-column">
                <header class="mb-auto">
                  <div class="text-white">

                    <h3 class="float-md-start mb-0">MyBlogSpace</h3>
                      <nav class="nav nav-masthead justify-content-center float-md-end">
                        <a class="nav-link fw-bold py-1 px-0" href="<c:url value="/login" /> ">Login</a>
                        <a class="nav-link fw-bold py-1 px-0" href="<c:url value="/SignUp" />">Signup</a>
                        
                      </nav>
                  </div>
                </header>
          
                <main class="px-3 text-white">
                  <h1>Share your ideas</h1>
                  <p class="lead">Cover is a one-page template for building simple and beautiful home pages. 
                  Download, edit the text, and add your own fullscreen background photo to make it your own.</p>
                  <p class="lead">
                    <a href="<c:url value="/SignUp" />" class="btn btn-lg btn-light fw-bold border-white bg-white">Signup</a>
                  </p>
                </main>
          
                <footer class="mt-auto text-white-50">
                  <p>Cover template for <a href="https://getbootstrap.com/" class="text-white">Bootstrap</a>, by 
                  <a href="https://twitter.com/mdo" class="text-white">@mdo</a>.</p>
                </footer>
              </div>
        
      
      
            </div>
          </div>
        </div>
      </div>
  
  <!--bootstrap jss-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
  integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
  
  </body>
   
</html>
