<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CarTalk</title>
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
    <link rel="stylesheet" href="../css/BSTalk.css">
    <script src="http://maps.google.com/maps/api/js"></script>
    <script src="BSTalk.js"></script>
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
    body{
      background-image: url(../image/Desktop.png);
      background-position: center;
      background-attachment: fixed;
      background-repeat:no-repeat;
      background-size: cover;
    }
    </style>
  </head>
  <body>
    <!-- navbar -->
    <nav class="navbar  navbar-expand-lg navbar-dark bg-dark">
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
                  <a class="dropdown-item" href="/BSCarRent.html">汽車</a>
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
      <!-- mainCar Area -->
      <section class="my-5">
        
      <div class="container text-white">
        <div class="row">
            <div class="col-12 head">
                汽車交流論壇
            </div>
            <div class="col-2 border">
                <a href="">
                <img src="https://picsum.photos/id/231/180/90" alt=""></a>
            </div>
            <div class="col-2 border ">
                <a href="">
                <img  src="https://picsum.photos/id/238/180/90" alt=""></a>
                
            </div>
            <div class="col-2 border">
                <a href="">
                <img src="https://picsum.photos/id/236/180/90" alt=""></a>

            </div>
            <div class="col-2 border">
                <a href="">
                <img src="https://picsum.photos/id/235/180/90" alt=""></a>

            </div>
            <div class="col-2 border">
                <a href="">
                <img src="https://picsum.photos/id/234/180/90" alt=""></a>

            </div>
            <div class="col-2 border">
                <a href="">
                <img src="https://picsum.photos/id/233/180/90" alt=""></a>

            </div>
            <div class="col-12 publish">
                <nav aria-label="Page navigation example ">
                    <ul class="pagination justify-content-end ">
                        <button class="btn text-white bg-primary mr-auto ml-1">發帖<i class="fas fa-angle-down"></i></button>
                      <li class="page-item disabled ">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                      </li>
                      <li class="page-item"><a class="page-link" href="#">1</a></li>
                      <li class="page-item active" aria-current="page">
                        <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                      </li>
                      <li class="page-item"><a class="page-link" href="#">3</a></li>
                      <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                      </li>
                    </ul>
                  </nav>
            </div>
            <div class="col-12 ">
                <ul class="classification ">
                    <li class="classification-item "><a class="classification-item-a" href="#">全部</a></li>
                    <li class="classification-item"><a class="classification-item-a" href="#">討論</a></li>
                    <li class="classification-item"><a class="classification-item-a" href="#">分享＆心得</a></li>
                    <li class="classification-item"><a class="classification-item-a" href="#">求助＆問題</a></li>
                    <li class="classification-item"><a class="classification-item-a" href="#">公告</a></li>
                </ul>
            </div>
            <div class="col-12 filter">
                <form class="mt-1">篩選：
                    <select name="" id="searchtime">
                    <option value="alltime">發佈時間</option>
                    <option value="oday">一天</option>
                    <option value="tday">兩天</option>
                    <option value="oweek">一週</option>
                    <option value="tweek">兩週</option>
                    <option value="amonth">一個月</option>
                    <option value="tday">兩個月</option>
                    </select>
                    </form>
            </div>
            <div class="col-12 main ">
                <table class="maintalk mt-1 ">
                    <tr>
                        <td class="sort ">分類</td>
                        <td class="pic">圖片</td>
                        <th class="title">內文標題</th>
                        <td class="author">        
                        作者/發佈時間
                        </td>
                        <td class="respon">回應/查看</td>
                        <td class="lastupdate">最後更新</td>
                    </tr>
                </table>
                
            </div>
    
            <div class="col-12">
                <table class="maintalk mt-1 talk">
                    <tr>
                        <td class="sort "><a href=""><i class="fas fa-car-crash"></i></i>求助＆問題</a></td>
                        <td class="pic"><img src="https://picsum.photos/id/231/100/50" alt=""></td>
                        <th class="title itemtitle"><a class="subtitle" href="${pageContext.request.contextPath}/forum/talktalk.jsp">2011年TIDA 5門 1.8 油耗問題</a></th>
                        <td class="author"><a class="talkname" href="${pageContext.request.contextPath}/forum/talktalk.jsp">RonLee</a><br>2020/09/20 </td>
                        <td class="respon"><a class="subrespon" href="">131</a><br>15443</td>
                        <td class="lastupdate"><a class="talkname" href="">WayneChen</a><br><a  class="time" href="">昨天10:43pm</a></td>
                    </tr>
                
                    <tr>
                        <td class="sort "><a href=""><i class="fas fa-bullhorn"></i>公告</a></td>
                        <td class="pic"><img src="https://picsum.photos/id/231/100/50" alt=""></td>
                        <th class="title itemtitle"><a class="subtitle" href="${pageContext.request.contextPath}/forum/talktalk.jsp">2011年TIDA 5門 1.8 油耗問題</a></th>
                        <td class="author"><a class="talkname" href="${pageContext.request.contextPath}/forum/talktalk.jsp">RonLee</a><br>2020/09/20 </td>
                        <td class="respon"><a class="subrespon" href="">131</a><br>15443</td>
                        <td class="lastupdate"><a class="talkname" href="">WayneChen</a><br><a  class="time" href="">昨天10:43pm</a></td>
                    </tr>                    
                    <tr>
                        <td class="sort "><a href=""><i class="fas fa-couch"></i>分享＆心得</a></td>
                        <td class="pic"><img src="https://picsum.photos/id/231/100/50" alt=""></td>
                        <th class="title itemtitle"><a class="subtitle" href="${pageContext.request.contextPath}/forum/talktalk.jsp">2011年TIDA 5門 1.8 油耗問題</a></th>
                        <td class="author"><a class="talkname" href="${pageContext.request.contextPath}/forum/talktalk.jsp">RonLee</a><br>2020/09/20 </td>
                        <td class="respon"><a class="subrespon" href="">131</a><br>15443</td>
                        <td class="lastupdate"><a class="talkname" href="">WayneChen</a><br><a  class="time" href="">昨天10:43pm</a></td>
                    </tr>
                    <tr>
                        <td class="sort "><a href=""><i class="fab fa-discourse"></i>討論</a></td>
                        <td class="pic"><img src="https://picsum.photos/id/231/100/50" alt=""></td>
                        <th class="title itemtitle"><a class="subtitle" href="${pageContext.request.contextPath}/forum/talktalk.jsp">2011年TIDA 5門 1.8 油耗問題</a></th>
                        <td class="author"><a class="talkname" href="${pageContext.request.contextPath}/forum/talktalk.jsp">RonLee</a><br>2020/09/20 </td>
                        <td class="respon"><a class="subrespon" href="">131</a><br>15443</td>
                        <td class="lastupdate"><a class="talkname" href="">WayneChen</a><br><a  class="time" href="">昨天10:43pm</a></td>
                    </tr>
                    
                </table>
            </div>
        </div>
       </div> 
    
    </section>

    

    <div class="footer-bottom  bg-dark text-light">
        <div class="container-fluid">
          <p class="pull-left">
            Copyright@ 2020 by Car98 Group
          </p>
        </div>
      </div>
      </body>
    </html>