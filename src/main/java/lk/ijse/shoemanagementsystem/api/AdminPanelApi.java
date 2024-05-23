package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.dto.AdminPanelDTO;
import lk.ijse.shoemanagementsystem.service.AdminPanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/adminPanel")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class AdminPanelApi {

    @Autowired
    private final AdminPanelService adminPanelService;

    @GetMapping("/{date}")
    public AdminPanelDTO getAdminPanelData(@PathVariable("date") LocalDate date){
        return adminPanelService.getAdminPanelData(date);
    }
}
