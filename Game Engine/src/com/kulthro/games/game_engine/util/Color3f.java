package com.kulthro.games.game_engine.util;

public class Color3f {
	private float r;
	private float g;
	private float b;

	//Using in Passing into the Render Class (To Be Implemented)
	public Color3f(float r, float g, float b){
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public void setR(float r){
		this.r = r;
	}

	public void setG(float g){
		this.g = g;
	}

	public void setB(float b){
		this.b = b;
	}

	public float setR(){
		return this.r;
	}

	public float setG(){
		return this.g;
	}

	public float setB(){
		return this.b;
	}

}
