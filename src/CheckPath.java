import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckPath {
	
	private Path path;
	private String input_string;
	
	public CheckPath(String input_string){
		this.input_string = input_string;
		input_stringToPath();
	}
	
	private Path input_stringToPath(){
		path = Paths.get(input_string);
		return path;
	}
	
	public Path isRealPath(){
		
		if(Files.exists(input_stringToPath(), LinkOption.NOFOLLOW_LINKS)){
			return path;
		};
		return null;
	}
}
