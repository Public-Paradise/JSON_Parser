import javax.json.*;
import javax.json.stream.*;
import javax.json.stream.JsonParser.Event;
import java.net.*;
import java.io.*;
import org.glassfish.json.*;
public class URLConnect{
	public static void main(String[] args) throws Exception{
		String weather = "https://randomuser.me/api/?format=json";
		try {
			URL url = new URL(weather);
			InputStream in = url.openStream();
			JsonParser parse = Json.createParser(in);
			while(parse.hasNext()) {
				Event e = parse.next();
				if(e == Event.KEY_NAME) {
					System.out.print(parse.getString() + " : ");
					e = parse.next();
					if(e == Event.VALUE_STRING) {
						System.out.println(parse.getString());
					}else {
						
					}
				}
			}
		}catch(Exception e) {
			System.out.println("Cannot establish connection");
		}
	}
}