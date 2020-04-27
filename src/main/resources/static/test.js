$(document).ready(function() {
    $('#example').DataTable();
} );


$(".demo_0").ionRangeSlider({
    min: 1,
    max: 30,
    from: 5,
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