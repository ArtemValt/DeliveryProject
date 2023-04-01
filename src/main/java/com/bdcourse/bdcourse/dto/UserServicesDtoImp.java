package com.bdcourse.bdcourse.dto;

import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserServicesDtoImp implements UserServicesDto {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<StoreVo> getStores(String name, String address) {
        String selectQuery = " select new com.bdcourse.bdcourse.model.vo.StoreVo(s.id,s.storeName,s.address,s.subjectProduct,s.status) from StoreEntity s ";
        StringBuilder resultQuery = new StringBuilder(selectQuery);
        resultQuery.append(filterPart(name, address));
        var query = em.createQuery(resultQuery.toString());
        if (StringUtils.isNotBlank(name)) {
            query.setParameter("name", name);
        }
        if (StringUtils.isNotBlank(address)) {
            query.setParameter("name", address);
        }
        return query.getResultList();
    }

    @Override
    public void buyProduct(ElectronicProductVo electronicProductVo) {

    }

    @Override
    public ElectronicProductVo checkPrice(ElectronicProductVo electronicProductVo, String userId) {
        var query = em.createQuery("select new com.bdcourse.bdcourse.model.vo.ElectronicProductVo(e.id,e.price,e.countProducts,e.productName,e.store.storeName) from ElectronicEntity e where e.id=:id ");
        query.setParameter("id", userId);
        return (ElectronicProductVo) query.getSingleResult();
    }


    private String filterPart(String name, String address) {
        return (" where 1=1 " + (StringUtils.isNotBlank(address) ? (" and s.address like :address") : " ") + (StringUtils.isNotBlank(name) ? " and s.storeName like :name" : " "));
    }
}
