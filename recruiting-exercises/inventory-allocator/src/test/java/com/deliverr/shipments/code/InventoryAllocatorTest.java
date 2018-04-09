package com.deliverr.shipments.code;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * Class which tests the InventoryAllocator code. This tests uses JUnit library.
 * 
 * @author aneesh
 *
 */
public class InventoryAllocatorTest {

	/**
	 * This test case will check if the inputs are case insensitive or not
	 */
	@Test
	public void testToCheckCaseInSensitivity() {
		Map<String, List<Inventory>> inventoryList = new HashMap<>();

		InventoryAllocator inventoryAllocator = new InventoryAllocator();

		inventoryAllocator.addInventoryToProductMap("apple", "OWD", 5, inventoryList);
		inventoryAllocator.addInventoryToProductMap("APPLE", "dm", 5, inventoryList);

		// We will use linked hash map as the input for each of the order placed
		// to maintain the order of the input
		Map<String, Integer> inputOrderPlaced = new HashMap<String, Integer>();
		inputOrderPlaced.put("aPple", 10);

		Map<String, List<Product>> cheapestShipmentInventoryToProductResultMap = inventoryAllocator
				.processOrdersForCheapestShipment(inventoryList, inputOrderPlaced);

		assertTrue("Result size cannot be null or empty as the inventory has enough products",
				(cheapestShipmentInventoryToProductResultMap != null
						&& cheapestShipmentInventoryToProductResultMap.size() > 0));

		for (Entry<String, List<Product>> entry : cheapestShipmentInventoryToProductResultMap.entrySet()) {
			String inventoryName = entry.getKey();
			List<Product> productList = entry.getValue();
			if (inventoryName.equals("owd")) {
				for (Product product : productList) {
					if (product.getName().equals("apple")) {
						int count = product.getCount();
						assertTrue(
								"Test Failed as the count of apples processed from owd inventory is not as expected.",
								count == 5);
					} else {
						fail("Result must contain all lower case products");
					}
				}
			} else if (inventoryName.equals("dm")) {
				for (Product product : productList) {
					if (product.getName().equals("apple")) {
						int count = product.getCount();
						assertTrue("Test Failed as the count of apples processed from dm inventory is not as expected.",
								count == 5);
					} else {
						fail("Result must contain all lower case products");
					}
				}
			} else {
				fail("Unexpected inventory returned");
			}
		}

	}

	/**
	 * Test to check only one product and one inventory. Do not need this test
	 */
	@Test
	public void testToCheckOnlyOneProductAndOneInventory() {
		Map<String, List<Inventory>> inventoryList = new HashMap<>();

		InventoryAllocator inventoryAllocator = new InventoryAllocator();

		inventoryAllocator.addInventoryToProductMap("aPPle", "owd", 1, inventoryList);

		// We will use linked hash map as the input for each of the order placed
		// to maintain the order of the input
		Map<String, Integer> inputOrderPlaced = new HashMap<String, Integer>();
		inputOrderPlaced.put("apple", 1);

		Map<String, List<Product>> cheapestShipmentInventoryToProductResultMap = inventoryAllocator
				.processOrdersForCheapestShipment(inventoryList, inputOrderPlaced);

		assertTrue("Result size cannot be null or empty as the inventory has enough products",
				(cheapestShipmentInventoryToProductResultMap != null
						&& cheapestShipmentInventoryToProductResultMap.size() > 0));

		for (Entry<String, List<Product>> entry : cheapestShipmentInventoryToProductResultMap.entrySet()) {
			String inventoryName = entry.getKey();
			List<Product> productList = entry.getValue();
			if (inventoryName.equals("owd")) {
				for (Product product : productList) {
					if (product.getName().equals("apple")) {
						int count = product.getCount();
						assertTrue(
								"Test Failed as the count of apples processed from owd inventory is not as expected.",
								count == 1);
					}
				}
			} else {
				fail("Unexpected inventory returned");
			}
		}
	}

