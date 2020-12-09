$('#search').on('submit', function() {
    var id = $('#dropdown').val();
    var formAction = $('#search').attr('action');
    $('#search').attr('action', formAction + id);
});

$(document).ready(function() {
  $("#book").click(function() {
    $("#search").toggle();
    });
});


function myFunction(){
    var x = document.getElementById("customerPassword");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}


