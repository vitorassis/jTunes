/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function trigger(source, event) {
    if (source != null) {
        $("a.active").each(function (index) {
            $(this).removeClass("active");
        });
        $(source).addClass("active");
    }

    //REQUISIÇÃO DA TELA

    fetch(event + ".jsp").then(function (response) {
        return response.text();
    }).then(function (text) {
        $(".pane").html(text);
    });

}

function recMusica() {
    var data = JSON.stringify({
        nome: $("#nome").val(),
        artista: $("#artista").val(),
        estilo: $("#estilo").val(),
        arquivo: $("#arquivo").val()
    });

    console.log(data);

    fetch("./proc-new-musica", {

        method: "POST",
        body: data,
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
    }).then(function (resp) {
        return resp.text();
    }).then(function (resp) {
        alert(resp);
    }).then(trigger(null, "manage"));

}
