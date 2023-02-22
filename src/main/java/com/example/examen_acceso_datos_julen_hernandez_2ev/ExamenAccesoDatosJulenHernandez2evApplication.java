package com.example.examen_acceso_datos_julen_hernandez_2ev;

import com.example.examen_acceso_datos_julen_hernandez_2ev.config.VuelosConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import(VuelosConfig.class)
public class ExamenAccesoDatosJulenHernandez2evApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenAccesoDatosJulenHernandez2evApplication.class, args);
    }

}
