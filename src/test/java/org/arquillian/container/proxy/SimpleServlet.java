package org.arquillian.container.proxy;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test"})
public class SimpleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private CountryRepository repo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        repo.createNew("Norway");
        repo.createNew("Germany");
        resp.getWriter().write("ok");
    }
}
