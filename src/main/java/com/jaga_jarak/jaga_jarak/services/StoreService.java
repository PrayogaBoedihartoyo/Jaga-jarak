package com.jaga_jarak.jaga_jarak.services;
import com.jaga_jarak.jaga_jarak.dto.StoreDTO;
import com.jaga_jarak.jaga_jarak.model.Store;

public interface StoreService {
    Store addStore(Long merchantId, Store store);
    Store mapToEntity(StoreDTO StoreDTO);
    StoreDTO mapToDTO(Store Store);
}
