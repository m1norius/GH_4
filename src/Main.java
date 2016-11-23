import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static List<String> list_of_data;

	public static void main(String[] args) {
		
		list_of_data = new ArrayList<String>();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		CheckPath check_path;
		
		String input_path;
		String input_path_to_copy;
		
		Path valid_path;
		Path valid_path_to_copy;

		while(true){

			list_of_data.clear();
			System.out.println("Enter path to directory:");
			input_path = sc.nextLine();
			check_path = new CheckPath(input_path);

			if(check_path.isRealPath() != null){
				valid_path = check_path.isRealPath();
				
				try {
					Files.walkFileTree(valid_path, new MyData());
				} catch (IOException e) {
					e.printStackTrace();
				}

				if(list_of_data.size() > 0){
					System.out.println("Enter path to copy:");
					input_path_to_copy = sc.nextLine();
					check_path = new CheckPath(input_path_to_copy);
					valid_path_to_copy = check_path.isRealPath();

					if(valid_path_to_copy != null && Files.isDirectory(valid_path_to_copy, LinkOption.NOFOLLOW_LINKS)){

						System.out.println("Copy...");
						
						for(int i = 0; i < list_of_data.size(); i++){

							//URI uri = URI.create("jar:file:"+ valid_path_to_copy+"/"+ Paths.get(list_of_data.get(i)).getFileName()+".zip");
							
							if( list_of_data.get(i).toString().endsWith(".jpeg") || 
								list_of_data.get(i).toString().endsWith(".jpg")  || 
								list_of_data.get(i).toString().endsWith(".gif")  || 
								list_of_data.get(i).toString().endsWith(".png")){
								
								Ziper.toZip(valid_path_to_copy, "images.zip", i);

								System.out.println(""+list_of_data.get(i)+"->"+valid_path_to_copy+"/"+ Paths.get(list_of_data.get(i)).getFileName()+".zip");
								
							}else if(list_of_data.get(i).toString().endsWith(".mp3") || 
									list_of_data.get(i).toString().endsWith(".wav")  || 
									list_of_data.get(i).toString().endsWith(".wma")){
								
								Ziper.toZip(valid_path_to_copy, "audios.zip", i);
								
								System.out.println(""+list_of_data.get(i)+"->"+valid_path_to_copy+"/"+ Paths.get(list_of_data.get(i)).getFileName()+".zip");
								
							}else if(list_of_data.get(i).toString().endsWith(".avi") || 
									list_of_data.get(i).toString().endsWith(".mp4")  || 
									list_of_data.get(i).toString().endsWith(".flw")){
								
								Ziper.toZip(valid_path_to_copy, "videos.zip", i);
								
								System.out.println(""+list_of_data.get(i)+"->"+valid_path_to_copy+"/"+ Paths.get(list_of_data.get(i)).getFileName()+".zip");
							}
						}
						
						System.out.println("Done");

					}else{
						System.out.println("This path is not exist");
					}
				}else{
					System.out.println("Directory is empty");
				}
			}else{
				System.out.println("This path is not exist");
			};
		}
	}
}

//			 		/home/minorius/for_GH/from/

//					/home/minorius/for_GH/to