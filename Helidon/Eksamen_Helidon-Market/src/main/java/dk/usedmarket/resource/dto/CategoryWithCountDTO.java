package dk.usedmarket.resource.dto;

public class CategoryWithCountDTO {

    private final int id;
    private final String description;
    private final int count;

    public CategoryWithCountDTO(int id, String description, int count) {
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
