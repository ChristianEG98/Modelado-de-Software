package _2.Diseño.Negocio.Client.imp;

import java.util.ArrayList;

import _2.Diseño.Integracion.Client.DAOClient;
import _2.Diseño.Integracion.Factory.FactoryIntegration;
import _2.Diseño.Integracion.Query.FactoryQuery;
import _2.Diseño.Integracion.Query.TQuery;
import _2.Diseño.Integracion.Transaction.Transaction;
import _2.Diseño.Integracion.Transaction.TransactionManager.TransactionManager;
import _2.Diseño.Negocio.Client.SAClient;

public class SAClientImp implements SAClient{

	@Override
	public int createClient(TClient tClient) {
		
		int id = -1;


        if (tClient != null) {

            TransactionManager transactionManager = TransactionManager.getInstance();
            Transaction transaction = transactionManager.createTransaction();
            transaction.start();

            FactoryIntegration factoryIntegration = FactoryIntegration.getInstance();
            DAOClient daoClient = factoryIntegration.createDAOClient();
            TClient tClientExists = daoClient.searchClientByDni(tClient.getDNI());

            tClient.setActive(true);

            if(tClientExists == null){
                id = daoClient.createClient(tClient);
                if(id == -100)
                    transaction.rollback();
                else
                    transaction.commit();
            }
            else {
                if(!tClientExists.getActive()){
                    tClient.setIdClient(tClientExists.getIdClient());
                    id = daoClient.modifyClient(tClient);

                    if(id==-100)
                        transaction.rollback();
                    else
                        transaction.commit();
                }
                else{
                    transaction.rollback();
                }
            }

            transactionManager.deleteTransaction();
        }
        return id;
	}

	@Override
	public int deleteClient(int idClient) {
		
		int id = -1;

        TransactionManager transactionManager = TransactionManager.getInstance();
        Transaction transaction = transactionManager.createTransaction();
        transaction.start();

        FactoryIntegration factoriaIntegracion = FactoryIntegration.getInstance();
        DAOClient daoClient = factoriaIntegracion.createDAOClient();

        TClient tClientExists = daoClient.searchClient(idClient);

        if (tClientExists == null) {
            transaction.rollback();
        } else {
            if(tClientExists.getActive()){
            id = daoClient.deleteClient(idClient);
            if (id == -100)
                transaction.rollback();
            else
                transaction.commit();
            } else {
                transaction.rollback();
                id = -2;
            }
        }

        transactionManager.deleteTransaction();

        return id;
    }

	@Override
	public int modifyClient(TClient tClient) {
		
		int id = -1;

        TransactionManager transactionManager = TransactionManager.getInstance();
        Transaction transaction = transactionManager.createTransaction();
        transaction.start();

        FactoryIntegration factoriaIntegracion = FactoryIntegration.getInstance();
        DAOClient daoClient = factoriaIntegracion.createDAOClient();

        TClient tClientExists = daoClient.searchClient(tClient.getIdClient());

        if (tClientExists == null) {
            transaction.rollback();
        } else {
            if(tClientExists.getActive()){
                TClient tModify = daoClient.searchClientByDni(tClient.getDNI());
                if(tModify == null){ 
                    id = daoClient.modifyClient(tClient);

                    if (id == -100)
                        transaction.rollback();
                    else
                        transaction.commit();
                } else { //El DNI existe
                    if(tClientExists.getIdClient() == tModify.getIdClient()){
                        id = daoClient.modifyClient(tClient);

                        if (id == -100)
                            transaction.rollback();
                        else
                            transaction.commit();
                    } else { //DNI repetido
                        transaction.rollback();
                        id = -2;
                        }
                    }
            } else {
                transaction.rollback();
                id = -3;
            }
        } 

        transactionManager.deleteTransaction();

        return id;
	}

	@Override
	public TClient searchClient(int idClient) {
		
		TClient tClient = null;

        //Crear transacción
        TransactionManager transactionManager = TransactionManager.getInstance();
        Transaction transaction = transactionManager.createTransaction();
        transaction.start();

        DAOClient daoClient = FactoryIntegration.getInstance().createDAOClient();
        tClient = daoClient.searchClient(idClient);

        if(tClient == null)
            transaction.rollback();
        else
            transaction.commit();

        //Eliminar transacción
        transactionManager.deleteTransaction();
        return tClient;


	}

	@Override
	public TClient searchClientByDni(String dni) {
		
		TClient client = null;

        //Crear transacción
        TransactionManager transactionManager = TransactionManager.getInstance();
        Transaction transaction = transactionManager.createTransaction();
        transaction.start();

        DAOClient daoClient = FactoryIntegration.getInstance().createDAOClient();
        client = daoClient.searchClientByDni(dni);
        transaction.commit();

        //Eliminar transacción
        transactionManager.deleteTransaction();
        return client;
	}

	@Override
	public ArrayList<TClient> listClients() {
		
		ArrayList<TClient> listClients = null;

		        TransactionManager transactionManager = TransactionManager.getInstance();
		        Transaction transaction = transactionManager.createTransaction();
		        transaction.start();

		        DAOClient daoClient  = FactoryIntegration.getInstance().createDAOClient();
		        listClients = daoClient.listClients();
		        transaction.commit();

		        transactionManager.deleteTransaction();
		        return listClients; 
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TClient> CustomersWhoHaveMadeMoreThan_X_Purchases(TQuery tQuery) {
		ArrayList<TClient> clients = null;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		FactoryQuery factoryQuery = FactoryQuery.getInstance();
		clients =  (ArrayList<TClient>) factoryQuery.customersWhoHaveMadeMoreThan_X_Purchases().execute(tQuery);
		transaction.commit();
	

		transactionManager.deleteTransaction();
		return clients;
	}
}
