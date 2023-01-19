package Controller;

import Entity.Login;
import Model.LoginModel;
import java.util.ArrayList;

public class LoginController {
    public LoginModel loginModel = new LoginModel();
    int loginlogin = 0;

    public LoginController(){

    }
    public ArrayList<Login> view(){
        return loginModel.getLogins();
    }

    public void insert(Login login){
        loginModel.insert(login);
    }

    public void update(int index, Login login){
        loginModel.update(index, login);
    }

    public void delete(int index){
        loginModel.delete(index);
    }

    public void datalogin(){
        String[] nama = {"rega"};
        String[] password = {"123"};

        for(int i = 0; i < nama.length; i++){
            loginModel.insert(new Login(nama[i],password[i]));
        }
    }

    public void ceklogin(String nama, String password) {
        loginlogin = loginModel.cekLogins(nama,password);
    }

    public Login loginEntity(){
        return loginModel.showLogins(loginlogin);
    }
}
