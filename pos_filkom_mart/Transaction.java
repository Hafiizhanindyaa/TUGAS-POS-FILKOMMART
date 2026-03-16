package pos_filkom_mart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class Transaction
 * Digunakan untuk mengelola transaksi penjualan pada sistem kasir.
 * 
 * Fitur yang tersedia:
 * - Menambahkan produk ke keranjang
 * - Mendukung method overloading addItem()
 * - Memproses transaksi dan menghitung total pembayaran
 * - Menampilkan struk pembelian
 */

public class Transaction {
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

        Map<String, Integer> itemQuantities = new LinkedHashMap<>();
        Map<String, Product> itemData = new HashMap<>();

        for (Product item : items) {
            String name = item.getName();
            itemQuantities.put(name, itemQuantities.getOrDefault(name, 0) + 1);
            itemData.put(name, item);

            totalHargaAwal += item.getPrice();
            totalDiskon += item.calculateDiscount();
            totalBayar += (item.getPrice() - item.calculateDiscount());
            item.setStockQuantity(item.getStockQuantity() - 1);
        }

        for (String name : itemQuantities.keySet()) {
            int qty = itemQuantities.get(name);
            Product p = itemData.get(name);

            double totalHargaItem = p.getPrice() * qty;
            double totalDiskonItem = p.calculateDiscount() * qty;
            double subtotalItem = totalHargaItem - totalDiskonItem;

            System.out.printf(" %dx %s\n", qty, name);
            System.out.printf(formatLabel + "Rp %15.2f\n", "Harga", totalHargaItem);

            if (totalDiskonItem > 0) {
                System.out.printf(formatLabel + "Rp %15.2f\n", "Diskon", totalDiskonItem);
            }
            System.out.printf(formatLabel + "Rp %15.2f\n", "Subtotal", subtotalItem);
            System.out.println(); 
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
