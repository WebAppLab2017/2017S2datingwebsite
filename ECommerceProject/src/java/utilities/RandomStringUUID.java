package utilities;


import java.util.UUID;

 
public class RandomStringUUID {
    public RandomStringUUID(){}
    public String UUID() {
        
        // Creating a random UUID (Universally unique identifier).
        
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
 
        return randomUUIDString;
    }
}