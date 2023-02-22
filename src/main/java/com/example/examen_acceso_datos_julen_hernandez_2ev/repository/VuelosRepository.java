package com.example.examen_acceso_datos_julen_hernandez_2ev.repository;

import com.example.examen_acceso_datos_julen_hernandez_2ev.entity.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VuelosRepository extends JpaRepository<Vuelos, String> {



    @Query("SELECT v FROM Vuelos v WHERE v.cod_vuelo=?1")
    Vuelos findByCod_vuelo(String cod_vuelo);
    @Query("SELECT v FROM Vuelos v WHERE v.origen=?1")
    List<Vuelos> findByOrigen(String origen);

    @Query("SELECT v FROM Vuelos v WHERE v.destino=?1")
    List<Vuelos>findByDestino(String destino);

    @Query("SELECT v FROM Vuelos v WHERE v.num_escalas=?1")
    List<Vuelos> findByNum_escalas(int num_escalas);


}
