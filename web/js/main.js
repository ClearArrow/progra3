$(function () {
    $('#limpiar').on('click', function (event) {
        event.preventDefault();
        $.post('./ChatBot', {'borrar': 'si'}).done(function (data) {
            // console.log(data);
            $('#chat').load('./ChatBot #chat', function () {
                // console.log("listo");
                $("#mensaje").focus();
                $("#mensaje").off('keypress').on('keypress', function (e) {
                    if (e.which == 13) {
                        enviarMensaje();
                    }
                });
            });
        });
    });
    $("#mensaje").off('keypress').on('keypress', function (e) {
        if (e.which == 13) {
            enviarMensaje();
        }
    });
});

function enviarMensaje() {
    var mensaje = $('#mensaje').val();
    if (mensaje.trim()) {
        $.post('./ChatBot', {texto: mensaje, fecha: new Date().getTime(), autor: '1'}).done(function (data) {
            // console.log(data);
            $('#mensaje').val('');
            $('#chat').load('./ChatBot #chat', function () {
                $("#mensaje").off('keypress').on('keypress', function (e) {
                    if (e.which == 13) {
                        enviarMensaje();
                    }
                });
                $("#mensaje").focus();
                $('#historial').scrollTop(10000);
            });
        });
    }
}