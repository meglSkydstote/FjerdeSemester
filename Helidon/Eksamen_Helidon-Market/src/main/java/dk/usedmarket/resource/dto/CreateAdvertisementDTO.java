package dk.usedmarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

public class CreateAdvertisementDTO {
    private final String type;
    private final String headline;
    private final String text;
    private final int price;
    private final UUID userId;
    private final int category;
    private final String creationDate;

//    http://localhost:8096/advertisements/fasfdfgagasd
//    {
//        "type": "private",
//        "headline": "BUY CHEAP LIVE LONG",
//        "text": "Here you can buy this, that, and nothing",
//        "price": 50,
//            "userId": 42665292-cb5b-48fc-9f56-f26207ed7df0,
//        "category": 3
//    }

    @JsonCreator
    public CreateAdvertisementDTO(
            @JsonProperty("type") String type,
            @JsonProperty("headline") String headline,
            @JsonProperty("text") String text,
            @JsonProperty("price") int price,
            @JsonProperty("userId") UUID userId, // TODO - ups.. unødvendigt - den gør ikke noget
            @JsonProperty("category") int category
    ){
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.userId = userId;
        this.category = category;
        Date date = new Date();
        this.creationDate = DateFormat.getDateInstance().format(date);
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


