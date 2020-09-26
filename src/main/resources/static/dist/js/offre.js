$(document).ready(function () {
    $(".table #acceptOffre").on('click',function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href,function (demande,status) {
            $('#idDemande').val(demande.id_demande);
            $('#localisation').val(demande.localisation);
            $('#nbr').val(demande.nbr_pieces);
            $('#type_offre').val(1);

        });

        $('#acceptModal').modal();

    })

    $(".table #newOffre").on('click',function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href,function (demande,status) {
            $('#idDemandeNew').val(demande.id_demande);


        });

        $('#proposeModal').modal();

    })
    $(".table #gererOffreBtn").on('click',function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href,function (offre,status) {
            $('#localisation_log').val(offre.localisation_log);
            $('#idDemande').val(offre.id_demande);
            $('#nbr_pieces').val(offre.nbr_pieces);
            $('#type_log').val(offre.type_log);

            $('#acceptoffre').attr('href' ,`/demandeur/accepterOffre?id=${offre.id_demande}`);
            if(offre.type_offre===0)
            $('#faireRecours').attr('href' ,`/demandeur/refuseOffreWithRecours?id=${offre.id_demande}`);
            else  {
                $('#faireRecours').attr('href' ,"");
                $('#faireRecours').hide();
            }
            $('#supprimerDemande').attr('href' ,`/demandeur/refuseOffreWithDeleteDemande?id=${offre.id_demande}`);


        });

        $('#gererModal').modal();

    })
})