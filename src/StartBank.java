import working.*;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import GUI.AdminChangePassword;
import GUI.CreateAdmin;
public class StartBank{
    public static void main(String v[]){
        try{
            UIManager.LookAndFeelInfo l1[]=UIManager.getInstalledLookAndFeels();
            UIManager.setLookAndFeel(l1[1].getClassName());
        }
        catch(Exception e){
        e.printStackTrace();}
        CreateAdmin ap=new CreateAdmin();
        ap.control();
        }
}
