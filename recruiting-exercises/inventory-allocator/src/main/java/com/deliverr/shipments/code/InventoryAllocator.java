package com.deliverr.shipments.code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Computes the best way an order can be shipped (called shipments) given
 * inventory across a set of warehouses (called inventory distribution) </br>
 * </br>
 * Assumptions made : </br>
 * 1. All inventory and product names are case insensitive.</br>
 * 2. The list of warehouses is pre-sorted based on cost. The first warehouse
 * will be less expensive to ship from than the second warehouse.</br>
 * 
 * 
 * @author aneesh
 *
 */
public class InventoryAllocator {

	/**
	 * Method which will process the input orders placed on inventory and
	 * compute the cheapest shipments from warehouses. </br>
	 * 
	 * @param productToInventoryListMap
	 * @param productToCountRequestOrderMap
	 * @return This method will return a map of inventory to products map from
	 *         where the shipments need to be made.
	 */
	public Map<String, List<Product>> processOrdersForCheapestShipment(
			Map<String, List<Inventory>> productToInventoryListMap,
			Map<String, Integer> productToCountRequestOrderMap) {

		Map<String, List<Product>> cheapestInventoryToProductShipmentResultMap = new LinkedHashMap<>();

		// Checking base conditions if the inventory map or request order list
		// is null or empty
		if (productToInventoryListMap == null || productToInventoryListMap.isEmpty()
				|| productToCountRequestOrderMap == null || productToCountRequestOrderMap.isEmpty()) {
			return cheapestInventoryToProductShipmentResultMap;
		}

		for (Entry<String, Integer> entrySet : productToCountRequestOrderMap.entrySet()) {

			String productName = entrySet.getKey();
			Integer requestedQuantity = entrySet.getValue();

			// Skip to process the request if the product name or requested
			// quantity is null
			if (productName == null || requestedQuantity == null || requestedQuantity == 0) {
				System.out.println(
						"Product name cannot be null and request quantity cannot be null or zero so skipping...");
				continue;
			}

			// Fetch the products and its inventory
			List<Inventory> productInventoryList = productToInventoryListMap.get(productName.toLowerCase());

			if (productInventoryList != null) {
				// process each inventory and find the products from the
				// inventories and add to the result
				for (Inventory inventory : productInventoryList) {

					// If items count in the inventory is less than one then no
					// need to process further.
					if (inventory.getItemCount() < 1) {
						continue;
					}

					List<Product> inventoryProductList = cheapestInventoryToProductShipmentResultMap
							.get(inventory.getName().toLowerCase());

					if (inventoryProductList == null) {
						inventoryProductList = new LinkedList<Product>();
						cheapestInventoryToProductShipmentResultMap.put(inventory.getName().toLowerCase(),
								inventoryProductList);
					}

					if (requestedQuantity > inventory.getItemCount()) {
						requestedQuantity -= inventory.getItemCount();
						inventoryProductList.add(new Product(productName.toLowerCase(), inventory.getItemCount()));
						inventory.setItemCount(0);
					} else {
						inventory.setItemCount(inventory.getItemCount() - requestedQuantity);
						inventoryProductList.add(new Product(productName.toLowerCase(), requestedQuantity));
						requestedQuantity = 0;
						break;
					}
				}
			}
		}
		return cheapestInventoryToProductShipmentResultMap;
	}

	/**
	 * Add Inventory to a product map
	 * 
	 * @param productToInventoryMap
	 * @param productName
	 * @param inventoryName
	 * @param count
	 */
	public void addInventoryToProductMap(String productName, String inventoryName, int count,
			Map<String, List<Inventory>> productToInventoryMap) {

		if (productName == null || productName.trim().isEmpty() || inventoryName == null
				|| inventoryName.trim().isEmpty()) {
			return;
		}

		if (productToInventoryMap == null) {
			productToInventoryMap = new HashMap<String, List<Inventory>>();
		}

		// Add an inventory to the product map or increment the count if already
		// part of the inventory
		List<Inventory> inventoryList = productToInventoryMap.get(productName.toLowerCase());
		if (inventoryList == null) {
			inventoryList = new LinkedList<Inventory>();
			productToInventoryMap.put(productName.toLowerCase(), inventoryList);
		}
		Inventory inventory = this.getInventoryFromList(inventoryName, inventoryList);
		if (inventory != null) {
			inventory.setItemCount(inventory.getItemCount() + count);
		}
	}

	/**
	 * Returns an existing inventory from the list, if found. If no inventory is
	 * found, then adds a new inventory with zero item counts to the list and
	 * returns it.
	 * 
	 * @param inventoryName
	 * @param inventoryList
	 * @return
	 */
	private Inventory getInventoryFromList(String inventoryName, List<Inventory> inventoryList) {
		Inventory result = null;
		for (Inventory inventory : inventoryList) {
			if (inventory.getName().equalsIgnoreCase(inventoryName)) {
				result = inventory;
				break;
			}
		}
		if (result == null) {
			result = new Inventory(inventoryName.toLowerCase(), 0);
			inventoryList.add(result);
		}
		return result;
	}
}
