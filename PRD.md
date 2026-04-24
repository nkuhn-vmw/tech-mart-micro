# Tech Mart Micro — Product Requirements Document

## 1. Executive Summary

Tech Mart Micro is a full-featured electronics retail web application inspired by the design language, user experience, and functionality of Micro Center (microcenter.com). The application will serve as a modern, responsive e-commerce platform for computer hardware, peripherals, and electronics with an emphasis on the in-store pickup experience, deal-driven merchandising, and enthusiast-grade product detail.

**Target Users:** PC builders, gamers, IT professionals, tech enthusiasts, and general electronics shoppers.

**Core Value Proposition:** Fast, visually rich product discovery with deep technical specifications, real-time pricing/availability, and a streamlined checkout flow optimized for both shipping and in-store pickup.

---

## 2. Design System & Visual Identity

### 2.1 Color Palette

| Token | Hex | Usage |
|-------|-----|-------|
| `--brand-primary` | `#0056a6` | Header background, primary CTAs, links |
| `--brand-accent` | `#f5a623` | Sale/savings badges, "SAVE" callouts |
| `--brand-dark` | `#1a1a1a` | Footer background, dark UI elements |
| `--brand-white` | `#ffffff` | Page background, card backgrounds |
| `--text-primary` | `#333333` | Body text |
| `--text-secondary` | `#666666` | Muted labels, secondary info |
| `--text-link` | `#0056a6` | Clickable text |
| `--price-color` | `#1a1a1a` | Current price (large, bold) |
| `--sale-color` | `#cc0000` | Strikethrough original price |
| `--savings-color` | `#e67e22` | "SAVE $XX" badges |
| `--success-green` | `#28a745` | In-stock indicators, checkmarks |
| `--border-light` | `#e0e0e0` | Card borders, dividers |
| `--bg-light` | `#f5f5f5` | Section backgrounds, alternating rows |

### 2.2 Typography

| Element | Font | Weight | Size |
|---------|------|--------|------|
| Body | Open Sans | 400 | 14px |
| Headings | Open Sans | 600-700 | 18-32px |
| Price (large) | Open Sans | 700 | 36-48px |
| Price (cents) | Open Sans | 700 | 18px (superscript) |
| Navigation | Open Sans | 600 | 14px |
| Badges/Tags | Open Sans | 700 | 11-12px, uppercase |
| Product titles | Open Sans | 400-600 | 14-16px |

### 2.3 Layout Grid

- **Max container width:** 1280px, centered
- **Gutter:** 16px
- **Product grid:** 4 columns desktop, 3 tablet, 2 mobile, 1 small mobile
- **Sidebar filters:** 240px fixed width on desktop, collapsible drawer on mobile
- **Header height:** ~130px total (top bar + search bar + nav bar)

### 2.4 Component Library

#### Buttons
- **Primary CTA:** Blue background (`#0056a6`), white text, rounded corners (4px), 12px 24px padding
- **Secondary:** White background, blue border, blue text
- **Danger/Sale:** Red background for urgency
- **Icon buttons:** Cart icon, wishlist heart, compare checkbox

#### Cards
- **Product Card:** White background, 1px border `#e0e0e0`, 4px border-radius, hover shadow
- **Deal Card:** Product card with orange "SAVE" badge overlay
- **Bundle Card:** Wider format showing multiple products with combined pricing

#### Badges
- **In-stock:** Green dot + "In Stock" text
- **Limited:** Orange badge "Limited Availability"
- **Sale:** Red/orange "SAVE $XX.XX" badge
- **New:** Blue "NEW" badge
- **Clearance:** Red "CLEARANCE" badge
- **Store pickup:** Blue clock icon + "18 MINUTE IN-STORE PICKUP"

---

## 3. Page Specifications

### 3.1 Global Header (All Pages)

#### Top Announcement Bar
- Full-width blue background (`#0056a6`)
- Centered promotional text in white, bold
- Clickable links (e.g., "Shop AMD | Shop INTEL")
- Dismissible with cookie persistence

