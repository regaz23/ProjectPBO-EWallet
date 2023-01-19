package Controller;
import Entity.Akun;
import Model.AkunModel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import View.allobjcontroller;

public class AkunController {
    public AkunModel akunModel = new AkunModel();

    public AkunController() {

    }

    public ArrayList<Akun> view() {
        return akunModel.getDataAkun();
    }

    public void insert(String saldo) {
        Akun akun = new Akun();
        akun.setSaldo(saldo);
        akunModel.insert(akun);
    }

    public void update(int index, String saldo) {
        Akun akun = new Akun();
        akun.setSaldo(saldo);
        akunModel.update(index, akun);
    }

    public void delete(int index) {
        akunModel.delete(index);
    }

    public DefaultTableModel listakun() {
        DefaultTableModel dtmlistakun = new DefaultTableModel();
        Object[] kolom = {"saldo"};
        dtmlistakun.setColumnIdentifiers(kolom);
        int size = allobjcontroller.akunController.view().size();
        for (int i = 0; i < size; i++) {
            Object[] akunController = new Object[7];
            akunController[0] = allobjcontroller.akunController.view().get(i).getSaldo();
            dtmlistakun.addRow(akunController);
        }
        return dtmlistakun;
    }
}