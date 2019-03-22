package br.com.alissontfb.gerenciador.servlet;

import br.com.alissontfb.gerenciador.data.Banco;
import br.com.alissontfb.gerenciador.models.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Banco banco = new Banco();

        request.setAttribute("empresas", banco.getEmpresas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");
        dispatcher.forward(request, response);
    }
}
