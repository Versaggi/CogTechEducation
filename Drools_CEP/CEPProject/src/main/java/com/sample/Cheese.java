package com.sample;

import java.util.List;

public class Cheese {

    private List<String> cheeseTypes;
    private List<String> matureCheeses;
	private String origin;
    private String shape;
    private String name;
    
    
    public Cheese(List<String> cheeseTypes, List<String> matureCheeses, String origin, String shape) {
        this.cheeseTypes = cheeseTypes;
        this.matureCheeses = matureCheeses;
        this.origin = origin;
        this.shape = shape;
    }
    
    public List<String> getCheeseTypes() {
        return cheeseTypes;
    }
    
    public void setCheeseTypes(List<String> cheeseTypes) {
        this.cheeseTypes = cheeseTypes;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getShape() {
        return shape;
    }
    
    public void setShape(String shape) {
        this.shape = shape;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMatureCheeses() {
		return matureCheeses;
	}

	public void setMatureCheeses(List<String> matureCheeses) {
		this.matureCheeses = matureCheeses;
	}
    

    @Override
	public String toString() {
		return "Cheese [cheeseTypes=" + cheeseTypes + ", matureCheeses="
				+ matureCheeses + ", origin=" + origin + ", shape=" + shape
				+ ", name=" + name + "]";
	}    
	
	
} // End Class Cheese
