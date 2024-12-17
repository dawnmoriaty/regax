package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static <T> List<T> readFromFile(String file){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            return (List<T>) ois.readObject();
        }catch (FileNotFoundException e){
            System.err.println("ko ton tai file");
        }catch (EOFException e){
            // ko cos du lieu
            System.err.println("ko co du lieu");
        }catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }finally {
            try {
                if (ois!=null) {
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return new ArrayList<>();
    }
    public static <T> void writeToFile(String path,List<T> list){
        File file = new File(path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(list);
//            oos.flush();
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            try {
                if (oos!=null) {
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}