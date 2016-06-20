package com.cooksys.butterpillar.model.impl;

import com.cooksys.butterpillar.model.IButterpillar;
import com.cooksys.butterpillar.model.ICatterfly;
import com.cooksys.butterpillar.model.IGrowthModel;
import com.cooksys.butterpillar.model.ISpecies;

public class Species implements ISpecies {

	private String name;
	private IGrowthModel growthModel;
	private IButterpillar butterpillar;
	private ICatterfly catterfly;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IGrowthModel getGrowthModel() {
		return growthModel;
	}

	public void setGrowthModel(IGrowthModel growthModel) {
		this.growthModel = growthModel;
	}

	public IButterpillar getButterpillar() {
		return butterpillar;
	}

	public void setButterpillar(IButterpillar butterpillar) {
		this.butterpillar = butterpillar;
	}

	public ICatterfly getCatterfly() {
		return catterfly;
	}

	public void setCatterfly(ICatterfly catterfly) {
		this.catterfly = catterfly;
	}

	public ICatterfly createCatterfly(double wingspan, double weight) {
		Catterfly catterfly = new Catterfly();
		catterfly.setWingspan(wingspan);
		catterfly.setWeight(weight);
		return catterfly;
	}

	public IButterpillar createButterpillar(double length, double leavesEaten) {
		Butterpillar butterpillar = new Butterpillar();
		butterpillar.setLength(length);
		butterpillar.setLeavesEaten(leavesEaten);
		return butterpillar;
	}

	public ICatterfly[] convert(IButterpillar[] butterpillars) {
		ICatterfly[] catterflies = new Catterfly[butterpillars.length];
		for (int i = 0; i < butterpillars.length; i++) {
			catterflies[i] = createCatterfly(butterpillars[i].getLength() * growthModel.getLengthToWingspan(), butterpillars[i].getLeavesEaten() * growthModel.getLeavesEatenToWeight());
		}
		return catterflies;
	}

	public IButterpillar[] convert(ICatterfly[] catterflies) {
		IButterpillar[] butterpillars = new Butterpillar[catterflies.length];
		for (int i = 0; i < catterflies.length; i++) {
			butterpillars[i] = createButterpillar(catterflies[i].getWingspan() / growthModel.getLengthToWingspan(), catterflies[i].getWeight() / growthModel.getLeavesEatenToWeight());
		}
		return butterpillars;
	}
}
