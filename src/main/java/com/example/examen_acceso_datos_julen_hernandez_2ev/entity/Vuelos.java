package com.example.examen_acceso_datos_julen_hernandez_2ev.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(schema = "vuelos")
@ApiModel(description="Todos los detalles sobre los vuelos")
public class Vuelos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Product ID", example = "1", required = true)
    private String cod_vuelo;

    @Basic
    @Column(name = "hora_salida")
    private String hora_salida;

    @Basic
    @Column(name = "origen")
    private String origen;

    @Basic
    @Column(name = "destino")
    private String destino;

    @Basic
    @Column(name = "precio")
    private float precio;

    @Basic
    @Column(name = "num_escalas")
    private int num_escalas;

    @Basic
    @Column(name = "compañia")
    private String compañia;

    public String getCod_vuelo() {
        return cod_vuelo;
    }

    public void setCod_vuelo(String cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNum_escalas() {
        return num_escalas;
    }

    public void setNum_escalas(int num_escalas) {
        this.num_escalas = num_escalas;
    }

    public String ñ() {
        return compañia;
    }

    public void setCompania(String compania) {
        this.compañia = compania;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelos vuelos = (Vuelos) o;
        return Float.compare(vuelos.precio, precio) == 0 && num_escalas == vuelos.num_escalas && cod_vuelo.equals(vuelos.cod_vuelo) && Objects.equals(hora_salida, vuelos.hora_salida) && Objects.equals(origen, vuelos.origen) && Objects.equals(destino, vuelos.destino) && Objects.equals(compañia, vuelos.compañia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_vuelo, hora_salida, origen, destino, precio, num_escalas, compañia);
    }
}
