package com.kodcu;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.annotation.*;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rahmanusta on 02.11.2015.
 */
@CacheDefaults(cacheName = "personCacher")
public class CacheBean {


    @CachePut
    public void put(@CacheKey Long id, @CacheValue Person person) {
        person.updateStatus();
    }

    @CacheResult
    public Person get(@CacheKey Long id) {
        final Person person = new Person(id);
        person.updateStatus();
        return person;
    }

    @CacheRemove
    public void invalidate(@CacheKey Long id) {

    }

    @CacheRemoveAll
    public void invalidateAll() {

    }

}
