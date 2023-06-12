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
    <link href="<c:url value="/resources/css/myblogs.css" />" rel="stylesheet" >

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

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Topics
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">

                <div class="form-check">
                  <input class="form-check-input" type="radio" name="flexRadioDefault" value="all" id="flexRadioDefault1" checked>
                  <label class="form-check-label" for="flexRadioDefault1">
                    All topics
                  </label>
                </div>

              </a></li>

              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="#">
                <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" value="first" id="flexRadioDefault1">
                <label class="form-check-label" for="flexRadioDefault1">
                  radio1
                </label>
                </div>
              </a></li>

              <li><a class="dropdown-item" href="#"><div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" value="second" id="flexRadioDefault2">
                <label class="form-check-label" for="flexRadioDefault2">
                  radio2
                </label>
              </div></a></li>

              <li><a class="dropdown-item" href="#"><div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" value="third" id="flexRadioDefault2">
                <label class="form-check-label" for="flexRadioDefault2">
                  radio3
                </label>
              </div></a></li>

            </ul>
          </li>

        </ul>
        
      </div>
    </div>
  </nav>
</header>

<main>

  <div class="container marketing">


    <!--section1-->

    <section id="section1" class="section first box">

      <div class="container py-5" id="custom-cards">
        <h2 class="pb-2 border-bottom">Section1</h2>
    
        <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
          <div class="col">
            <div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" style="background-image: url('unsplash-photo-1.jpg');">
              <div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
                <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Short title, long jacket</h3>
                <ul class="d-flex list-unstyled mt-auto">
                  <li class="me-auto">
                    <img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
                  </li>
                  <li class="d-flex align-items-center me-3">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>
                    <small>Earth</small>
                  </li>
                  <li class="d-flex align-items-center">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>
                    <small>3d</small>
                  </li>
                </ul>
              </div>
            </div>
          </div>
    
          <div class="col">
            <div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" style="background-image: url('unsplash-photo-2.jpg');">
              <div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
                <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Much longer title that wraps to multiple lines</h3>
                <ul class="d-flex list-unstyled mt-auto">
                  <li class="me-auto">
                    <img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
                  </li>
                  <li class="d-flex align-items-center me-3">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>
                    <small>Pakistan</small>
                  </li>
                  <li class="d-flex align-items-center">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>
                    <small>4d</small>
                  </li>
                </ul>
              </div>
            </div>
          </div>
    
          <div class="col">
            <div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" style="background-image: url('unsplash-photo-3.jpg');">
              <div class="d-flex flex-column h-100 p-5 pb-3 text-shadow-1">
                <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Another longer title belongs here</h3>
                <ul class="d-flex list-unstyled mt-auto">
                  <li class="me-auto">
                    <img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
                  </li>
                  <li class="d-flex align-items-center me-3">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>
                    <small>California</small>
                  </li>
                  <li class="d-flex align-items-center">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>
                    <small>5d</small>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      
    </section>

    <!-- End projects Section -->

    <!-- *********************** 2nd section*******************-->
    
    <section id="section2" class="section second box">

      <div class="container py-5" id="custom-cards">
        <h2 class="pb-2 border-bottom">Section2</h2>
    
        <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
          <div class="col">
            <div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" style="background-image: url('unsplash-photo-1.jpg');">
              <div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
                <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Short title, long jacket</h3>
                <ul class="d-flex list-unstyled mt-auto">
                  <li class="me-auto">
                    <img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
                  </li>
                  <li class="d-flex align-items-center me-3">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>
                    <small>Earth</small>
                  </li>
                  <li class="d-flex align-items-center">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>
                    <small>3d</small>
                  </li>
                </ul>
              </div>
            </div>
          </div>
    
          <div class="col">
            <div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" style="background-image: url('unsplash-photo-2.jpg');">
              <div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
                <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Much longer title that wraps to multiple lines</h3>
                <ul class="d-flex list-unstyled mt-auto">
                  <li class="me-auto">
                    <img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
                  </li>
                  <li class="d-flex align-items-center me-3">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>
                    <small>Pakistan</small>
                  </li>
                  <li class="d-flex align-items-center">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>
                    <small>4d</small>
                  </li>
                </ul>
              </div>
            </div>
          </div>
    
          <div class="col">
            <div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" style="background-image: url('unsplash-photo-3.jpg');">
              <div class="d-flex flex-column h-100 p-5 pb-3 text-shadow-1">
                <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Another longer title belongs here</h3>
                <ul class="d-flex list-unstyled mt-auto">
                  <li class="me-auto">
                    <img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
                  </li>
                  <li class="d-flex align-items-center me-3">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>
                    <small>California</small>
                  </li>
                  <li class="d-flex align-items-center">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>
                    <small>5d</small>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      
    </section>


    <section id="section3" class="section third box">

      <div class="container py-5" id="custom-cards">
        <h2 class="pb-2 border-bottom">Section3</h2>
    
        <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
          <div class="col">
            <div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" style="background-image: url('unsplash-photo-1.jpg');">
              <div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
                <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Short title, long jacket</h3>
                <ul class="d-flex list-unstyled mt-auto">
                  <li class="me-auto">
                    <img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
                  </li>
                  <li class="d-flex align-items-center me-3">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>
                    <small>Earth</small>
                  </li>
                  <li class="d-flex align-items-center">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>
                    <small>3d</small>
                  </li>
                </ul>
              </div>
            </div>
          </div>
    
          <div class="col">
            <div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" style="background-image: url('unsplash-photo-2.jpg');">
              <div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">
                <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Much longer title that wraps to multiple lines</h3>
                <ul class="d-flex list-unstyled mt-auto">
                  <li class="me-auto">
                    <img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
                  </li>
                  <li class="d-flex align-items-center me-3">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>
                    <small>Pakistan</small>
                  </li>
                  <li class="d-flex align-items-center">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>
                    <small>4d</small>
                  </li>
                </ul>
              </div>
            </div>
          </div>
    
          <div class="col">
            <div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" style="background-image: url('unsplash-photo-3.jpg');">
              <div class="d-flex flex-column h-100 p-5 pb-3 text-shadow-1">
                <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Another longer title belongs here</h3>
                <ul class="d-flex list-unstyled mt-auto">
                  <li class="me-auto">
                    <img src="https://github.com/twbs.png" alt="Bootstrap" width="32" height="32" class="rounded-circle border border-white">
                  </li>
                  <li class="d-flex align-items-center me-3">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>
                    <small>California</small>
                  </li>
                  <li class="d-flex align-items-center">
                    <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>
                    <small>5d</small>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      
    </section>
    
  </div><!-- /.container -->


  <!-- FOOTER -->
  <footer class="container">
    <p class="float-end"><a href="#">Back to top</a></p>
    <p>&copy; 2017–2023 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
  </footer>

 </main>

 <!-- bootstrap js -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" 
 integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
 
 <!-- jquery -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
 
 <!-- myjs -->
 <script src="<c:url value="/resources/js/myblogs.js" />"></script>
      
 </body>
</html>