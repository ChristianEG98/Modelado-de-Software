package _2.Diseño.Negocio.Employees.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import _2.Diseño.Negocio.Company.imp.Company;
import _2.Diseño.Negocio.Employees.SAEmployees;
import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Employees.TFullTimeEmployees;
import _2.Diseño.Negocio.Employees.TPartTimeEmployees;
import _2.Diseño.Negocio.Fair.imp.Assist;

public class SAEmployeesImp implements SAEmployees{

	@Override
	public int createEmployees(TEmployees temployees) {
		int id=-1;
		try{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
		EntityManager entitymanager = emfactory.createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		Company company = entitymanager.find(Company.class, temployees.getCompany().getIdCompany());
		if(company!=null && company.getActive()){
			TypedQuery<Employees> query = entitymanager
					.createNamedQuery("Negocio.Employees.imp.Employees.findByDni", Employees.class)
					.setParameter("Dni", temployees.getDni());
			List<Employees> res = query.getResultList();
			if(res.size()==0){
				temployees.setActive(true);
				company.setNumEmployees(company.getNumEmployees()+1);
				if(temployees instanceof TFullTimeEmployees){
					FullTimeEmployees fulltimeemployees = new FullTimeEmployees((TFullTimeEmployees)temployees);
					entitymanager.persist(fulltimeemployees);
					entitytransaction.commit();
					id = fulltimeemployees.getIdEmployees(); // resultado del alta empleado
				}
				else{
					PartTimeEmployees parttimeemployees=new PartTimeEmployees((TPartTimeEmployees)temployees);
					entitymanager.persist(parttimeemployees);
					entitytransaction.commit();
					id = parttimeemployees.getIdEmployees(); // resultado del alta empleado
				}
			}
			else if(!res.get(0).getActive()){
				if((res.get(0) instanceof FullTimeEmployees && temployees instanceof TFullTimeEmployees) 
						|| (res.get(0) instanceof PartTimeEmployees&& temployees instanceof TPartTimeEmployees)){
					res.get(0).setActive(true);
					res.get(0).setDni(temployees.getDni());
					res.get(0).setName(temployees.getName());
					res.get(0).setLastName(temployees.getLastName());
					res.get(0).setPhone(temployees.getPhone());
					res.get(0).setEmail(temployees.getEmail());
					res.get(0).setPayroll(temployees.getPayroll());
					if(res.get(0) instanceof FullTimeEmployees){
						((FullTimeEmployees)res.get(0)).setBonus(((TFullTimeEmployees)temployees).getBonus());
						id=res.get(0).getIdEmployees();
					}
					else{
						((PartTimeEmployees)res.get(0)).setHours(((TPartTimeEmployees)temployees).getHours());
						id=res.get(0).getIdEmployees();
					}
					company.setNumEmployees(company.getNumEmployees()+1);
					entitytransaction.commit();
				}
				else{
					//El que existe dado de baja no concuerda en tipo
					id=-3;
					entitytransaction.rollback();
					
				}
			}
			else{
				//Ya hay uno con el mismo dni dado de alta
				id=-2;
				entitytransaction.rollback();
			}
		}
		else{
			id=-1;//departamento no existe o no esta activo
			entitytransaction.rollback();
		}
		}catch(PersistenceException ex){
			id=-100;
		}
		return id;
	}

	@Override
	public int deleteEmployees(int idemployees) {
		
		int id = -100;
		
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			Employees employees = entitymanager.find(Employees.class, idemployees);
			if (employees != null) { // Empleado existe
				if (employees.getActive()) { // el Empleado está activo
					TypedQuery<Assist> query = entitymanager
							.createNamedQuery("Negocio.Fair.imp.Assist.findByemployees", Assist.class)
							.setParameter("employees", employees);
					List<Assist> res = query.getResultList();
					if(res.size()==0){
						employees.setActive(false);
					Company company = entitymanager.find(Company.class, employees.getcompany().getIdCompany());
					company.setNumEmployees(company.getNumEmployees()-1);
					
					entitytransaction.commit();
					id = idemployees ;
					}
					else{//el empleado tiene eventos activos
						id=-3;
						entitytransaction.rollback();
					}
				}
				else { //Empleado ya está desactivado
					id = -2;
					entitytransaction.rollback();
				}
			}
			else{//Empleado no existe
				id = -1;
				entitytransaction.rollback();
			}
			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {
			id = -100;
		}

		return id;
	}

