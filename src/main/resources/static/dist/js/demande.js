$(document).ready(function () {
    $(".table #delBtn").on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $('#delRef').attr('href', href);
        $('#delModal').modal();

    });

    $(".table #renBtn").on('click',function (event) {
        event.preventDefault();
        let href =$(this).attr('href');
        $('#renRef').attr('href',href);
        $('#renModal').modal();

    });

    $(".table #acceptBtn").on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $('#acceptRef').attr('href', href);
        $('#acceptModal').modal();

    });
    $(".table #editBtn").on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (demande, status) {
            $('#idEdit').val(demande.id_demande);
            $('#localisationEdit').val(demande.localisation);
            $('#nbrEdit').val(demande.nbr_pieces);
            $('#id_formule').val(demande.id_formule);
            $('#nbrEdit').val(demande.nbr_pieces);
            $('#id_demandeur').val(demande.id_demandeur);
            $('#type_demande').val(demande.type_demande);
            $('#etat_demande').val(demande.etat_demande);

        });

        $('#editModal').modal();

    })
})