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
    
    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    
     <!--favicon-->
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/images/favicon.ico" />">
    
  </head>
  <body>
    
    <div class="container my-5">
        <div class="position-relative p-5 text-center text-muted bg-body border border-dashed rounded-5">

            <div class="container text-center">
                <img src="https://images.template.net/84921/free-something-went-wrong-illustration-ujbiu.jpg" 
                  class="img-fluid mb-4" width="500" height="500" loading="lazy">
            </div>
            
            <div class="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5">
                <a href="<c:url value="/" />"> 
                  <button type="button" class="btn btn-outline-primary btn-lg px-4">Back to home page</button>
                </a>
            </div>

        </div>
    </div>
	
	<!-- bootstrap js -->
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" 
    crossorigin="anonymous"></script>
    
  </body>
</html>