#### Main Header Row
- **Logo:** Left-aligned, links to homepage. Micro Center style wordmark with red accent
- **Search Bar:** Centered, 400px+ width, placeholder "What can we help you find?", blue magnifying glass submit button, autocomplete dropdown with product suggestions
- **Store Selector:** Dropdown showing store locations with "Shippable Items" default option
- **Account:** "Hello, Sign in" with user icon, dropdown with account links
- **Cart:** Cart icon with item count badge, "Cart & List" label, links to cart page

#### Navigation Bar
- Horizontal menu bar below header
- Categories: Products, Top Deals, PC Parts, Computers, Apple, Services, PriorityCare+, Support, MC News
- Each category has a mega-menu dropdown on hover:
  - **Products:** Grid of subcategories with icons
  - **PC Parts:** CPUs, GPUs, Motherboards, RAM, Storage, PSUs, Cases, Cooling
  - **Computers:** Desktops, Laptops, Workstations, All-in-Ones
- Right-aligned: "18 MINUTE IN-STORE PICKUP" badge (blue text, clock icon)

### 3.2 Homepage

#### Hero Section (Top)
- **Left: Large carousel** (65% width)
  - Auto-rotating slides (5s interval) with manual dots/arrows
  - Each slide: product image + title + description + price + "SAVE" amount + CTA button
  - Dark overlay gradient for text readability
  - Dot indicators at bottom
- **Right: Featured product** (35% width)
  - Single highlighted deal with large product image
  - Brand logo, product name, large price, savings amount
  - "REG. $XXX.XX" strikethrough price

#### Secondary Banner Row
- Full-width promotional banner (bundle deals, seasonal sales)
- Alongside: "Top Deals For You" sidebar section with scrollable deal cards

#### Category Quick-Links Section
- Grid of category tiles (8-12 tiles)
- Each tile: icon/image + category name
- Categories: Processors, Graphics Cards, Motherboards, Memory, Storage, Power Supplies, Cases, Cooling, Monitors, Keyboards & Mice, Networking, Software

#### Deal Sections (Repeating Pattern)
- Section header: "Today's Top Deals" / "PC Bundle Deals" / "Gaming Deals"
- "See All" link in header
- Horizontal scrollable product card row (4-6 visible, arrows to scroll)
- Each product card:
  - Product image (square, centered)
  - Wishlist heart icon (top-right)
  - Product name (2 lines, truncated)
  - Star rating (1-5 stars + review count)
  - Price: large current price + strikethrough original + "SAVE $XX"
  - "Add to Cart" button or "In Store Only" badge
  - Store stock indicator

#### Recently Viewed / Recommended
- Personalized section based on browsing history
- Same horizontal card row pattern

#### Newsletter Signup
- Email input + "SIGN ME UP" button
- Brief value proposition text

### 3.3 Category / Product Listing Page

#### Breadcrumbs
- Home > Category > Subcategory path
- Clickable at each level

#### Page Header
- Category name (h1, large bold)
- Store context: "Choose a store to see products at your local Micro Center"
- Result count: "1773 Results for 'computer parts'"
- Result count badge (blue pill, right-aligned): "1773 Product(s) found"

#### Sidebar Filters (Left, 240px)
- **Selected Refinements:** Active filter pills with "X" remove buttons, "Clear All" link
- **Availability:** Checkbox filters
  - "X items available to ship" (checked by default)
  - "See all items at Micro Center"
- **Select Category:** Hierarchical checkbox tree with counts
  - Computer Parts (1773)
  - Keyboards, Mice & Tablets (598)
  - Air & Water Cooling (469)
  - Case Accessories (170)
  - etc.
