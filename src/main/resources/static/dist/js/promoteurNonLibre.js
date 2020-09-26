$('document').ready(function () {

    $(".table #delBtn").on('click',function (event) {
        event.preventDefault();
        let href =$(this).attr('href');
        $('#delRef').attr('href',href);
        $('#delModal').modal();

    });


    $(".table #editBtn").on('click',function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href,function (promoteur,status) {
            $('#idEdit').val(promoteur.id_promoteur);
            $('#nomEdit').val(promoteur.nom);
            $('#prenomEdit').val(promoteur.prenom);
            $('#emailEdit').val(promoteur.email);
            $('#addresseEdit').val(promoteur.adrs	);
            $('#numrRegistreEdit').val(promoteur.num_registre);
            $('#idFournisseurEdit').val(promoteur.id_fournisseur);
        });

        $('#editModal').modal();

    })

})
