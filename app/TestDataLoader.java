package app;
import model.Asset;
import model.LogEntry;
import structures.list.LinkedList;
import structures.list.ListNode;
import structures.log.LogList;
import structures.log.LogNode;
import structures.stack.Stack;
import structures.stack.StackNode;

public class TestDataLoader {
    public static void agregarDatos(LinkedList lista, LogList listaLog, Stack undoPila) {
        CRUDService opcion = new CRUDService();
        
        Asset a1 = new Asset(101, "Dell Latitude 5420", 18500, "Laptops");
        Asset a2 = new Asset(102, "Cisco Catalyst 2960 Switch", 32000, "Networking");
        Asset a3 = new Asset(103, "HP LaserJet Pro M404", 7200, "Printers");
        ListNode n1 = new ListNode(a1);
        ListNode n2 = new ListNode(a2);
        ListNode n3 = new ListNode(a3);
        LogEntry l1 = new LogEntry("Agregar", 101);
        LogEntry l2 = new LogEntry("Agregar", 102);
        LogEntry l3 = new LogEntry("Agregar", 103);
        LogNode nn1 = new LogNode(l1);
        LogNode nn2 = new LogNode(l2);
        LogNode nn3 = new LogNode(l3);

        lista.addULT(n1);
        StackNode ll1 = new StackNode(lista);
        undoPila.push(ll1);
        listaLog.addULT(nn1);

        LinkedList nueva1 = opcion.duplicar(lista);
        nueva1.addULT(n2);
        StackNode ll2 = new StackNode(nueva1);
        undoPila.push(ll2);
        listaLog.addULT(nn2);

        LinkedList nueva2 = opcion.duplicar(nueva1);
        nueva2.addULT(n3);
        StackNode ll3 = new StackNode(nueva2);
        undoPila.push(ll3);
        listaLog.addULT(nn3);
        
    }
}
