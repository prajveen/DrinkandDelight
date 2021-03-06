package com.capgemini.dad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dad.dao.IDistributorDao;
import com.capgemini.dad.dao.ISupplierDao;
import com.capgemini.dad.entity.Distributor;
import com.capgemini.dad.entity.Supplier;
import com.capgemini.dad.exceptions.DistributorNotFoundException;
import com.capgemini.dad.exceptions.SupplierNotFoundException;

@Service
@Transactional
public class DisplayServiceImplementation implements IDisplayService {
	
	@Autowired
	private IDistributorDao distributorDao;
	
	@Autowired
	private ISupplierDao supplierDao;
	
	/**
	 * @param supplierId This method will show account details by supplier_Id
	 * @return Supplier
	 */
	@Override
	public Supplier displaySupplierById(Long supplierId) {
		Supplier supplier=findSupplierById(supplierId);
		return supplier;
	}
	
	/**
	 * @param supplierId This method will fetch the Supplier by Supplier id
	 * @return Supplier
	 */
	@Override
	public Supplier findSupplierById(Long supplierId) {
		Optional<Supplier> optional = supplierDao.findById(supplierId);
		if (optional.isPresent()) {
			Supplier supplier = optional.get();
			return supplier;
		}
		throw new SupplierNotFoundException("Supplier not found for supplier_id=" + supplierId);
	}
	
	/**
	 * @param distributorId This method will show account details by distributor_Id
	 * @return Distributor
	 */
	@Override
	public Distributor displayDistributorById(Long distributorId) {
		Distributor distributor=findDistributorById(distributorId);
		return distributor;
	}
	
	/**
	 * @param distributorId This method will fetch the Distributor by Distributor_Id
	 * @return Distributor
	 */
	@Override
	public Distributor findDistributorById(Long distributorId) {
		Optional<Distributor> optional = distributorDao.findById(distributorId);
		if (optional.isPresent()) {
			Distributor distributor = optional.get();
			return distributor;
		}
		throw new DistributorNotFoundException("Distributor not found for distributor_Id=" + distributorId);
	}
	
	
}
