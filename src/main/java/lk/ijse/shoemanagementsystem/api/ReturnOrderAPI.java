package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.dto.ReturnOrderDTO;
import lk.ijse.shoemanagementsystem.service.ReturnOrderServic;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/returns")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class ReturnOrderAPI {
    private ReturnOrderServic returnOrderServic;
    @PostMapping
    public void returnOrders(@RequestBody ReturnOrderDTO returnOrderDTO){
        returnOrderServic.saveReturns(returnOrderDTO);
    }
}

