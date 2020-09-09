var product = sessionStorage.shoppingCart;

// console.log(product)
onload = function(){
  var table = document.createElement("table");
//   table.border = "1";
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


//計算價格總合測試失敗

// var price = JSON.parse(sessionStorage.getItem('shoppingCart'));
// console.log(price)


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

