public class Docenti extends Persona {
    private String materia;

    //costruttore
    public Docenti(String nome, String cognome, int anno_di_nascita, String materia) {
        super(nome, cognome);
        setAnno_di_nascita(anno_di_nascita);
        setMateria(materia);
    }

    //getters
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
}