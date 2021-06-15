package dk.usedmarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class AdvertisementDTO {
    private final UUID id;
    private final String type;
    private final String headline;
    private final String text;
    private final int price;
    private final UUID userId;
    private final int category;
    private final String creationDate;

    @JsonCreator
    public AdvertisementDTO(
            UUID id,
            String type,
            String headline,
            String text,
            int price,
            UUID userId,
            int category,
            String creationDate
    ){
        this.id = id;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.userId = userId;
        this.category = category;
        this.creationDate = creationDate;
    }

    public UUID getId() {
        return id;
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

    @Override
    public String toString() {
        return "AdvertisementDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", headline='" + headline + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", userId='" + userId + '\'' +
                ", category=" + category +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}

