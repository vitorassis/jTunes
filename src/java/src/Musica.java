/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import src.util.DB;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author vitorassis
 */
public class Musica {

    public static boolean exists(String nome, String artista) {
        return new DB().select("nome='" + nome + "' and artista='" + artista + "'").size() > 0;
    }
    private int id;
    private String nome;
    private String estilo;
    private String artista;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Musica(int id, String nome, String estilo, String artista) {
        this.id = id;
        this.nome = nome;
        this.estilo = estilo;
        this.artista = artista;
    }

    public Musica() {
        this.id = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAudio() {
        return null;
    }

    public void setAudio(File file) {

    }

    public static ArrayList<Musica> getAll() {
        ArrayList<Musica> musicas = new DB().select(null);

        return musicas;
    }

    public boolean salvar() {
        try {
            if (this.getId() == 0) {
                new DB().update(this);
            } else {
                new DB().insert(this);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
