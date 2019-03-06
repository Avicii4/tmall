package tmall.comparator;

import tmall.bean.Product;

import java.util.Comparator;

/**
 * Products are sorted by sale and reviews.
 * @author Harry Chou
 * @date 2019/3/6
 */
public class ProductAllComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getSaleCount()*o2.getReviewCount()-o1.getSaleCount()*o1.getReviewCount();
    }
}
