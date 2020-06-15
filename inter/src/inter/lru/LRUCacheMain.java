package inter.lru;

public class LRUCacheMain {

	public static void main(String[] args) throws InterruptedException {

		LRUCache cache = new LRUCache(4);
		cache.put("key-1", "Java");
		cache.put("key-2", "Python");
		cache.put("key-3", "C");
		cache.put("key-4", "C++");
		
		Thread.sleep(10*1000);
		
		cache.put("key-2", "Python");
		cache.put("key-3", "C");
		cache.put("key-4", "C++");
		
		cache.put("key-5", "Ruby");
		cache.put("key-6", "Ruby");
		
		System.out.println(cache);
	}
}
