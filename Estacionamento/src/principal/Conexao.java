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
			
			//Carrega da database estacionamento e da colecao estacionamento
			baseDados = mongoClient.getDatabase("Estacionamento").withCodecRegistry(pojoCodecRegistry);
			colecao = baseDados.getCollection("Estacionamento");
			
			//Como so tem um documento na base de dados (Estacionamento)
			this.documentoDatabase = colecao.find().first();
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

		return json;
	}

	public void salvaBancoDeDados(Estacionamento estacionamento) {
		Gson gson = new Gson();
		Document documentoAtualizado = Document.parse(gson.toJson(estacionamento));
		colecao.findOneAndReplace(documentoDatabase, documentoAtualizado);
		documentoDatabase = documentoAtualizado;
	}
}
