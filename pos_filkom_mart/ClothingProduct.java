package pos_filkom_mart;

public class ClothingProduct extends Product {
    // Tambahkan atribut size, brand & Constructor
    private String size;
    private String brand;

    public ClothingProduct(){
        super();
        this.size = "M";
        this.brand = "unknown";
    }

    public ClothingProduct(String productId, String name, double price, int stockQuantity, String size, String brand) {
        super (productId, name, price, stockQuantity);
        this.size = size;
        this.brand = brand;
    }

     public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public double calculateDiscount() {
    //Buat logika diskon 15% untuk ukuran L-XL
    
        if (size.equalsIgnoreCase("L") || size.equalsIgnoreCase("XL")) {
            return getPrice()*0.15;
        }
        else{
            return 0;
        }
    }

    @Override
    public void getProductInfo(){
    // Override info produk
     super.getProductInfo();
     System.out.println("Ukuran     : " + this.size);
     System.out.println("Brand      : " + this.brand);
    }
}