import java.util.ArrayList;
import java.util.Scanner;

public class Scuola {
    private ArrayList<Docenti> archivio_docenti = new ArrayList<Docenti>();
    private ArrayList<DocentiBES> archivio_docentiBES = new ArrayList<DocentiBES>();
    private ArrayList<Studenti> archivio_studenti = new ArrayList<Studenti>();
    private ArrayList<StudentiBES> archivio_studentiBES = new ArrayList<StudentiBES>();
    int numero_studenti = 1;
    Scanner input_testo = new Scanner(System.in);
    Scanner input_numero = new Scanner(System.in);

    //getter
    public int getNumero_studenti() {
        return this.numero_studenti;
    }

    //setter
    public void setNumero_studenti(int numero_studenti) {
        if(numero_studenti >= 0) {
            this.numero_studenti = numero_studenti;
        }
    }

    //metodi
    public void ammissione() {
        while(true) {
            System.out.println();
            System.out.println("SCRIVI");
            System.out.println("S per inserire uno studente");
            System.out.println("X per inserire uno studente BES");
            System.out.println("D per inserire un docente");
            System.out.println("C per inserire un docente BES");
            System.out.println("A per stampare la lista degli studenti");
            System.out.println("F per stampare la lista dei docenti");
            System.out.println("E per uscire");
            char scelta = input_testo.nextLine().toUpperCase().charAt(0);
            if(scelta == 'E') {
                break;
            }
            else if(scelta == 'S' || scelta == 'D' || scelta == 'X' || scelta == 'C') {
                System.out.print("Anno di nascita: ");
                int anno_di_nascita = input_numero.nextInt();
                switch(scelta) {
                    case 'S', 'X':
                        if(anno_di_nascita < 1994 || anno_di_nascita > 2016) {
                            System.out.println("L'anno di nascita deve essere inferiore al 2017 o maggiore del 1994, ci dispiace lo studente non puo' essere ammesso.");                        
                        }
                        else {
                            System.out.print("Nome: ");
                            String nome = input_testo.nextLine();
                            System.out.print("Cognome: ");
                            String cognome = input_testo.nextLine();           
                            System.out.print("Sezione A/B/C/D: ");
                            char sezione = input_testo.nextLine().toUpperCase().charAt(0);
                            System.out.print("Classe I/II/III/IV/V: ");
                            String classe = input_testo.nextLine();
                            if(scelta == 'X') {
                                StudentiBES istanza = new StudentiBES(nome, cognome, anno_di_nascita, sezione, classe, getNumero_studenti());
                                archivio_studentiBES.add(istanza);
                                setNumero_studenti(getNumero_studenti()+1);
                            }
                            else{
                                Studenti istanza = new Studenti(nome, cognome, anno_di_nascita, sezione, classe, getNumero_studenti());
                                archivio_studenti.add(istanza);
                                setNumero_studenti(getNumero_studenti()+1);
                            }
                        }
                        break;
                    case 'D', 'C':
                        if(anno_di_nascita < 1963 || anno_di_nascita > 1993) {
                            System.out.println("L'anno di nascita deve risultare tra il 1963 e il 1993, ci dispiace il docente e' troppo " + (anno_di_nascita < 1963 ? "anziano" : "giovane"));
                        }
                        else {
                            System.out.print("Nome: ");
                            String nome = input_testo.nextLine();
                            System.out.print("Cognome: ");
                            String cognome = input_testo.nextLine();
                            System.out.print("Materia: ");
                            String materia = input_testo.nextLine();
                            if(scelta == 'C') {
                                DocentiBES istanzaD_B = new DocentiBES(nome, cognome, anno_di_nascita, materia);
                                archivio_docentiBES.add(istanzaD_B);
                            }
                            else {
                                Docenti istanzaD = new Docenti(nome, cognome, anno_di_nascita, materia);
                                archivio_docenti.add(istanzaD);
                            }
                        }
                        break;
                }
            }
            else if(scelta == 'A' || scelta == 'F') {
                switch(scelta) {
                    case 'A':
                        int contatore = 1;
                        for(Studenti istanza : archivio_studenti) {
                            System.out.println();
                            System.out.println("--- " + "Studente " + contatore + " ---");
                            System.out.println("Nome: " + istanza.getNome());
                            System.out.println("Cognome: " + istanza.getCognome());
                            System.out.println("Anno di nascita: " + istanza.getAnno_di_nascita());
                            System.out.println("Sezione: " + istanza.getSezione());
                            System.out.println("Classe: " + istanza.getClasse());
                            System.out.println("Matricola: " + istanza.getMatricola());
                            contatore++;
                        }
                        for(StudentiBES istanza : archivio_studentiBES) {
                            System.out.println();
                            System.out.println("--- " + "Studente BES " + contatore + " ---");
                            System.out.println("Nome: " + istanza.getNome());
                            System.out.println("Cognome: " + istanza.getCognome());
                            System.out.println("Anno di nascita: " + istanza.getAnno_di_nascita());
                            System.out.println("Sezione: " + istanza.getSezione());
                            System.out.println("Classe: " + istanza.getClasse());
                            System.out.println("Matricola: " + istanza.getMatricola());
                            System.out.println("Docente assegnato: " + istanza.getDocente_assegnato());
                            contatore++;
                        }
                        break;
                    case 'F':
                        int contatore2 = 1;
                        for(Docenti istanza : archivio_docenti) {
                            System.out.println();
                            System.out.println("--- " + "Docente " + contatore2 + " ---");
                            System.out.println("Nome: " + istanza.getNome());
                            System.out.println("Cognome: " + istanza.getCognome());
                            System.out.println("Anno di nascita: " + istanza.getAnno_di_nascita());
                            System.out.println("Materia: " + istanza.getMateria());
                            contatore2++;
                        }
                        for(DocentiBES istanza : archivio_docentiBES) {
                            System.out.println();
                            System.out.println("--- " + "Docente BES " + contatore2 + " ---");
                            System.out.println("Nome: " + istanza.getNome());
                            System.out.println("Cognome: " + istanza.getCognome());
                            System.out.println("Anno di nascita: " + istanza.getAnno_di_nascita());
                            System.out.println("Materia: " + istanza.getMateria());
                            System.out.print("Studenti assegnati: ");
                            for(String s : istanza.getStudenti_assegnati()) {
                                System.out.print(s + " | ");
                            }
                            System.out.println();
                            contatore2++;
                        }
                        break;                    
                }
            }

            else {
                System.out.print("Riprova, scrivi S per inserire uno studente, D per inserire un docente, A per stampare la lista degli studenti, F per stampare la lista dei docenti o E per uscire: ");
                scelta = input_testo.nextLine().toUpperCase().charAt(0);
            }
        }
    }
}
