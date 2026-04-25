package com.techmart.config;

import com.techmart.domain.Category;
import com.techmart.domain.Product;
import com.techmart.repository.CategoryRepository;
import com.techmart.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;

    public DataSeeder(CategoryRepository categoryRepo, ProductRepository productRepo) {
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
    }

    @Override
    public void run(String... args) {
        // Existing seeding logic ...
        Category cpus = categoryRepo.save(new Category("Processors", "CPUs and APUs"));
        Category gpus = categoryRepo.save(new Category("Graphics Cards", "Discrete GPUs"));
        Category ram = categoryRepo.save(new Category("Memory", "DDR5 and DDR4 RAM"));
        Category storage = categoryRepo.save(new Category("Storage", "SSDs and HDDs"));
        Category monitors = categoryRepo.save(new Category("Monitors", "Gaming and professional displays"));
        Category peripherals = categoryRepo.save(new Category("Peripherals", "Keyboards, mice, headsets"));
        Category cases = categoryRepo.save(new Category("Cases", "PC cases and enclosures"));
        Category cooling = categoryRepo.save(new Category("Cooling", "Air and liquid cooling"));

        // CPUs
        Product p1 = new Product("AMD Ryzen 9 9950X3D", "16-Core, 32-Thread, 4.3GHz Base, AM5, 170W TDP", new BigDecimal("699.99"), 25, cpus, "https://placehold.co/400x400?text=AMD%20Ryzen%209%209950X3D");
        productRepo.save(p1);
        productRepo.save(new Product("AMD Ryzen 7 9800X3D", "8-Core, 16-Thread, 4.7GHz Base, AM5, 120W TDP", new BigDecimal("479.99"), 42, cpus));
        productRepo.save(new Product("AMD Ryzen 5 9600X", "6-Core, 12-Thread, 3.9GHz Base, AM5, 65W TDP", new BigDecimal("229.99"), 78, cpus));
        productRepo.save(new Product("Intel Core Ultra 9 285K", "24-Core, 24-Thread, 3.7GHz Base, LGA1851", new BigDecimal("589.99"), 15, cpus));
        productRepo.save(new Product("Intel Core Ultra 7 265K", "20-Core, 20-Thread, 3.9GHz Base, LGA1851", new BigDecimal("394.99"), 30, cpus));
        productRepo.save(new Product("Intel Core Ultra 5 245K", "14-Core, 14-Thread, 4.2GHz Base, LGA1851", new BigDecimal("309.99"), 55, cpus));

        // GPUs
        productRepo.save(new Product("NVIDIA RTX 5090 Founders Edition", "32GB GDDR7, 21760 CUDA Cores, PCIe 5.0", new BigDecimal("1999.99"), 5, gpus));
        productRepo.save(new Product("NVIDIA RTX 5080 Founders Edition", "16GB GDDR7, 10752 CUDA Cores", new BigDecimal("999.99"), 12, gpus));
        productRepo.save(new Product("NVIDIA RTX 5070 Ti", "16GB GDDR7, 8960 CUDA Cores", new BigDecimal("749.99"), 20, gpus));
        productRepo.save(new Product("AMD Radeon RX 9070 XT", "16GB GDDR6, Triple Fan", new BigDecimal("729.99"), 18, gpus));
        productRepo.save(new Product("AMD Radeon RX 9070", "12GB GDDR6, Dual Fan", new BigDecimal("549.99"), 35, gpus));

        // RAM
        productRepo.save(new Product("Corsair Vengeance RGB 32GB DDR5-6000", "2x16GB, CL30, Intel XMP 3.0", new BigDecimal("119.99"), 120, ram));
        productRepo.save(new Product("G.Skill Trident Z5 RGB 32GB DDR5-6400", "2x16GB, CL32", new BigDecimal("139.99"), 85, ram));
        productRepo.save(new Product("Kingston Fury Beast 64GB DDR5-5600", "2x32GB, CL40", new BigDecimal("189.99"), 45, ram));

        // Storage
        productRepo.save(new Product("Samsung 990 Pro 2TB NVMe", "PCIe 4.0 x4, 7450MB/s Read", new BigDecimal("169.99"), 95, storage));
        productRepo.save(new Product("WD Black SN850X 2TB", "PCIe 4.0 x4, 7300MB/s Read", new BigDecimal("149.99"), 110, storage));
        productRepo.save(new Product("Crucial T700 2TB", "PCIe 5.0 x4, 12400MB/s Read", new BigDecimal("249.99"), 30, storage));

        // Monitors
        productRepo.save(new Product("ASUS ROG Swift PG27AQDM", "27\" 1440p OLED, 240Hz, 0.03ms", new BigDecimal("799.99"), 15, monitors));
        productRepo.save(new Product("LG UltraGear 27GR95QE", "27\" 1440p OLED, 240Hz", new BigDecimal("699.99"), 22, monitors));
        productRepo.save(new Product("Samsung Odyssey G9 49\"", "49\" 5120x1440, 240Hz, Mini LED", new BigDecimal("1299.99"), 8, monitors));

        // Peripherals
        productRepo.save(new Product("Logitech G Pro X Superlight 2", "Wireless Gaming Mouse, 60g, 32K DPI", new BigDecimal("159.99"), 65, peripherals));
        productRepo.save(new Product("Razer BlackWidow V4 Pro", "Mechanical Keyboard, Green Switches, RGB", new BigDecimal("229.99"), 40, peripherals));
        productRepo.save(new Product("SteelSeries Arctis Nova Pro", "Wireless Gaming Headset, ANC, Hi-Res", new BigDecimal("349.99"), 28, peripherals));

        // Cases
        productRepo.save(new Product("NZXT H7 Flow", "Mid-Tower ATX, Tempered Glass, White", new BigDecimal("129.99"), 50, cases));
        productRepo.save(new Product("Corsair 4000D Airflow", "Mid-Tower ATX, Mesh Front Panel", new BigDecimal("104.99"), 70, cases));
        productRepo.save(new Product("Fractal Design North", "Mid-Tower ATX, Wood + Mesh Panel", new BigDecimal("139.99"), 35, cases));

        // Cooling
        productRepo.save(new Product("Noctua NH-D15 chromax.black", "Dual Tower Air Cooler, 2x140mm Fans", new BigDecimal("109.99"), 55, cooling));
        productRepo.save(new Product("Corsair iCUE H150i Elite", "360mm AIO Liquid Cooler, RGB", new BigDecimal("169.99"), 40, cooling));
        productRepo.save(new Product("Arctic Liquid Freezer III 360", "360mm AIO, Offset Mounting", new BigDecimal("89.99"), 60, cooling));
    }
}
