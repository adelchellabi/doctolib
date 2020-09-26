$(document).ready(function () {
    $(".table #detailsBtn").on('click',function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href,function (demandeur,status) {
            $('#num_carte_nationnel').val(demandeur.num_carte_nationnel);
            $('#niv_revenus').val(demandeur.niv_revenus);
            $('#condit_habitat').val(demandeur.condit_habitat);
            $('#st_individuelle').val(demandeur.st_individuelle);
            $('#st_fam').val(demandeur.st_fam);
            $('#num_carte_nationnel_conj').val(demandeur.num_carte_nationnel_conj);
            $('#niv_revenus_cnjnt').val(demandeur.niv_revenus_cnjnt);
            $('#nbr_enfant').val(demandeur.nbr_enfant);

        });

        $('#detailsModal').modal();

    })


})