	/**
	 * Test to check zero orders being placed
	 */
	@Test
	public void testToCheckZeroOrdersRequestFromInventory() {
		Map<String, List<Inventory>> inventoryList = new HashMap<>();

		InventoryAllocator inventoryAllocator = new InventoryAllocator();

		inventoryAllocator.addInventoryToProductMap("aPPle", "owd", 1, inventoryList);

		// We will use linked hash map as the input for each of the order placed
		// to maintain the order of the input
		Map<String, Integer> inputOrderPlaced = new HashMap<String, Integer>();
		inputOrderPlaced.put("apple", 0);

		Map<String, List<Product>> cheapestShipmentInventoryToProductResultMap = inventoryAllocator
				.processOrdersForCheapestShipment(inventoryList, inputOrderPlaced);

		assertTrue("Result size cannot be null or empty as the inventory has enough products",
				(cheapestShipmentInventoryToProductResultMap != null
						&& cheapestShipmentInventoryToProductResultMap.isEmpty()));

	}

	/**
	 * Test to check invalid or non existent orders being placed
	 */
	@Test
	public void testToCheckInvalidOrNonExistentOrdersBeingPlacedFromInventory() {
		Map<String, List<Inventory>> inventoryList = new HashMap<>();

		InventoryAllocator inventoryAllocator = new InventoryAllocator();

		inventoryAllocator.addInventoryToProductMap("apple", "owd", 1, inventoryList);

		// We will use linked hash map as the input for each of the order placed
		// to maintain the order of the input
		Map<String, Integer> inputOrderPlaced = new HashMap<String, Integer>();
		inputOrderPlaced.put("ple", 0);
		inputOrderPlaced.put("banana", 0);

		Map<String, List<Product>> cheapestShipmentInventoryToProductResultMap = inventoryAllocator
				.processOrdersForCheapestShipment(inventoryList, inputOrderPlaced);

		assertTrue("Result size cannot be null or empty as the inventory has enough products",
				(cheapestShipmentInventoryToProductResultMap != null
						&& cheapestShipmentInventoryToProductResultMap.isEmpty()));

	}

	/**
	 * Test to check when there are zero products in an inventory but the input
	 * order placed is requesting more products to be shipped
	 */
	@Test
	public void testToCheckZeroProductsInAnInventoryButInputOrderIsRequesting() {
		Map<String, List<Inventory>> inventoryList = new HashMap<>();

		InventoryAllocator inventoryAllocator = new InventoryAllocator();

		inventoryAllocator.addInventoryToProductMap("apple", "owd", 0, inventoryList);

		// We will use linked hash map as the input for each of the order placed
		// to maintain the order of the input
		Map<String, Integer> inputOrderPlaced = new HashMap<String, Integer>();
		inputOrderPlaced.put("apple", 1);

		Map<String, List<Product>> cheapestShipmentInventoryToProductResultMap = inventoryAllocator
				.processOrdersForCheapestShipment(inventoryList, inputOrderPlaced);

		assertTrue("Result size cannot be null or empty as the inventory has enough products",
				(cheapestShipmentInventoryToProductResultMap != null
						&& cheapestShipmentInventoryToProductResultMap.isEmpty()));
	}

