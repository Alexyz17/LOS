import java.util.Random;
import java.util.Scanner;

public class Penjat {
    public static void main(String[] args) {
        final char[][] estatPenjatInicial =
        {
          {' ',' ',' ',' ','_','_','_','_',' ',' ',' ',' '},                                      
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ','_','_','|','_',' ',' ',' ',' ',' ',' ',' '},                                      
          {'|',' ',' ',' ',' ','|','_','_','_','_','_',' '},
          {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
          {'|','_','_','_','_','_','_','_','_','_','_','|'}
        };
        
        String[] paraules = {"hola", "adeu", "feliç", "trist", "amor", "odio"};
        Random rand = new Random();
        String paraula = paraules[rand.nextInt(paraules.length)];
        
        char[] paraulaOculta = new char[paraula.length()];
        for(int i=0; i<paraula.length(); i++) {
            paraulaOculta[i] = '*';
        }
        boolean[] encertades = new boolean[paraula.length()];
        
        String lletresIntroduides = "";
        int errors = 0;
        
        do {
            netejaPantalla();
            mostrarEstatPenjat(estatPenjatInicial, errors);
            mostrarParaula(paraulaOculta, encertades);
            mostrarLletresIntroduides(lletresIntroduides);
            
            String lletra = demanarLletra(lletresIntroduides);
            
            if(existeixLletra(lletresIntroduides, lletra.charAt(0))) {
                System.out.println("La lletra " + lletra + " ja ha estat introduida!");
            } else if(paraula.contains(lletra)) {
                for(int i=0; i<paraula.length(); i++) {
                    if(paraula.charAt(i) == lletra.charAt(0)) {
                        encertades[i] = true;
                        paraulaOculta[i] = lletra.charAt(0);
                    }
                }
            } else {
                errors++;
            }
            
            lletresIntroduides += lletra;
        } while(errors < 6 && !paraula.equals(new String(paraulaOculta)));
        
        netejaPantalla();
        mostrarEstatPenjat(estatPenjatInicial, errors);
        mostrarParaula(paraulaOculta, encertades);
        mostrarLletresIntroduides(lletresIntroduides);
        
        if(errors == 6) {
                System.out.println("Has perdut! La paraula era: " + paraula);
            } else {
                System.out.println("Felicitats! Has encertat la paraula: " + paraula);
            }
        }
    
        static void mostrarEstatPenjat(char[][]estat, int errors) {
        for (char[] estat1 : estat) {
            for (int j = 0; j < estat1.length; j++) {
                System.out.print(estat1[j]);
            }
            System.out.println();
        }
        }

        static void inicialitzarEstatPenjat(char[][] estatPenjatIni, char[][] estat) {
            for (int i = 0; i < estatPenjatIni.length; i++) {
                for (int j = 0; j < estatPenjatIni[i].length; j++) {
                    estat[i][j] = estatPenjatIni[i][j];
                }
            }
        }

        static void mostrarParaula(String paraula, boolean[] encertades) {
            for (int i = 0; i < paraula.length(); i++) {
                if (encertades[i]) {
                    System.out.print(paraula.charAt(i));
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        static void mostrarLletresIntroduides(String lletres) {
            System.out.println("Lletres: " + lletres);
        }

        static String demanarLletra(String lletres) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introdueix lletra: ");
            String lletra = sc.nextLine().toLowerCase();
            while (lletra.isEmpty() || !Character.isLetter(lletra.charAt(0)) || lletres.contains(lletra)) {
                System.out.print("Introdueix una lletra vàlida que no hagis introduït abans: ");
                lletra = sc.nextLine().toLowerCase();
            }
            return lletra;
        }

        static boolean existeixLletra(String lletres, char lletra) {
            return lletres.indexOf(lletra) != -1;
        }

        static void actualitzarEstatPenjat(char[][] penjat,int errors) {
            switch(errors) {
                case 1:
                    penjat[1][5] = 'O';
                    break;
                case 2:
                    penjat[2][5] = '|';
                    break;
                case 3:
                    penjat[2][4] = '/';
                    break;
                case 4:
                    penjat[2][6] = '\\';
                    break;
                case 5:
                    penjat[3][4] = '/';
                    break;
                case 6:
                    penjat[3][6] = '\\';
                    break;
            }
            mostrarEstatPenjat(penjat);
        }

        static void netejaPantalla() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

    private static void mostrarEstatPenjat(char[][] penjat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
