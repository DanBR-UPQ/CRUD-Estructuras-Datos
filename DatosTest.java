public class DatosTest {
    public static void agregarDatos(CLista lista, CListaLog listaLog, CPila undoPila) {
        CRUDopciones opcion = new CRUDopciones();
        
        CJugador j1 = new CJugador(101, "Dani", 45, "Billar");
        CJugador j2 = new CJugador(102, "Perlita", 120, "Ruleta");
        CJugador j3 = new CJugador(103, "Richy", 90, "Blackjack");
        CNodo n1 = new CNodo(j1);
        CNodo n2 = new CNodo(j2);
        CNodo n3 = new CNodo(j3);
        CLog l1 = new CLog("Agregar", 101);
        CLog l2 = new CLog("Agregar", 102);
        CLog l3 = new CLog("Agregar", 103);
        CNodo3 nn1 = new CNodo3(l1);
        CNodo3 nn2 = new CNodo3(l2);
        CNodo3 nn3 = new CNodo3(l3);

        lista.addULT(n1);
        CNodo2 ll1 = new CNodo2(lista);
        undoPila.push(ll1);
        listaLog.addULT(nn1);

        CLista nueva1 = opcion.duplicar(lista);
        nueva1.addULT(n2);
        CNodo2 ll2 = new CNodo2(nueva1);
        undoPila.push(ll2);
        listaLog.addULT(nn2);

        CLista nueva2 = opcion.duplicar(nueva1);
        nueva2.addULT(n3);
        CNodo2 ll3 = new CNodo2(nueva2);
        undoPila.push(ll3);
        listaLog.addULT(nn3);
        
    }
}
