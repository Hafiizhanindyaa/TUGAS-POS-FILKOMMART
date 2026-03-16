package pos_filkom_mart;

/**
 * Class abstract Product
 * Menjadi superclass untuk semua jenis produk di Filkom Mart.
 * Class ini menyimpan atribut dasar produk seperti:
 * productId, name, price, dan stockQuantity.
 * 
 * Class ini juga memiliki method abstract calculateDiscount()
 * yang harus diimplementasikan oleh subclass.
 */

public abstract class Product {
public abstract class Product {
    // 1. Atribut private (Enkapsulasi)
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;

    // 2. Konstruktor Default
    public Product() {
        this.productId = "P000";
        this.name = "Unknown";
        this.price = 0.0;
        this.stockQuantity = 0;
    }

    // 3. Konstruktor Parameterized
    public Product(String productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // 4. Getter dan Setter (Enkapsulasi)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // 5. Method Abstrak untuk menghitung diskon
    public abstract double calculateDiscount();

    // 6. Method menampilkan informasi produk dasar
    public void getProductInfo() {
        System.out.println("ID Produk   : " + productId);
        System.out.println("Nama Produk : " + name);
        System.out.println("Harga       : Rp " + price);
        System.out.println("Sisa Stok   : " + stockQuantity);
    }

    // 7. Method Overloading: updateStock hanya dengan kuantitas
    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
        System.out.println("Stok " + this.name + " berhasil diupdate. Stok sekarang: " + this.stockQuantity);
    }

    // 8. Method Overloading: updateStock dengan kuantitas dan alasan
    public void updateStock(int quantity, String reason) {
        this.stockQuantity += quantity;
        System.out.println("Stok " + this.name + " berhasil diupdate. Stok sekarang: " + this.stockQuantity);
        System.out.println("Alasan update: " + reason);
    }
}
