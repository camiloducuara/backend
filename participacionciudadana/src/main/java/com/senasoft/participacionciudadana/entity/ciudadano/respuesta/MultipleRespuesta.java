package com.senasoft.participacionciudadana.entity.ciudadano.respuesta;

import com.senasoft.participacionciudadana.entity.ciudadano.PreguntaCiudadano;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "multiple_respuestas")
public class MultipleRespuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String option;

    @ManyToMany(mappedBy = "multipleRespuestas")
    private List<PreguntaCiudadano> preguntas;

}
