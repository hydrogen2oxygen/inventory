package net.hydrogen2oxygen.inventory.service;

import net.hydrogen2oxygen.inventory.domain.Item;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.UUID;

class DataBaseServiceTest {

    private DataBaseService dataBaseService;

    @BeforeEach
    public void setup() throws Exception {
        deleteTemporaryDatabaseFile();
        dataBaseService = new DataBaseService();
        dataBaseService.initService();
    }

    @AfterEach
    public void tearDown() {
        dataBaseService.closeDatabase();
        deleteTemporaryDatabaseFile();
    }

    private void deleteTemporaryDatabaseFile() {
        File databaseFile = new File(DataBaseService.DEFAULT_DATABASE_PATH);
        databaseFile.delete();
    }

    @Test
    public void testSimpleCrud() {
        Assert.assertTrue(dataBaseService.getAllItems().size() == 0);
        Assert.assertNull(dataBaseService.getItem(UUID.randomUUID()));
        dataBaseService.deleteItem(UUID.randomUUID());

        Item item = new Item();
        item = dataBaseService.saveOrUpdateItem(item);

        Assert.assertNotNull(item);
        Assert.assertNotNull(item.getUuid());

        Assert.assertTrue(dataBaseService.getAllItems().size() == 1);
        Assert.assertNotNull(dataBaseService.getItem(item.getUuid()));

        // again update
        item = dataBaseService.saveOrUpdateItem(item);

        Assert.assertNotNull(item);
        Assert.assertNotNull(item.getUuid());

        dataBaseService.deleteItem(item.getUuid());
        Assert.assertTrue(dataBaseService.getAllItems().size() == 0);
        Assert.assertNull(dataBaseService.getItem(item.getUuid()));
    }
}
