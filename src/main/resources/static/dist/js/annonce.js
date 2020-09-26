$(document).ready(function() {
$('#btnAnnonce').on("click",function () {
    $('#annonceModal').modal();
})
    $("#submit").on("click", function() {
        $("#submit").prop("disabled", true);
        var titre = $("#titre").val();
        var file = $("#image").val();
        var auteur = $("#auteur").val();
        var description = $("#description").val();
        var form = $("#form").serialize();
        var data = new FormData($("#form")[0]);
        data.append('titre', titre);
        data.append('auteur', auteur);
        data.append('description', description);
        //alert(data);

        if (titre === "" || file === "" || auteur === "" || description === "") {
            $("#submit").prop("disabled", false);

            $("#titre").css("border-color", "red");
            $("#image").css("border-color", "red");
            $("#auteur").css("border-color", "red");
            $("#description").css("border-color", "red");
            $("#error_titre").html("Please fill the required field.");
            $("#error_file").html("Please fill the required field.");
            $("#error_auteur").html("Please fill the required field.");
            $("#error_description").html("Please fill the required field.");
        } else {
            $("#titre").css("border-color", "");
            $("#image").css("border-color", "");
            $("#auteur").css("border-color", "");
            $("#description").css("border-color", "");
            $('#error_titre').css('opacity', 0);
            $('#error_file').css('opacity', 0);
            $('#error_auteur').css('opacity', 0);
            $('#error_description').css('opacity', 0);
            $.ajax({
                type: 'POST',
                enctype: 'multipart/form-data',
                data: data,
                url: "/fournisseur/saveAnnonce",
                processData: false,
                contentType: false,
                cache: false,
                success: function(data, statusText, xhr) {
                    console.log(xhr.status);
                    if(xhr.status == "200") {

                        $("#form")[0].reset();
                        $('#success').css('display','block');
                        $("#error").text("");
                        $("#success").html("Annonce Inserted Succsessfully.");
                        $('#success').delay(2000).fadeOut('slow');
                    }
                },
                error: function(e) {

                    $('#error').css('display','block');
                    $("#error").html("Oops! something went wrong.");
                    $('#error').delay(5000).fadeOut('slow');
                    location.href="/fournisseur/index";
                }
            });
        }
    });
});