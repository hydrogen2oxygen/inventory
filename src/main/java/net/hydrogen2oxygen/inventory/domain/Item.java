package net.hydrogen2oxygen.inventory.domain;

import org.dizitart.no2.objects.Id;

import java.util.UUID;

public class Item {

    @Id
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
