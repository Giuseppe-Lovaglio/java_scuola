import java.util.ArrayList;

public class DocentiBES extends Persona implements Sostegno{
    private String materia;
    public DocentiBES(String nome, String cognome, int anno_di_nascita, String materia) {
        super(nome, cognome);
        setNome(nome);
        setCognome(cognome);
        setAnno_di_nascita(anno_di_nascita);
        setMateria(materia);
        assegnazioneBES();
    }

    private ArrayList<String> studenti_assegnati = new ArrayList<String>();

    //getters
    public ArrayList<String> getStudenti_assegnati() {
        return studenti_assegnati;
    }

    public String getMateria() {
        return materia;
    }

    public int getAnno_di_nascita() {
        return anno_di_nascita;
    }

    //setters
    public void setMateria(String materia) {
        while(true) {
            if(materia.length() < 4) {
                System.out.print("La materia inserita non e' corretta, riprova: ");
                materia = input_testo.nextLine();
            }
            else {
                this.materia = materia;
                break;
            }
        }
    }

    public void setStudenti_assegnati(ArrayList<String> array_studenti) {
        while(true) {
            if(studenti_assegnati.size() <= 3) {
            this.studenti_assegnati = array_studenti;
            break;
            }
            else {
                String comando = "";
                System.out.println("Non e' possibile assegnare piu' di 3 studenti a questo docente, riprova.");
                while(array_studenti.size() < 3) {
                    System.out.println();
                    System.out.print("Scrivi il nome dello studente o exit per terminare: ");
                    comando = input_testo.nextLine();
                    if(comando.equals("exit")) {
                        break;
                    }
                    else if(comando.length() < 3) {
                        System.out.print("Il nome dello studente e' troppo corto, riprova: ");
                        comando = input_testo.nextLine();
                    }
                    else {
                        array_studenti.add(comando);
                        System.out.println("* Lo studente e' stato aggiunto! *");
                    }
                    System.out.println();
                    System.out.println("La lista e' al completo!");
                }
            }
        }
    }

    @Override
    public void setAnno_di_nascita(int anno_di_nascita) {
        if(anno_di_nascita < 1963 || anno_di_nascita > 1993) {
            System.out.print("L'anno di nascita deve risultare tra il 1963 e il 1993 ci dispiace il docente e' troppo " + (anno_di_nascita < 1963 ? "anziano/a" : "giovane"));
        }
        else {
            System.out.println("Complimenti! Il docente e' stato/a accettato/a.");
            this.anno_di_nascita = anno_di_nascita;
        }
    }
    
    //metodi
    @Override
    public void assegnazioneBES() {
        ArrayList<String> studentiBES = new ArrayList<String>();
        while(studentiBES.size() < 3) {
            System.out.println();
            System.out.print("Scrivi il nome dello studente da assegnargli o exit per terminare: ");
            String comando = input_testo.nextLine();
            if(comando.equals("exit")) {
                break;
            }
            else if(comando.length() < 3) {
                System.out.print("Il nome dello studente e' troppo corto, riprova: ");
                comando = input_testo.nextLine();
            }
            else {
                studentiBES.add(comando);
                System.out.println("* Lo studente e' stato aggiunto! *");
            }
        }
        System.out.println();
        System.out.println("La lista e' al completo!"); 
        setStudenti_assegnati(studentiBES);
    }
}
