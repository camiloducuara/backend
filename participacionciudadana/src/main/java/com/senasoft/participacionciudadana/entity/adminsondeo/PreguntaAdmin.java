package com.senasoft.participacionciudadana.entity.adminsondeo;

import com.senasoft.participacionciudadana.entity.ciudadanosondeo.RespuestaCiudadano;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pregunta_admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenido;
    private String type;

    @JoinColumn(name = "sondeo_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private SondeoAdmin sondeoAdmin;

    @OneToMany(mappedBy = "preguntaAdmin")
    private List<OpcionesAdmin> opcionesAdmins;

    @OneToMany(mappedBy = "preguntaAdmin")
    private List<RespuestaCiudadano> respuestaCiudadanos;

}
