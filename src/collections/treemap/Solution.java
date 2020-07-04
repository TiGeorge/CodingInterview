package collections.treemap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Map<String, Product> productsByName = new HashMap<>();

        Product eBike = new Product("E-Bike", "A bike with a battery");
        Product roadBike = new Product("Road bike", "A bike for competition");
        productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);

        LinkedHashMap<String, String> stringLinkedHashMap = new LinkedHashMap<>();
        stringLinkedHashMap.put(null, null);

    }
}

class Product {

    private String name;
    private String description;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    private List<String> tags;

    // standard getters/setters/constructors

    public Product addTagsOfOtherProdcut(Product product) {
        this.tags.addAll(product.getTags());
        return this;
    }
}