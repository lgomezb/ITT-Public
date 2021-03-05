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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.interfaces.CocheInterfaz;
import uf2_2.Coche;

/**
 *
 * @author Laura
 */
public class CocheDao implements CocheInterfaz {

    Connection conexion;
    PreparedStatement ps;

    public CocheDao(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean alta(Coche coche) {
        boolean alta = true;

        String query = "INSERT INTO COCHE (id, matricula, marca, modelo, color) "
                + " values(?,?,?,?,?)";

        try {
            //preparamos la query con valores parametrizables(?)
            ps = conexion.prepareStatement(query);
            ps.setInt(1, coche.getId());
            ps.setString(2, coche.getMatricula());
            ps.setString(3, coche.getMarca());
            ps.setString(4, coche.getModelo());
            ps.setString(5, coche.getColor());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                alta = false;
            } else {
                alta = true;
            }
        } catch (SQLException e) {
            System.out.println("alta -> Error al insertar: " + coche);
            alta = false;
            e.printStackTrace();
        }

        return alta;
    }

    @Override
    public boolean baja(int id) {

        try {
            String query = "DELETE FROM COCHE WHERE ID = ?";
            System.out.println(query);

            ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int afectados = ps.executeUpdate();
            System.out.println("Coche con ID = " + afectados + " borrado satisfactoriamente");
        } catch (SQLException e) {
            System.out.println("Error al borrar el coche");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Coche obtener(int id) {
        Coche coche = null;
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM coche WHERE ID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {//preguntamos si hay mas filas
                coche = new Coche();
                coche.setId(rs.getInt(1));
                coche.setMatricula(rs.getString(2));
                coche.setMarca(rs.getString(3));
                coche.setModelo(rs.getString(4));
                coche.setColor(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar el listado de coches");
            System.out.println(e.getMessage());
        }
        return coche;
    }

    @Override
    public Coche modificar(int id, Coche coche) {
        boolean modificar = true;
        String query = "update coche set MATRICULA=?, MARCA=?, "
                + "MODELO=?, COLOR=? WHERE ID=?";

        try {
            ps = conexion.prepareStatement(query);
            ps.setString(1, coche.getMatricula());
            ps.setString(2, coche.getMarca());
            ps.setString(3, coche.getModelo());
            ps.setString(4, coche.getColor());
            ps.setInt(5, id);

            int afectados = ps.executeUpdate();
            if (afectados == 0) {
                modificar = false;
            } else {
                modificar = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al a�adir nuevo cliente");
            System.out.println(e.getMessage());
            modificar = false;
            return coche;
        }

        return coche;
    }

    @Override
    public ArrayList<Coche> listar() {
        ArrayList<Coche> lista = new ArrayList<>();

        String query = "SELECT * FROM COCHE";

        try {
            ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);//no cambia registros
            while (rs.next()) {//preguntamos si hay mas filas
                Coche coche = new Coche();
                coche.setId(rs.getInt(1));
                coche.setMatricula(rs.getString(2));
                coche.setMarca(rs.getString(3));
                coche.setModelo(rs.getString(4));
                coche.setColor(rs.getString(5));

                lista.add(coche);
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar el listado de coches");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public int obtenerId() {
        try {
            int id = 0;
            PreparedStatement sentencia = conexion.prepareStatement("SELECT MAX(ID) AS ID FROM COCHE");
            ResultSet rs = sentencia.executeQuery();
            rs.next();
            id = rs.getInt("ID");
            return id;

        } catch (SQLException ex) {
            Logger.getLogger(CocheDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;

        }

    }

}
