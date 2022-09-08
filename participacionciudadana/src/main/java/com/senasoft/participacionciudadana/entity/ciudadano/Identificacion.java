package com.senasoft.participacionciudadana.entity.ciudadano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**

 * Esta clase contiene la informacion de credenciales del usuario y su relacion a la cuenta

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see Cuenta

 */
@Entity
@Table(name = "identificacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Identificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombreCompleto;
    private String apellidos;
    private String sexo;
    private String fechaNacimiento;
    private String etnia;
    private String discapacidad;

    @OneToOne(mappedBy = "identificacion")
    private Ciudadano ciudadano;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

}
