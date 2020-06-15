package inter.lru;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class LRUCache {

	Map<LRUKey, String> cache = null;
	int capacity = 0;
	public LRUCache(int size) {
		//We can also use TreeMap here, but using HashMap
		this.cache = new HashMap(size);
		this.capacity = size;
	}
	
	//Timestamp is only used while Purging, its not used for calculating the index in the map
	//Equals in LRUKey object, only compare Key and not the Timestamp
	public String get(String key) {
		LRUKey keyObj = new LRUKey(key);
		String value = this.cache.remove(keyObj);
		put(key, value);
		
		return value;
	}
	
	//Timestamp is only used while Purging, its not used for calculating the index in the map
	//Equals in LRUKey object, only compare Key and not the Timestamp
	public void put(String key, String value) {
		
		if(cache.size()>=capacity)
			purge();
		
		LRUKey keyObj = new LRUKey(key);
		this.cache.put(keyObj, value);
	}
	
	//Timestamp is only used while Purging
	private void purge() {
		Optional<LRUKey> lruKey = this.cache.keySet()
			.stream().min((lk1, lk2) -> lk1.timeStamp.compareTo(lk2.timeStamp));
		
		if(lruKey.isPresent())
		this.cache.remove(lruKey.get());
	}
	
	
	@Override
	public String toString() {
		return "LRUCache [cache=" + cache + "]";
	}

	private class LRUKey{
		String key;
		Timestamp timeStamp;
		
		public LRUKey(String key) {
			this.key = key;
			this.timeStamp = new Timestamp(System.currentTimeMillis());
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LRUKey other = (LRUKey) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}

		private LRUCache getEnclosingInstance() {
			return LRUCache.this;
		}

		@Override
		public String toString() {
			return "LRUKey [key=" + key + ", timeStamp=" + timeStamp + "]";
		}
	}
}

