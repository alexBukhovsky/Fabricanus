public class Staff {

    private String name;
    private String description;
    private String producer;
    private int count = 0;
    private int price;

    Staff(String name, String description, String producer, int count, int price){

        this.name = name;

        this.description = description;

        this.producer = producer;

        this.count = count;

        this.price = price;

    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public int getCount(){
        return this.count;
    }

}

