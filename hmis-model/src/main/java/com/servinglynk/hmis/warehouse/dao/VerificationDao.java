package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.entity.VerificationEntity;

public interface VerificationDao {

	VerificationEntity create(VerificationEntity verification);

	VerificationEntity findByToken(String token);

	VerificationEntity updateVerification(VerificationEntity pVerification);

}