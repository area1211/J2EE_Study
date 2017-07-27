package model;

public class DiceRoller {
	public static Integer rollDice(){
		return (int)((Math.random()*6)+1);
	}
}
