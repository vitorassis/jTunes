<%-- 
    Document   : new-musica
    Created on : 21/03/2021, 19:10:03
    Author     : vitorassis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form name="form-new" enctype="multipart/form-data" method="post">
    <div class="form-group">
        <label>Nome</label>
        <input type="text" name="nome" id="nome" class="form-control" placeholder="Nome" required>
    </div>
    <div class="form-group">
        <label>Artista</label>
        <input type="text" name="artista" id="artista" class="form-control" placeholder="Artista" required>
    </div>
    <div class="form-group">
        <label>Estilo</label>
        <input type="text" name="estilo" id="estilo" class="form-control" placeholder="Estilo" required>
    </div>
    <div class="form-group">
        <label>Arquivo MP3</label>
        <input type="file" name="arquivo" id="arquivo" class="form-control" placeholder="Arquivo MP3" accept=".mp3" required>
    </div>
    
    <div class="form-group">
        <button class="btn btn-large btn-negative" type="reset">Limpar</button>
        <button class="btn btn-large btn-positive" type="button" onclick="recMusica()">Salvar</button>
    </div>
</form>