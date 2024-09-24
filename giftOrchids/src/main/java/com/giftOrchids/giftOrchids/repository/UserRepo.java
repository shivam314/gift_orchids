package com.giftOrchids.giftOrchids.repository;

import com.giftOrchids.giftOrchids.models.UserAddress;
import com.giftOrchids.giftOrchids.models.UserInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public UserInfo findUserByUserId(UUID userId) {
        return entityManager.find(UserInfo.class, userId);
    }

    public UserAddress findPrimaryAddressByUserId(UUID userId) {
        String jpql = "SELECT a FROM address a WHERE a.user_id = :userId AND is_primary_address = 1";
        TypedQuery<UserAddress> query = entityManager.createQuery(jpql, UserAddress.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }

    public List<UserAddress> findAddressesByUserId(UUID userId) {
        String jpql = "SELECT a FROM address a WHERE a.user_id = :userId";
        TypedQuery<UserAddress> query = entityManager.createQuery(jpql, UserAddress.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public int upsertUserDetail(UserInfo userInfo) {
        String sql = "INSERT INTO user_info (user_id, first_name, last_name, email, contact, auth_token, created_date, last_updated_date) " +
                "VALUES (:userId, :firstName, :lastName, :email, :contact, :authToken, :createdDate, :lastUpdatedDate) " +
                "ON CONFLICT (user_id) " +
                "DO UPDATE SET first_name = EXCLUDED.first_name, " +
                "last_name = EXCLUDED.last_name, " +
                "email = EXCLUDED.email, " +
                "contact = EXCLUDED.contact, " +
                "auth_token = EXCLUDED.auth_token, " +
                "last_updated_date = EXCLUDED.last_updated_date";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("userId", userInfo.getUserId());
        query.setParameter("firstName", userInfo.getFirstName());
        query.setParameter("lastName", userInfo.getLastName());
        query.setParameter("email", userInfo.getEmail());
        query.setParameter("contact", userInfo.getContact());
        query.setParameter("authToken", userInfo.getAuthToken());
        query.setParameter("createdDate", userInfo.getCreatedDate());
        query.setParameter("lastUpdatedDate", userInfo.getLastUpdatedDate());

        return query.executeUpdate();
    }

    public int upsertUserAddress(UserAddress userAddress) {
        String sql = "INSERT INTO user_address (address_id, user_id, address_line1, address_line2, locality, city, state, country, pin_code, address_type, is_primary_address, reference_name, reference_contact) " +
                "VALUES (:addressId, :userId, :addressLine1, :addressLine2, :locality, :city, :state, :country, :pinCode, :addressType, :isPrimaryAddress, :referenceName, :referenceContact) " +
                "ON CONFLICT (address_id) " +
                "DO UPDATE SET user_id = EXCLUDED.user_id, " +
                "address_line1 = EXCLUDED.address_line1, " +
                "address_line2 = EXCLUDED.address_line2, " +
                "locality = EXCLUDED.locality, " +
                "city = EXCLUDED.city, " +
                "state = EXCLUDED.state, " +
                "country = EXCLUDED.country, " +
                "pin_code = EXCLUDED.pin_code, " +
                "address_type = EXCLUDED.address_type, " +
                "is_primary_address = EXCLUDED.is_primary_address, " +
                "reference_name = EXCLUDED.reference_name, " +
                "reference_contact = EXCLUDED.reference_contact";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("addressId", userAddress.getAddressId());
        query.setParameter("userId", userAddress.getUserId());
        query.setParameter("addressLine1", userAddress.getAddressLine1());
        query.setParameter("addressLine2", userAddress.getAddressLine2());
        query.setParameter("locality", userAddress.getLocality());
        query.setParameter("city", userAddress.getCity());
        query.setParameter("state", userAddress.getState());
        query.setParameter("country", userAddress.getCountry());
        query.setParameter("pinCode", userAddress.getPinCode());
        query.setParameter("addressType", userAddress.getAddressType());
        query.setParameter("isPrimaryAddress", userAddress.getIsPrimaryAddress());
        query.setParameter("referenceName", userAddress.getReferenceName());
        query.setParameter("referenceContact", userAddress.getReferenceContact());

        return query.executeUpdate();
    }
}