	/**
	 * Test to check if adding the same product to the same inventory updates
	 * the existing inventory count.
	 */
	@Test
	public void testToCheckIfAddingTheSameProductToTheSameInventoryUpdatesExistingInventoryCount() {

		InventoryAllocator inventoryAllocator = new InventoryAllocator();

		Map<String, List<Inventory>> productToInventoryListMap = new HashMap<>();
		// You can add the same product to the same inventory multiple times.
		inventoryAllocator.addInventoryToProductMap("apple", "owd", 1, productToInventoryListMap);
		inventoryAllocator.addInventoryToProductMap("apple", "owd", 2, productToInventoryListMap);

		// We will use linked hash map as the input for each of the order placed
		// to maintain the order of the input
		Map<String, Integer> inputOrderPlaced = new HashMap<String, Integer>();
		inputOrderPlaced.put("apple", 1);

		Map<String, List<Product>> cheapestShipmentInventoryToProductResultMap = inventoryAllocator
				.processOrdersForCheapestShipment(productToInventoryListMap, inputOrderPlaced);

		assertTrue("Result size cannot be null or empty as the inventory has enough products",
				(cheapestShipmentInventoryToProductResultMap != null
						&& cheapestShipmentInventoryToProductResultMap.size() > 0));

		// Test left out inventory products count
		for (Entry<String, List<Inventory>> entry : productToInventoryListMap.entrySet()) {
			String productName = entry.getKey();
			List<Inventory> inventoryList = entry.getValue();

			if (productName.equals("apple")) {
				for (Inventory inventory : inventoryList) {
					if (inventory.getName().equals("owd")) {
						int count = inventory.getItemCount();
						assertTrue(
								"Test Failed as the count of apples processed from owd inventory is not as expected.",
								count == 2);
					} else {
						fail("apple is only available from owd inventory");
					}
				}
			}

		}

	}

	/**
	 * Test to check base conditions null input orders
	 */
	@Test
	public void testToCheckNullInputOrderPlacement() {
		Map<String, List<Inventory>> inventoryList = new HashMap<>();

		InventoryAllocator inventoryAllocator = new InventoryAllocator();

		// You can add the same product to the same inventory multiple times.
		inventoryAllocator.addInventoryToProductMap("apple", "owd", 5, inventoryList);
		inventoryAllocator.addInventoryToProductMap("orange", "owd", 10, inventoryList);

		inventoryAllocator.addInventoryToProductMap("banana", "dm", 5, inventoryList);
		inventoryAllocator.addInventoryToProductMap("orange", "dm", 10, inventoryList);

		// We will use linked hash map as the input for each of the order placed
		// to maintain the order of the input
		Map<String, Integer> inputOrderPlaced = null;

		Map<String, List<Product>> cheapestShipmentInventoryToProductResultMap = inventoryAllocator
				.processOrdersForCheapestShipment(inventoryList, inputOrderPlaced);

		assertTrue("Result size cannot be null or empty as the inventory has enough products",
				(cheapestShipmentInventoryToProductResultMap != null
						&& cheapestShipmentInventoryToProductResultMap.isEmpty()));
	}

	/**
	 * Test to check base condition when inventory is empty.
	 */
	@Test
	public void testNullInventory() {

		InventoryAllocator inventoryAllocator = new InventoryAllocator();

		Map<String, List<Inventory>> inventoryList = null;

		// We will use linked hash map as the input for each of the order placed
		// to maintain the order of the input
		Map<String, Integer> inputOrderPlaced = new LinkedHashMap<String, Integer>();
		inputOrderPlaced.put("apple", 5);
		inputOrderPlaced.put("banana", 5);
		inputOrderPlaced.put("orange", 5);

		Map<String, List<Product>> cheapestShipmentInventoryToProductResultMap = inventoryAllocator
				.processOrdersForCheapestShipment(inventoryList, inputOrderPlaced);

		assertTrue("Result size cannot be null or empty as the inventory has enough products",
				(cheapestShipmentInventoryToProductResultMap != null
						&& cheapestShipmentInventoryToProductResultMap.isEmpty()));
	}

