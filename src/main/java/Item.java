public class Item {
    private String name;
    private Boolean domestic;
    private Double price;
    private Double weight;
    private String description;

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", domestic=" + domestic +
                ", price=" + price +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }


    //Constructor
    public Item(){}

    //Getters
    public String getName() {
        return name;
    }

    public Boolean getDomestic(){
        return domestic;
    }

    public Double getPrice() {
        return price;
    }

    public Double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDomestic(Boolean domestic) {
        this.domestic = domestic;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
