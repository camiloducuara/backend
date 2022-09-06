package com.senasoft.participacionciudadana.entity.ciudadano;

import com.senasoft.participacionciudadana.entity.ciudadano.SondeoCiudadano;
import com.senasoft.participacionciudadana.entity.ciudadano.respuesta.LibreRespuesta;
import com.senasoft.participacionciudadana.entity.ciudadano.respuesta.MultipleRespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pregunta_ciudadano")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaCiudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenido;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_respuesta")
    private LibreRespuesta libreRespuesta;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pregunta_multiple_respuesta",
            joinColumns = @JoinColumn(name = "id_pregunta"),
            inverseJoinColumns = @JoinColumn (name = "id_multiple_respuesta")

    )
    private List<MultipleRespuesta> multipleRespuestas;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "sondeo_id")
    private SondeoCiudadano sondeo;

}
