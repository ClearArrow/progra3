$(function () {
    $('#limpiar').on('click', function (event) {
        event.preventDefault();
        $.post('./ChatBot', {'borrar': 'si'}).done(function (data) {
            // console.log(data);
            $('#chat').load('./ChatBot #chat', function () {
                // console.log("listo");
            });
        });
    });
    $("#mensaje").keypress(function (e) {
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
                $("#mensaje").keypress(function (e) {
                    if (e.which == 13) {
                        enviarMensaje();
                    }
                });
                // console.log("listo");
            });
        });
    }
}