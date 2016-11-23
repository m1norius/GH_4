import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyData extends SimpleFileVisitor<Path>{
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		
		if(	file.toString().endsWith(".mp3")  || 
			file.toString().endsWith(".wav")  || 
			file.toString().endsWith(".wma")  || 
			file.toString().endsWith(".avi")  ||
			file.toString().endsWith(".mp4")  ||
			file.toString().endsWith(".flv")  ||
			file.toString().endsWith(".jpeg") ||
			file.toString().endsWith(".jpg")  ||
			file.toString().endsWith(".gif")  ||
			file.toString().endsWith(".png")
			){
			Main.list_of_data.add(file.toRealPath(LinkOption.NOFOLLOW_LINKS).toString());	
		}
		
		return super.visitFile(file, attrs);
	}
}
