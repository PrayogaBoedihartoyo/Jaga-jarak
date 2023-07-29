package com.jaga_jarak.jaga_jarak.controller;

import com.jaga_jarak.jaga_jarak.dto.StoreDTO;
import com.jaga_jarak.jaga_jarak.model.Store;
import com.jaga_jarak.jaga_jarak.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/add-store-to-merchant/{merchantId}")
    public StoreDTO addStoreToMerchant(@PathVariable Long merchantId, @RequestBody StoreDTO request) {
        final Store store = storeService.mapToEntity(request);
        final Store result = storeService.addStore(merchantId, store);
        return storeService.mapToDTO(result);
    }
}
