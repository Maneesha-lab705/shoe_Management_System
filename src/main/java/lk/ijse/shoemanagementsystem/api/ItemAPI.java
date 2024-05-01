package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.dto.ItemDTO;
import lk.ijse.shoemanagementsystem.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class ItemAPI {
    private final ItemService itemService;
    @PostMapping
    public void saveItem(@RequestBody ItemDTO itemDTO){
        System.out.println(itemDTO);
        itemService.saveItem(itemDTO);
    }
    @GetMapping
    public List<ItemDTO> getAllItem(){
        return itemService.getAllItem();
    }
}
