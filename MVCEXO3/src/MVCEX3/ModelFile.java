package MVCEX3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ModelFile {

	
	public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    public boolean moveFile(String sourcePath, String destinationPath) {
        try {
            Files.move(Path.of(sourcePath), Path.of(destinationPath), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
