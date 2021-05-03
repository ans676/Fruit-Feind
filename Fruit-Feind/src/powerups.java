public class Fruit {

  public static void main(String[] args) {

//variables 
    int cherry = 1;
    int peach = 2;
    int banana = 3;

    int pwrup; //4 is normal, 5 is speed, 6 is invincibility

    boolean invincibility;
    boolean speedBoost;
    int points;

    if (invincibility == true){
    	//figure out collisions w/ enemy class
    }
    if (speedBoost == true) {
    	//how many seconds do i add to the speed boost?
    }


    //testing out spawning individual fruit:
    //spawn a normal cherry
    cherry(1, 4);

    
   //spawn a normal peach
   peach(2, 4);

    // spawn a normal banana
    banana(3, 4);

    //spawn speed cherry
    cherry(1, 5);



  //FIGURE OUT COLLISION W PLAYER!!!!
  
  }
}

//code for cherries

  public static void cherry (int cherry, int pwrup ) {

  int[] pwrArray = new int[]{4, 5, 6};
  Random scrambler = new Random();
  int picker = generator.nextInt(pwrArray.length);
  return pwrArray[picker];
 

//FIRST NEED TO RANDOMIZE PWRUP VAL FROM ARRAY OF 5 AND 6
   
    if (cherry == 1){
      if(pwrup == 4){
           points = 1;
           //spawn REG cherry
    }
       if(pwrup == 5) {
    	points = 2;
    	speedBoost = true;
    	//spawn BLACK cherry
    }
    	if(pwrup = 6){
    		points = 2;
    		invincibility = true;
    		//spawn PURPLE cherry
    	}
    

     //spawn on board
    }

}

} 
public static void banana (int banana, int pwrup ) {

  int[] pwrArray = new int[]{4, 5, 6};
 

//randomize pwrArray
   
    if (cherry == 2){
      if(pwrup == 4){
           points = 1;
           //spawn REG banana
    }
       if(pwrup == 5) {
    	points = 2;
    	speedBoost = true;
    	//spawn BLACK banana
    }
    	if(pwrup = 6){
    		points = 2;
    		invincibility = true;
    		//spawn PURPLE banana
    	}
    

     //spawn on board
    }

}

} 
public static void peach (int peach, int pwrup ) {

  
//randomize pwrArray6
   
    if (peach == 1){
      if(pwrup == 4){
           points = 1;
           //spawn REG peach
    }
       if(pwrup == 5) {
    	points = 2;
    	speed_boost = true;
    	//spawn BLACK peach
    }
    	if(pwrup == 6){
    		points = 2;
    		invincibility = true;
    		//spawn PURPLE peach
    	}
    

     //spawn on board
    }

}

} 