package com.platzi.market.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    //EL @Id se utiliza cuando la PK es sencilla
    //El @EmbeddedId se usa cuando la PK es compuesta y esta dada por otra clase
    @EmbeddedId
    private ComprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;
}
