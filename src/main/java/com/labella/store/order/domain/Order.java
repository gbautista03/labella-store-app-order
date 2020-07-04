package com.labella.store.order.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A Order.
 */
@Entity
@Table(name = "jhi_order")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "order_number", nullable = false, unique = true)
    private Integer orderNumber;

    @NotNull
    @Column(name = "order_date", nullable = false)
    private Instant orderDate;

    @Column(name = "process_date")
    private LocalDate processDate;

    @OneToMany(mappedBy = "order")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<LineItem> items = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public Order orderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public Order orderDate(Instant orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getProcessDate() {
        return processDate;
    }

    public Order processDate(LocalDate processDate) {
        this.processDate = processDate;
        return this;
    }

    public void setProcessDate(LocalDate processDate) {
        this.processDate = processDate;
    }

    public Set<LineItem> getItems() {
        return items;
    }

    public Order items(Set<LineItem> lineItems) {
        this.items = lineItems;
        return this;
    }

    public Order addItems(LineItem lineItem) {
        this.items.add(lineItem);
        lineItem.setOrder(this);
        return this;
    }

    public Order removeItems(LineItem lineItem) {
        this.items.remove(lineItem);
        lineItem.setOrder(null);
        return this;
    }

    public void setItems(Set<LineItem> lineItems) {
        this.items = lineItems;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        return id != null && id.equals(((Order) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Order{" +
            "id=" + getId() +
            ", orderNumber=" + getOrderNumber() +
            ", orderDate='" + getOrderDate() + "'" +
            ", processDate='" + getProcessDate() + "'" +
            "}";
    }
}
