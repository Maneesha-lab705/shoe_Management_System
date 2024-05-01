package lk.ijse.shoemanagementsystem.service;


import lk.ijse.shoemanagementsystem.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    List<ItemDTO> getAllItem();

    void deleteItem(String id);
}
