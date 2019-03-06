package tmall.comparator;

import tmall.bean.Product;

import java.util.Comparator;

/**
 * roducts are sorted by sale count.
 * @author Harry Chou
 * @date 2019/3/6
 */
public class ProductSaleCountComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getSaleCount()-o1.getSaleCount();
    }
}
