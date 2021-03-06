package view;

import model.Mail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    public static List<Mail> read(String fileName){
        ArrayList<Mail> list = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader (new FileReader (fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (line.contains("@")){
                    list.add(new Mail(line));
                }
            }
            bufferedReader.close();
        }catch (FileNotFoundException e){
            System.out.println("El archivo no existe");
        }catch (IOException e){
            System.out.println("Error leyendo el archiivo");
        }
        return list;
    }
}
