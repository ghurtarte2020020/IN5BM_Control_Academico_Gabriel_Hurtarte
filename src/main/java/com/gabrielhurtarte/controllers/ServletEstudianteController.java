package com.gabrielhurtarte.controllers;

import com.gabrielhurtarte.models.dao.EstudianteDaoImpl;
import com.gabrielhurtarte.models.domain.Estudiante;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

/**
 * @author Gabriel Enrique Hurtarte Garcia Codigo técnico:IN5BM
 * @date 25/08/2021
 * @time 08:24:37 AM
 */
@WebServlet("/ServletEstudianteController")
public class ServletEstudianteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "listar":
                    listarEstudiantes(request, response);
                    break;
                case "editar":
                    break;
                case "eliminar":
                    eliminarEstudiante(request, response);
                    break;
            }

        }
    }

    private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));

        Estudiante estudiante = new Estudiante(idEstudiante);

        int registrosEliminados = new EstudianteDaoImpl().eliminar(estudiante);

        System.out.println("Cantidad de registros eliminados: " + registrosEliminados);

        listarEstudiantes(request, response);
    }

    private void listarEstudiantes(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Estudiante> listaEstudiante = new EstudianteDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoEstudiante", listaEstudiante);
        sesion.setAttribute("totalEstudiantes", listaEstudiante.size());
        sesion.setAttribute("saldoTotal", calcularSaldoTotal());
        response.sendRedirect("estudiante.jsp");
    }

    private double calcularSaldoTotal() {
        double saldo = 0;
        List<Estudiante> listaEstudiante = new EstudianteDaoImpl().listar();

        for (Estudiante estudiante : listaEstudiante) {
            saldo = saldo + estudiante.getSaldo();
        }
        return saldo;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
