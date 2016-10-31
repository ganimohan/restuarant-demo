package com.example.restuarant.model;

/**
 * This class models the Dish.
 * 
 * @author ganesh
 *
 */
public class Dish implements Comparable<Dish> {

	private int satisfactionNumber;

	private int timeTakenToConsume;

	public int getSatisfactionNumber() {
		return satisfactionNumber;
	}

	public void setSatisfactionNumber(int satisfactionNumber) {
		this.satisfactionNumber = satisfactionNumber;
	}

	public int getTimeTakenToConsume() {
		return timeTakenToConsume;
	}

	public void setTimeTakenToConsume(int timeTakenToConsume) {
		this.timeTakenToConsume = timeTakenToConsume;
	}

	@Override
	public int compareTo(Dish dish) {
		// TODO Auto-generated method stub
		return this.timeTakenToConsume - dish.getTimeTakenToConsume();
	}

	@Override
	public boolean equals(Object dish) {
		return this.getSatisfactionNumber() == ((Dish) dish).getSatisfactionNumber();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.satisfactionNumber;
		return result;
	}

}
