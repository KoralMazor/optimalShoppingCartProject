package com.hit.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
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
    private static IDao dao = new DaoFileImpl();

    ShoppingCartService() {
    }

    public ShoppingCartService(IAlgoKnapsack algoKnapsack, IDao dao) {
        this.oneOrZeroKnapsackAlgo = new OneOrZeroKnapsackAlgoImpl();
        this.unboundedKnapsackAlgo = new UnboundedKnapsackAlgoImpl();
        this.dao = new DaoFileImpl();
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

    public List<Product> getProductsList() throws IOException {
        DaoFileImpl daoFile = new DaoFileImpl(System.getProperty("user.dir")+"\\src\\main\\resources\\"+"dataSource.json");
        List<Product> products = daoFile.read(daoFile.getFilePath());
        return products;
    }


    public OptimalCartObject buildOptimalShoppingCart(String inputUserFile) throws IOException {
       OptimalCartObject algoOutput;
       DaoFileImpl daoFile = new DaoFileImpl(System.getProperty("user.dir")+"\\src\\main\\resources\\outputOptimalCart.json");
       CartObject cartObject = daoFile.readInputUser(inputUserFile);
       algoOutput = runKnapsackAlgo(cartObject);
       daoFile.write(algoOutput);

       return algoOutput;
    }

    public OptimalCartObject runKnapsackAlgo(CartObject cartObject) {
        int totalPrice;
        String buyingOptionAlgo;
        ArrayList<Integer> algoOutputIndexes;
        int productsLength = cartObject.getProducts().size(), i = 0;
        int[] prices = new int[productsLength];
        int[] weights = new int[productsLength];
        OptimalCartObject optimalCartObject;

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
        optimalCartObject = parseAlgoOutputToOptimalCartObject(algoOutputIndexes, cartObject, totalPrice);
        return optimalCartObject;
    }

    public OptimalCartObject parseAlgoOutputToOptimalCartObject(ArrayList<Integer> algoOutput, CartObject cartObject, int totalPrice){
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

    public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException {
        ShoppingCartService shoppingCartService = new ShoppingCartService();

      //  DaoFileImpl daoFile = new DaoFileImpl("C:\\Users\\koral\\optimalShoppingCartProject\\src\\main\\resources\\outputOptimalCart.json");
      //  OptimalCartObject itemsForShoppingCart = shoppingCartService.buildOptimalShoppingCart();
       //
        //shoppingCartService.getProductsList("dataSources.txt");
       // shoppingCartService.getDao().readInputUser("C:\\Users\\koral\\optimalShoppingCartProject\\src\\main\\resources\\inputUserCart.json");
        shoppingCartService.buildOptimalShoppingCart("C:\\Users\\koral\\optimalShoppingCartProject\\src\\main\\resources\\inputUserCartUnbounded.json");



    }
}

