package principal;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class Conexao{
	private DB baseDados;
	private MongoClient mongoClient;
	private DBCollection colecao;
	private BasicDBObject documento = new BasicDBObject();
	
	@SuppressWarnings("deprecation")
	public Conexao(int porta)
	{
		try
		{
			mongoClient = new MongoClient("mongodb://localhost:27017");
			baseDados = mongoClient.getDB("BaseEstacionamento");
			colecao = baseDados.getCollection("ColecaoEstacionamento");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean salvaBaseDados(Estacionamento estacionamento)
	{
		return false;
	}
	
	public void inserir(Object obj)
	{
		documento.put(obj.toString(), obj);
		colecao.insert(documento);
	}
}
