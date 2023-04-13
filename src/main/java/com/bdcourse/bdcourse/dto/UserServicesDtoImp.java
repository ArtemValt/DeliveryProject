package com.bdcourse.bdcourse.dto;

import com.bdcourse.bdcourse.model.PartOfList;
import com.bdcourse.bdcourse.model.products.ElectronicEntity;
import com.bdcourse.bdcourse.model.vo.ElectronicProductVo;
import com.bdcourse.bdcourse.model.vo.PartOfListVo;
import com.bdcourse.bdcourse.model.vo.StoreVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
@RequiredArgsConstructor
public class UserServicesDtoImp implements UserServicesDto {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public PartOfList<StoreVo> getStores(String name, String address) {
        String selectQuery = " select new com.bdcourse.bdcourse.model.vo.StoreVo(s.id,s.storeName,s.address,s.subjectProduct,s.status,s.products) " +
                "from StoreEntity s ";
        var query = em.createQuery(selectQuery + filterPart(name, address));
        if (StringUtils.isNotBlank(name)) {
            query.setParameter("name", name);
        }
        if (StringUtils.isNotBlank(address)) {
            query.setParameter("name", address);
        }
        return new PartOfListVo<>(query.getResultList(), query.getResultList().size());
    }

    @Override
    public void buyProduct(ElectronicProductVo electronicProductVo) {

    }

    @Override
    public ElectronicEntity getProduct(ElectronicProductVo electronicProductVo, String userId) {
        var query = em.createQuery("select e from ElectronicEntity e " +
                "where exists (select 1 from UserEntity u  where u.id=:id and u.rubles>e.price )" +
                "and e.countProducts <> 0 and lower( e.productName )like :name ");
        query.setParameter("name", "%" + electronicProductVo.getName().trim().toLowerCase() + "%");
        query.setParameter("id", userId);
        return (ElectronicEntity) query.getSingleResult();
    }

    @Override
    public PartOfList<ElectronicProductVo> getUsersProductsByUserId(String userId) {
        var query = em.createQuery("select u.productVos from  UserEntity u where u.id=:userId");
        query.setParameter("userId", userId);

        return new PartOfListVo<>(query.getResultList(), query.getResultList().size());
    }

    @Override
    public PartOfList<ElectronicProductVo> getProductFromCurrentStore(StoreVo storeVo) {
        var query = em.createQuery("select p.products from StoreEntity p where p.id =:id ");
        query.setParameter("id", storeVo.getId());
        return new PartOfListVo<>(query.getResultList(), query.getResultList().size());
    }


    private String filterPart(String name, String address) {
        return (" where 1=1 " + (StringUtils.isNotBlank(address) ? (" and s.address like :address") : " ") + (StringUtils.isNotBlank(name) ? " and s.storeName like :name" : " "));
    }
}
