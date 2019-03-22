package br.com.alissontfb.gerenciador.data;

import br.com.alissontfb.gerenciador.models.Empresa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Banco {

    private static HashMap<Integer, Empresa> empresas = new HashMap<>();
    private static Integer ultimoId = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setId(ultimoId++);
        empresa.setNome("Alisson");
        empresas.put(empresa.getId(), empresa);
        empresa = new Empresa();
        empresa.setId(ultimoId++);
        empresa.setNome("Alisson Bolsoni");
        empresas.put(empresa.getId(), empresa);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(ultimoId++);
        empresas.put(empresa.getId(), empresa);
    }

    public List<Empresa> getEmpresas() {
        return new ArrayList<>(empresas.values());
    }

    public Empresa getEmpresa(Integer id) {
        return empresas.get(id);
    }

    public void editaEmpresa(Empresa empresa){
        Empresa emp = getEmpresa(empresa.getId());
        if (emp != null)
            empresas.put(emp.getId(), empresa);
    }

    public void removeEmpresa(Integer id){
        Empresa empresa = getEmpresa(id);
        if (empresa != null)
            empresas.remove(id, empresa);
    }
}
