package com.senasoft.participacionciudadana.entity.ciudadanosondeo;

import com.senasoft.participacionciudadana.entity.adminsondeo.SondeoAdmin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
