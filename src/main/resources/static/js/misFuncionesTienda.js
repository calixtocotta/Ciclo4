/* global fetch */

//function traerInformacion(){location.reload(true);}
//Función para actualizar cada 60 segundos(60000 milisegundos)
//setInterval("traerInformacion()",60000);
//traerInformacion();

function traerInformacion(){
    $("#resultado").html("<p class='loader text-center'>Cargando...</p>");
    $.ajax({
        url:"http://144.22.228.79:8080/api/clothe/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);         
            pintarRespuesta(respuesta);
        }
    });
}

function pintarRespuesta(items){
    let myDiv="<div class='products-list'>";
    

    for (i=0; i<items.length; i++ ) {
        myDiv+="<div class='product-item' category='clothe'>";
        myDiv+="<img class='imagen' src='"+items[i].photography+"' alt=''>";
        myDiv+="<a>Descripción: "+items[i].description+"</a>";
        myDiv+="<a>Talla: "+items[i].size+"</a>";
        myDiv+="</div>";
    }
    myDiv+="</div";
    $("#resultado").html(myDiv);
}
