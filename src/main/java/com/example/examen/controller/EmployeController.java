package com.example.examen.controller;

import com.example.examen.entity.Employers;
import com.example.examen.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeController {

    @Autowired
    private EmployeRepository empleadoRepository;


    @GetMapping("/empleados")
    public List<Employers> obtenerTodosLosEmpleados(){
        return empleadoRepository.findAll();
    }

    @PostMapping("/empleados/nuevo")
    public Employers agregarEmpleado(@RequestBody Employers empleado){
        return empleadoRepository.save(empleado);
    }

    @PatchMapping("/empleados/editar/{id}")
    public Employers editarEmpleado(@PathVariable Integer id, @RequestBody Employers empleado){
        Optional<Employers> empleadoExistente = empleadoRepository.findById(id);

        if (empleadoExistente.isPresent()) {

            Employers empleadoActual = empleadoExistente.get();
          empleadoExistente.ifPresent(e -> {
            e.setNombre(empleado.getNombre());
            e.setApellidoPaterno(empleado.getApellidoPaterno());
            e.setApellidoMaterno(empleado.getApellidoMaterno());
            e.setEmail(empleado.getEmail());
            e.setCargo(empleado.getCargo());
            e.setSalario(empleado.getSalario());
          });

            return empleadoRepository.save(empleadoActual);

          /*
            Employers empleadoActual = empleadoExistente.get();
            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setApellidoPaterno(empleado.getApellidoPaterno());
            empleadoExistente.setApellidoMaterno(empleado.getApellidoMaterno());
            empleadoExistente.setEmail(empleado.getEmail());
            return empleadoRepository.save(empleadoActual);

           */
        }


        return null;
    }

    @GetMapping("/empleados/{id}")
    public Employers obtenerEmpleadoPorId(@PathVariable Integer id){
        return empleadoRepository.findById(id).orElse(null);
    }


    @DeleteMapping("/empleados/{id}")
    public void eliminarEmpleado(@PathVariable Integer id){
        empleadoRepository.deleteById(id);
    }

    @GetMapping("/empleados/3Ultimos")
    public List<Employers> obtener3UltimosEmpleado(){
        return empleadoRepository.getLast3Employers();
    }

}
