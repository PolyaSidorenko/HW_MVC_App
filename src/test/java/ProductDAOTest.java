import org.example.Product;
import org.example.ProductDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ProductDAOTest {
    private ProductDAO productDAO;

    @BeforeEach
    void setUp() {
        productDAO = new ProductDAO();
    }

    @Test
    void createProduct_test() {
        //Given
        Product product = new Product(null, "test", 1.0, 1);

        //When
        productDAO.create(product);

        //Then
        assertNotNull(productDAO.getById(product.getId()));
    }

    @Test
    void updateProduct_test() {
        //Given
        Product product = new Product(null, "test", 1.0, 1);
        productDAO.create(product);

        //When
        product.setName("test2");
        product.setPrice(2.0);
        product.setQuantity(1);
        productDAO.update(product);

        //Then
        Product product2 = productDAO.getById(product.getId());
        assertNotNull(product2);
        assertEquals(product, product2);
    }

    @Test
    void deleteProduct_test() {
        //Given
        Product product = new Product(null, "test", 1.0, 1);
        productDAO.create(product);

        //When
        productDAO.delete(product);

        //Then
        assertNull(productDAO.getById(product.getId()));
    }

    @Test
    void getAllProducts_test() {
        //Given
        Product product = new Product(null, "test", 1.0, 1);
        productDAO.create(product);

        //When
        List<Product> products = productDAO.getAll();

        //Then
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }
}