	@Override
	public int modifyEmployees(TEmployees employees) {
		
		int id = -100;
		if (employees != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				Employees emp = entitymanager.find(Employees.class, employees.getIdEmployees());
				Company company = entitymanager.find(Company.class, employees.getCompany().getIdCompany());
				if(company!=null && company.getActive()){
					if (emp != null) { // Existe Empleado
						if (emp.getActive()) { // Empleado activo
							TypedQuery<Employees> query = entitymanager
									.createNamedQuery("Negocio.Employees.imp.Employees.findByDni", Employees.class)
									.setParameter("Dni", employees.getDni());
							List<Employees> res = query.getResultList();
							if(res.size()==0 || res.get(0).getIdEmployees() == emp.getIdEmployees()){
								emp.setDni(employees.getDni());
								emp.setName(employees.getName());
								emp.setLastName(employees.getLastName());
								emp.setPayroll(employees.getPayroll());
								emp.setPhone(employees.getPhone());
								emp.setEmail(employees.getEmail());
								emp.getcompany().setNumEmployees(emp.getcompany().getNumEmployees()-1);
								company = entitymanager.find(Company.class, employees.getCompany().getIdCompany());
								company.setNumEmployees(company.getNumEmployees()+1);
								emp.setcompany(company);
								if(employees instanceof TFullTimeEmployees){
									((FullTimeEmployees)emp).setBonus(((TFullTimeEmployees)employees).getBonus());
								}
								else{
									((PartTimeEmployees)emp).setHours(((TPartTimeEmployees)employees).getHours());
								}
								
								entitytransaction.commit();
								id = employees.getIdEmployees();
							}
							else{//dni ya esta en uso
								id = -1;
								entitytransaction.rollback();
							}
						}
						else { //El Empleado no está activo
							id = -2;
							entitytransaction.rollback();
						}
					} else {//El empleado no existe
						id = -3;
						entitytransaction.rollback();
					}
				}
				else{
					id= -4;
					entitytransaction.rollback();
				}
				entitymanager.close();
				emfactory.close();
			} catch (PersistenceException ex) {
				id = -100;
			}
		}
		return id;
	}

	@Override
	public List<TEmployees> listEmployees() {
		
		List<Employees> list = null;
		List<TEmployees> listemployees=new ArrayList<TEmployees>();
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();

			TypedQuery<Employees> query = entitymanager.createNamedQuery("Negocio.Employees.imp.Employees.findByactive", Employees.class).setParameter("active",true);
			list = query.getResultList();
			for(int i = 0; i < list.size(); ++i) {
				listemployees.add(list.get(i).toTransfer());
			}
			entitytransaction.commit();

			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {}

		return listemployees;
	}

	@Override
	public TEmployees searchEmployees(int idemployees) {
		
		TEmployees temployees = null;

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
		try {
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();

			Employees emp = entitymanager.find(Employees.class, idemployees);

			if (emp == null) // no existe
				entitytransaction.rollback();
			else{
				temployees = emp.toTransfer();
				entitytransaction.commit();
			}
			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {
			temployees=null;
		}

		return temployees;
	}

	@Override
	public TEmployees seacrhEmployeesByDni(String Dni) {
		
		boolean search=false;
		TEmployees temployees = null;
		if (Dni != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				TypedQuery<Employees> query = entitymanager
						.createNamedQuery("Negocio.Employees.imp.Employees.findByDni", Employees.class)
						.setParameter("Dni", Dni);
				List<Employees> res = query.getResultList();
				if(res.size()>0){
					int i=0;
					while(!search && i<res.size()){
						if(res.get(i).getActive()){
							search=true;
							temployees=res.get(0).toTransfer();
						}
						++i;//**
					}
				}
				else{//no hay empleado con ese dni
					temployees=null;
				}
			}catch (PersistenceException ex) {
				temployees= null;
			}
		}
		return temployees;
			
	}

	@Override
	public Float calculatePayRollEmployees(int idEmployees) {
		
		float sum=0f;
		Employees employees = null;	
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("videojuegos");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				employees = entitymanager.find(Employees.class, idEmployees);
				
				if(employees == null){
					
					sum = -1;
						
					entitytransaction.rollback();
				}
					
				else{
					sum=employees.calculatePayRoll();
					entitytransaction.commit();
				}
				
				entitymanager.close();
				emfactory.close();
			}
			catch(PersistenceException ex) {
				sum = -100;
			}
		
		return sum;
	
	}
	

	

}
