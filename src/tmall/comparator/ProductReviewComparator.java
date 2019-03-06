package tmall.comparator;

import tmall.bean.Product;

import java.util.Comparator;

/**
 * Products are sorted by reviews.
 * @author Harry Chou
 * @date 2019/3/6
 */
public class ProductReviewComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getReviewCount()-o1.getReviewCount();
    }
}
