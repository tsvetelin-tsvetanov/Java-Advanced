import java.io.File;
import java.util.LinkedList;

public class IOManager {
    public static void traverseDirectory(String path){
        LinkedList<File> subFolders = new LinkedList<File>();
        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0){
            File currentFolder = subFolders.removeFirst();

            try {
                if (currentFolder.listFiles() != null) {
                    for (File file : currentFolder.listFiles()) {
                        subFolders.add(file);
                    }
                }
            } catch (Exception exception){
                OutputWriter.writeMessageOnNewLine("Access denied");
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());
        }
    }

}
