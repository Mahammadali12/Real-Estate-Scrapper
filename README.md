# Real Estate Scraper

**Real Estate Scraper** is a Java-based application that collects real estate listings from specified online sources. With this tool, you can automate the retrieval and inspection of property data like prices, addresses, and other details.

## Features

- **Automated Scraping:** Fetch listings from configurable real estate websites.
- **Data Extraction:** Extract key property details such as price and location.
- **Configurable & Extensible:** Add new websites or modify selectors with ease.
- **Built with Gradle:** Simplify build and dependency management.

## Getting Started

### Prerequisites
- **Java 11+**: Make sure you have Java 11 or later installed.

### Building the Project
1. **Clone the repository:**
   ```bash
   git clone https://github.com/Mahammadali12/Real-Estate-Scrapper.git
   cd Real-Estate-Scrapper
   ```

2. **Build with Gradle:**
   ```bash
   ./gradlew build
   ```
   *(Windows: `gradlew.bat build`)*

3. **Run the application:**
   ```bash
   ./gradlew run
   ```
   *(Windows: `gradlew.bat run`)*

## Viewing Paginated & Sorted Listings

- **Project will start in the localhost:8080 but double check the terminal logs just in case**

Once the server is running, you can view scraped listings via the `/paged` endpoint. Adjust pagination and sorting using query parameters:

- **`/paged?page=0&size=10`**  
  Returns the first page (index 0) with 10 items.

- **`/paged?page=0&size=5&sort=price,asc`**  
  Returns the first page with 5 items, sorted by `price` ascending.

- **`/paged?page=1&size=10&sort=price,asc&sort=location,desc`**  
  Returns the second page with 10 items, sorted by `price` ascending, then by `location` descending.

- **`/all`** you can see all scraped lists by default without any pagination .

You can modify `page`, `size`, and `sort` parameters as needed to navigate listings. (**in the url**)

## Configuration

Adjust scraping sources and parsing logic in `src/main/resources` or the corresponding Java parser classes. Update selectors, output format, and data fields as required.
