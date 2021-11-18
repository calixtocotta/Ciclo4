/* global fetch */

//function traerInformacion(){location.reload(true);}
//Función para actualizar cada 60 segundos(60000 milisegundos)
//setInterval("traerInformacion()",60000);


function consultar(dato){
    $("#resultado").html("<p class='loader text-center'>Cargando...</p>");
    $.ajax({
        url:"http://144.22.228.79:80/api/user/"+$('#email').val()+"/"+$('#password').val(),
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            //console.log(respuesta,dato);
            if(respuesta.id!=null && dato==1){
                $("#header").html("BIENVENIDO");
                $("#bienvenido").html("<h1 align='center'>"+respuesta.name+"</p>");
            }else if((respuesta.id==null && dato==2)){
                $("#resultado").html("<p class='loader text-center'>Creando la cuenta...</p>");
                guardar();
            }else{
                $("#resultado").html("<p align='center'>¿No tienes cuenta? <a id='link' href='javascript:crearCuenta()'>Crea tu cuenta aquí.<a></p>");
                
            }
            
        }
    });
}

function crearCuenta(){
    $("#resultado").html("");

    $("#btn-consultar").hide();
    $("#name").show();
    $("#confirmar").show();
    $("#btn-guardar").show();
}


function validar(){
    
    if ($('#email').val().length == 0 || $('#password').val().length == 0) {
        $("#validarCampos").html("<h4 style='color: red'>Todos los campos son necesarios</h4>");
        return false;
    }else{
        consultar(1);
    }
}

function validar2(){
    
    if ($('#email').val().length == 0 || $('#password').val().length == 0 || $('#confirmar').val().length == 0 || $('#name').val().length == 0) {
        $("#validarCampos").html("<h4 style='color: red'>Todos los campos son necesarios</h4>");
        return false;
    }else{
        if($('#password').val() == $('#confirmar').val()){

            validarEmail();
            //guardar();
        }else{
            $("#validarCampos").html("<h4 style='color: red'>La contraseña no coincide</h4>");
            //console.log("la contraseña no coincide");
            
        }
        
    }
}
function validarEmail(){
    $("#resultado").html("<p class='loader text-center'>Cargando...</p>");
    $.ajax({
        url:"http://144.22.228.79:80/api/user/"+$('#email').val(),
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            if(respuesta==true){
                $("#validarCampos").html("<p align='center' style='color:black'>¿Ya tienes cuenta? <a id='link' href='javascript:location.reload()'>Crea tu cuenta aquí.<a></p>");
            }else{
                consultar(2);
            }
            
        }
    });
}



function guardar(){
    let myData={
        email:$("#email").val(),
        password:$("#password").val(),
        name:$("#name").val()
    };
    let dataToSend=JSON.stringify(myData);
    //console.log(dataToSend);
    
    $.ajax({
        url: "http://144.22.228.79:80/api/user/new",
        type: "POST",
        data: dataToSend,
        contentType:"application/JSON",
        datatype: "JSON",
        success:function(respuesta){
            $("#resultado").html("<p class='loader text-center'>Cuenta creada, espere para ser redireccionado...</p>");
            setTimeout(
                function(){ 
                    $("#header").html("BIENVENIDO");
                    $("#bienvenido").html("<h1 align='center'>"+respuesta.name+"</p>");
                }, 6000
            );
        }
    });

}

