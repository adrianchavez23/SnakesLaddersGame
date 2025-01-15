

package snakesladders;

public class Jugador {

  private String name;
  private int posicion = 0;

  public Jugador(String nameP){
    this.name = nameP;
  }

  public String getName(){
    return name;
  }

  public int getPosicion(){
    if(posicion > 29){
      return 29;
    }
    return posicion;
  }

  public void setPosicion(int posicionP){
    this.posicion = posicionP;
  }

  public void setName(String nameP){
    this.name = nameP;
  }

  public int subirPosicion(int casillas){

    
    this.posicion += casillas;
    if(posicion > 29){
      return 29;
    }
    return posicion;
  }

  public int bajarPosicion(int casillas){
    this.posicion -= casillas;
    return posicion;
  }

}

