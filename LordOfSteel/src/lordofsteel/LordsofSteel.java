package lordofsteel;
import java.util.ArrayList;
import java.util.Scanner;

public class LordsofSteel {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    Nan n1 = new Nan("Tirion",8,6, 13,16,16,new Armes("Daga"));        
        Huma h1 = new Huma("Luis",13,16,6,10,6,new Armes("Espasa"));
        Mitja mi1 = new Mitja("Frodo",9,7,7,15,16,new Armes("Martell"));
        Maia ma1 = new Maia("Nil",7,9, 12,15,17,new Armes("Daga"));

        ArrayList<Personatge> personatges = new ArrayList<Personatge>();
        personatges.add(n1);
        personatges.add(h1);
        personatges.add(mi1);
        personatges.add(ma1);
        int opcio;
        do{
        /* Menú principal */
        System.out.println("");
        System.out.println("** MENÚ PRINCIPAL **");
        System.out.println("1.- Afegir personatge");
        System.out.println("2.- Esborrar personatge");
        System.out.println("3.- Editar personatge");
        System.out.println("4.- Iniciar combat");
        System.out.println("5.- Sortir");
        System.out.println("**__________________**");
        System.out.print("Tria opció [1-5]: ");
        
         opcio = leerEnteroValido();
        
        // Només hem d'arribar aquí si estem segurs
        // que l'opció triada és un enter entre 1-5
        //opcio = Integer.parseInt(entrada);
              
        switch (opcio) {
            case 1:
                agregaPersonatge(personatges);
                break;
            case 2:
                borrarPersonatge(personatges);
                break;
            case 3:
                editaPersonatge(personatges);
                break;
            case 4:
                iniciarCombat(personatges);
                break;
            case 5:
                System.out.println("¡Ha triat sortit!");
                break;
            default:
                System.out.println("Opcio invalida.");
        }
        }while(opcio !=5);    
    }
    
    }
}
