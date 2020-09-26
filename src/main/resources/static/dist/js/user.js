$('document').ready(function () {

    $(".table #delBtn").on('click',function (event) {
        event.preventDefault();
        let href =$(this).attr('href');
        $('#delRef').attr('href',href);
        $('#delModal').modal();

    });

    $(".table #acceptBtn").on('click',function (event) {
        event.preventDefault();
        let href=$(this).attr('href');
        $('#acceptRef').attr('href',href);
        $('#acceptModal').modal()

    })
    $(".table #blockedBtn").on('click',function (event) {
        event.preventDefault();
        let href=$(this).attr('href');
        $('#blockedRef').attr('href',href);
        $('#blockedModal').modal()

    })

    $(".table #detailsBtn").on('click',function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href,function (user,status) {
            $('#nom').val(user.firstName);
            $('#prenom').val(user.lastName);
            $('#email').val(user.email);

        });

        $('#detailsModal').modal();

    })

})
