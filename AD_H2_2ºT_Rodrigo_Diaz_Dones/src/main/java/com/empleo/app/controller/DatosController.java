package com.empleo.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.empleo.app.model.Datos;
import com.empleo.app.repositories.DatosRepository;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class DatosController {


    // Inyección de dependencias: Spring se encarga de crear una instancia del repositorio
    // y asignarla automáticamente a esta variable.
    @Autowired
    private DatosRepository datosRepository;
	
    // Redirige a la página principal (index)
    @GetMapping
    public String mostrarPaginaPrincipal() {
        return "index"; // Este es el archivo HTML de la página principal
    }
    
    // Método para cargar la vista de filtros
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        // Cargar los valores únicos de los filtros desde la tabla 'datos'
        List<String> ccaaList = datosRepository.findDistinctCcaa(); // Comunidades autónomas únicas
        List<String> sexoList = datosRepository.findDistinctSexo(); // Valores únicos de sexo
        List<String> periodoList = datosRepository.findDistinctPeriodo(); // Valores únicos de periodo

        // Agregar los valores al modelo para que puedan ser renderizados en la vista
        model.addAttribute("ccaas", ccaaList);
        model.addAttribute("sexos", sexoList);
        model.addAttribute("periodos", periodoList);

        // Retorna la vista del formulario
        return "paginaFiltros";
    }

    @GetMapping("/filtros")
    @ResponseBody
    public List<Map<String, Object>> obtenerDatosFiltrados(
            @RequestParam(required = false) String ccaa,
            @RequestParam(required = false) String sexo,
            @RequestParam(required = false) String periodo) {

        List<Datos> datos = datosRepository.findDatosByFiltros(ccaa, sexo, periodo);

        return datos.stream().map(d -> {
            Map<String, Object> result = new HashMap<>();
            result.put("ccaa", d.getCcaa().getNombre());
            result.put("sexo", d.getSexo());
            result.put("periodo", d.getPeriodo());
            result.put("edad", d.getEdad());
            result.put("total", d.getTotal());
            return result;
        }).toList();
    }


    // Maneja la solicitud para la página 1
    @GetMapping("/pagina1")
    public String mostrarPagina1(Model model) {
        List<Object[]> resultados = datosRepository.consulta1();
        model.addAttribute("resultados", resultados);
        return "pagina1";
    }

    @GetMapping("/pagina2")
    public String mostrarPagina2(Model model) {
        List<Object[]> resultados = datosRepository.consulta2(); // Llamar a consulta2
        model.addAttribute("resultados", resultados);           // Pasar resultados al modelo
        return "pagina2";                                       // Retornar la vista
    }

    @GetMapping("/pagina3")
    public String mostrarPagina3(Model model) {
        List<Object[]> resultados = datosRepository.consulta3(); 
        model.addAttribute("resultados", resultados);           
        return "pagina3";                                       
    }
   
    @GetMapping("/pagina4")
    public String mostrarPagina4(Model model) {
        List<Object[]> resultados = datosRepository.consulta4(); 
        model.addAttribute("resultados", resultados);           
        return "pagina4";                                       
    }
   
    @GetMapping("/pagina5")
    public String mostrarPagina5(Model model) {
        List<Object[]> resultados = datosRepository.consulta5(); 
        model.addAttribute("resultados", resultados);           
        return "pagina5";                                       
    }

    @GetMapping("/pagina6")
    public String mostrarPagina6(Model model) {
        List<Object[]> resultados = datosRepository.consulta6(); 
        model.addAttribute("resultados", resultados);           
        return "pagina6";                                       
    }
  
    @GetMapping("/pagina7")
    public String mostrarPagina7(Model model) {
        List<Object[]> resultados = datosRepository.consulta7(); 
        model.addAttribute("resultados", resultados);           
        return "pagina7";                                      
    }

    
    @GetMapping("/pagina8")
    public String mostrarPagina8(Model model) {
        List<Object[]> resultados = datosRepository.consulta8(); 
        model.addAttribute("resultados", resultados);           
        return "pagina8";                                      
    }

    @GetMapping("/pagina9")
    public String mostrarPagina9(Model model) {
        List<Object[]> resultados = datosRepository.consulta9(); 
        model.addAttribute("resultados", resultados);           
        return "pagina9";                                       
    }
   
    @GetMapping("/pagina10")
    public String mostrarPagina10(Model model) {
        List<Object[]> resultados = datosRepository.consulta10(); 
        model.addAttribute("resultados", resultados);            
        return "pagina10";                                      
    }
}