package print_model;

public class FieldReportPayment {
    private int stt;
    private String name;
    private int price;
    private int total;

    public FieldReportPayment() {
    }

    public FieldReportPayment(int stt, String name, int price, int total) {
        this.stt = stt;
        this.name = name;
        this.price = price;
        this.total = total;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
