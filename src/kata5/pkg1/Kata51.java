package kata5.pkg1;

import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

import java.sql.*;
import java.util.List;

public class Kata51 {

    private String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histogramDisplay;
    
    public static void main(String[] args) {
        try {
           Class.forName ("org.sqlite.JDB");
           Connection c = DriverManager.getConnection ("jdbc:sqlite:KATA5.1.sqlite");
           Statement s = c.createStatement();
           ResultSet resultSet = s.executeQuery("SELECT * FROM PEOPLE");
           
           while (resultSet.next()){
               System.out.println("ID= "+ resultSet.getInt("id"));
               System.out.println("Nombre= "+ resultSet.getString ("name"));
           }
           
           List<Mail> mails = MailListReader.read("emails.txt");
           for (Mail m : mails) {
            s.execute("INSERT INTO mails(id,mail) VALUES(null,'"+m.getMail()+"')");
         }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    private void execute(){
        input();
        proccess();
        output();
    }
    
    private void input (){
        fileName = "emails.txt";
        mailList = MailListReader.read(fileName);
    }
    
    private void proccess(){
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output(){
        histogramDisplay = new HistogramDisplay (histogram);
        histogramDisplay.execute();
    }
}
