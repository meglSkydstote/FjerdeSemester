package dk.Jonathan.domain;

import java.util.Date;

public class Advertisement {
    private final Id id;
    private String category;
    private String type;
    private String headline;
    private String text;
    private int price;
    private Date creation_Date;

    public Advertisement(Id id, String category, String type, String headline, String text, int price, Date creation_Date) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.creation_Date = creation_Date;
    }

    public Id getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public int getPrice() {
        return price;
    }

    public Date getCreation_Date() {
        return creation_Date;
    }
}
