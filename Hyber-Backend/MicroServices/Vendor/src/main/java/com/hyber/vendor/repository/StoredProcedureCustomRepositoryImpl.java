package com.hyber.vendor.repository;

import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StoredProcedureCustomRepositoryImpl implements StoreProcedureCustomRepository{
	
	private final EntityManager entityManager;
	
	@Autowired
	public StoredProcedureCustomRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public void executeStoredProcedure(String storedProcedureName) throws SQLDataException {
		try {
			StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(storedProcedureName);
			storedProcedureQuery.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void executeStoredProcedure(String storedProcedureName, String... paramName) throws SQLException {
		try {
			StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(storedProcedureName);
			
			for (int i = 0; i < paramName.length; i++) {
				storedProcedureQuery.registerStoredProcedureParameter(i+1, String.class, ParameterMode.IN);
				storedProcedureQuery.setParameter(i+1, paramName[i]);
			}
			storedProcedureQuery.executeUpdate();
		}catch (Exception e) {
			throw e;
		}
		
	}

}