- **Price Range:** Min-Max input fields + "Go" button, preset ranges as checkboxes
- **Brand:** Scrollable checkbox list with search, alphabetical
- **Specifications:** Dynamic facets based on category (e.g., Socket Type, Memory Type, Capacity)
- **Customer Rating:** Star-based filter (4+, 3+, etc.)

#### Product Grid (Right)
- **Toolbar:** Sort dropdown ("Most Popular", "Price Low-High", "Price High-Low", "Highest Rated", "Newest"), items-per-page (24/48/96), grid/list view toggle, pagination
- **Grid View (Default):** 3-column grid
  - Each card:
    - Wishlist heart (top-left)
    - Product image (centered, ~200px)
    - Compare checkbox
    - Product name (2 lines)
    - Star rating + review count
    - Price block: current price (large), original price (strikethrough), savings
    - "Add to Cart" or "Ship This Item" button
    - Store availability indicator
- **List View:** Single-column, horizontal layout with more specs visible
- **Pagination:** "Page 1 2 3 4 5 ... 74 >" at bottom

### 3.4 Product Detail Page

#### Breadcrumbs
- Full category path: Home > Gaming > PC, Mac Gaming > Accessories > Gaming Mice

#### Product Header
- Brand name (linked, blue)
- SKU number + Manufacturer part number
- Print + Share icons (right-aligned)
- **Product Title:** Large h1

#### Star Rating
- 5-star visual rating + "(X)" review count link

#### Three-Column Layout

**Left Column (Product Gallery, ~35%):**
- Main image (large, zoomable on hover)
- Thumbnail strip below (5-6 thumbnails)
- "ZOOM" button overlay
- Wishlist heart icon
- Video thumbnails mixed with images

**Center Column (Key Features, ~30%):**
- "Key Features" heading with horizontal rule
- Bulleted feature list (6-8 key specs)
- "Protect and Support" section
  - Extended warranty options
  - "Free 60 Day Tech Support" badge

**Right Column (Pricing & Purchase, ~35%):**
- Return policy banner: "MAY BE RETURNED WITHIN 30 DAYS OF PURCHASE* Learn More"
- Price block:
  - Original price (strikethrough, gray)
  - "SAVE $XX.XX" in orange
  - Current price (very large, ~48px, bold)
- **Purchase Options (tabbed):**
  - "18 MINUTE PICKUP" tab — store availability, "Not Available" / "In Stock"
  - "MAP YOUR TRIP" tab — "Add to List" button
  - "SHIPPING" tab — "Ship This Item" button, estimated delivery date
- Shipping estimate: "Usually ships in 5-7 business days"
- "Shippable Items" link + "Text to Me" link

#### Tabbed Content Section (Below)
- **Overview:** Long-form product description, marketing content, key feature highlights with images
- **Specifications:** Full spec table, two-column layout (spec name | value), organized by category (General, Performance, Physical, etc.)
- **Reviews:**
  - Average rating summary with star breakdown bar chart
  - Individual reviews with star rating, date, verified purchaser badge, helpful vote buttons
  - "Write a Review" CTA
- **Q&A:** Community questions and answers

#### Related/Accessories Section
- "Frequently Bought Together" — bundled product suggestions with combined price
- "Customers Also Viewed" — horizontal product card carousel
- "Compatible Accessories" — category-specific accessories

### 3.5 Shopping Cart Page

- Line items with product image, name, quantity selector, unit price, line total
- "Remove" and "Save for Later" links per item
- Order summary sidebar: subtotal, estimated tax, shipping estimate, promo code input, order total
- "Proceed to Checkout" primary CTA
- "Continue Shopping" secondary link

### 3.6 Account Pages

- **Sign In / Register:** Clean form with email/password, "Create Account" tab
- **Order History:** List of past orders with status, tracking links
- **Wishlist / Saved Items:** Grid of saved products
- **Account Settings:** Name, email, password, address book

### 3.7 Footer

#### Newsletter Row
- Email signup with "SIGN ME UP" blue button

