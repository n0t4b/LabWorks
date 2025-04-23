package com.example.mynewwebapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String fio = "Ващенко Микита Андрійович";
        int courseNumber = 2;
        int groupNumber = 231;
        String courseTopic = "Розробка мобільного додатку управління персональними фінанасами";

        out.println("<html>");
        out.println("<head><title>Мої Дані</title></head>");
        out.println("<body>");
        out.println("<h1>Мої Дані</h1>");
        out.println("<p>ФІО: " + fio + "</p>");
        out.println("<p>Номер курсу: " + courseNumber + "</p>");
        out.println("<p>Номер групи: " + groupNumber + "</p>");
        out.println("<p>Тема курсової: " + courseTopic + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
