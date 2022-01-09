package dirandfile;

import java.io.*;
import java.net.URL;

public class DirUtils {
    public static void createDirectory(String path, String name) throws DirUtilException {
        File file = new File(path, name);
        boolean wasCreated = file.mkdir();
        if (!wasCreated) {
            throw new DirUtilException("directory alredy wasCreated");
        }
    }

    public static boolean exists(String name) throws DirUtilException {
        var file = new File(name);
        return file.exists();
    }

    public static void createFile(String path, String name) throws IOException, DirUtilException {
        File file = new File(path, name);
        file.createNewFile();

    }

    public static void delete(String name) throws DirUtilException {
        if (!exists(name)) {
            throw new DirUtilException(("directory is not exists"));
        } else {
            File file = new File(name);
            file.delete();
        }
    }

    public static void downloadImage(String strImageURL,String path) {

        //get file name from image path
        String strImageName =
                strImageURL.substring(strImageURL.lastIndexOf("/") + 1);

        System.out.println("Saving: " + strImageName + ", from: " + strImageURL);

        try {
            //open the stream from URL
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os =
                    new FileOutputStream(path+ "/" + strImageName);

            //write bytes to the output stream
            while ((n = in.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }

            //close the stream
            os.close();

            System.out.println("Image saved");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
