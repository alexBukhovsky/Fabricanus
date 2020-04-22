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

    public void setName(String name){this.name = name;}

    public void setDescription(String description){this.description = description;}

    public void setProducer(String producer){this.producer = producer;}

    public void setCount(int count){this.count = count;}

    public void setPrice(int price){this.price = price;}

    public String getInfoForSt(){ return  "Name: " + name + " " + "Description: " + description + " " + "Producer: " + producer + " " + "Count : " + count + " " + "Price : " + price ; }

    public String getInfo(){ return  "Name: " + name + "\n" + "\n" + "Description: " + description + "\n" + "\n"  + "Producer: " + producer + "\n" + "\n" + "Count : " + count + "\n" + "\n" + "Price : " + price + "\n" + "\n" ; }

    public String getId(){ return  name + "<*end*>" + description + "<*end*>" + producer + "<*end*>" + count + "<*end*>" + price + "<*endStaff*>"; };

}

