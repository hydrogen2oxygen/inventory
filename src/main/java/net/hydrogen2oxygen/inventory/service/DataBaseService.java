package net.hydrogen2oxygen.inventory.service;

import net.hydrogen2oxygen.inventory.domain.Item;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.WriteResult;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

public class DataBaseService {

    public static final String DEFAULT_DATABASE_PATH = "inventory.db";
    private Nitrite db;
    private ObjectRepository<Item> itemObjectRepository;

    @PostConstruct
    public void initService() throws Exception{

        db = Nitrite.builder()
                .compressed()
                .filePath(DEFAULT_DATABASE_PATH)
                .openOrCreate("user", "password");

        itemObjectRepository = db.getRepository(Item.class);

        // TODO createIndexes();
    }

    public void closeDatabase() {
        db.close();
    }

    // CRUD ITEM
    // CREATE OR UPDATE ITEM
    public Item saveOrUpdateItem(Item item) {

        WriteResult result;

        if (item.getUuid() == null) {
            item.setUuid(UUID.randomUUID());
        }

        if (getItem(item.getUuid()) != null) {
            result = itemObjectRepository.update(ObjectFilters.eq("uuid", item.getUuid()), item);
        } else {
            result = itemObjectRepository.insert(item);
        }

        return item;
    }

    // READ
    public List<Item> getAllItems() {
        return itemObjectRepository.find().toList();
    }

    public Item getItem(UUID uuid) {
        return itemObjectRepository.find(ObjectFilters.eq("uuid", uuid)).firstOrDefault();
    }

    public void deleteItem(UUID uuid) {
        itemObjectRepository.remove(ObjectFilters.eq("uuid", uuid));
    }

}
