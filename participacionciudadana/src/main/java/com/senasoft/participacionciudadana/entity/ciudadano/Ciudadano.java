package com.senasoft.participacionciudadana.entity.ciudadano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

/**

 * Esta clase contiene el ultimo nivel de estudio, si cuenta con dispositivos, cuales, conectividad
 * y regimen de afilizacion. Junto con la relacion a la identificacion que servira de cadena a los
 * demas datos

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see com.senasoft.participacionciudadana.entity.ciudadano.Identificacion

 */
@Entity
@Table(name = "ciudadano")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ciudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ultimoGradoAlcanzado;
    private boolean cuentaConDispositivos;
    private String dispositivos;
    private boolean cuentaConConectividad;
    private String regimenAfiliacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identificacion_id")
    private Identificacion identificacion;

}
