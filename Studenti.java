public class Studenti extends Persona {
    private char sezione;
    private String classe;
    private String matricola;
    private int numero_studenti;

    public Studenti(String nome, String cognome, int anno_di_nascita, char sezione, String classe, int numero_studenti) {
        super(nome, cognome);
        setAnno_di_nascita(anno_di_nascita);
        setSezione(sezione);
        setClasse(classe);
        setNumero_studenti(numero_studenti);
        crea_matricola();
    }

    //getters
    public char getSezione() {
        return sezione;
    }
    public String getClasse() {
        return classe;
    }
    public String getMatricola() {
        return matricola;
    }
    public int getAnno_di_nascita() {
        return anno_di_nascita;
    }
    public int getNumero_studenti() {
        return numero_studenti;
    }

    //setters
    public void setSezione(char sezione) {
        ciclo: while(true) {
            switch(sezione) {
                case 'A', 'B', 'C', 'D':
                    this.sezione = sezione;
                    break ciclo;
                default:
                    System.out.print("Le possibili sezioni sono A/B/C/D riprova: ");
                    sezione = input_testo.nextLine().toUpperCase().charAt(0);
                    break;
            }
        }
    }
    public void setClasse(String classe) {
        classe = classe.toUpperCase();
        ciclo: while(true) {
            switch(classe) {
                case "I", "II", "III", "IV", "V":
                    this.classe = classe;
                    break ciclo;
                default:
                    System.out.print("Le possibili classi sono I/II/III/IV/V riprova: ");
                    classe = input_testo.nextLine().toUpperCase();
                    break;
            }
        }
        
    }
    public void setMatricola(String matricola) {
        if(matricola.length() == 6) {
            this.matricola = matricola; 
        }
    }
    public void setNumero_studenti(int numero_studenti) {
        if(numero_studenti > 0) {
            this.numero_studenti = numero_studenti;  
        }
    }

    @Override
    public void setAnno_di_nascita(int anno_di_nascita) {
        if(anno_di_nascita < 1994 || anno_di_nascita > 2016) {
            System.out.println("L'anno di nascita deve essere inferiore al 2017 o maggiore del 1994, ci dispiace lo studente non puo' essere ammesso.");
        }
        else {
            this.anno_di_nascita = anno_di_nascita;
        }
    }

    //metodi

    public void crea_matricola() {
        String stringa_anno_di_nascita = String.valueOf(getAnno_di_nascita());
        String ultime_cifre = stringa_anno_di_nascita.substring(stringa_anno_di_nascita.length()-2, stringa_anno_di_nascita.length());

        String centro = ""; //creo la stringa della parte centrale
        if(getNumero_studenti() < 10) {
            centro = "00" + getNumero_studenti();
        }
        else if(numero_studenti < 100) {
            centro = "0" + getNumero_studenti();
        }
        else if(numero_studenti >= 1000) {

        }
        else {
            centro = "" + getNumero_studenti();
        }
        String n_matricola = ultime_cifre + centro + getSezione();
        setMatricola(n_matricola);
    }
}
