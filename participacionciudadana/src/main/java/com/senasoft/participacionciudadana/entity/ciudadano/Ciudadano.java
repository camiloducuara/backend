package com.senasoft.participacionciudadana.entity.ciudadano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
