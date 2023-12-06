import java.util.Scanner;

public abstract class Persona {
    private String nome;
    private String cognome;
    protected int anno_di_nascita;

    Scanner input_testo = new Scanner(System.in);
    Scanner input_numero = new Scanner(System.in);

    //costruttore
    public Persona(String nome, String cognome) {
        setNome(nome);
        setCognome(cognome);
    }

    //getters
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public int getAnno_di_nascita() {
        return anno_di_nascita;
    }

    //setters
    public void setNome(String nome) {
        while (true) {
            if(nome.length() < 3) {
                System.out.print("Il nome inserito non è corretto, riprova: ");
                nome = input_testo.nextLine();
            }

            else {
                this.nome = nome;
                break;
            }
        }
    }
    public void setCognome(String cognome) {
        while (true) {
            if(cognome.length() < 3) {
                System.out.print("Il cognome inserito non è corretto, riprova: ");
                cognome = input_testo.nextLine();
            }

            else {
                this.cognome = cognome;
                break;
            }
        }
    }
    public abstract void setAnno_di_nascita(int anno_di_nascita);
}