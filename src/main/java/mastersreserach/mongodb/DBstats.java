package mastersreserach.mongodb;

        import org.bson.Document;
        import com.mongodb.MongoClient;
        import com.mongodb.client.MongoDatabase;
        import java.util.Map;

public class DBstats {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("10.47.3.109", 27017);
        MongoDatabase database = mongoClient.getDatabase("boniface");

        Document stats = database.runCommand(new Document("dbstats", 1));

        for (Map.Entry<String, Object> set : stats.entrySet()) {

            System.out.format("%s: %s%n", set.getKey(), set.getValue());
        }

        mongoClient.close();
    }
}