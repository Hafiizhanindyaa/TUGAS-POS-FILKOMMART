public abstract class Product {
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;

    // TODO: Anggota 1 - Buat Constructor, Getter, dan Setter

    public abstract double calculateDiscount();

    public void getProductInfo() {
        // TODO: Anggota 1 - Isi cetakan info produk
    }

    public void updateStock(int quantity) {
        // TODO: Anggota 1 - Isi logika tambah stok
    }

    public void updateStock(int quantity, String reason) {
        // TODO: Anggota 1 - Isi logika tambah stok dengan alasan
    }
}