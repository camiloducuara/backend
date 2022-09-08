package com.senasoft.participacionciudadana.entity.ciudadanosondeo;

import com.senasoft.participacionciudadana.entity.adminsondeo.SondeoAdmin;
import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**

 * Contiene la informacion del sondeo que el ciudadano respondio, el nombre de usuario, el sondeo
 * del administrador y las respuestas que les dio los ciudadanos

 * @author : Camilo Andres Ducuara Cardozo

 * @version : 08/09/2022
 *
 * @see SondeoAdmin

 */
@Entity
@Table(name = "sondeo_ciudadano")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SondeoCiudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @JoinColumn(name = "sondeo_admin_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private SondeoAdmin sondeoAdmin;

    @OneToMany(mappedBy = "sondeo")
    private List<RespuestaCiudadano> respuestaCiudadanos;





}
