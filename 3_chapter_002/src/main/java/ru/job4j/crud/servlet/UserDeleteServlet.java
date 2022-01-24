package ru.job4j.crud.servlet;

import ru.job4j.crud.logic.Validate;
import ru.job4j.crud.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {

    /**
     * Logic layout - слой содержит выполнение бизнес логики.
     */
    private final Validate service = ValidateService.getInstance();

    private static final String FN = File.separator;

    /**
     * Удаляет пользователя.
     * После удаления отправляет GET сервлету UsersServlet.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        if (service.delete(id)) {
            response.sendRedirect(String.format("%s/", request.getContextPath()));
        } else {
            writer.append(String.format("error delete for id=%d", id));
        }
    }
}
