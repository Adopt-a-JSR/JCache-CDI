package com.kodcu;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

/**
 * Created by rahmanusta on 02.11.2015.
 */
public class App {

    @Inject
    private CacheBean cacheBean;

    public static void main(String[] args) throws Exception {

        CDI<Object> cdi = CDI.getCDIProvider().initialize();
        final App app = cdi.select(App.class).get();

        final CacheBean cacheBean = app.cacheBean;

        print("Put first object in cache");

        // Put cahce id:1,name:Rahman Usta
        cacheBean.put(1L, new Person(1L));

        // Get id:1
        final Person p1 = cacheBean.get(1L);
        print(p1);
        // Get id:1
        final Person p2 = cacheBean.get(1L);
        print(p2);
        // Get id:1
        final Person p3 = cacheBean.get(1L);
        print(p3);

        print("\n******\n");

        print("Put second object in cache");
        cacheBean.put(2L, new Person(2L));

        // Get id:2
        final Person p4 = cacheBean.get(2L);
        print(p4);
        // Get id:2
        final Person p5 = cacheBean.get(2L);
        print(p5);

        print("\n******\n");

        // Invalidate one
        print("Invalidate first object in cache");
        cacheBean.invalidate(1L);

        print(cacheBean.get(1L));
        print(cacheBean.get(2L));

        print("\n******\n");

        // Invalidate all
        print("Invalidate all in cache");
        cacheBean.invalidateAll();

        print(cacheBean.get(1L));
        print(cacheBean.get(2L));

    }


    private static void print(Object object) {
        System.out.println(object);
    }

}
