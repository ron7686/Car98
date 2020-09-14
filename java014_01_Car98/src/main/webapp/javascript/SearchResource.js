$(document).ready(function () {
  function format(item) {
    opt = $("#searchitem").find(":selected");
    sel = opt.text();
    og1 = opt.closest("optgroup").attr("label");
    return (og1 ? og1 + " - " : "") + item.text;
  }
  $("#searchitem").select2({
    templateSelection: format,
    escapeMarkup: function (a) {
      return a;
    },
  });
});