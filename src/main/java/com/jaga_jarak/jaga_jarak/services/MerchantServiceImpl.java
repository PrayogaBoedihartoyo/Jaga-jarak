package com.jaga_jarak.jaga_jarak.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaga_jarak.jaga_jarak.dto.MerchantDTO;
import com.jaga_jarak.jaga_jarak.model.Merchant;
import com.jaga_jarak.jaga_jarak.repository.MerchantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class MerchantServiceImpl implements MerchantService{

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant create(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant update(long id, Merchant merchant) {
        final Merchant result = findById(id);
        if (result != null) {
            result.setName(merchant.getName());
            return merchantRepository.save(result);
        }
        return null;

    }

    @Override
    public Boolean delete(long id) {
        final Merchant result = findById(id);
        if (result != null) {
            merchantRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Merchant> findAll() {
        return merchantRepository.findAll();
    }

    @Override
    public Merchant findById(long id) {
        Optional<Merchant> merchantData = merchantRepository.findById(id);
        if (merchantData.isPresent()) {
            return merchantData.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public MerchantDTO mapToDTO(Merchant merchant) {
        return mapper.convertValue(merchant, MerchantDTO.class);
    }

    @Override
    public Merchant mapToEntity(MerchantDTO merchantDTO) {
        return mapper.convertValue(merchantDTO, Merchant.class);
    }
}
