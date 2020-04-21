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

    @Override
    public String toString(){
        return name;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public String getProducer(){
        return this.producer;
    }

    public int getPrice(){
        return this.price;
    }

    public int getCount(){
        return this.count;
    }

    public String getInfo(){ return  "Name: " + name + "\n" + "\n" + "Description: " + description + "\n" + "\n"  + "Producer: " + producer + "\n" + "\n" ; }

    public String getId(){ return  name + "_" + description + "_" + producer + "_" + count + "_" + price ; };

}


