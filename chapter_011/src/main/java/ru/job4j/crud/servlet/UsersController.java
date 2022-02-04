package ru.job4j.crud.servlet;

import ru.job4j.crud.logic.Validate;
import ru.job4j.crud.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UsersController extends HttpServlet {

    /**
     * Ссылка на объект ValidateService.
     * Logic layout - слой содержит выполнение бизнес логики.
     */
    private final Validate service = ValidateService.getInstance();

    /**
     * Выполняет редирект на UsersView.jsp
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        request.setAttribute("user", service.findByLogin(login));
        request.setAttribute("users", service.findAll());
        request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(request, response);
    }
}
