package mx.uv;


import static spark.Spark.*;

import java.util.List;

import com.google.gson.Gson;

public class App {
    static Gson gson = new Gson();
    static AutoDAO autoDAO = new AutoDAO(Conexion.getConnection());

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        // Endpoint para obtener todos los autos
        get("/autos", (request, response) -> {
            response.type("application/json");
            List<Auto> autos = autoDAO.obtenerTodosvehiculos();
            return gson.toJson(autos);
        });

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; // return default port if heroku-port isn't set (i.e. on localhost)
    }
}
