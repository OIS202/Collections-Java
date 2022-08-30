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
}
