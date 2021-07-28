package model;
import java.io.Serializable;
public class Health implements Serializable {
	private double height, weight, bmi;
	private String bodyType;
	private String bodyTypeAdv;
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public String getBodyType() {
		return this.bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getBodyTypeAdv() {
		return this.bodyTypeAdv;
	}
	public void setBodyTypeAdv(String bodyTypeAdv) {
		this.bodyTypeAdv = bodyTypeAdv;
	}
}