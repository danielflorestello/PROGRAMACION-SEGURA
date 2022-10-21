$(document).ready(function () {

    $("#boton").click(function () {
        var tipo = document.getElementById("password");

        if (tipo.type === 'password') {
            tipo.type = 'text';
            $('#icon').removeClass('bi bi-eye-slash'),
                    $('#icon').addClass('bi bi-eye');

        } else {
            tipo.type = 'password';
            $('#icon').removeClass('bi bi-eye'),
                    $('#icon').addClass('bi bi-eye-slash');
        }
    });

    $("#ingresar").click(function () {
        var usuario = document.getElementById('user').value;
        var clave = document.getElementById('password').value;

        if (usuario.length === 0) {
            alert("!Ingresar el Usuario por favor!");

        } else {

            if (clave.length === 0) {
                alert("!Ingresar Clave por favor¡");

            } else {
                document.form.action = "Validar?accion=Ingresar";
                document.form.method = "POST";
                document.form.submit();
            }
        }
    });
});