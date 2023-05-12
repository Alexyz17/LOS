/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lordofsteel;

/**
 *
 * @author alex
 */
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
        
        String entrada = sc.nextLine();
        
        // Només hem d'arribar aquí si estem segurs
        // que l'opció triada és un enter entre 1-5
        opcio = Integer.parseInt(entrada);
              
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
    
    private static void agregaPersonatge(ArrayList<Personatge> personatges){
        int categoria;
        System.out.println("Introdueix la categoria del personatge: ");
        System.out.println("1: Nan /n"
                + "2: Humá /n"
                + "3: Mitjà/n"
                + "4: Maia");
        categoria = sc.nextInt();
        
        int devocion;
        System.out.println("Introdueix la devoció del personatge: ");
        System.out.println("1: Ordre o 2: Caos");
        devocion = sc.nextInt();
        
        
        System.out.println("Introdueix el nom del personatge: ");
        String nom=sc.nextLine();
        sc.nextLine();
        int fuerza, constitucion, velocidad, inteligencia, suerte, totalPunts;
        do{
            System.out.println("Reparteix 60 punts entre les estadístiques primàries:");
            System.out.println("Força: ");
            fuerza = sc.nextInt();
            System.out.println("Constitució: ");
            constitucion = sc.nextInt();
            System.out.println("Velocitat: ");
            velocidad = sc.nextInt();
            System.out.println("Intel·ligència: ");
            inteligencia = sc.nextInt();
            System.out.println("Sort: ");
            suerte = sc.nextInt();
            
            totalPunts = fuerza+constitucion+velocidad+inteligencia+suerte;
            if (totalPunts!=60){
                System.out.println("Assegura't de repartir un total de 60 punts entre les estadístiques primàries: força, destresa, constitució i agilitat.");                
            }
        }while(totalPunts!=60);
            System.out.println("Introdueix el nom de l'arma: ");
            String nomArma = sc.nextLine();
        
        switch (categoria) {
            case 1:
                {
                    if(devocion==1){
                        NanOrdre personatge = new NanOrdre(nom,fuerza,constitucion, velocidad,inteligencia ,suerte,new Armes(nomArma));
                        personatges.add(personatge);
                    }else{
                        NanCaos personatge = new NanCaos(nom,fuerza,constitucion, velocidad,inteligencia ,suerte,new Armes(nomArma));
                        personatges.add(personatge);
                    }
                    break;
                }
            case 2:
                {
                    Huma personatge = new Huma(nom,fuerza,constitucion, velocidad,inteligencia ,suerte,new Armes(nomArma));
                    personatges.add(personatge);
                    break;
                }
            case 3:
                {
                    Mitja personatge = new Mitja(nom,fuerza,constitucion, velocidad,inteligencia ,suerte,new Armes(nomArma));
                    personatges.add(personatge);
                    break;
                }
            case 4:
                {
                    Maia personatge = new Maia(nom,fuerza,constitucion, velocidad,inteligencia ,suerte,new Armes(nomArma));
                    personatges.add(personatge);
                    break;
                }
            default:
                break;
        }
            System.out.println("S'ha afegit el personatge amb èxit.");
        /*mirar de guaradr el personaje, caos o orden*/
    }
    
    private static void borrarPersonatge(ArrayList<Personatge> personatges){
        System.out.println("----- LLISTA DE PERSONATGES DISPONIBLES -----");
        for (int i = 0; i < personatges.size(); ++i) {
            System.out.println((i+1)+ ". "+ personatges.get(i).getNOM());            
        }
        System.out.println("-----------------------------------");
        boolean valido = false;
        do{
            System.out.println("Si us plau, seleccioneu el número del personatge que voleu eliminar: ");
            int seleccio = sc.nextInt() -1;

            if(seleccio>=0 && seleccio<personatges.size()){
                personatges.remove(seleccio);
                System.out.println("S'ha eliminat el personatge amb èxit.");
                valido=true;
            } else {
                System.out.println("Ho sento, el número de personatge no és vàlid. Si us plau, seleccioneu un número de personatge vàlid per continuar.");
            }
        } while(valido);
        System.out.println("");
    }
    
    private static void editaPersonatge(ArrayList<Personatge> personatges){
        System.out.println("----- LLISTA DE PERSONATGES DISPONIBLES -----");
        for (int i = 0; i < personatges.size(); ++i) {
            System.out.println((i+1)+ ". "+ personatges.get(i).getNOM());            
        }
        System.out.println("-----------------------------------");
        boolean valido = false;
        System.out.println("Si us plau, seleccioneu el número del personatge que voleu eliminar: ");
        int seleccio = sc.nextInt() -1;
        if(seleccio>=0 && seleccio<personatges.size()){
            Personatge personatge = personatges.get(seleccio);
            System.out.println("Estadístiques actuals del personatge:");
            System.out.println(personatge);
            int newFuerza, newConstitucion, newVelocidad, newInteligencia, newSuerte;
            do{
                System.out.println("Introdueix el nou valor de Força:");
                newFuerza=sc.nextInt();
                System.out.println("Introdueix el nou valor de Constitució:");
                newConstitucion=sc.nextInt();
                System.out.println("Introdueix el nou valor de Velocitat:");
                newVelocidad=sc.nextInt();
                System.out.println("Introdueix el nou valor de Intel·ligència:");
                newInteligencia=sc.nextInt();
                System.out.println("Introdueix el nou valor de Sort:");
                newSuerte=sc.nextInt();
            int totalPunts = newFuerza+newConstitucion+newVelocidad+newInteligencia+newSuerte;
            if(totalPunts <=60){    
                valido = true;
            }else{
                System.out.println("Ho sento, però el total de punts excedeix els punts disponibles. Si us plau, torna-ho a intentar distribuint els punts de manera que la suma total no superi el límit disponible.");
            }
            }while(valido);
            
            personatge.setFOR(newFuerza);
            personatge.setCON(newConstitucion);
            personatge.setVEL(newVelocidad);
            personatge.setINT(newInteligencia);
            personatge.setSOR(newSuerte);
            
            System.out.println("Les estadístiques del personatge s'han actualitzat amb èxit.");
            System.out.println("");
        }
    }
    
    private static void iniciarCombat(ArrayList<Personatge> personatges) {
        
        boolean[] seleccionats = new boolean[personatges.size()];
        Personatge[] lluitadors = new Personatge[2];
        for (int selec = 1; selec <= 2; selec++) {
            for (int i = 0; i < personatges.size(); ++i) {
                if (!seleccionats[i]) {
                    String tipus = "";
                    if (personatges.get(i) instanceof Nan)
                        tipus = "Nan";
                    else if (personatges.get(i) instanceof Huma)
                        tipus = "Huma";
                    else if (personatges.get(i) instanceof Mitja)
                        tipus = "Mitja";
                    else if (personatges.get(i) instanceof Maia)
                        tipus = "Maia";

                    System.out.printf("%d %s (%s)\n",(i+1),personatges.get(i).getNOM(),
                                                     tipus);
                }            
            }
            System.out.print("\nTria un personatge " + selec + ": ");
            int opcio = sc.nextInt();
            seleccionats[opcio-1] = true;
            lluitadors[selec-1] = personatges.get(opcio-1);
            System.out.println("Personatge triat: " + 
                              personatges.get(opcio-1).getNOM());        
        }
        
        
        // Inici combat
        Personatge atacant  = lluitadors[0];
        Personatge defensor = lluitadors[1];
        
        Dau dau1 = new Dau();
        Dau dau2 = new Dau();
        Dau dau3 = new Dau();
        
        int valor = dau1.llencar() + dau2.llencar() + dau3.llencar();
        //System.out.println("Valor daus: " + valor);
        
        if (valor <= atacant.getPA()) { // Atacant ataca
            valor = dau1.llencar() + dau2.llencar() + dau3.llencar();
            if (valor > defensor.getPE()) { // No aconsegueix esquivar
                defensor.setPS(defensor.getPS() - atacant.getPD());
            }
        }
        
        // Final ronda
        Personatge aux = atacant;
        atacant  = defensor;
        defensor = aux;
        if (valor <= atacant.getPA()) { // Atacant ataca
            valor = dau1.llencar() + dau2.llencar() + dau3.llencar();
            if (valor > defensor.getPE()) { // No aconsegueix esquivar
                defensor.setPS(defensor.getPS() - atacant.getPD());
            }
        }
        
        Personatge ganador, perdedor;
        if(defensor.getPS() <=0){
            ganador = atacant;
            perdedor = defensor;
        }else{
            ganador = defensor;
            perdedor = atacant;
        }
        System.out.println("¡La batalla ha acabat!");
        System.out.println("El guanyador es: "+ganador.getNOM());
        System.out.println("------------------------");
        
        ganador.restaurarPS();
        perdedor.restaurarPS();
        /*revisar*/
        /*mirar que los datos interoducidos sean correctos*/
        
        
    }

}
