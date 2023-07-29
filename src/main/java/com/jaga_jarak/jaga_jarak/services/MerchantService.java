package com.jaga_jarak.jaga_jarak.services;

import com.jaga_jarak.jaga_jarak.dto.MerchantDTO;
import com.jaga_jarak.jaga_jarak.model.Merchant;

import java.util.List;

public interface MerchantService {
    Merchant create(Merchant merchant);
    Merchant update(long id, Merchant merchant);
    Boolean delete(long id);
    List<Merchant> findAll();
    Merchant findById(long id);

    MerchantDTO mapToDTO(Merchant merchant);
    Merchant mapToEntity(MerchantDTO merchantDTO);
}
