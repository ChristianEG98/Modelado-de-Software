/**
 * 
 */
package _2.Diseño.Negocio.Company.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import _2.Diseño.Negocio.Company.SACompany;
import _2.Diseño.Negocio.Employees.imp.Employees;


public class SACompanyImp implements SACompany {
	
	public int createCompany(TCompany company) {
		int idCompany = -1;
		if (company != null) {
			try {
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("videojuegos");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				EntityTransaction entitytransaction = entityManager.getTransaction();
				entitytransaction.begin();
				TypedQuery<Company> query = entityManager
						.createNamedQuery("Negocio.Company.imp.Company.findBycif", Company.class)
						.setParameter("cif", company.getCif());
				List<Company> res = query.getResultList();

				// Si el Company no existe-> se crea nuevo
				if (res.isEmpty()) {
					Company newCompany = new Company(company);
					newCompany.setActive(true);
					entityManager.persist(newCompany);
					entitytransaction.commit();
					idCompany = newCompany.getIdCompany();

				} else { // ya existe el Company
					Company result = res.get(0); // cogentityManageros el Company que devuelve la consulta
					if (result.getActive()) { // Si el compo está ya activo
						idCompany = -3;
						entitytransaction.rollback();
					} else {
						result.setActive(true);
						result.setName(company.getName());
						result.setCif(company.getCif());
						result.setNumEmployees(company.getNumEmployees());
						entitytransaction.commit();
						idCompany = result.getIdCompany();
					}
				}
				entityManager.close();
				entityManagerFactory.close();
			} catch (PersistenceException ex) {
				idCompany = -2;
			}
		}
		return idCompany;
	}


	
	public int modifyCompany(TCompany tCompany) {
		
		int idCompany = -1;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("videojuegos");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			if (entityTransaction != null) {
				entityTransaction.begin();

				Company company = entityManager.find(Company.class, tCompany.getIdCompany());

				if (company != null) {
					if (company.getActive()) {
						TypedQuery<Company> res = entityManager
								.createNamedQuery("Negocio.Company.imp.Company.findBycif", Company.class)
								.setParameter("cif", tCompany.getCif());

						if (res.getResultList().isEmpty() || res.getResultList().get(0)
								.getIdCompany() == tCompany.getIdCompany()) {

							company.setName(tCompany.getName());
							company.setCif(tCompany.getCif());
							
							entityTransaction.commit();
							idCompany = tCompany.getIdCompany();

						} else {
							idCompany = -5;
							entityTransaction.rollback();
						}
					} else {
						idCompany = -2;
						entityTransaction.rollback();
					}

				} else {
					idCompany = -3;
					entityTransaction.rollback();
				}
			} 

			entityManager.close();
			entityManagerFactory.close();
		} catch (PersistenceException e) {
			idCompany = -1; // error de Persistence
		}
		return idCompany;
		
	}
	
	@Override
	public int deleteCompany(int idCompany) {
		
		int idComp = -1;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("videojuegos");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entitytransaction = entityManager.getTransaction();
			entitytransaction.begin();

			Company resultado = entityManager.find(Company.class, idCompany);

			if (resultado != null) {
				if (resultado.getActive()) {
					if (resultado.getNumEmployees() == 0) { // no tiene entityManagerpleados
						resultado.setActive(false);
						entitytransaction.commit();
						idComp = resultado.getIdCompany();
					} else {
						idComp = -5; // Error tiene entityManagerpleados
						entitytransaction.rollback();
					}
				} else {
					idComp = -4;
					entitytransaction.rollback(); // Company ya esta dado de baja
				}
			} else {
				idComp = -3; // Company dado no existe
				entitytransaction.rollback();
			}
			entityManager.close();
			entityManagerFactory.close();
		} catch (PersistenceException e) {
			idComp = -2; // error de Persistence
		}
		return idComp;
	}

	@Override
	public TCompany searchCompany(int idCompany) {
		Company company = null;
		TCompany tCompany = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("videojuegos");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entitytransaction = entityManager.getTransaction();
			entitytransaction.begin();
			company = entityManager.find(Company.class, idCompany);

			if (company != null) {
				tCompany = company.toTransfer();
				entitytransaction.commit();
			} else {
				tCompany = null;
				entitytransaction.rollback();
			}

			entityManager.close();
			entityManagerFactory.close();
		} catch (PersistenceException e) {
			tCompany = null;
		}

		return tCompany;
	}

	@Override
	public List<TCompany> listCompanies() {
		List<TCompany> listCompany = new ArrayList<TCompany>();

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("videojuegos");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			if (entityTransaction != null) {
				entityTransaction.begin();

				TypedQuery<Company> query = entityManager.createNamedQuery("Negocio.Company.imp.Company.findAll",
						Company.class);
				List<Company> list = query.getResultList();

				// No hay Companys
				if (list.isEmpty()) {
					listCompany = null;
					entityTransaction.rollback();
				}
				// la lista no está vacía
				else {
					for (Company company : list) {
						TCompany tCompany = company.toTransfer();
						listCompany.add(tCompany);
					}
					entityTransaction.commit();
				}
			}
			entityManager.close();
			entityManagerFactory.close();
		} catch (PersistenceException e) {
			listCompany = null;
		}
		return listCompany;
	}
	
	
	
	public float calculatePayroll(int idCompany) {
		float suma = 0;
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("videojuegos");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			if(entityTransaction!=null){
				entityTransaction.begin();
				Company company = entityManager.find(Company.class, idCompany, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				if (company != null){
					if(company.getActive()) {

						TypedQuery<Employees> query = entityManager
								.createNamedQuery("Negocio.Employees.imp.Employees.findBycompany", Employees.class);
						query.setParameter("company", company);
						List<Employees> employees = query.getResultList();
						for (Employees e : employees) {
							suma += e.calculatePayRoll();
						}
						entityTransaction.commit();
					}
					else{
						suma = -4;
						entityTransaction.rollback();
					}
				} else{
					suma = -3;
					entityTransaction.rollback();
				}
			}
			
			entityManager.close();
			entityManagerFactory.close();
			
		} catch (PersistenceException e) {
			suma = -1;
		}

		return suma;
	}
}