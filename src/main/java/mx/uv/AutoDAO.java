package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.google.gson.JsonElement;

public class AutoDAO {

    private Connection connection;

    public AutoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para guardar un modelo de auto en la base de datos
    public void guardarAuto(Auto auto) {
        try {
            String query = "INSERT INTO vehiculos (nombre, marca, modelo, puertas, clase, precio, imagen) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, auto.getNombre());
                preparedStatement.setString(2, auto.getMarca());
                preparedStatement.setString(3, auto.getModelo());
                preparedStatement.setInt(4, auto.getPuertas());
                preparedStatement.setString(5,auto.getClase());
                preparedStatement.setDouble(6, auto.getPrecio());
                preparedStatement.setString(7, auto.getImagen());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para recuperar todos los modelos de autos de la base de datos
    public List<Auto> obtenerTodosvehiculos() {
        List<Auto> vehiculos = new ArrayList<>();
        try {
            String query = "SELECT * FROM vehiculos";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Auto auto = new Auto();
                        auto.setNombre(resultSet.getString("nombre"));
                        auto.setModelo(resultSet.getString("modelo"));
                        auto.setMarca(resultSet.getString("marca"));
                        auto.setPuertas(resultSet.getInt("puertas"));
                        auto.setClase(resultSet.getString("clase"));
                        auto.setPrecio(resultSet.getDouble("precio"));
                        auto.setImagen(resultSet.getString("imagen"));
                        vehiculos.add(auto);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    // Método para eliminar un modelo de auto de la base de datos por nombre
    public void eliminarAutoPorNombre(String nombre) {
        try {
            String query = "DELETE FROM vehiculos WHERE nombre=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nombre);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
