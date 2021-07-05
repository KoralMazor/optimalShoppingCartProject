package com.hit.service;

import com.hit.algo.OneOrZeroKnapsackAlgoImpl;
import com.hit.algo.UnboundedKnapsackAlgoImpl;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import org.junit.jupiter.api.*;
import org.testng.Assert;
import org.testng.AssertJUnit;
import com.hit.algo.OneOrZeroKnapsackAlgoImpl;
import com.hit.algo.UnboundedKnapsackAlgoImpl;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;


import java.util.ArrayList;
import java.util.Collection;


public class ShoppingCartTest {

        OneOrZeroKnapsackAlgoImpl oneOrZeroKnapsack = null;
        UnboundedKnapsackAlgoImpl unboundedKnapsack = null;

        ShoppingCartService shoppingCartService = new ShoppingCartService();
        IDao dao = new DaoFileImpl();

        private static ArrayList<Integer> resultArray = new ArrayList();
        private static final int[] v = new int[]{60, 100, 120};
        private static final int[] w = new int[]{10, 20, 30};
        private static final int n;
        private static ArrayList<Integer> unboundedResultArray;
        private static final int[] values;
        private static final int[] weights;
        private static final int length = 0;

    static {
        n = v.length;
        unboundedResultArray = new ArrayList();
        values = new int[]{30, 14, 16, 9};
        weights = new int[]{6, 3, 4, 2};
    }

        public ShoppingCartTest() {
        }

        @BeforeAll
        public static void beforeAllTest() {
            System.out.println("Runs once at the beginning of the test");
            resultArray.add(2);
            resultArray.add(1);
            unboundedResultArray.add(0);
            unboundedResultArray.add(3);
            unboundedResultArray.add(3);

        }

        @AfterAll
        public static void afterAllTest() {
            System.out.println("Runs once at the end of the test");
        }

        @BeforeEach
        public void beforeTest() {
            this.oneOrZeroKnapsack = new OneOrZeroKnapsackAlgoImpl();
            this.unboundedKnapsack = new UnboundedKnapsackAlgoImpl();
        }

        @AfterEach
        public void tearDown() {
            System.out.println("Running: tearDown");
            this.oneOrZeroKnapsack = null;
            this.unboundedKnapsack = null;
            AssertJUnit.assertNull(this.oneOrZeroKnapsack);
            AssertJUnit.assertNull(this.unboundedKnapsack);
        }

        @Test
        public void oneOrZeroKnapsackTest() {
            Assert.assertEquals(resultArray, this.oneOrZeroKnapsackBuildShoppingCart(this.oneOrZeroKnapsack, v, w, 50, n));
        }

        @Test
        public void invalidTotalWeightOneOrZeroKnapsackTest() {
            Assert.assertEquals(new ArrayList(), this.oneOrZeroKnapsackBuildShoppingCart(this.oneOrZeroKnapsack, v, w, -1, n));
            Assert.assertEquals(new ArrayList(), this.oneOrZeroKnapsackBuildShoppingCart(this.oneOrZeroKnapsack, v, w, 0, n));
        }

        @Test
        public void unboundedKnapsackTest() {
            Assert.assertEquals(unboundedResultArray, this.unboundedKnapsackBuildShoppingCart(this.unboundedKnapsack, values, weights, 10, 0));
        }

        @Test
        public void invalidTotalWeightUnboundedKnapsackTest() {
            Assert.assertEquals(new ArrayList(), this.unboundedKnapsackBuildShoppingCart(this.unboundedKnapsack, values, weights, -1, 0));
            Assert.assertEquals(new ArrayList(), this.unboundedKnapsackBuildShoppingCart(this.unboundedKnapsack, values, weights, 0, 0));
        }

        private Collection<Integer> oneOrZeroKnapsackBuildShoppingCart(OneOrZeroKnapsackAlgoImpl oneOrZeroKnapsack, int[] v, int[] w, int totalWeight, int n) {
            ArrayList<Integer> result = new ArrayList();
            oneOrZeroKnapsack.buildShoppingCart(v, w, totalWeight, n).forEach((index) -> {
                result.add(index);
            });
            return result;
        }

        private Collection<Integer> unboundedKnapsackBuildShoppingCart(UnboundedKnapsackAlgoImpl unboundedKnapsack, int[] v, int[] w, int totalWeight, int n) {
            ArrayList<Integer> result = new ArrayList();
            unboundedKnapsack.buildShoppingCart(v, w, totalWeight, n).forEach((index) -> {
                result.add(index);
            });
            return result;
        }

    }


