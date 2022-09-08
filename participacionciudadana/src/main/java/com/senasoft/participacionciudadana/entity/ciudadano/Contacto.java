package com.senasoft.participacionciudadana.entity.ciudadano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**

 * Esta clase contiene celular, fijo, correo electronico y la relacion a cuenta para el ciudadano

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see Cuenta

 */
@Entity
@Table(name = "contacto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String celular;
    private String fijo;
    private String correoElectronico;

    @OneToOne(mappedBy = "contacto")
    private Cuenta cuenta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;


}
