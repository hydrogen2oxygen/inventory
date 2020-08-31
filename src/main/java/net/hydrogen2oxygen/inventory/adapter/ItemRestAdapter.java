package net.hydrogen2oxygen.inventory.adapter;

import net.hydrogen2oxygen.inventory.domain.ItemEntry;
import net.hydrogen2oxygen.inventory.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/item")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemRestAdapter {

    @Autowired
    private DataBaseService dataBaseService;

    @PostMapping
    ResponseEntity<ItemEntry> save(@RequestBody ItemEntry itemEntry) {
        return ResponseEntity.ok(dataBaseService.saveOrUpdateItem(itemEntry));
    }

    @PutMapping
    ResponseEntity<ItemEntry> update(@RequestBody ItemEntry itemEntry) {
        return ResponseEntity.ok(dataBaseService.saveOrUpdateItem(itemEntry));
    }

    @GetMapping
    ResponseEntity<List<ItemEntry>> getAll() {
        return ResponseEntity.ok(dataBaseService.getAllItems());
    }

    @GetMapping("/{uuid}")
    ResponseEntity<ItemEntry> get(@PathVariable String uuid) {
        return ResponseEntity.ok(dataBaseService.getItem(UUID.fromString(uuid)));
    }

    @DeleteMapping
    void delete(@PathVariable String uuid) {
        dataBaseService.deleteItem(UUID.fromString(uuid));
    }
}
