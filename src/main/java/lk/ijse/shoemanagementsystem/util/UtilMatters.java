package lk.ijse.shoemanagementsystem.util;

import lk.ijse.shoemanagementsystem.dao.CustomerDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Base64;

@AllArgsConstructor
@Component
public class UtilMatters {
    private final CustomerDAO customerDAO;
//    public String getMaxId() {
//        return generateNextOrderId(customerDAO.findMaxId());
//    }
//    private static String generateNextOrderId(String lastOrderId) {
//        String numericPart = lastOrderId.substring(1);
//        int nextNumericValue = Integer.parseInt(numericPart) + 1;
//        String nextNumericPart = String.format("%03d", nextNumericValue);
//        return "C" + nextNumericPart;
//    }
    public static String genarateId(){
         int idCounter = 1;
            String prefix = "Coo";
            String id = prefix + String.format("%03d", idCounter);
            idCounter++;
            return id;
    }

    public static String convertBAse64(String data){
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
}
