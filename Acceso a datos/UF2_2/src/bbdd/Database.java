/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Laura
 */
public class Database {

    private Connection conexion;

    public boolean abrirConexion() {
        String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd_uf2";
        String user = "root";
        String pass = ""; // sustituye por la contraseña que especificaste durante la instalacion de MySQL.

        try {
            //DriverManager es una clase que gestiona las conexiones, y aqui le
            //pedimos una conexion
            conexion = DriverManager.getConnection(cadenaConexion, user, pass);
        } catch (SQLException e) {
            System.out.println("No se ha podido establecer la conexion con la BD");
            System.out.println(e.getMessage());
            return false;
        }

        System.out.println("Se ha establecido la conexion con la Base de datos");
        return true;
    }

    public boolean cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Connection crearBBDD() {
        abrirConexion();
        boolean estaCreada = true;

        try {
            //Con esto creamos una bbdd enbebida dentro del proyecto 
            Statement state = conexion.createStatement();

            state.execute("create table coche(ID INT NOT NULL, "
                    + "MATRICULA varchar(7), "
                    + "MARCA varchar(20), "
                    + "MODELO varchar(100),"
                    + "COLOR varchar(50),"
                    + "CONSTRAINT primary_key PRIMARY KEY (ID)"
                    + ")");
            
        } catch (SQLException e) {
            estaCreada = false;
        }

        return conexion;
    }

    public Connection crearBBDD2() {
        boolean estaCreada = true;

        try {
            //Con esto creamos una bbdd enbebida dentro del proyecto 
            Statement state2 = conexion.createStatement();

            state2.execute("create table pasajero(IDP INT NOT NULL, "
                    + "NOMBRE varchar(50), "
                    + "EDAD integer, "
                    + "PESO float, "
                    + "FK_IDC INT, "
                    + "CONSTRAINT primary_key PRIMARY KEY (IDP), "
                    + "CONSTRAINT foreign_key FOREIGN KEY (FK_IDC) REFERENCES coche(ID)"
                    + ")");

        } catch (SQLException e) {
            estaCreada = false;
        }

        return conexion;
    }

    public Connection getConexion() {
        return conexion;
    }
}
