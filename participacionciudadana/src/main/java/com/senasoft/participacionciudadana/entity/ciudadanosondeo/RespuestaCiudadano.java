package com.senasoft.participacionciudadana.entity.ciudadanosondeo;

import com.senasoft.participacionciudadana.entity.adminsondeo.PreguntaAdmin;
import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**

 * Contiene las respuestas que le dan los ciudadanos a las preguntas

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see PreguntaAdmin

 */

@Entity
@Table(name = "respuesta_ciudadano")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaCiudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sondeo_id")
    private SondeoCiudadano sondeo;
    @JoinColumn(name = "pregunta_admin_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private PreguntaAdmin preguntaAdmin;

    private String respuesta;
}
