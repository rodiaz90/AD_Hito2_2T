package com.empleo.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.empleo.app.model.Datos;

@Repository // Indica que esta interfaz es un componente Spring de tipo repositorio, utilizado para la interacción con la base de datos.
public interface DatosRepository extends JpaRepository<Datos, Integer> {
   
	//1. Media del total de empleados por comunidad autónoma
    @Query(value = "SELECT ccaa.nombre AS Comunidad_Autonoma, AVG(datos.total) AS Media_Total_Empleados " +
                   "FROM datos " +
                   "JOIN ccaa ON datos.id_ccaa = ccaa.codigo " +
                   "GROUP BY ccaa.nombre;", nativeQuery = true) // Indica que esta consulta está escrita en SQL nativo en lugar de JPQL.
    List<Object[]> consulta1(); // Devuelve una lista de arreglos de objetos, donde cada arreglo representa una fila del resultado.
 
    //2. Media del total de empleados por edad
    @Query(value = "SELECT edad, AVG(total) AS media_total " +
            "FROM datos " +
            "GROUP BY edad", nativeQuery = true)
    List<Object[]> consulta2();
   
    //3. Media del total de empleados por periodo
    @Query(value = "SELECT periodo, AVG(total) AS mediaTotalEmpleados FROM datos GROUP BY periodo", nativeQuery = true)
    List<Object[]> consulta3();
    
    //4. Media del total de empleados por sexo
    @Query(value = "SELECT sexo, AVG(total) AS media_total FROM datos GROUP BY sexo", nativeQuery = true)
    List<Object[]> consulta4();
    
    //5. Media y varianza del total de empleados por sexo y grupo de edad
    @Query(value = "SELECT sexo, edad, AVG(total) AS Media_Total_Empleados, VARIANCE(total) AS Varianza_Total_Empleados "
    		+ "FROM datos "
    		+ "GROUP BY sexo, edad", nativeQuery = true)
    List<Object[]> consulta5();
    
    //6. Varianza del total de empleados por sexo
    @Query(value = "SELECT sexo, VARIANCE(total) AS Varianza_Total_Empleados "
    		+ "FROM datos "
    		+ "GROUP BY sexo", nativeQuery = true)
    List<Object[]> consulta6();
    
    //7. Total de empleados por comunidad autónoma y sexo
    @Query(value = "SELECT c.nombre AS comunidad_autonoma, d.sexo, SUM(d.total) AS total_empleados " +
            "FROM datos d " +
            "JOIN ccaa c ON d.id_ccaa = c.codigo " +
            "GROUP BY c.nombre, d.sexo", nativeQuery = true)
    List<Object[]> consulta7();

    //8. Suma total de empleados por comunidad autónoma y grupo de edad
    @Query(value = "SELECT ccaa.nombre AS Comunidad_Autonoma, edad, SUM(total) AS Suma_Total_Empleados "
    		+ "FROM datos "
    		+ "JOIN ccaa ON datos.id_ccaa = ccaa.codigo "
    		+ "GROUP BY ccaa.nombre, edad", nativeQuery = true)
    List<Object[]> consulta8();
    
    //9. Desviación estándar del total de empleados por grupo de edad
    @Query(value = "SELECT edad, STDDEV(total) AS Desviacion_Estandar_Total_Empleados "
    		+ "FROM datos "
    		+ "GROUP BY edad", nativeQuery = true)
    List<Object[]> consulta9();
    
    //10. Desviación estándar del total de empleados por comunidad autónoma y periodo
    @Query(value = "SELECT ccaa.nombre AS Comunidad_Autonoma, periodo, STDDEV(total) AS Desviacion_Estandar_Total_Empleados "
    		+ "FROM datos "
    		+ "JOIN ccaa ON datos.id_ccaa = ccaa.codigo "
    		+ "GROUP BY ccaa.nombre, periodo", nativeQuery = true)
    List<Object[]> consulta10();
    
    // Consulta para obtener las comunidades autónomas únicas
    @Query("SELECT DISTINCT d.ccaa.nombre FROM Datos d")
    List<String> findDistinctCcaa();

    // Consulta para obtener los valores únicos de sexo
    @Query("SELECT DISTINCT d.sexo FROM Datos d")
    List<String> findDistinctSexo();

    // Consulta para obtener los periodos únicos
    @Query("SELECT DISTINCT d.periodo FROM Datos d")
    List<String> findDistinctPeriodo();

    // Consulta dinámica con filtros
    @Query("SELECT d FROM Datos d " +
           "WHERE (:ccaa IS NULL OR d.ccaa.nombre = :ccaa) " +
           "AND (:sexo IS NULL OR d.sexo = :sexo) " +
           "AND (:periodo IS NULL OR d.periodo = :periodo)")
    List<Datos> findDatosByFiltros(
            @Param("ccaa") String ccaa,
            @Param("sexo") String sexo,
            @Param("periodo") String periodo);
}
