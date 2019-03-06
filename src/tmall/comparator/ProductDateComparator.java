package tmall.comparator;

import tmall.bean.Product;

import java.util.Comparator;

/**
 * Products are sorted by date.
 * @author Harry Chou
 * @date 2019/3/6
 */
public class ProductDateComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getCreateDate().compareTo(o2.getCreateDate());
    }
}
