package lordofsteel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alex
 */
public class Personaje {
    private String nombre;
    private String categoria;
    private String arma;
    private int experiencia;
    private int nivel;
    private int FOR;
    private int CON;
    private int VEL;
    private int INT;
    private int SOR;
    private int WPOW;
    private int WVEL;
    private int PS;
    private int PD;
    private int PA;
    private int PE;

    // Constructor
    public Personaje(String nombre, String categoria, String arma, int experiencia, int nivel, int FOR, int CON, int VEL, int INT, int SOR) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.arma = arma;
        this.experiencia = experiencia;
        this.nivel = nivel;
        this.FOR = FOR;
        this.CON = CON;
        this.VEL = VEL;
        this.INT = INT;
        this.SOR = SOR;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getFOR() {
        return FOR;
    }

    public void setFOR(int FOR) {
        this.FOR = FOR;
    }

    public int getCON() {
        return CON;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public int getVEL() {
        return VEL;
    }

    public void setVEL(int VEL) {
        this.VEL = VEL;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public int getSOR() {
        return SOR;
    }

    public void setSOR(int SOR) {
        this.SOR = SOR;
    }

    // Calcula la estadística secundaria PS (puntos de salud) a partir de CON y FOR
    public int calcularPS() {
        return CON + FOR;
    }

    // Calcula la estadística secundaria PD (puntos de daño) a partir de FOR, WPOW y arma
    public int calcularPD(int WPOW) {
        return (FOR + WPOW) / 4;
    }

    // Calcula la estadística secundaria PA (probabilidad de ataque) a partir de INT, SOR, WVEL y arma
    public int calcularPA(int WVEL) {
        return INT + SOR + WVEL;
    }

    // Calcula la estadística secundaria PE (probabilidad de esquivar) a partir de VEL, SOR, INT y FOR
    public int calcularPE() {
        return VEL + SOR + INT;
    }
    
    // Actualiza el personaje al subir de nivel
    public void subirNivel() {
    // Incrementar el nivel del personaje
        this.nivel++;
    // Actualizar estadisticas primarias y secundarias
        this.FOR++;
        this.CON++;
        this.VEL++;
        this.INT++;
        this.SOR++;
        this.experiencia = 0;
            actualizarEstadisticasSecundarias();
    }

    public int getPexSiguienteNivel(){
        switch(this.nivel){
            case 1:
                return 100;
            case 2:
                return 200;
            case 3:
                return 500;
            case 4:
                return 1000;
            case 5:
                return 2000;
            default:
                return Integer.MAX_VALUE;
        }
    }
    public void actualizarEstadisticasSecundarias() {
        // Actualizar estadisticas secundarias
            this.PS = this.CON + this.FOR;
            this.PD = (this.FOR + this.WPOW) / 4;
            this.PA = this.INT + this.SOR + this.WVEL;
            this.PE = this.VEL + this.SOR + this.INT;

        // Aplicar la bonificacion de la categoria del personaje
            switch(this.categoria) {
                case "Nan":
                    this.PD = (this.FOR + this.WPOW + this.CON) / 4;
                break;
                case "Humà":
                    this.PS = this.CON + this.FOR + this.INT;
                break;
                case "Mitjà":
                     this.PE = this.VEL + this.SOR + this.INT + this.FOR + 2;
                  break;
                case "Maia":
                  this.PA = this.INT + this.SOR + this.WVEL + this.VEL + 2;
                  break;
                default:
                  break;
            }
    }
}