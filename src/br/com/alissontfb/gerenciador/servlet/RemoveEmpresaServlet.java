package br.com.alissontfb.gerenciador.servlet;

import br.com.alissontfb.gerenciador.data.Banco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idAtt = request.getParameter("id");
        Integer id = Integer.valueOf(idAtt);
        Banco banco = new Banco();
        banco.removeEmpresa(id);
        response.sendRedirect("listaEmpresas");
    }
}
