$(document).ready(function() {
	getCarDataOptions();
	format1();
	format2();
	format3();
});
	
	function getCarDataOptions() {
		$.ajax({
			method : "GET",
			url : "/java014_01_Car98/rentcar/RentCarData",
			success : function(res) {
				// 	console.log(res);
				var last_brand = "";
				// 先設一個變數last_brand
				for (i = 0; i < res.length; i++) {
					// 新增optgroup：carBrand
					if (last_brand != res[i].carBrand){
						$("#caritem").append(
							"<optgroup label=" + res[i].carBrand + ">"
							                   + "</optgroup>"
							                   );
					}	
					// 新增option：carType，option的爸爸為新產生的<optgroup></optgroup>
					$("optgroup[label=" + res[i].carBrand + "]").append(
					    "<option value=" + res[i].typeId + ">"
					     + res[i].carType
					     + "</option>"
					     );	
					
					last_brand = res[i].carBrand;	
				}
			}
		})
	}
  /* 選擇地區，價格及車型 */

   function format1(item1) {
     opt1 = $("#areaitem").find(":selected");
     sel1 = opt1.text();
     og1 = opt1.closest("optgroup").attr("label");
     return (og1 ? og1 + " - " : "") + item1.text;
   }

    $("#areaitem").select2({
     templateSelection: format1,
     escapeMarkup: function (a) {
       return a;
     }
   });

    function format2(item2) {
    opt2 = $("#priceitem").find(":selected");
    sel2 = opt2.text();
    og2 = opt2.closest("optgroup").attr("label");
    return (og2 ? og2 + " - " : "") + item2.text;
  }
  
  $("#priceitem").select2({
    templateSelection: format2,
    escapeMarkup: function (b) {
      return b;
    }
  });
  
  function format3(item3) {
    opt3 = $("#caritem").find(":selected");
    sel3 = opt3.text();
    og3 = opt3.closest("optgroup").attr("label");
    return (og3 ? og3 + " - " : "") + item3.text;
  }
  $("#caritem").select2({
    templateSelection: format3,
    escapeMarkup: function (c) {
      return c;
   }
});
