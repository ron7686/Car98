<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
    integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous" />
  <link rel="stylesheet" href="../css/shopAdd.css">
</head>

<body>
  <!-- navbar -->
  <nav class="navbar navbar-expand-lg navbar-dark ">
    <a class="navbar-brand" href="#"><img src="../image/car98logo.png" width="50" height="50" alt=""></a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
      data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
      aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
            Car好康
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="#">搜尋加油站</a>
            <a class="dropdown-item" href="#">搜尋自助洗車</a>
            <a class="dropdown-item" href="#">搜尋停車位</a>
          </div>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="/carEasy.html" id="navbarDropdownMenuLink" role="button"
            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Car方便
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="/carEasy.html">加油紀錄</a>
            <a class="dropdown-item" href="#">保養紀錄</a>
            <a class="dropdown-item" href="#">保險紀錄</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
            Car租車
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="#">汽車</a>
            <a class="dropdown-item" href="#">機車</a>
            <a class="dropdown-item" href="#">腳踏車</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
            Car帳單
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="https://www.mvdis.gov.tw/m3-emv-vil/vil/penaltyQueryPay" target="_blank"">罰單查詢</a>
            <a class=" dropdown-item" href="https://parkingfee.pma.gov.taipei/" target="_blank">停車費查詢</a>
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

  <!-- shopping product -->
  <div class="container">
    <div class="contorl  my-2 d-flex justify-content-end">
      <button type="button" class="btn btn-outline-light letter-spacing" data-toggle="modal" data-target="#cart"><i
          class="fa fa-shopping-cart"></i><span class="badge total-count "></span></button>
      <button class="clear-cart btn btn-outline-danger ml-2"><i class="far fa-trash-alt"></i></button>
    </div>


    <!-- product card -->
    <div class="row">
      <div class="col-md-3 col-sm-6">
        <div class="product-grid">
          <div class="product-image">
            <a href="#">
              <img class="pic-1" src="../image/shp1.jpg" />
              <img class="pic-2" src="../image/shp2.jpg" />
            </a>
          </div>
          <div class="product-content">
            <h3 class="title"><a href="#"> 360度旋轉車載手機支架</a></h3>
            <div class="price">
              $490
              <!-- <span>$1000</span> -->
            </div>
            <a data-name="360度旋轉車載手機支架" data-price="490" class="add-to-cart" href="">+ Add To Cart</a>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="product-grid">
          <div class="product-image">
            <a href="#">
              <img class="pic-1" src="../image/shp3.jpg" />
              <img class="pic-2" src="../image/shp4.jpg" />
            </a>
          </div>
          <div class="product-content">
            <h3 class="title"><a href="#">K1PLUSGPS衛星定位安全警示器</a></h3>
            <div class="price">
              $500
              <!-- <span>$1000</span> -->
            </div>
            <a class="add-to-cart" data-name="K1PLUSGPS衛星定位安全警示器" data-price="500" href="">+ Add To Cart</a>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="product-grid">
          <div class="product-image">
            <a href="#">
              <img class="pic-1" src="../image/shp5.jpg" />
              <img class="pic-2" src="../image/shp6.jpg" />
            </a>
          </div>
          <div class="product-content">
            <h3 class="title"><a href="#">電動打氣機</a></h3>
            <div class="price">
              $500
              <!-- <span>$1000</span> -->
            </div>
            <a class="add-to-cart" data-name="電動打氣機" data-price="500" href="">+ Add To Cart</a>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="product-grid">
          <div class="product-image">
            <a href="#">
              <img class="pic-1" src="../image/shp7.jpg" />
              <img class="pic-2" src="../image/shp8.jpg" />
            </a>
          </div>
          <div class="product-content">
            <h3 class="title"><a href="#">MiVue大光圈GPS行車記錄器</a></h3>
            <div class="price">
              $100
              <!-- <span>$1000</span> -->
            </div>
            <a class="add-to-cart" data-name="MiVue大光圈GPS行車記錄器" data-price="100" href="">+ Add To Cart</a>
          </div>
        </div>
      </div>
      <!-- </div> -->
      <!-- <div class="row"> -->
      <div class="col-md-3 col-sm-6">
        <div class="product-grid">
          <div class="product-image">
            <a href="#">
              <img class="pic-1" src="../image/shp9.jpeg" />
              <img class="pic-2" src="../image/shp10.jpeg" />
            </a>
          </div>
          <div class="product-content">
            <h3 class="title"><a href="#">GARMIN 車用衛星導航</a></h3>
            <div class="price">
              $150
              <!-- <span>$1000</span> -->
            </div>
            <a class="add-to-cart" data-name="GARMIN車用衛星導航" data-price="150" href="">+ Add To Cart</a>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="product-grid">
          <div class="product-image">
            <a href="#">
              <img class="pic-1" src="../image/shp11.jpg" />
              <img class="pic-2" src="../image/shp12.jpg" />
            </a>
          </div>
          <div class="product-content">
            <h3 class="title"><a href="#">SILVERS NEOMAX 避震器</a></h3>
            <div class="price">
              $500
              <!-- <span>$1000</span> -->
            </div>
            <a class="add-to-cart" data-name="SILVERSNEOMAX避震器" data-price="500" href="">+ Add To Cart</a>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="product-grid">
          <div class="product-image">
            <a href="#">
              <img class="pic-1" src="../image/shp13.jpg" />
              <img class="pic-2" src="../image/shp14.jpg" />
            </a>
          </div>
          <div class="product-content">
            <h3 class="title"><a href="#">BASEUS 手機支架</a></h3>
            <div class="price">
              $799
              <!-- <span>$1000</span> -->
            </div>
            <a class="add-to-cart" data-name="BASEUS手機支架" data-price="799" href="">+ Add To Cart</a>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6">
        <div class="product-grid">
          <div class="product-image">
            <a href="#">
              <img class="pic-1" src="../image/shp15.jpg" />
              <img class="pic-2" src="../image/shp16.jpg" />
            </a>
          </div>
          <div class="product-content">
            <h3 class="title"><a href="#">Formula1超級防護頂級棕櫚臘</a></h3>
            <div class="price">
              $699
              <!-- <span>$1000</span> -->
            </div>
            <a class="add-to-cart" data-name="Formula1超級防護頂級棕櫚臘" data-price="699" href="">+ Add To Cart</a>
          </div>
        </div>
      </div>
    </div>
    <hr>
    <!-- page bar -->
    <nav class="">
      <ul class="pagination pagination-sm justify-content-center mb-2">
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
          </a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </ul>
    </nav>
  </div>
  <!-- footer -->
  <div class="footer-bottom  bg-dark text-light">
    <div class="container-fluid">
      <p class="pull-left">
        Copyright@ 2020 by Car98 Group
      </p>
    </div>
  </div>

  <!-- modale_shopping window -->

  <div class="modal fade" id="cart" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Cart</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <table class="show-cart table">

          </table>
          <div>Total price: $<span class="total-cart"></span></div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Order now</button>
        </div>
      </div>
    </div>
  </div>












  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
    integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
    integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
    crossorigin="anonymous"></script>
  <script src="../js/shopAdd.js"></script>
</body>

</html>