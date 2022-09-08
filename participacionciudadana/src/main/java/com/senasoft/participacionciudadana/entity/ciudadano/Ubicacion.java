package com.senasoft.participacionciudadana.entity.ciudadano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**

 * Esta clase contiene la informacion sobre ubicacion del usuario y es la ultima en la cadena de
 * relaciones con Ciudadano

 * @author : Camilo Andres Ducuara Cardozo
 * @version  : 08/09/2022

 */

@Entity
@Table(name = "ubicacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String municipio;
    private String direccion;
    private String barrio;
    private String estratoResidencia;

    @OneToOne(mappedBy = "ubicacion")
    private Contacto contacto;

}
