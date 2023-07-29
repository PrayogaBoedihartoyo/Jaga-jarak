package com.jaga_jarak.jaga_jarak.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaga_jarak.jaga_jarak.dto.StoreDTO;
import com.jaga_jarak.jaga_jarak.model.Merchant;
import com.jaga_jarak.jaga_jarak.model.Store;
import com.jaga_jarak.jaga_jarak.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    MerchantService merchantService;

    @Autowired
    StoreRepository storeRepository;

    ObjectMapper mapper = new ObjectMapper();
    @Override
    public Store addStore(Long merchantId, Store store) {
        final Merchant merchant = merchantService.findById(merchantId);
        if (merchant != null) {
            store = storeRepository.save(store);
            if (merchant.getStores() != null) {
                List<Store> stores = merchant.getStores();
                stores.add(store);
                merchant.setStores(stores);
            } else {
                merchant.setStores(Collections.singletonList(store));
            }
            merchantService.create(merchant);
            return store;
        }
        return null;
    }

    @Override
    public Store mapToEntity(StoreDTO StoreDTO) {
        return mapper.convertValue(StoreDTO, Store.class);
    }

    @Override
    public StoreDTO mapToDTO(Store Store) {
        return mapper.convertValue(Store, StoreDTO.class);
    }
}
