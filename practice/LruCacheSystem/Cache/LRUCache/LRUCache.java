package LruCacheSystem.Cache.LRUCache;

import java.util.HashMap;

import LruCacheSystem.Cache.Cache;

public class LRUCache<K,V> implements Cache<K,V> {
    public class Node {
        K key;
        V value;
        Node prev;
        Node next;
    
        Node(K key,V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private static LRUCache<?, ?> instance;
    private HashMap<K, Node> cache;

    private LRUCache(int capacity)
    {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(null,null);
        tail = new Node(null,null);
        head.next = tail;
        tail.prev = head;
    }

    @SuppressWarnings("unchecked")
    public static <K,V> LRUCache<K,V> getInstance(int capacity)
    {
        if(instance==null)
        {
            synchronized(LRUCache.class)
            {
                if(instance==null)
                {
                    instance = new LRUCache<>(capacity);
                }
            }
        }
        return (LRUCache<K, V>) instance;
    }

    @Override
    public V get(K key)
    {
        if(cache.containsKey(key))
        {
            Node node = cache.get(key);
            deleteNode(node);
            insertAtHead(node);
            return node.value;
        }
        throw new RuntimeException("Invalid cache. No value found");
    }

    @Override
    public void put(K key,V value)
    {
        if(cache.containsKey(key))
        {
            Node node = cache.get(key);
            node.value = value;
            deleteNode(node);
            insertAtHead(node);
        }
        else{
            if(cache.size()==capacity)
            {
                cache.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insertAtHead(newNode);
        }
    }

    private void deleteNode(Node node)
    {
        Node temp = node.prev;
        temp.next = node.next;
        node.next.prev = temp;
    }

    private void insertAtHead(Node node)
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
