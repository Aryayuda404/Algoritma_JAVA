package UAS_Algo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BRILIamWMS {

    static String[][] userData = new String[5][2]; // array untuk menyimpan data user
    static int userCount = 2; // menghitung jumlah user yang tersedia (2 karena sudah ada data masuk berjumlah 2)
    static ArrayList<ProductIn> arrProIn = new ArrayList<>(); // array untuk barang masuk
    static ArrayList<ProductOut> arrProOut = new ArrayList<>(); // array untuk barang keluar
    static ArrayList<stockAval> available = new ArrayList<>(); // array untuk jumlah aktual barang

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // List user yang sudah terdaftar
        String admin = "ilham";
        String admin2 = "niken";
        String keyPass = "1234"; // password

        // List untuk stock
        available.add(new stockAval(101, "Bodypack", 10, 200000));
        available.add(new stockAval(109, "Kremlin", 15, 250000));
        available.add(new stockAval(105, "Ventela", 13, 150000));
        available.add(new stockAval(107, "SKMEI", 19, 250000));
        available.add(new stockAval(103, "Machine58", 17, 600000));

        // memasukan data user ke array
        userData[0][0] = admin;
        userData[0][1] = keyPass;
        userData[1][0] = admin2;
        userData[1][1] = keyPass;

        // Pengulangan Start
        boolean start = true;
        while (start) {
            System.out.println("");
            System.out.println("Warehouse Management System v1.0");
            System.out.println("============================[ Wellcome To WMS ]=============================");
            System.out.println("================[ Click [Y] for start | Click [N] for exit ]================");
            System.out.print("Answer : ");
            String startApp = scan.nextLine();

            // Perkondisian Y | N
            if (startApp.equalsIgnoreCase("Y")) {
                // Pengulangan L  R
                while (true) {
                    System.out.println("");
                    System.out.println("============================================================================");
                    System.out.println("Click [L] for login | Click [R] for registration.");
                    System.out.print("Answer : ");
                    String startMain = scan.nextLine();
                    // Perkondisian L | R
                    if (startMain.equalsIgnoreCase("L")) {
                        if (login(scan)) {
                            System.out.println("");
                            System.out.println("You have successfully logged in.");
                            start = false;
                            break;
                        } else {
                            System.out.println("");
                            System.out.println("Login failed, Please register.");
                        }
                    } else if (startMain.equalsIgnoreCase("R")) {
                        register(scan);
                        System.out.println("");
                        System.out.println("Registration successfully, please click [L] for login.");
                    } else {
                        System.out.println("");
                        System.out.println("The input you entered is incorrect, please re-enter.");
                    }
                }
            } else if (startApp.equalsIgnoreCase("N")) {
                System.out.println("Exiting aplication...");
                System.exit(0); // exit keseluruhan program
            } else {
                System.out.println("The input you entered is incorrect, please re-enter.");
            }
        }

        // Pengulangan Running
        boolean running = true;
        while (running) {
            System.out.println("");
            System.out.println("==============================[ BRILIam WMS ]===============================");
            System.out.println("===[ v1.0 ]================================================[ By : Ilham ]===");
            System.out.println("");
            System.out.println("""
                               a. Inbound
                               b. Outbound
                               c. Inbound List
                               d. Outbound List
                               e. Stock Report
                               f. Adjustment Stock
                               g. Search Product
                               h. *Exit*
                               i. Other menu""");
            System.out.println("");
            System.out.print("Answer : ");
            String choice = scan.nextLine();
            // Perkondisian running
            switch (choice.toLowerCase()) {
                case "a": {
                    System.out.println();
                    System.out.println("================================[ Inbound ]=================================");
                    inbound(scan); // menampilkan inbound
                    break;
                }
                case "b": {
                    System.out.println();
                    System.out.println("================================[ Outbound ]================================");
                    outbound(scan); // menampilkan outbound
                    break;
                }
                case "c": {
                    System.out.println();
                    System.out.println("==========================[ Product Inbound List ]==========================");
                    showInList(); // menampilkan list inbound
                    break;
                }
                case "d": {
                    System.out.println();
                    System.out.println("==========================[ Product Outbound List ]=========================");
                    showOutList(); // menampilkan list outbound
                    break;
                }
                case "e": {
                    System.out.println();
                    System.out.println("============================[ Available Stock ]=============================");
                    System.out.println("***");
                    showStock(); // menampilkan aktual stock
                    System.out.println("***");
                    break;
                }
                case "f": {
                    System.out.println();
                    System.out.println("==============================[ Edit Stock ]================================");
                    adjust(scan); // menampilkan edit stock
                    break;
                }
                case "g": {
                    System.out.println();
                    System.out.println("=============================[ Search Product ]=============================");
                    searchPro(scan); // menampilkan pencarian barang menggunakan metoder search manual (pengulangan)
                    break;
                }
                case "h": {
                    System.out.println();
                    System.out.println("Exiting aplication...");
                    System.exit(0); // exit keseluruhan program
                    running = false;
                }
                case "i": {
                    System.out.println();
                    System.out.println("===============================[ Other Menu ]===============================");
                    System.out.println("[ Sort the data by code before searching it! ]");
                    othMenu(scan, available); // menu lainnya
                    break;
                }
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // function login
    public static boolean login(Scanner scan) {
        System.out.print("Username : ");
        String name = scan.nextLine();
        System.out.print("Password : ");
        String pass = scan.nextLine();

        /* check user */
        for (int i = 0; i < userCount; i++) {
            if (userData[i][0].equals(name) && userData[i][1].equals(pass)) {
                return true;
            }
        }
        return false;
    }

    // function register
    public static void register(Scanner scan) {
        /* check data */
        if (userCount > userData.length) {
            System.out.println("Registration failed, data has been fully");
            return;
        }

        System.out.print("Username : ");
        String name = scan.nextLine();
        /* duplicate username */
        for (int i = 0; i < userCount; i++) {
            if (userData[i][0].equals(name)) {
                System.out.println("Username already exists. Please choose a different username.");
                return;
            }
        }

        System.out.print("Password : ");
        String pass = scan.nextLine();

        userData[userCount][0] = name;
        userData[userCount][1] = pass;
        userCount++; // increment jumlah user 
    }

    // function inbound
    public static void inbound(Scanner scan) {
        int codePro = 0;
        while (true) {
            try {
                System.out.print("Product Code  : ");
                codePro = scan.nextInt();
                scan.nextLine();

                boolean found = false;
                for (stockAval stock : available) {
                    if (stock.getCode() == codePro) {
                        System.out.println("Product Name  : " + stock.getName());
                        System.out.println("Product Qty   : " + stock.getQty());
                        System.out.println("Product Price : " + stock.getPrice());

                        System.out.print("Input new qty : ");
                        int newQty = scan.nextInt();
                        scan.nextLine();

                        stock.qty += newQty;
                        System.out.println("Qty update successfully");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.print("Product Name  : ");
                    String namePro = scan.nextLine();
                    System.out.print("Product Qty   : ");
                    int qtyPro = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Product Price : ");
                    int pricePro = scan.nextInt();
                    scan.nextLine();

                    ProductIn product = new ProductIn(codePro, namePro, qtyPro, pricePro);
                    arrProIn.add(product);

                    available.add(new stockAval(codePro, namePro, qtyPro, pricePro));

                    System.out.println("New product added successfully.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Invalid input. Please enter a numeric value for the Product Code.");
                scan.nextLine();
                continue;
            }
        }
    }

    // Class ProductIn
    public static class ProductIn {

        int code;
        String name;
        int qty;
        int price;

        public ProductIn(int code, String name, int qty, int price) {
            this.code = code;
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public int getQty() {
            return qty;
        }

        public int getPrice() {
            return price;
        }

        /* Show product */
        public void showProduct() {
            System.out.println("Product Code : " + code + " | Product Name : " + name + " | Qty : " + qty + " | Price : " + price);
        }
    }

    // function outbound
    public static void outbound(Scanner scan) {
        stockAval stock = null;
        int codePro = 0;
        /* pengulangan pertanyaan */
        while (true) {
            try {
                System.out.print("Product Code  : ");
                codePro = scan.nextInt();
                scan.nextLine();

                for (stockAval s : available) {
                    if (s.getCode() == codePro) {
                        stock = s;
                        break;
                    }
                }
                if (stock == null) {
                    System.out.println("Product with code " + codePro + " not found.");
                    System.out.println("Press [Enter] to return to the main menu...");
                    scan.nextLine();
                    return;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Invalid input. Please enter a numeric value for the Product Code.");
                scan.nextLine();
            }
        }

        System.out.println("Product Name  : " + stock.getName());
        System.out.println("Product Qty   : " + stock.getQty());
        System.out.println("Product Price : " + stock.getPrice());

        int qtyOut = 0;
        /* pengulangan pertanyaan berdasarkan kondisi */
        while (true) {
            try {
                System.out.println("");
                System.out.print("Qty Deducted  : ");
                qtyOut = scan.nextInt();
                scan.nextLine();

                /* qtyOut > qty stock */
                if (qtyOut > stock.getQty()) {
                    System.out.println("Not enough stock available.");
                    return;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Invalid input. Please enter a numeric value for the quantity.");
            }
        }

        /* Pengurangan Stock */
        stock.qty -= qtyOut;

        /* menghapus stock (available) jika qty nya 0 */
        if (stock.getQty() == 0) {
            available.remove(stock);
            System.out.println("Product is out of stock.");
        }
        /* menambahkannya ke arrProOut (history) */
        ProductOut product = new ProductOut(codePro, stock.getName(), qtyOut, stock.getPrice());
        arrProOut.add(product);
        System.out.println("");
        System.out.println("Product successfully deducted from stock.");
    }

    // class ProductOut
    public static class ProductOut {

        int code;
        String name;
        int qty;
        int price;

        public ProductOut(int code, String name, int qty, int price) {
            this.code = code;
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public int getQty() {
            return qty;
        }

        public int getPrice() {
            return price;
        }
    }

    // function show inbound list
    public static void showInList() {
        if (arrProIn.isEmpty()) {
            System.out.println("No product in the inbound list.");
        } else {
            System.out.println("Displaying Inbound Products...");
            System.out.println("");
            System.out.println("***");
            for (ProductIn product : arrProIn) {
                /* menggunakan function jadi langsung panggil */
                product.showProduct();
            }
            System.out.println("***");
        }
    }

    // function show outbound list
    public static void showOutList() {
        if (arrProOut.isEmpty()) {
            System.out.println("No product in the outbound list.");
        } else {
            System.out.println("Displaying Outbound List.");
            System.out.println("");
            System.out.println("***");
            for (ProductOut product : arrProOut) {
                /* menggunakan cara manual dengan memanggil 1/1 */
                System.out.println("Product Code : " + product.getCode() + " | Product Name : " + product.getName() + " | Qty Deducted : " + product.getQty() + " | Price : " + product.getPrice());
            }
            System.out.println("***");
        }
    }

    // function stock report
    public static void showStock() {
        if (available.isEmpty()) {
            System.out.println("No product in stock");
            return;
        }
        for (stockAval stock : available) {
            stock.showProduct();
            // System.out.println("Product Code : " + stock.getCode() + " | Product Name : " + stock.getName() + " | Available Stock : " + stock.getQty() + " | Price : " + stock.getPrice());
        }
    }

    // Class stockAval
    public static class stockAval {

        int code;
        String name;
        int qty;
        int price;

        public stockAval(int code, String name, int qty, int price) {
            this.code = code;
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public int getQty() {
            return qty;
        }

        public int getPrice() {
            return price;
        }

        public void showProduct() {
            System.out.println("Product Code : " + code + " | Product Name : " + name + " | Qty : " + qty + " | Price : " + price);
        }
    }

    // function adjustment
    public static void adjust(Scanner scan) {
        stockAval stock = null;
        while (true) {
            try {
                System.out.print("Enter Product Code to adjust : ");
                int code = scan.nextInt();
                scan.nextLine();

                for (stockAval s : available) {
                    if (s.getCode() == code) {
                        stock = s;
                        break;
                    }
                }
                if (stock == null) {
                    System.out.println("Product with code " + code + " not found.");
                    return;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Invalid input. Please enter a numeric value for the code");
                scan.nextLine();
            }
        }

        boolean adj = true;
        while (adj) {
            System.out.println("");
            System.out.println("Current Product Detail : ");
            System.out.println("Product Code    : " + stock.getCode());
            System.out.println("Product Name    : " + stock.getName());
            System.out.println("Available Stock : " + stock.getQty());
            System.out.println("Product Price   : " + stock.getPrice());
            System.out.println("");
            System.out.println("What would you like to adjust : ");
            System.out.println("1. Code");
            System.out.println("2. Name");
            System.out.println("3. Qty");
            System.out.println("4. Price");
            System.out.println("Click [E] For Finish Adjustment");
            System.out.print("Chose an option [1-5] : ");
            String choice = scan.nextLine();

            switch (choice.toLowerCase()) {
                case "1": {
                    System.out.print("Enter new Product Code ; ");
                    int newCode = scan.nextInt();
                    scan.nextLine();
                    stock.code = newCode;
                    System.out.println("");
                    System.out.println("Product Code updated succesfully.");
                    System.out.println(">>> >>> >>>");
                    break;
                }
                case "2": {
                    System.out.print("Enter new Product Name ; ");
                    String newName = scan.nextLine();
                    stock.name = newName;
                    System.out.println("");
                    System.out.println("Product Name updated succesfully.");
                    System.out.println(">>> >>> >>>");
                    break;
                }
                case "3": {
                    System.out.print("Enter new Product Qty ; ");
                    int newQty = scan.nextInt();
                    scan.nextLine();
                    stock.qty = newQty;
                    System.out.println("");
                    System.out.println("Product Qty updated succesfully.");
                    System.out.println(">>> >>> >>>");
                    break;
                }
                case "4": {
                    System.out.print("Enter new Product Price ; ");
                    int newPrice = scan.nextInt();
                    scan.nextLine();
                    stock.price = newPrice;
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Product Price updated succesfully.");
                    System.out.println(">>> >>> >>>");
                    break;
                }
                case "e": {
                    adj = false;
                    System.out.println("Adjustment Finished.");
                }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // function search product
    public static void searchPro(Scanner scan) {
        int code = 0;
        while (true) {
            try {
                System.out.print("Enter Product Code to search : ");
                code = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Invalid input. Please enter a numeric value for the code.");
                scan.nextLine();
                continue;
            }

            boolean found = false;
            System.out.println("");
            for (stockAval stock : available) {
                if (stock.getCode() == code) {
                    System.out.println("");
                    System.out.println("Product Found.");
                    System.out.println("***");
                    stock.showProduct();
                    System.out.println("***");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Product with code " + code + " not found.");
            }
            break;
        }
    }

    // function otherMenu
    public static void othMenu(Scanner scan, ArrayList<stockAval> available) {
        boolean start = true;
        while (start) {
            System.out.println("a. Sorting data");
            System.out.println("b. Searching data");
            System.out.println("c. Exit");
            System.out.println("");
            System.out.print("Answer : ");
            String choice = scan.nextLine();

            switch (choice.toLowerCase()) {
                case "a" -> {
                    System.out.println("");
                    System.out.println("=============================[ Sorting Data ]===============================");
                    sorting(scan, available);
                }
                case "b" -> {
                    System.out.println("");
                    System.out.println("=============================[ Searching Data ]==============================");
                    System.out.println("This search uses the binary search method.");
                    searchCode(available, scan);
                }
                case "c" -> {
                    System.out.println("");
                    System.out.println("Exiting menu...");
                    start = false;
                }
                default -> {
                    System.out.println("Invalid input.");
                }
            }
        }
    }

    // function sorting menu
    public static void sorting(Scanner scan, ArrayList<stockAval> available) {
        System.out.println("Which data do you want to sort : ");
        System.out.println("1. Code");
        System.out.println("2. Qty");
        System.out.println("3. Price");
        System.out.println("");
        System.out.print("Answer : ");
        String choice = scan.nextLine();

        switch (choice.toLowerCase()) {
            case "1" -> {
                sortCode(available);
            }
            case "2" -> {
                sortQty(available);
            }
            case "3" -> {
                sortPrice(available);
            }
            default ->
                System.out.println("Invalid input.");
        }
    }

    // function sortCode
    public static void sortCode(ArrayList<stockAval> available) {
        int n = available.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (available.get(j).code > available.get(j + 1).code) {
                    stockAval temp = available.get(j);
                    available.set(j, available.get(j + 1));
                    available.set(j + 1, temp);

                }
            }
        }
        System.out.println("***");
        for (stockAval sorted : available) {
            System.out.println("Code : " + sorted.code + " | Name : " + sorted.name + " | Qty : " + sorted.qty + " | Price : " + sorted.price);
        }
        System.out.println("***");
        System.out.println("============================================================================");

    }

    // function sortQty
    public static void sortQty(ArrayList<stockAval> available) {
        int n = available.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (available.get(j).qty > available.get(j + 1).qty) {
                    stockAval temp = available.get(j);
                    available.set(j, available.get(j + 1));
                    available.set(j + 1, temp);

                }
            }
        }
        System.out.println("***");
        for (stockAval sorted : available) {
            System.out.println("Code : " + sorted.code + " | Name : " + sorted.name + " | Qty : " + sorted.qty + " | Price : " + sorted.price);
        }
        System.out.println("***");
        System.out.println("============================================================================");
    }

    // function sortPrice
    public static void sortPrice(ArrayList<stockAval> available) {
        int n = available.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (available.get(j).price > available.get(j + 1).price) {
                    stockAval temp = available.get(j);
                    available.set(j, available.get(j + 1));
                    available.set(j + 1, temp);

                }
            }
        }
        System.out.println("***");
        for (stockAval sorted : available) {
            System.out.println("Code : " + sorted.code + " | Name : " + sorted.name + " | Qty : " + sorted.qty + " | Price : " + sorted.price);
        }
        System.out.println("***");
        System.out.println("============================================================================");
    }

    // Search berdasarkan Code menggunakan Binary Search
    public static void searchCode(ArrayList<stockAval> available, Scanner scan) {
        int targetCode = 0;
        while (true) {
            try {
                System.out.print("Enter Product Code to search: ");
                targetCode = scan.nextInt();
                scan.nextLine(); // Membersihkan buffer
                break;
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Invalid input.");
                scan.nextLine();
                continue;
            }
        }
        // Binary Search
        int index = binarySearchCode(available, targetCode);

        if (index != -1) {
            System.out.println("\nProduct Found:");
            System.out.println("Code : " + available.get(index).code
                    + " | Name : " + available.get(index).name
                    + " | Qty : " + available.get(index).qty
                    + " | Price : " + available.get(index).price);
            System.out.println("============================================================================");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("Product with code " + targetCode + " not found.");
            System.out.println("============================================================================");
        }
    }

    // Binary Search untuk mencari berdasarkan Code
    public static int binarySearchCode(ArrayList<stockAval> available, int targetCode) {
        int left = 0, right = available.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midCode = available.get(mid).code;

            if (midCode == targetCode) {
                return mid; // Ditemukan
            } else if (midCode < targetCode) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Tidak ditemukan
    }
}