#### Link Columns (4 columns)
- **Customer Service:** Satisfaction Guarantee, Returns, Service & Repair
- **Shopping:** My Account, In-Store Pickup, Product Availability, Online Restrictions
- **Resources:** Community, MC News, Rebate Center, Ink & Toner Finder, Careers
- **Company:** About Us, Store Locations, Privacy Policy, Terms of Use

#### Bottom Bar
- Copyright notice
- Social media icons (Facebook, Twitter, Instagram, YouTube)
- Accessibility link

---

## 4. Data Model

### 4.1 Core Entities

#### Product
```
id: UUID
sku: String (unique, e.g., "851311")
name: String (full product name)
brand: String
manufacturer_part: String (MFR part number)
slug: String (URL-friendly)
short_description: String (200 char)
long_description: Text (HTML)
category_id: FK -> Category
price: Decimal
original_price: Decimal (null if no sale)
cost: Decimal
weight: Decimal
dimensions: JSON {length, width, height}
images: JSON array of image URLs
thumbnail: String (primary image URL)
video_urls: JSON array
key_features: JSON array of strings
status: ENUM (ACTIVE, DISCONTINUED, COMING_SOON)
created_at: Timestamp
updated_at: Timestamp
```

#### Category
```
id: UUID
name: String
slug: String
parent_id: FK -> Category (null for top-level)
icon_url: String
display_order: Integer
description: Text
seo_title: String
seo_description: String
facet_config: JSON (which spec filters to show)
```

#### ProductSpecification
```
id: UUID
product_id: FK -> Product
spec_group: String (e.g., "General", "Performance")
spec_name: String (e.g., "Socket Type")
spec_value: String (e.g., "AM5")
display_order: Integer
filterable: Boolean
```

#### Review
```
id: UUID
product_id: FK -> Product
user_id: FK -> User
rating: Integer (1-5)
title: String
body: Text
verified_purchase: Boolean
helpful_count: Integer
created_at: Timestamp
```

#### Store
```
id: UUID
name: String (e.g., "TX - Austin")
code: String (e.g., "215")
address: String
city: String
state: String
zip: String
phone: String
latitude: Decimal
longitude: Decimal
hours: JSON
active: Boolean
```

#### StoreInventory
```
product_id: FK -> Product
store_id: FK -> Store
quantity: Integer
status: ENUM (IN_STOCK, LOW_STOCK, OUT_OF_STOCK, NOT_CARRIED)
updated_at: Timestamp
```

#### CartItem
```
id: UUID
session_id: String (or user_id)
product_id: FK -> Product
quantity: Integer
added_at: Timestamp
```

#### Order
```
id: UUID
user_id: FK -> User
status: ENUM (PENDING, CONFIRMED, PROCESSING, SHIPPED, DELIVERED, CANCELLED)
subtotal: Decimal
tax: Decimal
shipping: Decimal
total: Decimal
shipping_address: JSON
fulfillment_type: ENUM (SHIP, PICKUP)
store_id: FK -> Store (if pickup)
created_at: Timestamp
```

#### User
```
id: UUID
email: String (unique)
password_hash: String
first_name: String
last_name: String
phone: String
addresses: JSON array
created_at: Timestamp
```

---

## 5. Technical Architecture

### 5.1 Technology Stack

| Layer | Technology |
|-------|-----------|
| **Backend** | Spring Boot 3.4.x, Java 21 |
| **Templating** | Thymeleaf + HTMX for dynamic sections |
| **Styling** | Tailwind CSS 3.x with custom design tokens |
| **Interactivity** | Vanilla JS + HTMX (no heavy framework) |
| **Database** | PostgreSQL 15+ |
| **Search** | PostgreSQL full-text search (tsvector) |
| **Image CDN** | Static assets served from `/static/` |
| **Build** | Gradle |
| **Testing** | JUnit 5, Playwright for E2E |

### 5.2 Application Architecture