	/**
	 * Test to check order being shipped from different inventories and also
	 * check both the leftout products in the inventory and orders shipped from
	 * inventories.
	 */
	@Test
	public void testToCheckOrdersBeingShippedFromDifferentInventoriesAndCheckLeftOutProductsInTheInventory() {
		Map<String, List<Inventory>> productToInventoryListMap = new HashMap<>();

		InventoryAllocator inventoryAllocator = new InventoryAllocator();

		// You can add the same product to the same inventory multiple times.
		inventoryAllocator.addInventoryToProductMap("apple", "owd", 5, productToInventoryListMap);
		inventoryAllocator.addInventoryToProductMap("orange", "owd", 10, productToInventoryListMap);

		inventoryAllocator.addInventoryToProductMap("banana", "dm", 5, productToInventoryListMap);
		inventoryAllocator.addInventoryToProductMap("orange", "dm", 10, productToInventoryListMap);

		// We will use linked hash map as the input for each of the order placed
		// to maintain the order of the input
		Map<String, Integer> inputOrderPlaced = new LinkedHashMap<String, Integer>();
		inputOrderPlaced.put("apple", 5);
		inputOrderPlaced.put("banana", 5);
		inputOrderPlaced.put("orange", 15);

		Map<String, List<Product>> cheapestShipmentInventoryToProductResultMap = inventoryAllocator
				.processOrdersForCheapestShipment(productToInventoryListMap, inputOrderPlaced);

		assertTrue("Result size cannot be null or empty as the inventory has enough products",
				(cheapestShipmentInventoryToProductResultMap != null
						&& cheapestShipmentInventoryToProductResultMap.size() > 1));

		// Test left out inventory products count
		for (Entry<String, List<Inventory>> entry : productToInventoryListMap.entrySet()) {
			String productName = entry.getKey();
			List<Inventory> inventoryList = entry.getValue();

			if (productName.equals("apple")) {
				for (Inventory inventory : inventoryList) {
					if (inventory.getName().equals("owd")) {
						int count = inventory.getItemCount();
						assertTrue(
								"Test Failed as the count of apples processed from owd inventory is not as expected.",
								count == 0);
					} else {
						fail("apple is only available from owd inventory");
					}
				}
			} else if (productName.equals("banana")) {
				for (Inventory inventory : inventoryList) {
					if (inventory.getName().equals("dm")) {
						int count = inventory.getItemCount();
						assertTrue(
								"Test Failed as the count of banana processed from owd inventory is not as expected.",
								count == 0);
					} else {
						fail("banana is only available from owd inventory");
					}
				}
			} else if (productName.equals("orange")) {
				for (Inventory inventory : inventoryList) {
					if (inventory.getName().equals("owd")) {
						int count = inventory.getItemCount();
						assertTrue(
								"Test Failed as the count of oranges processed from owd inventory is not as expected.",
								count == 0);
					} else if (inventory.getName().equals("dm")) {
						int count = inventory.getItemCount();
						assertTrue(
								"Test Failed as the count of oranges processed from dm inventory is not as expected.",
								count == 5);
					} else {
						fail("orange is only available from either owd or dm inventory");
					}
				}
			}

		}

		// Test the result shipment
		for (Entry<String, List<Product>> entry : cheapestShipmentInventoryToProductResultMap.entrySet()) {
			String inventoryName = entry.getKey();
			List<Product> productList = entry.getValue();
			if (inventoryName.equals("owd")) {
				for (Product product : productList) {
					if (product.getName().equals("apple")) {
						int count = product.getCount();
						assertTrue(
								"Test Failed as the count of apples processed from owd inventory is not as expected.",
								count == 5);
					} else if (product.getName().equals("orange")) {
						int count = product.getCount();
						assertTrue(
								"Test Failed as the count of apples processed from owd inventory is not as expected.",
								count == 10);
					}
				}
			} else if (inventoryName.equals("dm")) {
				for (Product product : productList) {
					if (product.getName().equals("banana")) {
						int count = product.getCount();
						assertTrue("Test Failed as the count of apples processed from dm inventory is not as expected.",
								count == 5);
					} else if (product.getName().equals("orange")) {
						int count = product.getCount();
						assertTrue("Test Failed as the count of apples processed from dm inventory is not as expected.",
								count == 5);
					}
				}
			} else {
				fail("Unexpected inventory returned");
			}
		}
	}
}
