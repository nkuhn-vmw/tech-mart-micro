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
        Category cpus = categoryRepo.save(new Category("Processors", "CPUs and APUs"));
        Category gpus = categoryRepo.save(new Category("Graphics Cards", "Discrete GPUs"));
        Category ram = categoryRepo.save(new Category("Memory", "DDR5 and DDR4 RAM"));
        Category storage = categoryRepo.save(new Category("Storage", "SSDs and HDDs"));
        Category monitors = categoryRepo.save(new Category("Monitors", "Gaming and professional displays"));
        Category peripherals = categoryRepo.save(new Category("Peripherals", "Keyboards, mice, headsets"));
        Category cases = categoryRepo.save(new Category("Cases", "PC cases and enclosures"));
        Category cooling = categoryRepo.save(new Category("Cooling", "Air and liquid cooling"));

        // CPUs
        productRepo.save(new Product("AMD Ryzen 9 9950X3D", "16-Core, 32-Thread, 4.3GHz Base, AM5, 170W TDP", new BigDecimal("699.99"), 25, "https://placehold.co/400x400?text=AMD+Ryzen+9+9950X3D", cpus));
        productRepo.save(new Product("AMD Ryzen 7 9800X3D", "8-Core, 16-Thread, 4.7GHz Base, AM5, 120W TDP", new BigDecimal("479.99"), 42, "https://placehold.co/400x400?text=AMD+Ryzen+7+9800X3D", cpus));
        productRepo.save(new Product("AMD Ryzen 5 9600X", "6-Core, 12-Thread, 3.9GHz Base, AM5, 65W TDP", new BigDecimal("229.99"), 78, "https://placehold.co/400x400?text=AMD+Ryzen+5+9600X", cpus));
        productRepo.save(new Product("Intel Core Ultra 9 285K", "24-Core, 24-Thread, 3.7GHz Base, LGA1851", new BigDecimal("589.99"), 15, "https://placehold.co/400x400?text=Intel+Core+Ultra+9+285K", cpus));
        productRepo.save(new Product("Intel Core Ultra 7 265K", "20-Core, 20-Thread, 3.9GHz Base, LGA1851", new BigDecimal("394.99"), 30, "https://placehold.co/400x400?text=Intel+Core+Ultra+7+265K", cpus));
        productRepo.save(new Product("Intel Core Ultra 5 245K", "14-Core, 14-Thread, 4.2GHz Base, LGA1851", new BigDecimal("309.99"), 55, "https://placehold.co/400x400?text=Intel+Core+Ultra+5+245K", cpus));

        // GPUs
        productRepo.save(new Product("NVIDIA RTX 5090 Founders Edition", "32GB GDDR7, 21760 CUDA Cores, PCIe 5.0", new BigDecimal("1999.99"), 5, "https://placehold.co/400x400?text=NVIDIA+RTX+5090", gpus));
        productRepo.save(new Product("NVIDIA RTX 5080 Founders Edition", "16GB GDDR7, 10752 CUDA Cores", new BigDecimal("999.99"), 12, "https://placehold.co/400x400?text=NVIDIA+RTX+5080", gpus));
        productRepo.save(new Product("NVIDIA RTX 5070 Ti", "16GB GDDR7, 8960 CUDA Cores", new BigDecimal("749.99"), 20, "https://placehold.co/400x400?text=NVIDIA+RTX+5070+Ti", gpus));
        productRepo.save(new Product("AMD Radeon RX 9070 XT", "16GB GDDR6, Triple Fan", new BigDecimal("729.99"), 18, "https://placehold.co/400x400?text=AMD+RX+9070+XT", gpus));
        productRepo.save(new Product("AMD Radeon RX 9070", "12GB GDDR6, Dual Fan", new BigDecimal("549.99"), 35, "https://placehold.co/400x400?text=AMD+RX+9070", gpus));

        // RAM
        productRepo.save(new Product("Corsair Vengeance RGB 32GB DDR5-6000", "2x16GB, CL30, Intel XMP 3.0", new BigDecimal("119.99"), 120, "https://placehold.co/400x400?text=Corsair+Vengeance+RGB", ram));
        productRepo.save(new Product("G.Skill Trident Z5 RGB 32GB DDR5-6400", "2x16GB, CL32", new BigDecimal("139.99"), 85, "https://placehold.co/400x400?text=G.Skill+Trident+Z5", ram));
        productRepo.save(new Product("Kingston Fury Beast 64GB DDR5-5600", "2x32GB, CL40", new BigDecimal("189.99"), 45, "https://placehold.co/400x400?text=Kingston+Fury+Beast", ram));

        // Storage
        productRepo.save(new Product("Samsung 990 Pro 2TB NVMe", "PCIe 4.0 x4, 7450MB/s Read", new BigDecimal("169.99"), 95, "https://placehold.co/400x400?text=Samsung+990+Pro", storage));
        productRepo.save(new Product("WD Black SN850X 2TB", "PCIe 4.0 x4, 7300MB/s Read", new BigDecimal("149.99"), 110, "https://placehold.co/400x400?text=WD+Black+SN850X", storage));
        productRepo.save(new Product("Crucial T700 2TB", "PCIe 5.0 x4, 12400MB/s Read", new BigDecimal("249.99"), 30, "https://placehold.co/400x400?text=Crucial+T700", storage));

        // Monitors
        productRepo.save(new Product("ASUS ROG Swift PG27AQDM", "27\" 1440p OLED, 240Hz, 0.03ms", new BigDecimal("799.99"), 15, "https://placehold.co/400x400?text=ASUS+ROG+Swift", monitors));
        productRepo.save(new Product("LG UltraGear 27GR95QE", "27\" 1440p OLED, 240Hz", new BigDecimal("699.99"), 22, "https://placehold.co/400x400?text=LG+UltraGear", monitors));
        productRepo.save(new Product("Samsung Odyssey G9 49\"", "49\" 5120x1440, 240Hz, Mini LED", new BigDecimal("1299.99"), 8, "https://placehold.co/400x400?text=Samsung+Odyssey+G9", monitors));

        // Peripherals
        productRepo.save(new Product("Logitech G Pro X Superlight 2", "Wireless Gaming Mouse, 60g, 32K DPI", new BigDecimal("159.99"), 65, "https://placehold.co/400x400?text=Logitech+G+Pro+X", peripherals));
        productRepo.save(new Product("Razer BlackWidow V4 Pro", "Mechanical Keyboard, Green Switches, RGB", new BigDecimal("229.99"), 40, "https://placehold.co/400x400?text=Razer+BlackWidow", peripherals));
        productRepo.save(new Product("SteelSeries Arctis Nova Pro", "Wireless Gaming Headset, ANC, Hi-Res", new BigDecimal("349.99"), 28, "https://placehold.co/400x400?text=SteelSeries+Arctis", peripherals));

        // Cases
        productRepo.save(new Product("NZXT H7 Flow", "Mid-Tower ATX, Tempered Glass, White", new BigDecimal("129.99"), 50, "https://placehold.co/400x400?text=NZXT+H7+Flow", cases));
        productRepo.save(new Product("Corsair 4000D Airflow", "Mid-Tower ATX, Mesh Front Panel", new BigDecimal("104.99"), 70, "https://placehold.co/400x400?text=Corsair+4000D", cases));
        productRepo.save(new Product("Fractal Design North", "Mid-Tower ATX, Wood + Mesh Panel", new BigDecimal("139.99"), 35, "https://placehold.co/400x400?text=Fractal+Design+North", cases));

        // Cooling
        productRepo.save(new Product("Noctua NH-D15 chromax.black", "Dual Tower Air Cooler, 2x140mm Fans", new BigDecimal("109.99"), 55, "https://placehold.co/400x400?text=Noctua+NH-D15", cooling));
        productRepo.save(new Product("Corsair iCUE H150i Elite", "360mm AIO Liquid Cooler, RGB", new BigDecimal("169.99"), 40, "https://placehold.co/400x400?text=Corsair+iCUE+H150i", cooling));
        productRepo.save(new Product("Arctic Liquid Freezer III 360", "360mm AIO, Offset Mounting", new BigDecimal("89.99"), 60, "https://placehold.co/400x400?text=Arctic+Liquid+Freezer", cooling));
    }
}