```
src/main/java/com/techmart/
  TechMartApplication.java
  config/
    WebConfig.java           # Static resources, CORS
    SecurityConfig.java      # Session auth, CSRF
    DataSeeder.java          # Sample product data
  model/
    Product.java
    Category.java
    ProductSpecification.java
    Review.java
    Store.java
    StoreInventory.java
    CartItem.java
    Order.java
    User.java
  repository/
    ProductRepository.java   # JPA + custom queries
    CategoryRepository.java
    ReviewRepository.java
    StoreRepository.java
    CartRepository.java
  service/
    ProductService.java      # Search, filtering, pagination
    CategoryService.java     # Tree navigation
    CartService.java         # Session-based cart
    CheckoutService.java
    SearchService.java       # Full-text search
  controller/
    HomeController.java      # Homepage
    ProductController.java   # PLP + PDP
    CartController.java      # Cart operations
    SearchController.java    # Search results
    AccountController.java   # Auth + account pages
    ApiController.java       # HTMX endpoints (JSON fragments)
  dto/
    ProductCard.java         # Lightweight projection for listings
    SearchResult.java
    FilterOptions.java
```

### 5.3 URL Structure

| URL | Page |
|-----|------|
| `/` | Homepage |
| `/category/{slug}` | Category listing page |
| `/category/{slug}?brand=X&minPrice=Y&sort=Z` | Filtered listing |
| `/product/{slug}` | Product detail page |
| `/search?q=keyword` | Search results |
| `/cart` | Shopping cart |
| `/checkout` | Checkout flow |
| `/account` | Account dashboard |
| `/account/orders` | Order history |
| `/account/wishlist` | Saved items |
| `/deals` | Top deals page |
| `/store/{code}` | Store details |

### 5.4 API Endpoints (HTMX)

| Endpoint | Method | Purpose |
|----------|--------|---------|
| `/api/cart/add` | POST | Add item to cart (returns cart badge fragment) |
| `/api/cart/update` | PUT | Update quantity |
| `/api/cart/remove` | DELETE | Remove item |
| `/api/wishlist/toggle` | POST | Add/remove from wishlist |
| `/api/products/compare` | GET | Compare selected products |
| `/api/search/suggest` | GET | Autocomplete suggestions |
| `/api/store/availability` | GET | Check product stock at store |

---

## 6. Seed Data Requirements

The application must ship with realistic seed data to demonstrate all features:

### Categories (Top-level)
1. Computer Parts (CPUs, GPUs, Motherboards, RAM, Storage, PSUs, Cases, Cooling)
2. Computers (Desktops, Laptops, All-in-Ones)
3. Gaming (Keyboards, Mice, Headsets, Monitors, Controllers)
4. Networking (Routers, Switches, Cables, WiFi)
5. Software (Operating Systems, Productivity, Security)
6. Apple (MacBook, iPad, iPhone, Accessories)
7. Monitors & Displays
8. Peripherals (Printers, Scanners, Webcams)

### Products (Minimum 50 products across categories)
- 10+ CPUs (AMD Ryzen 9/7/5, Intel Core i9/i7/i5)
- 8+ GPUs (NVIDIA RTX 5090/5080/5070, AMD RX 9070/7900)
- 6+ Motherboards (ASUS, MSI, Gigabyte for AM5/LGA1851)
- 5+ RAM kits (Corsair, G.Skill DDR5)
- 5+ SSDs (Samsung, WD, Crucial NVMe)
- 5+ Cases (NZXT, Corsair, Fractal)
- 5+ Gaming peripherals (keyboards, mice)
- 5+ Monitors (ultrawide, 4K, gaming)
- 3+ Bundles (CPU + Mobo + RAM combos)

Each product must have:
- Realistic pricing with some on sale (15-25% showing savings)
- 5-10 key features
- 10-20 specifications
- 3-5 product images (can use placeholder images)
- 2-5 reviews with realistic text
- Store availability data for 3+ stores

