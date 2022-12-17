$(document).ready(function () {

    /*Agregar Cliente*/
    $("#agregarCliente").click(function () {
        var dni = document.getElementById('dni').value;
        var nombre = document.getElementById('nombre').value;
        var apellido = document.getElementById('apellido').value;
        var direccion = document.getElementById('direccion').value;

        if (dni.length === 0 || nombre.length === 0 || apellido === 0 || direccion === 0) {
            alert("!Todos los campos deben estar llenos!");

        } else {
            document.form.action = "Controlador?menu=Cliente&accion=Agregar";
            document.form.method = "POST";
            document.form.submit();
        }
    });
    
    /*Agregar Producto*/
    $("#agregarProducto").click(function () {
        var nombre = document.getElementById('nombre').value;
        var precio = document.getElementById('precio').value;
        var stock = document.getElementById('stock').value;

        if (nombre.length === 0 || precio.length === 0 || stock.length === 0) {
            alert("!Todos los campos deben estar llenos!");

        } else {
            document.form.action = "Controlador?menu=Producto&accion=Agregar";
            document.form.method = "POST";
            document.form.submit();
        }
    });
    
    /*Agregar Empleado*/
    $("#agregarEmpleado").click(function () {
        var dni = document.getElementById('dni').value;
        var nombre = document.getElementById('nombre').value;
        var apellido = document.getElementById('apellido').value;
        var telefono = document.getElementById('telefono').value;
        var usuario = document.getElementById('usuario').value;
        var clave = document.getElementById('clave').value;

        if (dni.length === 0 || nombre.length === 0 || apellido.length === 0 || telefono.length === 0 || usuario === 0 || clave === 0) {
            alert("!Todos los campos deben estar llenos!");

        } else {

            if (usuario.length < 8) {
                alert("!El nombre de usuario debe tener mínimo 8 caracteres!");

            } else if (clave.length < 8) {
                alert("!La clave debe tener mínimo 8 caracteres!");

            } else {
                document.form.action = "Controlador?menu=Empleado&accion=Agregar";
                document.form.method = "POST";
                document.form.submit();
            }
        }
    });
    
    /*Actualizar Empleado*/
    $("#actualizarEmpleado").click(function () {
        var dni = document.getElementById('dni').value;
        var nombre = document.getElementById('nombre').value;
        var apellido = document.getElementById('apellido').value;
        var telefono = document.getElementById('telefono').value;
        var usuario = document.getElementById('usuario').value;

        if (dni.length === 0 || nombre.length === 0 || apellido.length === 0 || telefono.length === 0 || usuario === 0) {
            alert("!Todos los campos deben estar llenos!");

        } else {

            if (usuario.length < 8) {
                alert("!El nombre de usuario debe tener mínimo 8 caracteres!");
                
            } else {
                document.form.action = "Controlador?menu=Empleado&accion=Actualizar";
                document.form.method = "POST";
                document.form.submit();
            }
        }
    });    
});