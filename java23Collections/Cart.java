package java23Collections;

import java.util.HashMap;

public class Cart {
    private HashMap<Product, Integer> articleMap;

    public Cart(HashMap<Product, Integer> articleMap) {
        this.articleMap = articleMap;
    }


    public HashMap<Product, Integer> getArticleMap() {
        return articleMap;
    }
}
