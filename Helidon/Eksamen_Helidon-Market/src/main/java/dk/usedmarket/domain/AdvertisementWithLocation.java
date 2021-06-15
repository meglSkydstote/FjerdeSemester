package dk.usedmarket.domain;

import java.util.UUID;
import dk.usedmarket.domain.Location;

public class AdvertisementWithLocation {
    private final UUID id;
    private final String type;
    private final String headline;
    private final String text;
    private final int price;
    private final UUID userId;
    private final int category;
    private final String creationDate;
    private final Location location;

    public AdvertisementWithLocation(UUID id,
                                     String type,
                                     String headline,
                                     String text,
                                     int price,
                                     UUID userId,
                                     int category,
                                     String creationDate,
                                     Location location
    ) {
        this.id = id;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.userId = userId;
        this.category = category;
        this.creationDate = creationDate;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }
}

