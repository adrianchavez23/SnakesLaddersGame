package snakesladders;

import java.util.Random;

public class Dado{

  private Random random;

  public Dado(Random objetoRandom){
    this.random = objetoRandom;
  }

  public int tirar(){
    return random.nextInt(6) + 1;
  }
    

}
