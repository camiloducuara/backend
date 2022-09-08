package com.senasoft.participacionciudadana.entity.adminsondeo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**

 * Esta clase contiene los datos para opciones de las preguntas del lado del administrador
 * junto con su respectiva relacion a la pregunta

 * @author: Camilo Andres Ducuara Cardozo

 * @version: 08/09/2022

 */

@Entity
@Table(name = "opciones_admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpcionesAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @JoinColumn(name = "pregunta_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private PreguntaAdmin preguntaAdmin;

}
