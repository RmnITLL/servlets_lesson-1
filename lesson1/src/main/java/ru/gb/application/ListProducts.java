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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "products", urlPatterns = "/products")
public class ListProducts extends HttpServlet {

    //List<Product> productsList = new ArrayList<>();


    private static Logger logger = LoggerFactory.getLogger(ListProducts.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        logger.info("Log: Products");
        res.setContentType("text/html");
        res.getWriter().printf("<html><body>");

        List<Product> products = new ArrayList<Product>();

        products.add(new Product(1, "Milk", 2.99));
        products.add(new Product(2, "Cheese", 3.99));
        products.add(new Product(3, "Kefir", 1.99));
        products.add(new Product(4, "Yogurt", 0.99));
        products.add(new Product(5, "Ryazhnka", 2.99));
        products.add(new Product(7, "Butter", 4.99));
        products.add(new Product(8, "Curd", 3.99));
        products.add(new Product(9, "Cream", 2.99));
        products.add(new Product(10, "Sour Cream", 5.99));

        for (Product dre : products)
            res.getWriter().printf(dre.toString());

        res.getWriter().printf("</body></html>");
        res.getWriter().close();

    }


}
