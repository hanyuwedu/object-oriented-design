package type.management.parkinglot.v3.spot;

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
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.stall + ", " + this.getSpotSize());

        if (!this.isAvailable) {
            sb.append("<O>");
        }

        sb.append("]");
        return sb.toString();
    }
}
