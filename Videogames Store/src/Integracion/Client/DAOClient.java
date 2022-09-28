package _2.Dise�o.Integracion.Client;

import java.util.ArrayList;

import _2.Dise�o.Negocio.Client.imp.TClient;

public interface DAOClient {

	public int createClient (TClient tClient);
	public int deleteClient(int idClient);
	public int modifyClient(TClient tClient);
	public TClient searchClient (int idClient);
	public TClient searchClientByDni(String dni);
	public ArrayList<TClient> listClients();
	
}
