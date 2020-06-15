package inter.lruCache;

public class LRUCacheMain {

	public static void main(String[] args) throws InterruptedException {

		LRUCache cache = new LRUCache(4);
		cache.put("key-1", "Java");
		cache.put("key-2", "Python");
		cache.put("key-3", "C");
		cache.put("key-4", "C++");
		
		Thread.sleep(3*1000);
		
		cache.get("key-2");
		cache.get("key-3");
		cache.get("key-4");
		
		cache.put("key-5", "Ruby");
		cache.put("key-6", "Ruby");
		
		System.out.println("Printing complete cache");
		System.out.println(cache);
		
		System.out.println("\n \nKeys present in the cache");
        System.out.println(cache.getKeys());
	}
}
