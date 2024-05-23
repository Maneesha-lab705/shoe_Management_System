package lk.ijse.shoemanagementsystem.service.impl;


import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.dao.OrderDao;
import lk.ijse.shoemanagementsystem.dao.OrderItemDao;
import lk.ijse.shoemanagementsystem.dto.AdminPanelDTO;
import lk.ijse.shoemanagementsystem.service.AdminPanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminPanelServiceImpl implements AdminPanelService {

    @Autowired
    private final OrderDao orderDao;

    @Autowired
    private final OrderItemDao orderItemDao;
    @Override
    public AdminPanelDTO getAdminPanelData(LocalDate date) {
        Double totalAmountByDate = orderDao.findTotalAmountByDate(date);
        Double totalProfitByDate = orderDao.findTotalProfitByDate(date);
        String bestSellingShoeCodeByDate = orderItemDao.findBestSellingShoeCodeByDate(date);
        String bestSellingShoeCodeImageByDate = orderItemDao.findBestSellingShoeCodeImageByDate(date);
        Integer bestSellingShoeCodeQtyByDate = orderItemDao.findBestSellingShoeCodeQtyByDate(date);
        return new AdminPanelDTO(totalAmountByDate,totalProfitByDate,bestSellingShoeCodeByDate,bestSellingShoeCodeImageByDate,bestSellingShoeCodeQtyByDate);
    }
}
