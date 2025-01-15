package snakesladders;

import java.util.Random;

public class Juego {

  private Jugador jugador1;
  private Jugador jugador2;
  private Casilla[] Tablero;
  private Dado miDado;
  private Jugador ganador;
  private int numeroTurnos = 1;

  public Juego(Jugador jugador1P, Jugador jugador2P, Casilla[] tableroP){
    this.jugador1 = jugador1P;
    this.jugador2 = jugador2P;
    this.Tablero = tableroP; 
    Random ran = new Random();
    this.miDado = new Dado(ran);
  } 

  public void jugar(){

        int numeroTurno = 1;
        while(Tablero[29].isVacia()){

            System.out.println("\nTURNO " + numeroTurno);
            System.out.println("MARCADOR: " + jugador1.getName() + ":" + (jugador1.getPosicion() + 1) + " || " + jugador2.getName() + ":" + (jugador2.getPosicion() + 1) );

            int tiroJugador1 = miDado.tirar();
            System.out.println(jugador1.getName() + " tira el dado y saca: " + tiroJugador1);
            Tablero[jugador1.getPosicion()].vaciar();
            jugador1.subirPosicion(tiroJugador1);
            System.out.println(jugador1.getName() + " avanza " + tiroJugador1 + " casillas y aterriza en la casilla " + aterrizaCasillaText(jugador1.getPosicion()));
            
            Tablero[jugador1.getPosicion()].llenar();

            if (!Tablero[29].isVacia()){
                ganador.setName(jugador1.getName());
                break;
            }
            int casillasMov1 = Tablero[jugador1.getPosicion()].getCasillasMov();

            if(Tablero[jugador1.getPosicion()].getTipo().equals("E")){
                jugador1.subirPosicion(casillasMov1);
                System.out.println("Esta casilla tiene una ESCALERA! Sube a la casilla " + aterrizaCasillaText(jugador1.getPosicion()));
            }
            
            if(Tablero[jugador1.getPosicion()].getTipo().equals("S")){
                jugador1.bajarPosicion(casillasMov1);
                System.out.println("Esta casilla tiene una SERPIENTE! Baja a la casilla " + aterrizaCasillaText(jugador1.getPosicion()));
            }
            else{
                System.out.println("Esta casilla es normal. Estate quieto.");
            }

            int tiroJugador2 = miDado.tirar();
            System.out.println("\n" + jugador2.getName() + " tira el dado y saca: " + tiroJugador2);
            Tablero[jugador2.getPosicion()].vaciar();
            jugador2.subirPosicion(tiroJugador2);
            System.out.println(jugador2.getName() + " avanza " + tiroJugador2 + " casillas y aterriza en la casilla " + aterrizaCasillaText(jugador2.getPosicion()));
            
            Tablero[jugador2.getPosicion()].llenar();

            if (!Tablero[29].isVacia()){
                ganador.setName(jugador2.getName());
                break;
            }
            int casillasMov2 = Tablero[jugador2.getPosicion()].getCasillasMov();

            if(Tablero[jugador2.getPosicion()].getTipo().equals("E")){
                jugador2.subirPosicion(casillasMov2);
                System.out.println("Esta casilla tiene una ESCALERA! Sube a la casilla " + aterrizaCasillaText(jugador2.getPosicion()));
            }
            
            if(Tablero[jugador2.getPosicion()].getTipo().equals("S")){
                jugador2.bajarPosicion(casillasMov2);
                System.out.println("Esta casilla tiene una SERPIENTE! Baja a la casilla " + aterrizaCasillaText(jugador2.getPosicion()));
            }
            else{
                System.out.println("Esta casilla es normal. Estate quieto.");
            }
            
            numeroTurno++;

        }

        this.numeroTurnos = numeroTurno;

        reporteJuego();
  }

  public void reporteJuego(){
    System.out.println("\"---------------------------------------------");
    System.out.println("\nGANADOR: " + ganador.getName() + "con " + (numeroTurnos) + " turnos.");
    System.out.println("\"---------------------------------------------");
  }

  private int aterrizaCasillaText(int posicionJugador){
            
    if (posicionJugador >= 30){
        return 30;
    }
    
    return posicionJugador + 1;
    
}


}
