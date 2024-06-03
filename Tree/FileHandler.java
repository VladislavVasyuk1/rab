import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writeble {
    @Override
    public boolean save(Serializable serializable, String filePyt) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePyt))){
        objectOutputStream.writeObject(serializable);
        return true;
    } catch (Exception e) {
        e.printStackTrace();
            return false ;   }
}

    @Override
    public Object read(String filePyt) {
            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePyt))){
                return objectInputStream.readObject();}
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }     
    }
}
