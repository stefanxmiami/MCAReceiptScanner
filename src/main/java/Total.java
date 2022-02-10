public class Total {

    private double domesticCost = 0.0;
    private double importedCost = 0.0;
    private int domesticCount = 0;
    private int importedCount = 0;

    public void printTotal(){
        System.out.println("Domestic cost: $" + getDomesticCost());
        System.out.println("Imported cost: $" + getImportedCost());
        System.out.println("Domestic count: " + getDomesticCount());
        System.out.println("Imported count: " + getImportedCount());
    }

    public double getDomesticCost() {
        return domesticCost;
    }

    public double getImportedCost() {
        return importedCost;
    }

    public int getDomesticCount() {
        return domesticCount;
    }

    public int getImportedCount() {
        return importedCount;
    }

    public void addDomesticCost(double domesticCost) {
        this.domesticCost += domesticCost;
    }

    public void addImportedCost(double importedCost) {
        this.importedCost += importedCost;
    }

    public void addDomesticCount() {
        this.domesticCount++;
    }

    public void addImportedCount() {
        this.importedCount++;
    }
}
