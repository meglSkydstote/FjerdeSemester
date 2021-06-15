package dk.howard.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CART")
@NamedQueries({
        @NamedQuery(name = "Cart1PO.findAll", query = "Select c FROM Cart1PO c")
})
public class Cart1PO {

    public static final String FIND_ALL = "Cart1PO.findAll";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    private UUID id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(40)", nullable = false)
    private String name;

    @OneToMany(mappedBy = "cart")
    private List<Item1PO> items;

    public Cart1PO(String name) {
        this.name = name;
    }

    public Cart1PO() {
        // JPA
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Item1PO> getItems() {
        return items;
    }

    public void add(Item1PO itemPO) {
        items.add(itemPO);
    }

}
