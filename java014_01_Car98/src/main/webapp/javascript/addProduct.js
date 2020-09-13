var product = sessionStorage.shoppingCart;

// console.log(product)
onload = function(){
  var table = document.createElement("table");
  var jsons =new Function("return" + product)();
  for(var i=0;i<jsons.length;i++){
    var tr =document.createElement("tr");
    for(var k in jsons[i]){
      var td =document.createElement("td");
      td.appendChild(document.createTextNode(jsons[i][k]));
      tr.appendChild(td);
    }
    table.appendChild(tr);
  }
  document.getElementsByTagName("p")[0].appendChild(table);
};


//計算總價格最終版
var price = JSON.parse(sessionStorage.getItem('shoppingCart'));
var totalCart = 0;
      for (var item in price) {
        totalCart += price[item].price * price[item].count;
      }
      document.getElementById('totalresult').innerHTML= '金額：'+ totalCart;
//計算價格總合測試失敗
// // console.log(price[0]['price'])
// console.log(price)
// let str = "";
// price.forEach(function(el){
//   str += 'tasty ' + el + ', ';
// });
// console.log(str);

// var objarray=price.map(el=>el.price);
// console.log(objarray)
// var abc = price.map(el=>el.count);
// console.log(abc)

// function SumDatareduce(arr){
//     return arr.reduce((a,b)=>a+b);  
// }
// console.log(SumDatareduce(objarray));
// console.log(SumDatareduce(abc));
// console.log(SumDatareduce(objarray)*SumDatareduce(abc));



///AJAX formData API
$('button').click(function(e){
  e.preventDefault();
  var form = $('form')[0];
  console.log(form);
  var formData = new FormData(form);
  console.log(formData);
  $.ajax({
      url:'/upload',
      type : "POST",
      data : formData,
      contentType: false,
      cache: false,
      processData: false,
      success : function(data) 
      {
          console.log(data);
      },error: function(data) 
      {
          // console.log('無法送出');
          console.log(formData)
      }
  })
});


