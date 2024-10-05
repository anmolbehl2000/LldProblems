public class CacheFactory {
    public enum CacheSystemType {
        LRU
    }

    public static <K,V> Cache<K,V> createCache(CacheSystemType type, int capacity)
    {
        switch(type) {
            case LRU:
                return LRUCache.getInstance(capacity);
            default:
                throw new IllegalArgumentException("Illegal eviction type");
        }
    }
}
