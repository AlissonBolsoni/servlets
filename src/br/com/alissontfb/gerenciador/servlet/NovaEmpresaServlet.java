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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idAtt = req.getParameter("id");
        String nome = req.getParameter("nome");
        String dataAbertura = req.getParameter("dataAbertura");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Banco banco = new Banco();

        Empresa empresa = banco.getEmpresa(Integer.valueOf(idAtt));
        if (empresa == null) {
            empresa = new Empresa();
        }
        empresa.setNome(nome);
        try {
            empresa.setDataAbertura(sdf.parse(dataAbertura));
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        if (idAtt.isEmpty())
            banco.adiciona(empresa);
        else {
            empresa.setId(Integer.valueOf(idAtt));
            banco.editaEmpresa(empresa);
        }


        resp.sendRedirect("listaEmpresas");


//        RequestDispatcher dispatcher = req.getRequestDispatcher("/listaEmpresas");
//        req.setAttribute("empresa", empresa.getNome());
//        dispatcher.forward(req, resp);
    }

}
