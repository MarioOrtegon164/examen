package com.example.examen.repository;

import com.example.examen.entity.Employers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employers, Integer> {


    // Ejemplo de consulta personalizada usando @Query
    //@Query("SELECT e FROM Empleado e WHERE e.salario > ?1")
    //List<Empleado> findBySalarioGreaterThan(double salario);

    @Query(value="SELECT * FROM demo.employers order by id_empleado DESC limit 3",nativeQuery = true)
    List<Employers> getLast3Employers();
}
