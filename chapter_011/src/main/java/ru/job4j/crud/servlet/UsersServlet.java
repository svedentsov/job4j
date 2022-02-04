package ru.job4j.crud.servlet;

import ru.job4j.crud.datamodel.User;
import ru.job4j.crud.logic.Validate;
import ru.job4j.crud.logic.ValidateService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Presentation layout - слой сервлетов.
 */
public class UsersServlet extends HttpServlet {

    /**
     * Ссылка на объект ValidateService.
     * Logic layout - слой содержит выполнение бизнес логики.
     */
    private final Validate service = ValidateService.getInstance();

    /**
     * Открывает html-страницу с таблицей пользователей и возможностью их редактировать и удалять.
     * <p>
     * кнопка "update" отправляет GET сервлету UserUpdateServlet
     * кнопка "delete" отправляет POST сервлету UserDeleteServlet
     * также на странице есть кнопка "Create new user" - отправляет GET сервлету UserCreateServlet.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String table = createHTMLTable(this.service.findAll(), request);

        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"

                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Users list</title>"
                + "</head>"

                + "<body>"
                + "<form action = '" + request.getContextPath() + "/list/create' method='get'>"
                + "<input type='submit' value='Create new user' />"
                + "</form>"
                + "<br>"
                + table
                + "</body>"

                + "</html>");

        writer.flush();
    }

    /**
     * Создает таблицу со списком пользователей и кнопками редактировать и удалить.
     * <p>
     * Создание таблицы:
     * <table> создаем таблицу
     * <tr><td> </tr></td> создаем новую строку и новую ячейку
     * </table>
     * <p>
     * Создание кнопки редактирования:
     * <form action = .../update' method='get'> данные формы обрабатывает сервлет с адресом /list/update, тип запроса GET
     * <input type='hidden' name='id' value='tmp.getId()'/> передаем скрытый параметр id=номер пользователя.
     * <input type='submit' value='update'> </form> кнопка для отправки данных формы на сервер, текст на кнопке update.
     *
     * @param users список пользователей
     * @return таблица в html
     */
    private String createHTMLTable(List<User> users, HttpServletRequest request) {
        StringBuilder sb = new StringBuilder("<table>");

        for (User user : users) {
            sb.append("<tr>");
            sb.append("<td>" + user.toString() + "</td>");

            sb.append("<td>"
                    + "<form action = '" + request.getContextPath() + "/list/update' method='get'>"
                    + "<input type='hidden' name='id' value='" + user.getId() + "'/>"
                    + "<input type='submit' value='update'>" + "</form>"
                    + "</td>");

            sb.append("<td>"
                    + "<form action = '" + request.getContextPath() + "/list/delete' method='post'>"
                    + "<input type='hidden' name='id' value='" + user.getId() + "'/>"
                    + "<input type='submit' value='delete' />" + "</form>"
                    + "</td>");

            sb.append("</tr>");
        }

        sb.append("</table>");
        return sb.toString();
    }
}
