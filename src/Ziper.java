import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class Ziper {

	public static void toZip(Path path, String type_of_file, int i){
		
		Map<String, String> env = new HashMap<>(); 
	    env.put("create", "true");
	    
		URI uri = URI.create("jar:file:"+ path +"/"+type_of_file);
		
		try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
		    Path externalTxtFile = Paths.get(Main.list_of_data.get(i));
		    Path pathInZipfile = zipfs.getPath("/" + Paths.get(Main.list_of_data.get(i)).getFileName());          
		    Files.copy(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING); 
		    
		} catch (IOException e) {
			System.out.println("Access Denied: "+ path +"/"+ Paths.get(Main.list_of_data.get(i)).getFileName());
			return;
		}
	}
}
