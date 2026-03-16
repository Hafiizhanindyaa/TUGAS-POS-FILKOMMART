package pos_filkom_mart;

/**
 * Class FoodProduct
 * Merupakan subclass dari Product yang merepresentasikan
 * produk makanan atau minuman.
 * 
 * Atribut tambahan:
 * expiryDate -> tanggal kadaluarsa produk.
 * 
 * Diskon:
 * 10% jika stok lebih dari 10.
 */

public class FoodProduct extends Product {
    // Tambahkan atribut expiryDate & Constructor
    private String expiryDate;

    public FoodProduct(){
        super();
        this.expiryDate = "unknown";
    }

    public FoodProduct(String productId, String name, double price, int stockQuantity, String expiryDate) {
        super(productId, name, price, stockQuantity);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }


    @Override
    public double calculateDiscount() {
        // Buat logika diskon 10% jika stok > 10
         if (getStockQuantity() > 10) {
            return getPrice() * 0.10;
        }
        return 0;
    }

    @Override
    public void getProductInfo(){
        super.getProductInfo();
        System.out.println("Tanggal Expiry : " + this.expiryDate);
    }


}
