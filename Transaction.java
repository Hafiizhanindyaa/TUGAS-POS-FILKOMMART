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
    String formatLabel = " %-18s : "; 
    
    System.out.println("\n====================================================");
    System.out.printf(" %-28s %18s\n", "STRUK PEMBELIAN", transactionId);
    System.out.println("====================================================");

    double totalHargaAwal = 0.0;
    double totalDiskon = 0.0;
    double totalBayar = 0.0;

    for (Product item : items) {
        double harga = item.getPrice();
        double diskon = item.calculateDiscount();
        double hargaSetelahDiskon = harga - diskon;

        System.out.println(" " + item.getName());
        System.out.printf(formatLabel + "Rp %15.2f\n", "Harga", harga);

        if (diskon > 0) {
            System.out.printf(formatLabel + "Rp %15.2f\n", "Diskon", diskon);
        }
        System.out.printf(formatLabel + "Rp %15.2f\n", "Subtotal", hargaSetelahDiskon);
        System.out.println(); 

        totalHargaAwal += harga;
        totalDiskon += diskon;
        totalBayar += hargaSetelahDiskon;

        item.setStockQuantity(item.getStockQuantity() - 1);
    }

    System.out.println("----------------------------------------------------");
    System.out.printf(formatLabel + "%s\n", "Transaction ID", transactionId);
    System.out.printf(formatLabel + "%s\n", "Total Items", totalItems);
    System.out.println("----------------------------------------------------");
    System.out.printf(formatLabel + "Rp %15.2f\n", "Price", totalHargaAwal);
    System.out.printf(formatLabel + "Rp %15.2f\n", "Discount", totalDiskon);
    System.out.println("....................................................");
    System.out.printf(formatLabel + "Rp %15.2f\n", "GRAND TOTAL", totalBayar);
    System.out.println("====================================================\n");
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
