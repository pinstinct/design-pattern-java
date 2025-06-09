package dev.limhm;

import dev.limhm.middleware.Middleware;
import dev.limhm.middleware.RoleCheckMiddleware;
import dev.limhm.middleware.ThrottlingMiddleware;
import dev.limhm.middleware.UserExistsMiddleware;
import dev.limhm.server.Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Demo class. Everything comes together here.
 */
public class Demo {

  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Server server;

  private static void init() {
    server = new Server();
    server.register("admin@example.com", "admin_pass");
    server.register("user@example.com", "user_pass");

    // All checks are linked. Client can build various chains using the same component.
    Middleware middleware = Middleware.link(new ThrottlingMiddleware(2),
        new UserExistsMiddleware(server), new RoleCheckMiddleware());

    // Server gets a chain from client code.
    server.setMiddleware(middleware);
  }

  public static void main(String[] args) throws IOException {
    init();

    boolean success;
    do {
      System.out.println("Enter email: ");
      String email = reader.readLine();
      System.out.println("Input password: ");
      String password = reader.readLine();
      success = server.login(email, password);
    } while (!success);
  }
}
