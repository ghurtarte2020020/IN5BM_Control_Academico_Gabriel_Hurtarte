package com.gabrielhurtarte.models.idao;

import com.gabrielhurtarte.models.domain.Estudiante;
import java.util.List;

/**
 * @author Gabriel Enrique Hurtarte Garcia Codigo técnico:IN5BM
 * @date 19/08/2021
 * @time 10:40:20 AM
 */
public interface IEstudianteDao {

    public List<Estudiante> listar();

    public Estudiante encontrar(Estudiante estudiante);

    public int insertar(Estudiante estudiante);

    public int actualizar(Estudiante estudiante);

    public int eliminar(Estudiante estudiante);
}
