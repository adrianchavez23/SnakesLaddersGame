package snakesladders;

public class Casilla{

  private boolean isVacia = true;
  private int casillas;
  private String tipo;

  public Casilla(int casillasP, String tipoP){
    this.casillas = casillasP;
    this.tipo = tipoP;
  }

  public void llenar(){
    this.isVacia = false;
  }

  public void vaciar(){
    this.isVacia = true;
  }

  public boolean isVacia(){
    return isVacia;
  }

  public String getTipo(){
    return tipo;
  }

  public int getCasillasMov(){
    return casillas;
  }

  
}
