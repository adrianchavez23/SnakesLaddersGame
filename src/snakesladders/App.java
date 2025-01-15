package snakesladders;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Bienvenido a Serpientes y Escaleras!\n\nEscribe tu nombre:");
        String playerName = scanner.next();

        Jugador mainPlayer = new Jugador(playerName);
        Jugador enemyPlayer = new Jugador("Martha");
        Casilla[] tableroGenerado = generarTablero();

        Juego partidaNueva = new Juego(mainPlayer,enemyPlayer, tableroGenerado);

        partidaNueva.jugar(); //JUGAR

        scanner.close();
    }

    public static Casilla[] generarTablero(){
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
        Tablero[29] = new Casilla(0,"N");

        return Tablero;
    }

}
