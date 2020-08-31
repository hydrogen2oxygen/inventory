package net.hydrogen2oxygen.inventory.service;

import net.hydrogen2oxygen.inventory.domain.ItemEntry;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.WriteResult;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Service
public class DataBaseService {

    public static final String DEFAULT_DATABASE_PATH = "inventory.db";
    private Nitrite db;
    private ObjectRepository<ItemEntry> itemObjectRepository;

    @PostConstruct
    public void initService() throws Exception{

        db = Nitrite.builder()
                .compressed()
                .filePath(DEFAULT_DATABASE_PATH)
                .openOrCreate("user", "password");

        itemObjectRepository = db.getRepository(ItemEntry.class);

        // TODO createIndexes();
    }

    @PreDestroy
    public void closeDatabase() {
        db.close();
    }

    // CRUD ITEM
    // CREATE OR UPDATE ITEM
    public ItemEntry saveOrUpdateItem(ItemEntry item) {

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
    public List<ItemEntry> getAllItems() {
        return itemObjectRepository.find().toList();
    }

    public ItemEntry getItem(UUID uuid) {
        return itemObjectRepository.find(ObjectFilters.eq("uuid", uuid)).firstOrDefault();
    }

    public void deleteItem(UUID uuid) {
        itemObjectRepository.remove(ObjectFilters.eq("uuid", uuid));
    }

}
