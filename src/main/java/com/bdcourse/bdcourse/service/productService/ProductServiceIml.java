package com.bdcourse.bdcourse.service.productService;

import com.bdcourse.bdcourse.dto.UserServicesDto;
import com.bdcourse.bdcourse.helper.SecurityHelper;
import com.bdcourse.bdcourse.jpa.ProductRepository;
import com.bdcourse.bdcourse.model.entitys.ProductEntity;
import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceIml implements ProductService {
    private final ProductRepository productRepository;
    private final UserServicesDto userServicesDto;


    @Override
    public ProductEntity getProduct(ElectronicProductVo electronicProductVo) {
        var product = userServicesDto.getProduct(electronicProductVo, SecurityHelper.getUserId());
        if (product.isEmpty()) throw new RuntimeException("product is not define");
        ProductEntity entity = product.get();
        entity.setCountProducts(entity.getCountProducts() - 1);

        return productRepository.save(entity);
    }
}
