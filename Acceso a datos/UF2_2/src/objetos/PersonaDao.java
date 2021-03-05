/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.interfaces.PersonaInterfaz;
import uf2_2.Persona;

/**
 *
 * @author Laura
 */
public class PersonaDao implements PersonaInterfaz {

    Connection conexion;
    PreparedStatement ps;

    public PersonaDao(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean alta(Persona p) {
        boolean alta = true;

        String query = "INSERT INTO PASAJERO (idp, nombre, edad, peso) "
                + " values(?,?,?,?)";

        try {
            //preparamos la query con valores parametrizables(?)
            ps = conexion.prepareStatement(query);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getEdad());
            ps.setFloat(4, p.getPeso());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                alta = false;
            } else {
                alta = true;
            }
        } catch (SQLException e) {
            System.out.println("alta -> Error al insertar: " + p);
            alta = false;
            e.printStackTrace();
        }

        return alta;
    }

    @Override
    public boolean baja(int id) {
        try {
            String query = "DELETE FROM COCHE WHERE IDP = ?";
            System.out.println(query);

            ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int afectados = ps.executeUpdate();
            System.out.println("Coche con ID = " + afectados + " borrado satisfactoriamente");
        } catch (SQLException e) {
            System.out.println("Error al borrar la persona");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Persona obtener(int id) {
        Persona p = null;
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM PASAJERO WHERE IDP=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {//preguntamos si hay mas filas
                p = new Persona();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setEdad(rs.getInt(3));
                p.setPeso(rs.getFloat(4));
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar el listado de personas");
            System.out.println(e.getMessage());
        }
        return p;
    }

    @Override
    public int obtenerId() {
        try {
            int id = 0;
            PreparedStatement sentencia = conexion.prepareStatement("SELECT MAX(IDP) AS IDP FROM PASAJERO");
            ResultSet rs = sentencia.executeQuery();
            rs.next();
            id = rs.getInt("IDP");
            return id;

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        }
    }

    @Override
    public ArrayList<Persona> listar() {
        ArrayList<Persona> listaP = new ArrayList<>();

        String query = "SELECT * FROM PASAJERO";

        try {
            ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);//no cambia registros
            while (rs.next()) {//preguntamos si hay mas filas
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setEdad(rs.getInt(3));
                p.setPeso(rs.getFloat(4));

                listaP.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar el listado de personas");
            System.out.println(e.getMessage());
        }
        return listaP;
    }

    @Override
    public boolean altaEnCoche(int id, int fk) {
        boolean modificar = true;
        Persona p = null;

        String query = "update PASAJERO set FK_IDC=? WHERE IDP=?";

        try {
            ps = conexion.prepareStatement(query);
            ps.setInt(1, fk);
            ps.setInt(2, id);

            int afectados = ps.executeUpdate();
            if (afectados == 0) {
                modificar = false;
            } else {
                modificar = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al añadir nuevo cliente");
            System.out.println(e.getMessage());
            modificar = false;
            return modificar;
        }

        return modificar;
    }

    @Override
    public boolean bajaEnCoche(int id) {
        boolean modificar = true;
        Persona p = null;

        String query = "update PASAJERO set FK_IDC=0 WHERE IDP=?";

        try {
            ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int afectados = ps.executeUpdate();
            if (afectados == 0) {
                modificar = false;
            } else {
                modificar = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al añadir nuevo cliente");
            System.out.println(e.getMessage());
            modificar = false;
            return modificar;
        }

        return modificar;
    }

    @Override
    public ArrayList<Persona> listarEnCoche(int fk) {
        ArrayList<Persona> listaP = new ArrayList<>();

        String query = "SELECT * FROM PASAJERO WHERE FK_IDC=" + fk;

        try {
            ps = conexion.prepareStatement(query);
            //ps.setInt(5, fk);
            //System.out.println(ps);

            ResultSet rs = ps.executeQuery(query);//no cambia registros
            while (rs.next()) {//preguntamos si hay mas filas
                Persona p = new Persona();
                p.setId(rs.getInt("IDP"));
                p.setNombre(rs.getString("NOMBRE"));
                p.setEdad(rs.getInt("EDAD"));
                p.setPeso(rs.getFloat("PESO"));

                listaP.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar el listado de personas");
            System.out.println(e.getMessage());
        }
        return listaP;
    }

}
