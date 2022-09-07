package com.senasoft.participacionciudadana.entity.adminsondeo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
