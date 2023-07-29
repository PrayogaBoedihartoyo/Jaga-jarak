package com.jaga_jarak.jaga_jarak.dto;

import java.util.List;

public record MerchantDTO(
        long id,
        String name,
        List<StoreDTO> stores
) {}
