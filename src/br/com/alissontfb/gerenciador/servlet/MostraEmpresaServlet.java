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

@WebServlet(urlPatterns = "/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idAtt = request.getParameter("id");
        Integer id = Integer.valueOf(idAtt);
        Banco banco = new Banco();
        Empresa empresa = banco.getEmpresa(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/formNovaEmpresa.jsp");
        if (empresa != null)
            request.setAttribute("empresa", empresa);
        dispatcher.forward(request, response);
    }
}
