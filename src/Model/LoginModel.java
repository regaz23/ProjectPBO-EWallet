package Model;

import Entity.Login;

import java.util.ArrayList;

public class LoginModel implements ModelInterfaces{
    public ArrayList <Login> logins;

    public LoginModel(){
        logins = new ArrayList<>();
    }
    public ArrayList<Login>getLogins(){
        return logins;
    }
    public void  view(){

    }
    public void insert(Object x){
        logins.add((Login) x);
    }

    @Override
    public void update(int index, Object x) {

    }

    @Override
    public void delete(int index) {

    }

    public Login showLogins(int index){
        return logins.get(index);
    }
    public int cekLogins(String nama, String password){
        int loop = 0;
        for(Login loginEntity : getLogins()){
            if(loginEntity.getNama().equals(nama) && loginEntity.getPassword().equals(password)){
                break;
            }else{
                loop++;
            }
        }
        return loop;
    };
}