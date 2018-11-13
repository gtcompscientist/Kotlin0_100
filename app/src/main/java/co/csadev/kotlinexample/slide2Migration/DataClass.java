package co.csadev.kotlinexample.slide2Migration;

@SuppressWarnings("ALL")
public class DataClass {
    private String id;
    private String barcode;

    public DataClass(String id, String barcode) {
        this.id = id;
        this.barcode = barcode;
    }

    public String getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }
}
