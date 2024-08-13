import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
// http://localhost:8080/VLC/resources
@ApplicationPath("resources")
public class MyApplication extends ResourceConfig {
	 public MyApplication() {
	     packages("com.vlc");
	     //System.out.println("MyApplication ctor..");
	    }
	}

