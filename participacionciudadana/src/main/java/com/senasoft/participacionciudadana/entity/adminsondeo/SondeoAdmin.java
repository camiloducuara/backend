package com.senasoft.participacionciudadana.entity.adminsondeo;

import com.senasoft.participacionciudadana.entity.ciudadanosondeo.SondeoCiudadano;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sondeo_admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SondeoAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String contenido;
    private String imagen;
    private String etniaDirigida;

    @OneToMany(mappedBy = "sondeoAdmin")
    private List<PreguntaAdmin> preguntaAdmins;

    @OneToMany(mappedBy = "sondeoAdmin")
    List<SondeoCiudadano> sondeoCiudadanos;
}
