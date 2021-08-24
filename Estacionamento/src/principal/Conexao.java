package principal;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

import org.bson.Document;

public class Conexao{
	private MongoDatabase baseDados;
	private com.mongodb.client.MongoClient mongoClient;
	private DBCollection colecao;
	private BasicDBObject documento = new BasicDBObject();
	
	@SuppressWarnings("deprecation")
	public Conexao(int porta) throws Exception
	{
		try
		{
			mongoClient = MongoClients.create("mongodb+srv://dbLucas:dbLucas@cluster0.tkyku.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
			
			baseDados = mongoClient.getDatabase("Estacionamento");
			MongoCollection<Document> collection = baseDados.getCollection("Estacionamento");
			MongoCursor<Document> doc = collection.find().iterator();
			while(doc.hasNext())
				System.out.println(doc.next());
			while(doc.hasNext()) {
				ArrayList<Object> ar = new ArrayList<Object>(doc.next().values());
				for(int i = 0; i < ar.size(); i++)
					System.out.println(doc.next());
				
			}
			Document aux = new Document();
			String content;
			StringBuilder stringBuilder = new StringBuilder();
			File file = new File("blabla.json");
			Scanner scan = new Scanner(file);
			while(scan.hasNext())
				stringBuilder.append(scan.next());
			content = stringBuilder.toString();
			System.out.println("Content: " + content);
			aux.parse("");
			aux.append("0", "lucas");
			//collection.insertOne(aux);
			collection.deleteOne(aux);

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
	
	public static void main(String[] args) {
		try {
			Conexao con = new Conexao(2123);
		}
		catch(Exception e) {
			
		}
	}
}