### Stores (5 stores minimum)
- TX - Austin
- CA - Santa Clara
- NY - Brooklyn
- IL - Chicago
- GA - Duluth

---

## 7. Key User Flows

### 7.1 Product Discovery Flow
1. User lands on homepage → sees hero deals and category tiles
2. Clicks "PC Parts" in nav → mega-menu shows subcategories
3. Clicks "Graphics Cards" → category listing page with sidebar filters
4. Applies filters (Brand: NVIDIA, Price: $500-$800) → results update
5. Clicks product card → product detail page
6. Reviews specs, reads reviews → clicks "Ship This Item"
7. Item added to cart → cart badge updates

### 7.2 Search Flow
1. User types in search bar → autocomplete suggestions appear
2. Selects suggestion or hits Enter → search results page
3. Results show with relevance ranking, filter sidebar
4. User refines with filters → results update via HTMX

### 7.3 Bundle/Deal Flow
1. User sees "3-in-1 Bundle" on homepage hero
2. Clicks "BUNDLE NOW" → bundle detail page
3. Shows component breakdown + combined savings
4. "Add Bundle to Cart" adds all items

---

## 8. Responsive Breakpoints

| Breakpoint | Width | Layout Changes |
|-----------|-------|----------------|
| Desktop XL | 1280px+ | Full layout, 4-col product grid |
| Desktop | 1024-1279px | 3-col product grid |
| Tablet | 768-1023px | 2-col grid, hamburger nav, filter drawer |
| Mobile | 480-767px | 1-col grid, stacked layout, bottom nav |
| Small Mobile | <480px | Compact cards, minimal chrome |

---

## 9. Performance Requirements

- **First Contentful Paint:** < 1.5s
- **Largest Contentful Paint:** < 2.5s
- **Time to Interactive:** < 3s
- **Product listing page load:** < 500ms (with pagination)
- **Search autocomplete:** < 200ms response
- **Add to cart:** < 300ms response (HTMX swap)
- **Image lazy loading** for below-fold content
- **Product images:** WebP format with JPEG fallback, responsive srcset

---

## 10. SEO Requirements

- Semantic HTML5 (proper heading hierarchy, landmarks)
- Structured data (JSON-LD for Product, BreadcrumbList, Organization)
- Clean URL slugs (`/product/amd-ryzen-9-9950x3d`)
- Meta titles and descriptions per page
- Canonical URLs
- Sitemap.xml generation
- robots.txt

---

## 11. Accessibility Requirements (WCAG 2.1 AA)

- Keyboard navigable (tab order, focus indicators)
- Screen reader compatible (ARIA labels, alt text)
- Color contrast ratio 4.5:1 minimum for text
- Skip-to-content link
- Form labels and error messages
- Focus management on modal open/close
- Reduced motion support

---

## 12. Implementation Phases

### Phase 1: Foundation (MVP)
- Project scaffolding (Spring Boot, Gradle, Tailwind)
- Data model + Flyway migrations
- Seed data loader
- Homepage with hero carousel, category tiles, deal sections
- Global header + footer
- Basic responsive layout

### Phase 2: Product Experience
- Category listing page with filters, sorting, pagination
- Product detail page with gallery, specs, pricing
- Search with autocomplete
- Breadcrumb navigation

### Phase 3: Commerce
- Shopping cart (session-based)
- Wishlist
- Store selector + availability checking
- Checkout flow (simplified)

### Phase 4: Polish
- Reviews system
- Product comparison
- Bundle deals page
- Newsletter signup
- Performance optimization
- E2E test suite

---

## 13. Success Metrics

- Homepage fully renders with hero carousel, deals, category tiles
- Category page shows filterable product grid with sidebar
- Product detail page shows all sections (gallery, specs, reviews, pricing)
- Cart operations work (add, update, remove)
- Search returns relevant results with autocomplete
- Responsive across all breakpoints
- Lighthouse performance score > 80
- No accessibility violations (axe-core)
