$(document).ready(function () {
  /* 選擇車型，價格及地區 */

  function format(item1) {
    opt1 = $("#searchitem").find(":selected");
    sel1 = opt1.text();
    og1 = opt1.closest("optgroup").attr("label");
    return (og1 ? og1 + " - " : "") + item1.text;
  }
  $("#searchitem").select2({
    templateSelection: format,
    escapeMarkup: function (a) {
      return a;
    }
  });
  function format(item) {
    opt = $("#priceitem").find(":selected");
    sel = opt.text();
    og = opt.closest("optgroup").attr("label");
    return (og ? og + " - " : "") + item.text;
  }

  $("#priceitem").select2({
    templateSelection: format,
    escapeMarkup: function (m) {
      return m;
    }
  });

});

