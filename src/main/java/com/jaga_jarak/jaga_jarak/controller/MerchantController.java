package com.jaga_jarak.jaga_jarak.controller;
import com.jaga_jarak.jaga_jarak.dto.MerchantDTO;
import com.jaga_jarak.jaga_jarak.model.Merchant;
import com.jaga_jarak.jaga_jarak.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/merchant")
    public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping("/create")
    public MerchantDTO create(@RequestBody MerchantDTO request) {
        final Merchant merchant = merchantService.mapToEntity(request);
        final Merchant result = merchantService.create(merchant);
        return merchantService.mapToDTO(result);
    }

    @PutMapping("/update/{id}")
    public MerchantDTO update(@PathVariable("id") Long id, @RequestBody MerchantDTO request) {
        final Merchant merchant = merchantService.mapToEntity(request);
        final Merchant result = merchantService.update(id, merchant);
        return merchantService.mapToDTO(result);
    }
    @GetMapping("/get-all")
    public List<MerchantDTO> findAll() {
        return merchantService.findAll().stream().map(merchant -> merchantService.mapToDTO(merchant)).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return merchantService.delete(id);
    }
}
