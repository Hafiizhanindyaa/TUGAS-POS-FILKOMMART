public class ElectronicProduct extends Product {
    // Tambahkan atribut warrantyPeriod & Constructor
    private String warrantyPeriod;

    public ElectronicProduct(){
        super();
        this.warrantyPeriod = "Unknown";
    }

    public ElectronicProduct(String productId, String name, double price, int stockQuantity, String warrantyPeriod) {
        super(productId, name, price, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    
    @Override
    public double calculateDiscount() {
        // Buat logika diskon 5% + bonus 2% jika harga > 500rb
         double discount = getPrice() * 0.05;

        if (getPrice() > 500000) {
            discount += getPrice() * 0.02;
        }

        return discount;
    }

    @Override
    public void getProductInfo(){
        super.getProductInfo();
        System.out.println("Warranty period : " + this.warrantyPeriod);
    }
}