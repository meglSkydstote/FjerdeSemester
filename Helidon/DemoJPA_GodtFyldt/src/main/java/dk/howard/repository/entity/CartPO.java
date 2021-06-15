package dk.howard.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CART")
@NamedQueries({
        @NamedQuery(name = "CartPO.findAll", query = "Select c FROM CartPO c")
})
public class CartPO {

    public static final String FIND_ALL = "CartPO.findAll";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    private UUID id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(40)", nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "CART_FK")
    private List<ItemPO> items;

    public CartPO(String name) {
        this.name = name;
    }

    public CartPO() {
        // JPA
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ItemPO> getItems() {
        return items;
    }

    public void add(ItemPO itemPO) {
        items.add(itemPO);
    }

}
