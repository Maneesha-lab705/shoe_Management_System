package lk.ijse.shoemanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.conversion.ConversionData;
import lk.ijse.shoemanagementsystem.dao.ItemDAO;
import lk.ijse.shoemanagementsystem.dto.ItemDTO;
import lk.ijse.shoemanagementsystem.entity.ItemEntity;
import lk.ijse.shoemanagementsystem.entity.ItemGender;
import lk.ijse.shoemanagementsystem.entity.Ocation;
import lk.ijse.shoemanagementsystem.entity.Verities;
import lk.ijse.shoemanagementsystem.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceIMPL implements ItemService {
    private final ConversionData conversionData;
    private final ItemDAO itemDAO;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setShoeCode(selectItemCategory(itemDTO.getOcation(),itemDTO.getVerities(),itemDTO.getItemGender()));
        System.out.println(itemDTO);
        ItemEntity itemEntity = conversionData.toItemEntity(itemDTO);
        System.out.println(itemEntity);
        itemDAO.save(itemEntity);
    }

    @Override
    public List<ItemDTO> getAllItem() {
      return   conversionData.getAllItemList(itemDAO.findAll());
    }

    private String selectItemCategory(Ocation occasion, Verities verities, ItemGender gender) {
        String gender1=null;
        String occasion1=null;
        String verities1=null;
        switch (gender) {
            case WOMEN: gender1 = "W";
                break;
            case MAN:
                gender1 = "M";
                break;
            default:
        }

        switch (occasion) {
            case FORMAL:
                occasion1 = "F";
                break;
            case CASUAL:
                occasion1 = "C";
                break;
            case INDUSTRIAL:
                occasion1 = "I";
                break;
            case SPORT:
                occasion1 = "S";
                break;
        }

        switch (verities) {
            case HEEL:
                verities1 = "H";
                break;
            case FLAT:
                verities1 = "F";
                break;
            case WEDGES:
                verities1 = "W";
                break;
            case FLIP_FLOPS:
                verities1 = "FF";
                break;
            case SANDALS:
                verities1 = "SD";
                break;
            case SHOES:
                verities1 = "S";
                break;
            case SLIPPERS:
                verities1 = "SL";
                break;
        }
        System.out.println(occasion1 + verities1 + gender1);
        return nextItemId(occasion1 + verities1 + gender1) ;

    }

        public String nextItemId(String s) {
            String maxId = itemDAO.findMaxId();
            System.out.println(maxId);
            if (maxId != null){
                return generateNextItemId(maxId,s);
            }else {
                System.out.println(s+"001");
                return s+"001";
            }
        }
    private static String generateNextItemId(String lastItemId, String concatString) {
        int nextNumericValue = Integer.parseInt(lastItemId) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return  concatString + nextNumericPart;
    }
    }
