package com.hit.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.hit.algo.IAlgoKnapsack;
import com.hit.algo.OneOrZeroKnapsackAlgoImpl;
import com.hit.algo.UnboundedKnapsackAlgoImpl;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.CartObject;
import com.hit.dm.OptimalCartObject;
import com.hit.dm.Product;

public class ShoppingCartService {

    private IAlgoKnapsack oneOrZeroKnapsackAlgo = new OneOrZeroKnapsackAlgoImpl();
    private IAlgoKnapsack unboundedKnapsackAlgo = new UnboundedKnapsackAlgoImpl();
    private IDao dao;

    ShoppingCartService() {
    }

    ShoppingCartService(IAlgoKnapsack algoKnapsack, IDao dao) {
        oneOrZeroKnapsackAlgo = new OneOrZeroKnapsackAlgoImpl();
        unboundedKnapsackAlgo = new UnboundedKnapsackAlgoImpl();
        this.dao = dao;
    }

    public IAlgoKnapsack getOneOrZeroKnapsackAlgo() {
        return oneOrZeroKnapsackAlgo;
    }

    public void setOneOrZeroKnapsackAlgo(IAlgoKnapsack oneOrZeroKnapsackAlgo) {
        this.oneOrZeroKnapsackAlgo = oneOrZeroKnapsackAlgo;
    }

    public IAlgoKnapsack getUnboundedKnapsackAlgo() {
        return unboundedKnapsackAlgo;
    }

    public void setUnboundedKnapsackAlgo(IAlgoKnapsack unboundedKnapsackAlgo) {
        this.unboundedKnapsackAlgo = unboundedKnapsackAlgo;
    }

    public IDao getDao() {
        return dao;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    public CartObject buildOptimalShoppingCart() throws URISyntaxException, IOException {
        int[] productsForOptimalCart;
        DaoFileImpl daoFile = new DaoFileImpl();
        CartObject inputShoppingCart = daoFile.read("inputCartOptions.json");
        runKnapsackAlgo(inputShoppingCart);
        // productsForOptimalCart = algoKnapsack.buildShoppingCart()
        return inputShoppingCart;

    }

    public ArrayList<Integer> runKnapsackAlgo(CartObject cartObject) {

        int totalPrice;
        String buyingOptionAlgo;
        ArrayList<Integer> algoOutputIndexes;
        int productsLength = cartObject.getProducts().size(), i = 0;
        int[] prices = new int[productsLength];
        int[] weights = new int[productsLength];

        totalPrice = cartObject.getTotalPrice();
        buyingOptionAlgo = cartObject.getBuyingOptionAlgo();

        for (Product productItem : cartObject.getProducts()) {
            prices[i] = productItem.getPrice();
            weights[i] = productItem.getWeight();
            i++;
        }
        if (buyingOptionAlgo.contentEquals("oneOrZero")) {
            algoOutputIndexes = (ArrayList<Integer>) oneOrZeroKnapsackAlgo.buildShoppingCart(weights, prices, totalPrice, productsLength);
        } else {
            if (buyingOptionAlgo.contentEquals("unbounded")) {
                algoOutputIndexes = (ArrayList<Integer>) unboundedKnapsackAlgo.buildShoppingCart(weights, prices, totalPrice, productsLength);
            } else {
                algoOutputIndexes = null;
            }
        }
        parseAlgoOutputToOptimalCartObject(algoOutputIndexes, cartObject, weights, prices, totalPrice);
        return algoOutputIndexes;
    }

    public OptimalCartObject parseAlgoOutputToOptimalCartObject(ArrayList<Integer> algoOutput, CartObject cartObject, int [] weights, int [] prices, int totalPrice){
        Product product = new Product();
        ArrayList<Product> products =  new ArrayList<>();
        OptimalCartObject optimalCartObject = new OptimalCartObject();
        Integer [] indexes;
        int totalWeights = 0;

        indexes = algoOutput.stream().toArray( n -> new Integer[n]);

        for(int i = 0; i < indexes.length; i++)
        {
            product = cartObject.getProducts().get(indexes[i]);
            products.add(product);
            totalWeights += product.getWeight();
        }

        optimalCartObject.setProducts(products);
        optimalCartObject.setTotalPrice(totalPrice);
        optimalCartObject.setTotalWeights(totalWeights);

        return optimalCartObject;
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        CartObject itemsForShoppingCart = shoppingCartService.buildOptimalShoppingCart();
    }
}

