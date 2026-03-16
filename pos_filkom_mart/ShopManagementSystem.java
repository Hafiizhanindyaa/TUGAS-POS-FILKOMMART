package pos_filkom_mart;

public class ShopManagementSystem {
    public static void main(String[] args) {
        System.out.println("======= Sistem Kasir Filkom Mart =======");
        System.out.println();
        
        // Membuat array Product[] dengan isi 6 objek produk
        Product[] produk = new Product[6];

        // Membuat objek FoodProduct
        produk[0] = new FoodProduct("F-000", "Keripik Kentang", 15000, 21, "05-07-2031");
        produk[1] = new FoodProduct("F-001", "Susu Kotak", 15000, 43, "16-11-2045");

        // Membuat objek ElectronicProduct
        produk[2] = new ElectronicProduct("E-004", "Smartphone", 1500000, 17, "3 Years");
        produk[3] = new ElectronicProduct("E-005", "Laptop", 2500000, 33, "2 Years");

        // Membuat objek ClothingProduct
        produk[4] = new ClothingProduct("C-002", "Celana Jeans", 80000, 30, "L", "Uniqlo");
        produk[5] = new ClothingProduct("C-003", "Hoodie", 125000, 25, "XL", "Erigo");

        // Menampilkan informasi setiap produk
        System.out.println("======= DAFTAR PRODUK FILKOM MART =======");
        for (Product p : produk) {
            // Menghitung diskon dan mengupdate harga
            double diskon = p.calculateDiscount();
            p.setPrice(p.getPrice() - diskon);

            // Menampilkan seluruh informasi produk
            p.getProductInfo();
            System.out.println("Diskon      : Rp " + diskon);
            System.out.println("Harga Akhir : Rp " + p.getPrice());
            System.out.println("----------------------------------------");
        }

        System.out.println();

        // Melakukan method overloading pada updateStock()
        System.out.println("=========== UBAH STOK PRODUK ==========");

        // Mengubah stok saja
        System.out.println("Stok barang " + produk[0].getName() + " sebelum: " + produk[0].getStockQuantity());
        produk[0].updateStock(4);
        System.out.println();

        // Mengubah stok dengan memasukkan alasan
        System.out.println("Stok barang " + produk[1].getName() + " sebelum: " + produk[1].getStockQuantity());
        produk[1].updateStock(-2, "Kemasan barang rusak");
        System.out.println("=======================================");

        System.out.println();

        // Membuat objek Transaction untuk simulasi transaksi 1
        Transaction transaksi1 = new Transaction();
        System.out.println("============= TRANSAKSI 1 =============");

        // Menambahkan item ke keranjang
        transaksi1.addItem(produk[0], 5);
        transaksi1.addItem(produk[1], 7);
        transaksi1.addItem(produk[4], 3);

        // Memproses transaksi 1
        transaksi1.processSale();

        // Membuat objek Transaction untuk simulasi transaksi 2
        Transaction transaksi2 = new Transaction();
        System.out.println("============= TRANSAKSI 2 =============");

        // Menambahkan item ke keranjang
        transaksi2.addItem(produk[0], 4);
        transaksi2.addItem(produk[2], 3);
        transaksi2.addItem(produk[3], 2);
        transaksi2.addItem(produk[5], 1);

        // Memproses transaksi 2
        transaksi2.processSale();

        // ===== LAPORAN PENJUALAN =====
        System.out.println("============== LAPORAN PENJUALAN ==============");

        // Mengambil total transaksi
        double totalTransaksi1 = transaksi1.getTotalTransactionAmount();
        double totalTransaksi2 = transaksi2.getTotalTransactionAmount();

        // Total seluruh penjualan
        double totalPenjualan = totalTransaksi1 + totalTransaksi2;

        System.out.println("Total Penjualan Transaksi 1 : Rp " + totalTransaksi1);
        System.out.println("Total Penjualan Transaksi 2 : Rp " + totalTransaksi2);
        System.out.println("-----------------------------------------------");
        System.out.println("TOTAL PENJUALAN HARI INI    : Rp " + totalPenjualan);
        System.out.println("===============================================");

        // ===== MENENTUKAN PRODUK TERLARIS =====
        System.out.println("\n============== PRODUK TERLARIS ==============");

        // jumlah yang dijual (sesuai transaksi di atas)
        int[] jumlahTerjual = {9, 7, 3, 2, 3, 1}; 
        // urutan sesuai array produk

        int max = jumlahTerjual[0];
        int indexProduk = 0;

        for (int i = 1; i < jumlahTerjual.length; i++) {
        if (jumlahTerjual[i] > max) {
        max = jumlahTerjual[i];
        indexProduk = i;
    }
}

        System.out.println("Produk Terlaris : " + produk[indexProduk].getName());
        System.out.println("Jumlah Terjual  : " + max + " item");
        System.out.println("==============================================");
    }
}
