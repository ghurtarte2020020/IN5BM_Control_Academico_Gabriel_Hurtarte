<%-- 
    Document   : estudiante
    Created on : 25/08/2021, 10:44:34 AM
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Estudiantes</title>
    </head>
    <body>
        <h1>Listado Estudiantes</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nombre</th>
                    <th>Saldo</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="estudiante" items="${listadoEstudiante}">
                    <tr>
                        <td>${estudiante.idEstudiante}</td>
                        <td>${estudiante.nombre} ${estudiante.apellido}</td>
                        <td>${estudiante.saldo}</td>
                        <td><a href="${pageContext.request.contextPath}/ServletEstudianteController?accion=eliminar&idEstudiante=${estudiante.idEstudiante}">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h3>Total de Estudiantes</h3>
        <h4>${totalEstudiantes}</h4>
        <h3>Saldo Total</h3>
        <h4>${saldoTotal}</h4>
    </body>
</html>
