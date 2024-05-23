package lk.ijse.shoemanagementsystem.service;


import lk.ijse.shoemanagementsystem.dto.AdminPanelDTO;

import java.time.LocalDate;

public interface AdminPanelService {
    AdminPanelDTO getAdminPanelData(LocalDate date);
}
