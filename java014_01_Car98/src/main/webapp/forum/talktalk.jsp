<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>MemberTalk Page</title>
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
    <link rel="stylesheet" href="../css/talktalk.css">

    <script src="http://maps.google.com/maps/api/js"></script>
    <script src="../js/BSRent.js"></script>
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
        <a class="navbar-brand" href="#"><img src="../image/car98logo.png" width="60" height="60" alt=""></a>
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
              <a class="nav-link" href="${pageContext.request.contextPath}/forum/talktop.do">Car論壇</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/BSlogin.html">註冊登入 <span class="sr-only">(current)</span></a>
            </li>
          </ul>
        </div>
      </nav>
       <div class="container">
         <div class="row">
           <div class="col-12 text-white">
          	${TalkBean.postTitle}
           </div>
           <div class="col-2">
             <a href="#"><img src="../image/喬巴1.jpg"></a>
             <div class="text-white">多尼多尼喬巴</div>
             <div class="text-white">zzz94572</div>
             <div class="text-white"></div>
              
           </div>
           <div class="col-10">
              <ul class="AAA" >
                <li class="floor">樓主<br><a href="#">發表於 2020-09-01 09:21 PM</a></li>
                <li class="author">多尼多尼喬巴</li>
                <li class="account">zzz94572</li>
                <li class="gp">讚12</li>
                <li class="bp">噓18</li>
              </ul>
              <div class="col-12 BBB">
                    ${TalkBean.postText}
                    <img src="https://picsum.photos/id/222/500/600" alt=""><br>
                  </div>
                  <div class="col-12 CCC">
                    <ul class="DDD">
                      <li class="EEE"><button class="rounded-circle">讚</button>12</li>
                      <li class="FFF"><button class="rounded-circle">噓</button>18</li>
                      <li class="GGG"><button class="response">回覆</button></li>
                    </ul>
                  </div>
                </div>
                <div class="col-2">
                  <a href="#"><img src="../image/熱巴.jpg"></a>
                  <div class="text-white">迪麗熱巴</div>
                  <div class="text-white">reba0603</div>
                  <div class="text-white"></div>
                   
                </div>
                <div class="col-10">
                   <ul class="AAA" >
                     <li class="floor">2樓<br><a href="#">發表於 2020-09-02 09:21 PM</a></li>
                     <li class="author">迪麗熱巴</li>
                     <li class="account">reba0603</li>
                     <li class="gp">讚3</li>
                     <li class="bp">噓1</li>
                   </ul>
                   <div class="col-12 BBB">
                       先看預算，再來就是外型和內裝還有主被動安全配備這些<br>
                       買車主要還是自己喜歡最重要
                       </div>
                   <div class="col-12 CCC">
                      <ul class="DDD">
                        <li class="EEE"><button class="rounded-circle">讚</button>3</li>
                        <li class="FFF"><button class="rounded-circle">噓</button>1</li>
                        <li class="GGG"><button class="response">回覆</button></li>
                      </ul>
                   </div>
                </div>
                <div class="col-2">
                  <a href="#"><img src="../image/Shirahoshi.png"></a>
                  <div class="text-white">白星公主</div>
                  <div class="text-white">shirahoshi123</div>
                  <div class="text-white"></div>
                   
                </div>
                <div class="col-10">
                   <ul class="AAA" >
                     <li class="floor">3樓<br><a href="#">發表於 2020-09-02 10:28 PM</a></li>
                     <li class="author">白星公主</li>
                     <li class="account">shirahoshi123</li>
                     <li class="gp">讚1</li>
                     <li class="bp">噓6</li>
                   </ul>
                   <div class="col-12 BBB">
                      依有限的預算選擇自己能負擔的品牌車，<br>
                      並且考量所選購的車子是否省油，且後續保養費用是否會過於昂貴，<br>
                      當然車子的外型是否是自己所喜愛的款式也是很重要的考量，<br>
                      至於配備內規當然以安全性為首要其它配備是否加購就看實用性高不高再來選擇。<br>
                       </div>
                   <div class="col-12 CCC">
                      <ul class="DDD">
                        <li class="EEE"><button class="rounded-circle">讚</button>3</li>
                        <li class="FFF"><button class="rounded-circle">噓</button>1</li>
                        <li class="GGG"><button class="response">回覆</button></li>
                      </ul>
                   </div>
                </div>
                <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                  <div class="btn-group mr-2" role="group" aria-label="First group">
                    <center>
                      <button type="button" class="btn btn-secondary">1</button>
                      <button type="button" class="btn btn-secondary">2</button>
                      <button type="button" class="btn btn-secondary">3</button>
                      <button type="button" class="btn btn-secondary">4</button>
                      <button type="button" class="btn btn-secondary">5</button>
                      <button type="button" class="btn btn-secondary">6</button>
                      <button type="button" class="btn btn-secondary">7</button>

                    </center>  
                    
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