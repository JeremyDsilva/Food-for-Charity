$(document).ready(function() {
    $('#register').on('click', function(e) {
        $("#myModal").modal();
        $("#myModalBody").text("");
        $.ajax({
            url: "register",
            cache: false
        }).done(function(html) {
            $("#myModalBody").append(html);
        });
    })
});