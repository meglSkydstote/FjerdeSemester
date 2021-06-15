package dk.usedmarket.service.request;

import java.util.UUID;

public class CreateAdvertisementRequest {
    private final String type;
    private final String headline;
    private final String text;
    private final int price;
    private final UUID userId;
    private final int category;
    private final String creationDate;

    public CreateAdvertisementRequest(String type, String headline, String text, int price, UUID userId, int category, String creationDate) {
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.userId = userId;
        this.category = category;
        this.creationDate = creationDate;
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

    public UUID getUserId() {
        return userId;
    }

    public int getCategory() {
        return category;
    }

    public String getCreationDate() {
        return creationDate;
    }
}