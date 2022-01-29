package ru.job4j.crud.servlet;

import ru.job4j.crud.datamodel.User;
import ru.job4j.crud.logic.Validate;
import ru.job4j.crud.logic.ValidateService;
import ru.job4j.crud.datamodel.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdateServlet extends HttpServlet {

    /**
     * Logic layout - слой содержит выполнение бизнес логики.
     */
    private final Validate service = ValidateService.getInstance();

    /**
     * Открывает форму для редактирования с заполенными полями.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", service.findById(id));
        request.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(request, response);
    }

    /**
     * Обновляет пользователя.
     * После обновления отправляет GET сервлету UsersServlet.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        String country = request.getParameter("country");
        String city = request.getParameter("city");

        User user = new User(id, name, login, email, password, new Role(role));

        user.setCountry(country);
        user.setCity(city);

        if (service.update(user, id)) {
            response.sendRedirect(String.format("%s/", request.getContextPath()));
        } else {
            writer.append(String.format("error updated for id=%d", id));
        }
    }
}
