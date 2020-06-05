$(document).ready(function() {
    $('#example').DataTable();
} );


$(".demo_0").ionRangeSlider({
    min: 1,
    max: 30,
    from: 5,
});
$(".hours_spent").ionRangeSlider({
    min: 1,
    max: 300,
    from: 10,
});
$(".contribution").ionRangeSlider({
    min: 1,
    max: 100,
    from: 50,
});



$(".demo_6").ionRangeSlider({
    grid: true,
    values: [
        "Beginner", "Intermediate", "Advanced"

    ]
});
$('#myDatepicker2').datetimepicker({
    format: 'YYYY.MM.DD'
});
$('#content').summernote({
    height: 200
});

$(function() {
    $(".knob").knob();
});
$(function() {
    $(".knob1").knob();
});

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#imgInp").change(function(){
    readURL(this);
});

$(document).on("click", ".open-AddBookDialog", function () {
    var myBookId = $(this).data('id');
    $(".modal-body #bookId").val( myBookId );

     $('#addBookDialog').modal('show');
});