<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shop information</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link
    rel="stylesheet"
    href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
    integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
    crossorigin="anonymous"
  />
  <link rel="stylesheet" href="/java014_01_Car98/src/main/webapp/css/shopCheckout.css">
</head>
<body>
     <!-- navbar -->
     <jsp:include page="/fragment/topIndex.jsp" />
<!-- 結帳畫面 -->
    <section class="py-5">
        <div class="container">
            <div class="h1 text-center mb-3 text-secondary">結帳囉！</div>
            <div class="row justify-content-center mt-5">
                <div class="col-md-8">
                    <div class="accordion" id="accordionExample">
    <!-- 購物車商品記錄<p class="text-white" id="result"></p>  -->
                        <div class="card border-0">
                            <div class="card-header d-flex border" id="headingOne">
                                <a class="btn btn-link text-primary" data-toggle="collapse" href="#collapseOne"
                                    role="button" aria-expanded="false" aria-controls="collapseOne">顯示購物車細節</a>
                            </div>
                        </div>
                        <div id="collapseOne" class="collapse" aria-labelledby="headingOne"
                            data-parent="#accordionExample">
                            <div class="card-body pt-0" id="product-table">
                              <p class="text-white" id="result"></p>
            <!-- 動態新增區域<table class="table"> -->
                                     <!-- <thead>
                                        <tr class="text-center">
                                            <th class="align-middle" width="30px"></th>
                                            <th class="align-middle" width="100px">商品圖</th>
                                            <th class="align-middle">商品名稱</th>
                                            <th class="align-middle" width="100px">數量</th>
                                            <th class="align-middle" width="100px">小計</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="text-center">
                                            <td class="align-middle"><a href="#" data-toggle="modal" data-target="#removeModal"
                                                data-backdrop="static" data-title="商品"><i
                                                    class="far fa-trash-alt"></i></a>
                                            </td>
                                            <td class="align-middle"><img class="img-fluid"
                                                    src="">
                                            </td>
                                            <td class="align-middle">商品</td>
                                            <td class="align-middle">1件</td>
                                            <td class="align-middle text-right">$520</td>
                                        </tr>
                                        <tr class="text-right">
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>運費</td>
                                            <td class="font-weight-bold">$60</td>
                                        </tr>
                                    </tbody>
                                    <tfoot>
                                        <tr class="text-right">
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>合計</td>
                                            <td class="font-weight-bold">$580</td>
                                        </tr>
                                    </tfoot>  -->
                                <!-- </table> -->
                            </div>
                        </div>
                    </div>
                    <h5 class="text-center bg-light py-3 my-5">訂購人資料</h5>
                    <form>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="name" class="text-white">姓名</label>
                                <input type="name" class="form-control" id="name" placeholder="姓名" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="Email" class="text-white">Email</label>
                                <input type="email" class="form-control" id="Email" placeholder="Email" required>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="country" class="text-white">國家</label>
                                <select id="country" class="form-control" required>
                                    <option selected>台灣</option>
                                    <option>日本</option>
                                    <option>韓國</option>
                                    <option>印度</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="city" class="text-white">城市</label>
                                <select id="city" class="form-control" required>
                                    <option selected>新北市</option>
                                    <option>台北市</option>
                                    <option>台中市</option>
                                    <option>高雄市</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="placenumber" class="text-white">郵遞區號</label>
                                <input type="text" class="form-control" id="placenumber" required>
                            </div>
                            <div class="form-group col">
                                <label for="Address" class="text-white">地址</label>
                                <input type="text" class="form-control" id="Address" placeholder="Address" required>
                            </div>
                        </div>
                        <div class="text-right">
                            <!-- <a class="btn btn-secondary" href="#product-list">繼續選購</a> -->
                            <button type="submit" class="btn btn-primary">確認</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <hr>
    <section class="py-5">
        <div class="container">
            <div class="h1 text-center mb-3 text-white">結帳完成</div>
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <h3 class="text-center mb-3 text-white">購物記錄</h3>
    <!--動態新增區域 --><table class="table"> 
                       
                    </table>
                    <h3 class="text-center mb-3 text-white">個人資訊</h3>
    <!--動態新增區域 --><table class="table">
                        
                    </table>
                </div>
            </div>
        </div>
    </section>
    <!-- footer -->
  <div class="footer-bottom  bg-dark text-light">
    <div class="container-fluid">
      <p class="pull-left">
        Copyright@ 2020 by Car98 Group
      </p>
    </div>
  </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
    ></script>
  <script src="/java014_01_Car98/src/main/webapp/javascript/addProduct.js"></script>
</body>
</html>