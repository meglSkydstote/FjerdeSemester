package dk.usedmarket.repository.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "CategoryPO.findAll", query = "Select u FROM CategoryPO u"),
})
@Entity
@Table(name = "CATEGORY")
public class CategoryPO {

    public static final String FIND_ALL = "CategoryPO.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(255)", nullable = false)
    private String description;

    @Column(name = "TOTAL", columnDefinition = "int", nullable = false)
    private int count;

    public CategoryPO() {
        // JPA
    }

    public CategoryPO(int id, String description, int count) {
        this.id = id;
        this.description = description;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }
}

