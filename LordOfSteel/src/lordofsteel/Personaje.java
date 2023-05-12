package lordofsteel;
/**
 *
 * @author alex
 */
public class Personatge {
    
    protected int FOR; 
    protected int CON;
    protected int VEL; 
    protected int INT; 
    protected int SOR;

    protected Armes arma;
    
    protected int PS;
    protected int PD; 
    protected int PA; 
    protected int PE;
    
    protected int WPOW;
    protected int WVEL;
    
    protected String NOM;

    
    public Personatge (String NOM, int FOR, int CON, int VEL, int INT, int SOR, Armes arma){
        this.NOM = NOM;
        this.FOR = FOR;
        this.CON = CON;
        this.VEL = VEL;
        this.INT = INT;
        this.SOR = SOR;
        this.arma = arma;
        
        calculaEstadistiquesSecundaries();
    }
    
    protected void calculaEstadistiquesSecundaries(){
        WPOW = arma.getWPOW();
        WVEL = arma.getWVEL();
        PS = CON + FOR;
        PD = (FOR + WPOW) / 4;
        PA = INT + SOR + WVEL;
        PE = VEL + SOR + INT;   
    }
    
        public void restaurarPS(){
            this.PS = (int)(this.PS*1.10);
    }
    
    public void metodo(Dau... d){
        d[0].llencar();
        d[1].llencar();
        d[2].llencar();
    }    
        
    public void setFOR(int FOR) {
        this.FOR = FOR;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public void setVEL(int VEL) {
        this.VEL = VEL;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public void setSOR(int SOR) {
        this.SOR = SOR;
    }

    public void setArma(Armes arma) {
        this.arma = arma;
    }

    public void setPS(int PS) {
        this.PS = PS;
    }

    public void setPD(int PD) {
        this.PD = PD;
    }

    public void setPA(int PA) {
        this.PA = PA;
    }

    public void setPE(int PE) {
        this.PE = PE;
    }

    public int getFOR() {
        return FOR;
    }

    public int getCON() {
        return CON;
    }

    public int getVEL() {
        return VEL;
    }

    public int getINT() {
        return INT;
    }

    public int getSOR() {
        return SOR;
    }

    public Armes getArma() {
        return arma;
    }

    public int getPS() {
        return PS;
    }

    public int getPD() {
        return PD;
    }

    public int getPA() {
        return PA;
    }

    public int getPE() {
        return PE;
    }
        public void setWPOW(int WPOW) {
        this.WPOW = WPOW;
    }

    public void setWVEL(int WVEL) {
        this.WVEL = WVEL;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public int getWPOW() {
        return WPOW;
    }

    public int getWVEL() {
        return WVEL;
    }

    public String getNOM() {
        return NOM;
    }
}