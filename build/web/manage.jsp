<%-- 
    Document   : manage
    Created on : 21/03/2021, 16:45:38
    Author     : vitorassis
--%>

<%@page import="src.Musica"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    ArrayList<Musica> musicas = Musica.getAll();
%>

<div class="toolbar-actions">
    <div class="btn-group">
        <button class="btn btn-default" onclick="trigger(this, 'new-musica')">
            <span class="icon icon-plus"></span>
        </button>
        <button class="btn btn-default">
            <span class="icon icon-pencil"></span>
        </button>
        <button class="btn btn-default">
            <span class="icon icon-trash"></span>
        </button>
        
    </div>

    <button class="btn btn-default">
        <span class="icon icon-search"></span>
        Buscar
    </button>
</div>

<table class="table-striped">
    <thead>
        <tr>
            <th></th>
            <th>ID</th>
            <th>Nome</th>
            <th>Arista</th>
            <th>Estilo</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (Musica musica : musicas) {
        %>
        <tr>
            <td><input type="radio" name="musica" value="<%=musica.getId()%>"></td>
            <td><%=musica.getId()%></td>
            <td><%=musica.getNome()%></td>
            <td><%=musica.getArtista()%></td>
            <td><%=musica.getEstilo()%></td>

        </tr>
        <% }%>
    </tbody>
</table>