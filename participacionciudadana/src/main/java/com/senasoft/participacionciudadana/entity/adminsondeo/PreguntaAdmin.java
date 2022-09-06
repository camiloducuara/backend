package com.senasoft.participacionciudadana.entity.adminsondeo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

}
