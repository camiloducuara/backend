package com.senasoft.participacionciudadana.entity.ciudadano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**

 * Esta clase contiene la informacion de credenciales del usuario y su relacion a la ubicacion

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see Contacto

 */
@Entity
@Table(name = "cuenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;

    @OneToOne(mappedBy = "cuenta")
    private Identificacion identificacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "contacto_id")
    private Contacto contacto;

}
