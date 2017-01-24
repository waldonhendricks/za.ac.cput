package mastersreserach.mongodb;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;

public class DBwrite {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("10.47.3.109", 27017);
        MongoDatabase database = mongoClient.getDatabase("boniface");

        try {

            database.createCollection("cars");
        } catch (MongoCommandException e) {

            database.getCollection("cars").drop();
        }

        List<Document> writes = new ArrayList<>();

        MongoCollection<Document> carsCol = database.getCollection("cars");

        Document d1 = new Document("_id", 1);
        d1.append("name", "Audi");
        d1.append("price", 52642);
        writes.add(d1);

        Document d2 = new Document("_id", 2);
        d2.append("name", "Mercedes");
        d2.append("price", 57127);
        writes.add(d2);

        Document d3 = new Document("_id", 3);
        d3.append("name", "Skoda");
        d3.append("price", 9000);
        writes.add(d3);

        Document d4 = new Document("_id", 4);
        d4.append("name", "Volvo");
        d4.append("price", 29000);
        writes.add(d4);

        Document d5 = new Document("_id", 5);
        d5.append("name", "Bentley");
        d5.append("price", 350000);
        writes.add(d5);

        Document d6 = new Document("_id", 6);
        d6.append("name", "Citroen");
        d6.append("price", 21000);
        writes.add(d6);

        Document d7 = new Document("_id", 7);
        d7.append("name", "Hummer");
        d7.append("price", 41400);
        writes.add(d7);

        Document d8 = new Document("_id", 8);
        d8.append("name", "Volkswagen");
        d8.append("price", 21600);
        writes.add(d8);

        carsCol.insertMany(writes);

        mongoClient.close();
    }
}