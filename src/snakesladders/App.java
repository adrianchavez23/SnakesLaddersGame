package snakesladders;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Bienvenido a Serpientes y Escaleras!\n\nEscribe tu nombre:");
        String playerName = scanner.next();

        Jugador mainPlayer = new Jugador(playerName);
        Jugador enemyPlayer = new Jugador("Martha");

        Jugador winnerPlayer = new Jugador("WinnerPlayer");

        Casilla[] Tablero = new Casilla[30];

        Tablero[0] = new Casilla(0,"N"); //1
        Tablero[1] = new Casilla(0,"N"); //2
        Tablero[2] = new Casilla(0,"N"); //3
        Tablero[3] = new Casilla(7,"E"); //4
        Tablero[4] = new Casilla(0,"N"); //5
        Tablero[5] = new Casilla(0,"N"); //6

        Tablero[6] = new Casilla(0,"N"); //7
        Tablero[7] = new Casilla(0,"N"); //8
        Tablero[8] = new Casilla(5,"S"); //9
        Tablero[9] = new Casilla(0,"N"); //10
        Tablero[10] = new Casilla(0,"N"); //11
        Tablero[11] = new Casilla(0,"N"); //12

        Tablero[12] = new Casilla(0,"N"); //13
        Tablero[13] = new Casilla(12,"E"); //14
        Tablero[14] = new Casilla(0,"N"); //15
        Tablero[15] = new Casilla(0,"N"); //16
        Tablero[16] = new Casilla(0,"N"); //17
        Tablero[17] = new Casilla(0,"N"); //18

        Tablero[18] = new Casilla(0,"N"); //19
        Tablero[19] = new Casilla(0,"N"); //20
        Tablero[20] = new Casilla(7,"S"); //21
        Tablero[21] = new Casilla(0,"N"); //22
        Tablero[22] = new Casilla(5,"E"); //23
        Tablero[23] = new Casilla(0,"N"); //24

        Tablero[24] = new Casilla(0,"N"); //25
        Tablero[25] = new Casilla(0,"N"); //26
        Tablero[26] = new Casilla(0,"N"); //27
        Tablero[27] = new Casilla(0,"N"); //28
        Tablero[28] = new Casilla(18,"S"); //29
        Tablero[29] = new Casilla(0,"N"); //30

        Random ran = new Random(); 
        Dado miDado = new Dado(ran);

        
        int numeroTurno = 1;
        while(Tablero[29].isVacia()){

            System.out.println("\nTURNO " + numeroTurno);
            System.out.println("MARCADOR: " + mainPlayer.getName() + ":" + (mainPlayer.getPosicion() + 1) + " || " + enemyPlayer.getName() + ":" + (enemyPlayer.getPosicion() + 1) );

            int tiroJugador1 = miDado.tirar();
            System.out.println(mainPlayer.getName() + " tira el dado y saca: " + tiroJugador1);
            Tablero[mainPlayer.getPosicion()].vaciar();
            mainPlayer.subirPosicion(tiroJugador1);
            System.out.println(mainPlayer.getName() + " avanza " + tiroJugador1 + "casillas y aterriza en la casilla " + AterrizaCasillaText(mainPlayer.getPosicion()));
            
            Tablero[mainPlayer.getPosicion()].llenar();

            if (!Tablero[29].isVacia()){
                winnerPlayer.setName(mainPlayer.getName());
                break;
            }
            int casillasMov1 = Tablero[mainPlayer.getPosicion()].getCasillasMov();

            if(Tablero[mainPlayer.getPosicion()].getTipo().equals("E")){
                mainPlayer.subirPosicion(casillasMov1);
                System.out.println("Esta casilla tiene una ESCALERA! Sube a la casilla " + AterrizaCasillaText(mainPlayer.getPosicion()));
            }
            
            if(Tablero[mainPlayer.getPosicion()].getTipo().equals("S")){
                mainPlayer.bajarPosicion(casillasMov1);
                System.out.println("Esta casilla tiene una SERPIENTE! Baja a la casilla " + AterrizaCasillaText(mainPlayer.getPosicion()));
            }
            else{
                System.out.println("Esta casilla es normal. Estate quieto.");
            }

            int tiroJugador2 = miDado.tirar();
            System.out.println("\n" + enemyPlayer.getName() + " tira el dado y saca: " + tiroJugador2);
            Tablero[enemyPlayer.getPosicion()].vaciar();
            enemyPlayer.subirPosicion(tiroJugador2);
            System.out.println(enemyPlayer.getName() + " avanza " + tiroJugador2 + " casillas y aterriza en la casilla " + AterrizaCasillaText(enemyPlayer.getPosicion()));
            
            Tablero[enemyPlayer.getPosicion()].llenar();

            if (!Tablero[29].isVacia()){
                winnerPlayer.setName(enemyPlayer.getName());
                break;
            }
            int casillasMov2 = Tablero[enemyPlayer.getPosicion()].getCasillasMov();

            if(Tablero[enemyPlayer.getPosicion()].getTipo().equals("E")){
                enemyPlayer.subirPosicion(casillasMov2);
                System.out.println("Esta casilla tiene una ESCALERA! Sube a la casilla " + AterrizaCasillaText(enemyPlayer.getPosicion()));
            }
            
            if(Tablero[enemyPlayer.getPosicion()].getTipo().equals("S")){
                enemyPlayer.bajarPosicion(casillasMov2);
                System.out.println("Esta casilla tiene una SERPIENTE! Baja a la casilla " + AterrizaCasillaText(enemyPlayer.getPosicion()));
            }
            else{
                System.out.println("Esta casilla es normal. Estate quieto.");
            }
            
            numeroTurno++;

        }

        System.out.println("\"---------------------------------------------");
        System.out.println("\nGANADOR: " + winnerPlayer.getName() + "con " + (numeroTurno) + " turnos.");
        System.out.println("\"---------------------------------------------");

        scanner.close();
    }

    public static int AterrizaCasillaText(int posicionJugador){
            
        if (posicionJugador >= 30){
            return 30;
        }
        
        return posicionJugador + 1;
        
    }

}
