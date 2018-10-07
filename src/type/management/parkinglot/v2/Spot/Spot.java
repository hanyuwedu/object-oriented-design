package type.management.parkinglot.v2.Spot;

public abstract class Spot {
    protected int stall;
    protected SpotSize spotSize;
    protected boolean isAvailable;

    protected Spot(int stall, SpotSize spotSize) {
        this.stall = stall;
        this.spotSize = spotSize;
        this.isAvailable = true;
    }

    public int getStall() {
        return this.stall;
    }
    public SpotSize getSpotSize() {
        return this.spotSize;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsAvailable() {
        this.isAvailable = true;
    }

    public void markAsUnavailable() {
        this.isAvailable = false;
    }

    @Override
    public String toString() {
        return "[" + this.stall + ", " + this.getSpotSize() + "]";
    }
}
