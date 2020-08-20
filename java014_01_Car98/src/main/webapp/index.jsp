<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home Page</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
      crossorigin="anonymous"
    />
    <script
      src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
      integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
      integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
      crossorigin="anonymous"
    ></script>
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
      integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
      crossorigin="anonymous"
    />
    <style>
      #carouselExampleFade .carousel-inner .carousel-item img{
        height:720px;       
        }
      .footer-bottom{
      margin-top: 1em;
      /* border-top: 1px solid #DDDDDD; */
      padding-top: 10px;
      padding-bottom: 5px;
     
    }
    .footer-bottom p.pull-left{
      padding-top: 6px;
      font-size: 0.5em;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    .bg-cover{
      background-size: cover;
    }
    /* body{
      background-image: url(./image/Desktop.png);
      background-position: center;
      background-attachment: fixed;
      background-repeat:no-repeat;
      background-size: cover;
    } */
    </style>
  </head>
  <body>
    <!-- navbar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#"><img src="./image/car98logo.png" width="60" height="60" alt=""></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Car好康
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="#">搜尋加油站</a>
                <a class="dropdown-item" href="#">搜尋自助洗車</a>
                <a class="dropdown-item" href="#">搜尋停車位</a>
              </div>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="/carEasy.html" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Car方便
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="/carEasy.html">加油紀錄</a>
                <a class="dropdown-item" href="#">保養紀錄</a>
                <a class="dropdown-item" href="#">保險紀錄</a>
              </div>
            </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Car租車
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="#">汽車</a>
                  <a class="dropdown-item" href="#">機車</a>
                  <a class="dropdown-item" href="#">腳踏車</a>
                </div>
              </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Car帳單
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="https://www.mvdis.gov.tw/m3-emv-vil/vil/penaltyQueryPay" target="_blank"">罰單查詢</a>
                <a class="dropdown-item" href="https://parkingfee.pma.gov.taipei/" target="_blank">停車費查詢</a>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Car好買</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Car論壇</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/BSlogin.html">註冊登入 <span class="sr-only">(current)</span></a>
            </li>
          </ul>
        </div>
      </nav>
      <!-- carousel -->
      <div id="carouselExampleFade" class="carousel slide carousel-fade" data-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="./image/CAR1.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
              <img src="./image/CAR2.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
              <img src="./image/CAR3.jpg" class="d-block w-100" alt="...">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
      </div>
      <!-- About -->
      <div class="jumbotron-fluid bg-dark">
        <h1 class="display-5 text-light pt-2 pl-2">About</h1>
        <p class="lead text-light pl-2">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
        <a class="btn btn-primary mb-2 ml-2 btn-sm" href="#" role="button">Learn more</a>
      </div>
    <!-- card -->
    <div class="container mt-4 mb-5">
    <div class="row">
      <div class="col-sm-4">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Special title treatment</h5>
            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
          </div>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Special title treatment</h5>
            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
          </div>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Special title treatment</h5>
            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- footer -->
  <div class="footer-bottom  bg-dark text-light">
    <div class="container-fluid">
      <p class="pull-left">
        Copyright@ 2020 by Car98 Group
      </p>
    </div>
  </div>
  </body>
</html>
