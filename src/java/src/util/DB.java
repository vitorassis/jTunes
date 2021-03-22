package src.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.Musica;
import src.Musica;

public class DB {

    private Connection c;

    public void connectDB() {
        c = null;
        try {
            Class.forName("org.postgresql.Driver");
            String jdbcUrl = "jdbc:postgresql://motty.db.elephantsql.com:5432/dvvipcmx";
            String username = "dvvipcmx";
            String password = "PLa45r5Ql99cT-pIGFYVuUm8snqy3AID";
            c = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Opened database successfully");
    }

    public void disconnectDB() {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(Musica musica) {
        Statement stmt = null;
        try {
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO musicas (nome, artista, estilo) VALUES("
                    + "'" + musica.getNome() + "', " + "'" + musica.getArtista() + "'" + ",'" + musica.getEstilo() + "')";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }

    public ArrayList<Musica> select(String where) {
        Statement stmt = null;
        ArrayList<Musica> musicas = new ArrayList<Musica>();
        try {
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM musicas WHERE " + (where == null ? "1=1" : where));
            while (rs.next()) {
                musicas.add(new Musica(rs.getInt("id"), rs.getString("nome"), rs.getString("estilo"), rs.getString("artista")));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");

        return musicas;
    }

    public void update(Musica musica) {
        Statement stmt = null;
        try {

            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "UPDATE musicas SET nome='" + musica.getNome() + "', "
                    + "estilo='" + musica.getEstilo() + "',"
                    + "artista='" + musica.getArtista() + "' WHERE id=" + musica.getId();
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }

    public void delete(Musica musica) {
        Statement stmt = null;
        try {
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "DELETE from musicas where id=" + musica.getId();
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operation done successfully");
    }

    public DB() {
        this.connectDB();
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            this.disconnectDB();
        } finally {
            super.finalize();
        }
    }

    ///////////////////////////////////////////////////////////////////
    public static void createDB() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.JDBC");
            String jdbcUrl = "jdbc:postgresql://motty.db.elephantsql.com:5432/dvvipcmx";
            String username = "dvvipcmx";
            String password = "PLa45r5Ql99cT-pIGFYVuUm8snqy3AID";
            c = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE musicas "
                    + "(id SERIAL PRIMARY KEY,"
                    + " nome           text    NOT NULL, "
                    + " artista        TEXT     NOT NULL, "
                    + " estilo     text    not null)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Table created successfully");
    }

}
