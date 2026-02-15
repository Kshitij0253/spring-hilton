package com.hiltonMicroSwitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiltonMicroSwitch.entity.ContactEnquiry;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactEnquiry, Long> {

}
