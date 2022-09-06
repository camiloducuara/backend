package com.senasoft.participacionciudadana.entity.ciudadano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sondeo_ciudadano")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SondeoCiudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String contenido;
    private String imagen;

    @OneToMany(mappedBy = "sondeo")
    private List<PreguntaCiudadano> preguntaCiudadanos;

}
