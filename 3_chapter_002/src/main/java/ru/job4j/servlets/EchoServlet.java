package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EchoServlet extends HttpServlet {

    private List<String> users = new CopyOnWriteArrayList<>();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        writer.append("hello world, " + this.users);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        this.users.add(req.getParameter("login"));
        doGet(req, res);
    }
}
