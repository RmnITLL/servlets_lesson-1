package ru.gb.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "products", urlPatterns = "/products")
public class ListProducts extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ListProducts.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        logger.info("Log: Third");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.printf("<html><body><h1>Third request</h1></body></html>");
        out.close();
    }
}