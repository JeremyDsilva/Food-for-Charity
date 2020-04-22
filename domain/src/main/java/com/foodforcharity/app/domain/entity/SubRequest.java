package com.foodforcharity.app.domain.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The persistent class for the SUB_REQUEST database table.
 */
@Data
@Entity
@Table(name = "SUB_REQUEST")
public class SubRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PRICE_AT_PURCHASE")
    @NotNull
    private Integer priceAtPurchase;

    @NotNull
    private Integer quantity;

    // bi-directional many-to-one association to Request
    @ManyToOne
    @NotNull
    private Request request;

    // bi-directional many-to-one association to Food
    @ManyToOne
    @NotNull
    private Food food;

//	@PreRemove
//	public void preRemove(){
//		request.removeSubRequest(this);
//	}

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SubRequest && ((SubRequest) obj).getId() == getId())
            return true;
        return false;
    }

}