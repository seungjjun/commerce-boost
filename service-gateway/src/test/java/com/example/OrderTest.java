package com.example.tickets;

import com.example.order.OrderFeignClient;
import com.example.order.dto.OrderRequest;
import com.example.product.ProductFeignClient;
import com.example.product.dto.ProductRequest;
import com.example.stock.StockFeignClient;
import com.example.stock.dto.StockRequest;
import com.example.stock.dto.StockResponse;
import com.example.store.StoreFeignClient;
import com.example.store.dto.StoreRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
class OrderTest {

//    @Autowired
//    StoreFeignClient storeClient;
//
//    @Autowired
//    ProductFeignClient productClient;
//
//    @Autowired
//    OrderFeignClient orderClient;
//
//    @Autowired
//    StockFeignClient stockClient;
//
//    private String stockId;
//    private String storeId;
//    private String productId;
//    private final long stockCount = 1000;
//
//    @BeforeEach
//    void setUp() {
//        StoreRequest storeRequest = new StoreRequest();
//        storeRequest.setStoreName("Store name");
//        storeRequest.setAddress("Store address");
//        storeRequest.setOwnerName("test");
//        storeRequest.setPhoneNumber("01012341234");
//
//        String storeId = storeClient.createStore(storeRequest);
//
//        ProductRequest productRequest = new ProductRequest();
//        productRequest.setName("Product");
//        productRequest.setPrice(1000);
//
//        String productId = productClient.createProduct(productRequest);
//
//        productClient.createProduct(productRequest);
//
//        StockRequest stockRequest = new StockRequest();
//        stockRequest.setStoreId(storeId);
//        stockRequest.setProductId(productId);
//        stockRequest.setStock(stockCount);
//
//        stockId = stockClient.createStock(stockRequest);
//    }
//
//    @AfterEach
//    void tearDown() {
//        storeClient.deleteStore("");
//    }
//
//    private void orderTest(Consumer<Void> action) throws InterruptedException {
//        log.info("orderTest");
//        ExecutorService executorService = Executors.newFixedThreadPool(32);
//        int CONCURRENT_COUNT = 100;
//        CountDownLatch latch = new CountDownLatch(CONCURRENT_COUNT);
//
//        for (int i = 0; i < CONCURRENT_COUNT; i++) {
//            executorService.submit(() -> {
//                try {
//                    action.accept(null);
//                } finally {
//                    latch.countDown();
//                }
//            });
//        }
//
//        latch.await();
//
//        StockResponse stock = stockClient.getStock(stockId);
//
//        assertEquals(stockCount - CONCURRENT_COUNT, stock.getStock());
//    }
//
//    @Test
//    @DisplayName("동시에 100개의 주문")
//    public void redissonOrderTest() throws Exception {
//        orderTest((_no) -> {
//            OrderRequest orderRequest = new OrderRequest();
//            orderRequest.setStoreId(storeId);
//            orderRequest.setProductId(productId);
//            orderRequest.setQuantity(1);
//
//            orderClient.createOrder(orderRequest);
//            stockClient.decreaseStock(stockId, 1);
//        });
//    }
}