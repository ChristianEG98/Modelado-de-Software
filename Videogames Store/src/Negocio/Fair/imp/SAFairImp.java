/**
 * 
 */
package _2.Diseño.Negocio.Fair.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import _2.Diseño.Negocio.Employees.imp.Employees;
import _2.Diseño.Negocio.Fair.SAFair;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class SAFairImp implements SAFair {
	
	public int createFair(TFair tFair) {
		
		int id = -1;
		
		if (tFair != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				TypedQuery<Fair> query = entitymanager
						.createNamedQuery("Negocio.Fair.imp.Fair.findByname", Fair.class)
						.setParameter("name", tFair.getNameFair());
				List<Fair> res = query.getResultList();
				if (res.isEmpty()) {//No existe
					Fair Fair = new Fair(tFair);
					tFair.setActive(true);
					entitymanager.persist(Fair);
					entitytransaction.commit();
					id = Fair.getIdFair();
				} else { // Ya existe
					Fair FairRes = res.get(0);
					if (FairRes.getActive()) {
						id = -2;
						entitytransaction.rollback();
					} else { //Reactivar
						FairRes.setActive(true);
						FairRes.setPlace(tFair.getPlace());
						FairRes.setNameFair(tFair.getNameFair());
						FairRes.setCapacity(tFair.getCapacity());

						entitytransaction.commit();

						id = FairRes.getIdFair();
					}
				}
				entitymanager.close();
				emfactory.close();
			} catch (PersistenceException ex) {
				id = -1;
			}
		}

		return id;
		
	}

	
	public int addEmployeesFair(TAssist tAssist) {
		
		final int WEEK = 7;
		int id = -10;
		int capacity=0;
		if (tAssist != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();

				Fair Fair = entitymanager.find(Fair.class, tAssist.getfair(),
						LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				Employees empleado = entitymanager.find(Employees.class, tAssist.getemployees(),
						LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				

				int fairidquery;
				fairidquery=Fair.getIdFair();
	            Query query = entitymanager.createQuery("SELECT COUNT(obj) FROM Assist obj WHERE obj.Fair.idFair = " + fairidquery);     
	            long count = (long) query.getSingleResult();
				
				
				
				

				if (Fair != null) {
					if (empleado != null) {
						if (Fair.getActive() ) {
							if (Fair.getCapacity()>count){
							if (empleado.getActive()) {
								AssistId assistId = new AssistId(tAssist.getfair(),
										tAssist.getemployees());
								Assist AssistRes = entitymanager.find(Assist.class, assistId);

								if (AssistRes == null) {
									Assist Assist = new Assist(Fair, empleado);
									
									Assist.setActive(true);
									Assist.setDate(new Date());
									Assist.setDuration(WEEK);
									entitymanager.persist(Assist);
									entitytransaction.commit();
									capacity++;
									id = assistId.hashCode();
								} else {
									if (AssistRes.getActive()) {// ya esta en la Fair
										entitytransaction.rollback();
										id = -5;
									} else {// reactivacion a la Fair
										AssistRes.setActive(true);
										AssistRes.setDate(new Date());
										entitytransaction.commit();
										id = assistId.hashCode();
									}
								}
							} else {// Empleado no activo
								id = -4;
								entitytransaction.rollback();
							}
							}
							else{
								id=-6;
								entitytransaction.rollback();
							}
						} else {// Fair no activa y capacidad menor
							id = -3;
							entitytransaction.rollback();
						}
							

					} else {// Empleado no existe
						entitytransaction.rollback();
						id = -2;
					}
				} else {// Fair no existe
					entitytransaction.rollback();
					id = -1;
				}

				entitymanager.close();
				emfactory.close();
			} catch (PersistenceException ex) {
				id = -10;
			}
		}
	
		return id;
	
	}


	public int deleteFair(int idFair) {
		
		int id = -10;
		
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			Fair Fair = entitymanager.find(Fair.class, idFair);
			if (Fair != null) {
				if (Fair.getActive()) {
					TypedQuery<Assist> query = entitymanager
							.createNamedQuery("Negocio.Fair.imp.Assist.findByFair", Assist.class);
					query.setParameter("Fair", Fair);
					List<Assist> Assist = query.getResultList();
					if (Assist.isEmpty()) {
						Fair.setActive(false);
						entitytransaction.commit();
						id = idFair;
					} else {
						id = -3;
						entitytransaction.rollback();
					}

				} else {
					id = -2;
					entitytransaction.rollback();
				}
			}
			else{
				id = -1;
				entitytransaction.rollback();
			}
			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {
			id = -10;
		}

		return id;
	
	}


	public TFair searchFair(int idFair) {
		
		TFair tFair = null;

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
		try {
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();

			Fair Fair = entitymanager.find(Fair.class, idFair);

			if (Fair == null)
				entitytransaction.rollback();
			else{
				tFair = Fair.toTransfer();
				entitytransaction.commit();
			}
			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {
		}

		return tFair;
		
	}

	
	public int deleteEmployeesFair(TAssist tAssist) {
		
		int id = -10;
		if(tAssist != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				
				entitytransaction.begin();
				Fair Fair = entitymanager.find(Fair.class, tAssist.getfair(),
						LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				Employees empleado = entitymanager.find(Employees.class, tAssist.getemployees(),
						LockModeType.OPTIMISTIC_FORCE_INCREMENT);

				if (Fair != null) {
					if (empleado != null) {
						if (Fair.getActive()) {
							if (empleado.getActive()) {
								AssistId assistId = new AssistId(tAssist.getfair(),
										tAssist.getemployees());
								Assist AssistRes = entitymanager.find(Assist.class, assistId);
									if(AssistRes == null) {//El empleado no Assist a esa Fair
										entitytransaction.rollback();
										id = -7;
									} else {
										if(AssistRes.getActive()) {
											AssistRes.setActive(false);
											entitytransaction.commit();
											id = assistId.hashCode();
											
										} else {//El empleado ya esta quitado de esa Fair
											entitytransaction.rollback();
											id = -5;
										}
									}
								} else {//Empleado no activo
									entitytransaction.rollback();
									id = -4;
								}
	
							} else {//Fair no activa
								entitytransaction.rollback();
								id = -3;
							}
						} else {//Empleado no existe
							entitytransaction.rollback();
							id = -2;
						}
					} else {//Fair no existe
						entitytransaction.rollback();
						id = -1;
					}
				
			
				entitymanager.close();
				emfactory.close();
			} catch(PersistenceException ex) {
				id = -10;
			}
		}
		return id;
		
	}
	
	public List<TAssist> showEmployeesFair(int idFair){
		List<TAssist> res = new ArrayList<>();
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Fair Fair = entityManager.find(Fair.class, idFair);
			if (Fair != null && Fair.getActive()) {
				TypedQuery<Assist> consulta = entityManager
						.createNamedQuery("Negocio.Fair.imp.Assist.findByFair", Assist.class);
				consulta.setParameter("Fair", Fair);
				if (!consulta.getResultList().isEmpty()) {
					for (Assist a : consulta.getResultList()) {
						res.add(a.toTransfer());
					}
					entityTransaction.commit();
				} else
					entityTransaction.rollback();
			} else {
				entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();
		
		return res;
	}
	


	public List<TFair> listFairs() {
		
		List<Fair> lista = null;
		List<TFair> FairsLista=new ArrayList<TFair>();
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			
			TypedQuery<Fair> query = entitymanager.createNamedQuery("Negocio.Fair.imp.Fair.readAll", Fair.class);
			lista = query.getResultList();
			for(int i = 0; i < lista.size(); ++i) {
				FairsLista.add(lista.get(i).toTransfer());
			}
			entitytransaction.commit();

			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {}

		return FairsLista;
		
	}


	public int modifyFair(TFair tFair) {
		
		int id = -10;
		if (tFair != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				Fair Fair = entitymanager.find(Fair.class, tFair.getIdFair());
				if (Fair != null) {
					if (Fair.getActive()) {
						TypedQuery<Fair> query = entitymanager
								.createNamedQuery("Negocio.Fair.imp.Fair.findByname", Fair.class)
								.setParameter("name", tFair.getNameFair());
						List<Fair> lista = query.getResultList();
						
						if (lista.isEmpty() || lista.get(0).getIdFair() == tFair.getIdFair()) {
							Fair.setNameFair(tFair.getNameFair());
							Fair.setPlace(tFair.getPlace());
							Fair.setCapacity(tFair.getCapacity());
							entitytransaction.commit();
							id = tFair.getIdFair();
						} else { //Hay una Fair con ese nombre
							id = -3;
							entitytransaction.rollback();
						}
					} else { //Fair con activo a 0
						id = -2;
						entitytransaction.rollback();
					}
				} else {//la Fair no existe
					id = -1;
					entitytransaction.rollback();
				}
				entitymanager.close();
				emfactory.close();
			} catch (PersistenceException ex) {
				id = -10;
			}
		}
		return id;
		
	}



	
}