package Report.Providers;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
public interface ConfigProviderInterface {

    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("project.conf");
    }


    String baseURL = readConfig().getString("baseURL");
}
