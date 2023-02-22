package com.example.examen_acceso_datos_julen_hernandez_2ev.controller;

import com.example.examen_acceso_datos_julen_hernandez_2ev.entity.Vuelos;
import com.example.examen_acceso_datos_julen_hernandez_2ev.service.VuelosService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VuelosController {

    @Autowired
    private VuelosService vuelosService;

    //COMPROBAR FUNCIONAMIENTO
    @GetMapping("/")
    public String Inicio() {
        return "Bienvenido al gestor de vuelos";
    }

    //PETICIONES GET

    @GetMapping(value = "/vuelos/all")
    @ApiOperation(value = "Encuentra un vuelo por su origen, necesita pasar en el path el origen")
    public List<Vuelos> getAll() {
        return vuelosService.findAll();
    }


    @GetMapping(value = "/vuelos/origen/{origen}")
    @ApiOperation(value = "Encuentra un vuelo por su origen, necesita pasar en el path el origen")
    public List<Vuelos> getByOrigen(@PathVariable String origen) {
        return vuelosService.findByOrigen(origen);
    }

    @GetMapping(value = "/vuelos/destino/{destino}")
    @ApiOperation(value = "Encuentra un vuelo por su destino, necesita pasar en el path el destino")
    public List<Vuelos> getByDestino(@PathVariable String destino) {
        return vuelosService.findByDestino(destino);
    }

    @GetMapping(value = "/vuelos/escala/{num_escalas}")
    @ApiOperation(value = "Encuentra un vuelo por su número de escalas, necesita pasar en el path el número de escalas")
    public List<Vuelos> getByNum_escalas(@PathVariable int num_escalas) {
        return vuelosService.findByNum_escalas(num_escalas);
    }

    //PETICION POST
    @PostMapping(value = "/new")
    @ApiOperation(value = "Inserta un nuevo vuelo. Le mandamos los campos por el body en JSON")
    public String guardarCancion(@RequestBody Vuelos vuelo) {
        vuelosService.save(vuelo);
        return "Un nuevo vuelo fue insertado";

    }

    //PETICION PUT
    @PutMapping(value = "/update/{cod_vuelo}")
    @ApiOperation(value = "Actualiza todos los campos de un vuelo determinado. Pasamos el código en el path de la petición," +
            " los campos nuevos los mandamos a través del body JSON")
    public String actualizaVuelo(@PathVariable String cod_vuelo, @RequestBody Vuelos vuelo) {
        Optional<Vuelos> optionalVuelo = Optional.ofNullable(vuelosService.findByCod_vuelo(cod_vuelo));
        if (optionalVuelo.isPresent()) {
            Vuelos actualizarVuelo = optionalVuelo.get();
            actualizarVuelo.setHora_salida(vuelo.getHora_salida());
            actualizarVuelo.setOrigen(vuelo.getOrigen());
            actualizarVuelo.setDestino(vuelo.getDestino());
            actualizarVuelo.setPrecio(vuelo.getPrecio());
            actualizarVuelo.setNum_escalas(vuelo.getNum_escalas());
            actualizarVuelo.setCompañia(vuelo.getCompañia());

            vuelosService.save(actualizarVuelo);
            return "Vuelo actualizado con éxito";
        } else {
            return "No existe un vuelo con ese código";
        }

    }

    //PETICIONES DELETE
    @DeleteMapping(value = "/delete/{cod_vuelo}")
    @ApiOperation(value = "Elimina un vuelo por su código. Indicamos el código en el path")
    public String borrarVuelo(@PathVariable String cod_vuelo) {
        //Utilizamos el optional dado que el .get nos daba error al no usar un id autoincremental
        Optional<Vuelos> optionalVuelo = Optional.ofNullable(vuelosService.findByCod_vuelo(cod_vuelo));
        if (optionalVuelo.isPresent()) {
            Vuelos vuelo = optionalVuelo.get();
            vuelosService.delete(vuelo);
            return "Vuelo eliminado";
        } else {
            return "No existe un vuelo con ese código";
        }
    }

    //BORRAR TODOS LOS VUELOS DE UN DESTINO DETERMINADO
    @DeleteMapping(value = "/delete/destino/{destino}")
    @ApiOperation(value = "Elimina un vuelo por su destino. Indicampos el destino en el path.")
    public String eliminarVueloPorDestino(@PathVariable String destino) {
        List<Vuelos> vuelos_eliminar = vuelosService.findByDestino(destino);
        //por cada registro de la lista que nos devolvió la consulta anterior,
        //los eliminamos con el bulce for
        for(int i = 0; i< vuelos_eliminar.size(); i++){
            vuelosService.delete(vuelos_eliminar.get(i));
        }
        return "Los vuelos con destino a " +  destino + " fueron eliminados";
    }

}
