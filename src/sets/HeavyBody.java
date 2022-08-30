package sets;

import java.util.HashSet;
import java.util.Set;

public final class HeavyBody {
	private final String name;
	private final double orbitalPeriod;
	private final Set<HeavyBody> satellites;
	
	public HeavyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }
    @Override
    public boolean equals(Object obj) {
    	if(this == obj) {
    		return true;
    	}
    	if((obj == null)||obj.getClass() != this.getClass())
    		return false;
    	String objName = ((HeavyBody) obj).getName();
    	return this.name.equals(objName);
    }
    @Override
    public int hashCode() {
    	System.out.println("hashcode called");
    	return this.name.hashCode() + 57;//57  so it isnt a zero
    }
}
