package net.hydrogen2oxygen.inventory.domain;

import org.dizitart.no2.objects.Id;

import java.util.Calendar;
import java.util.UUID;

public class ItemEntry {

    @Id
    private UUID uuid;
    private String name;
    private String tags;
    private String description;
    private Calendar lastUpdate;
    private Calendar expirationDate;
    private QuantityClassifierEnum quantityClassifierEnum;
    private Float quantity;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Calendar lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public QuantityClassifierEnum getQuantityClassifierEnum() {
        return quantityClassifierEnum;
    }

    public void setQuantityClassifierEnum(QuantityClassifierEnum quantityClassifierEnum) {
        this.quantityClassifierEnum = quantityClassifierEnum;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
