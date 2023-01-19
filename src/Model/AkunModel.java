package Model;

import Entity.Akun;
import java.util.ArrayList;

public class AkunModel implements ModelInterfaces{
    private ArrayList<Akun> dataAkun;
    public ArrayList<Akun> getDataAkun;

    public AkunModel(){
        dataAkun = new ArrayList<>();
    }
    public ArrayList<Akun>getDataAkun(){
        return dataAkun;
    }
    @Override
    public void view(){

    }
    @Override
    public void insert(Object x){
        dataAkun.add((Akun) x);
    }
    @Override
    public void update(int index, Object x){
        dataAkun.set(index ,(Akun) x);
    }
    @Override
    public void delete(int index){
        dataAkun.remove(index);
    }

    public void get_where(int index){
        dataAkun.get(index);
    }
}