package dk.howard.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ITEM")
public class Item1PO {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(40)", nullable = false)
    private String name;

    @Column(name = "PRICE", columnDefinition = "VARCHAR(40)", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "CART_FK")//owning side
    private Cart1PO cart;

    public Item1PO() {
    }

    public Item1PO(String name, double price, Cart1PO cart) {
        this.name = name;
        this.price = price;
        this.cart = cart;
    }

    public Item1PO(String name, double price) {
        this.name = name;
        this.price = price;

    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
