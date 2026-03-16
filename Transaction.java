import java.util.ArrayList;

public class Transaction {
    private ArrayList<Product> items;
    private int totalItems;
    private static int transactionCounter = 1;
    private String transactionId;

    // Constructor untuk inisialisasi
    public Transaction() {
        this.items = new ArrayList<>();
        this.totalItems = 0;
        this.transactionId = "TRX-" + String.format("%03d", transactionCounter++);
    }

    // Method Overloading: addItem dengan 1 parameter (1 produk)
    public void addItem(Product item) {
        this.items.add(item);
        this.totalItems++;
        System.out.println(item.getName() + " berhasil ditambahkan ke keranjang.");
    }

    // Method Overloading: addItem dengan 2 parameter (produk dan jumlah kuantitas)
    public void addItem(Product item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.items.add(item);
        }
        this.totalItems += quantity;
        System.out.println(quantity + " " + item.getName() + " berhasil ditambahkan ke keranjang.");
    }

    // Method processSale() untuk memproses keranjang dan menghitung total
    public void processSale() {
        System.out.println("\n========================================");
        System.out.println("             STRUK PEMBELIAN - " + transactionId );
        System.out.println("========================================");
        
        double totalHargaAwal = 0.0;
        double totalDiskon = 0.0;
        double totalBayar = 0.0;

        for (Product item : items) {
            double harga = item.getPrice();
            double diskon = item.calculateDiscount(); 
            double hargaSetelahDiskon = harga - diskon;

            System.out.println("- " + item.getName());
            System.out.println("  Harga   : Rp " + harga);
            
            if (diskon > 0) {
                System.out.println("  Diskon  : Rp " + diskon);
            }
            System.out.println("  Subtotal: Rp " + hargaSetelahDiskon);
            
            totalHargaAwal += harga;
            totalDiskon += diskon;
            totalBayar += hargaSetelahDiskon;

            item.setStockQuantity(item.getStockQuantity() - 1);
        }

        System.out.println("----------------------------------------");
        System.out.println("ID Transaksi  : " + transactionId);
        System.out.println("Total Item    : " + totalItems);
        System.out.println("Total Belanja : Rp " + totalHargaAwal);
        System.out.println("Total Diskon  : Rp " + totalDiskon);
        System.out.println("Total Bayar   : Rp " + totalBayar);
        System.out.println("========================================\n");
    }

    // Getter untuk ID 
    public String getTransactionId() {
        return transactionId;
    }

    // Getter untuk mengambil total bayar dari setiap transaksi
    public double getTotalTransactionAmount() {
        double total = 0.0;
        for (Product item : items) {
            total += (item.getPrice() - item.calculateDiscount());
        }
        return total;
    }
}
