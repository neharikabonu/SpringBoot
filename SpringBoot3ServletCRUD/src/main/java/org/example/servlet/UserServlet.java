package org.example.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.example.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

  private UserService userService = new UserService();

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Integer id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    Integer mobile = Integer.parseInt(request.getParameter("mobile"));

    if(id == null || email == null || name == null || mobile == null) {
      response.setStatus(400);
      response.setContentType("application/json");
      response.getWriter().write(
        "{\n" +
                "  \"message\" : \"Some fields are missing\" \n" + "}"
      );
    }

    User user = new User(id, name, email, mobile);
    User createdUser = userService.createUser(user);

    response.setStatus(201);
    response.setContentType("application/json");
    response.getWriter().write(
            "{\n" +
                    "  \"message\" : \"User added successfully \" \n" + "}"
    );
   }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Integer idParam = Integer.parseInt(request.getParameter("id"));

    if (idParam == null) {
      List<User> users = userService.getAllUsers();
    }

    User user = userService.getUserById(idParam);

    if (user == null) {
      response.setStatus(404);
      response.setContentType("application/json");
    }

    //return user
    response.setStatus(201);
    response.setContentType("application/json");
    response.getWriter().write(
            "{\n" +
                    "  \"message\" : \"User added successfully \" \n" + "}"
    );
  }

  @Override
  public void doPut(HttpServletRequest request, HttpServletResponse response) {

  }

  @Override
  public void doDelete(HttpServletRequest request, HttpServletResponse response) {

  }

  @Override
  public void doPatch(HttpServletRequest request, HttpServletResponse response) {

  }

}
