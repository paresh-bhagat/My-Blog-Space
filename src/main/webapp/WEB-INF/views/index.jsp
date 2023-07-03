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
                      
                  </div>
                </header>
          
                <main class="px-3 text-white">
                  <h1>Share your ideas</h1>
                  
                  <p class="lead">Express yourself. Connect with a vibrant community and explore captivating blogs. Join us today!</p>
                  
                  <p class="lead m-1">
                    <a href="<c:url value="/login" />" class="btn btn-lg btn-secondary fw-bold mx-2">Login</a>
                    <a href="<c:url value="/SignUp" />" class="btn btn-lg btn-light fw-bold border-white bg-white mx-2">Signup</a>
                  </p>
                  
                </main>
          
                <footer class="mt-auto text-white-50">
                  <p>Thanks to <a href="https://getbootstrap.com/" class="text-white">Bootstrap</a>.</p>
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
