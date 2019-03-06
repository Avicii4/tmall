package tmall.comparator;

import tmall.bean.Product;

import java.util.Comparator;

/**
 * Products are sorted by price.
 * @author Harry Chou
 * @date 2019/3/6
 */
public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int)(o1.getPromotePrice()-o2.getPromotePrice());
    }
}
