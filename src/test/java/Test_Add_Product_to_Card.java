import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_to_Card extends BaseTest{

    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    public void loadingPageClass(){
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        homePage.acceptCookies();
    }

    @Test
    @Order(1)
    public void search_a_product(){
        loadingPageClass();
        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productPage.isOnProductPage(),
                "Not on product page!");
    }

    @Test
    @Order(2)
    public void select_a_product(){


        productPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on product detail page!");
    }

    @Test
    @Order(3)
    public void add_product_to_cart(){


        productDetailPage.addToCart(1);
        Assertions.assertTrue(homePage.isProductCountUp(),
                "Product count did not increase!");
    }

    @Test
    @Order(4)
    public void go_to_cart(){

        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),
                "Product was not added to cart!");
    }
}
