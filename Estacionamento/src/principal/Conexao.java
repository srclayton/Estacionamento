package principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.util.JSON;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.json.JSONObject;

public class Conexao {
	private MongoDatabase baseDados;
	private com.mongodb.client.MongoClient mongoClient;
	
	MongoCollection<Document> colecao;
	
	
	Document documentoDatabase;
	
	private static Conexao CONEXAO;
	
	public Conexao()
	{
		try
		{
			Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
			mongoClient = MongoClients.create(
					"mongodb+srv://dbLucas:dbLucas@cluster0.tkyku.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
			
			//Cria codec para inserir novos itens na database
			CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
					MongoClientSettings.getDefaultCodecRegistry(),
					CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
			
			//Carrega da database estacionamento e da coleção estacionamento
			baseDados = mongoClient.getDatabase("Estacionamento").withCodecRegistry(pojoCodecRegistry);
			colecao = baseDados.getCollection("Estacionamento");
			
			//Só tem somente um documento na base de dados (Estacionamento)
			this.documentoDatabase = colecao.find().first();
			/*System.out.println(documentoDatabase.toJson());
			
			MongoCursor<Document> doc = colecao.find().iterator();
			while(doc.hasNext())
				System.out.println(doc.next());
			
			while(doc.hasNext()) {
				ArrayList<Object> ar = new ArrayList<Object>(doc.next().values());
				for(int i = 0; i < ar.size(); i++)
					System.out.println(doc.next());
				
			}

			String content;
			StringBuilder stringBuilder = new StringBuilder();
			File file = new File("blabla.json");
			Scanner scan = new Scanner(file);

			while(scan.hasNext())
				stringBuilder.append(scan.next());

			content = stringBuilder.toString();

			System.out.println("Content: " + content);*/
			
			/*Document aux = new Document();

			aux.append("0", "lucas");
			collection.insertOne(aux);
			colecao.deleteOne(aux);*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public synchronized static Conexao getInstance() {
		if(Conexao.CONEXAO == null)
			Conexao.CONEXAO = new Conexao();
		return Conexao.CONEXAO;
	}
	
	public Document getDocumentoDatabase() {
		return this.documentoDatabase;
	}

	public String getDatabaseJsonAsString() {
		Gson gson = new Gson();
		String json = gson.toJson(documentoDatabase);
		System.out.println(json);
		
		return json;
	}
	
	/*public void salvaBancoDeDados(Document documentoAtualizado) throws Exception {
		colecao.findOneAndReplace(documentoDatabase, documentoAtualizado);
		//colecao.insertOne(documentoAtualizado);
		documentoDatabase = documentoAtualizado;
	}
	
	public void salvaBancoDeDados(String dbData) throws Exception {
		Document documentoAtualizado = new Document();
		documentoAtualizado.append("Estacionamento", dbData);
		colecao.findOneAndReplace(documentoDatabase, documentoAtualizado);
		System.out.println("Salvo: " + dbData);
		documentoDatabase = documentoAtualizado;
	}*/

	public void salvaBancoDeDados(Estacionamento estacionamento) {
		Gson gson = new Gson();
		Document documentoAtualizado = Document.parse(gson.toJson(estacionamento));
		colecao.findOneAndReplace(documentoDatabase, documentoAtualizado);
		documentoDatabase = documentoAtualizado;
	}
}
