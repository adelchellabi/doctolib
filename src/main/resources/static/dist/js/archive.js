$('document').ready(function () {

    $(".table #delBtn").on('click',function (event) {
        event.preventDefault();
        let href =$(this).attr('href');
        $('#delRef').attr('href',href);
        $('#delModal').modal();

    });



})
