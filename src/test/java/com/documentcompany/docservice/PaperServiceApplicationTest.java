package com.documentcompany.docservice;

import com.thimbleware.jmemcached.CacheImpl;
import com.thimbleware.jmemcached.Key;
import com.thimbleware.jmemcached.LocalCacheElement;
import com.thimbleware.jmemcached.MemCacheDaemon;
import com.thimbleware.jmemcached.storage.CacheStorage;
import com.thimbleware.jmemcached.storage.hash.ConcurrentLinkedHashMap;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetSocketAddress;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaperServiceApplicationTest {

    private final MemCacheDaemon<LocalCacheElement> daemon = new MemCacheDaemon<LocalCacheElement>();

    @Before
    public void setUp() throws Exception {
        startMemcached();
    }

    @After
    public void tearDown() throws Exception {
        stopMemcached();
    }

    @Test
    public void shouldRegisterPaperResourceInRunMethod() throws Exception {

        // Given
        PaperServiceConfiguration configuration = new PaperServiceConfiguration();
        configuration.setMemcachedAddress("localhost:11211");

        JerseyEnvironment jerseyEnvironment = mock(JerseyEnvironment.class);
        Environment environment = mock(Environment.class);
        given(environment.jersey()).willReturn(jerseyEnvironment);

        // When
        new PaperServiceApplication().run(configuration, environment);

        // Then
        verify(jerseyEnvironment).register(any(PaperResource.class));
    }

    private void startMemcached() {
        CacheStorage<Key, LocalCacheElement> storage = ConcurrentLinkedHashMap.create(ConcurrentLinkedHashMap.EvictionPolicy.FIFO, 100, 1024 * 1024);
        daemon.setCache(new CacheImpl(storage));
        daemon.setBinary(false);
        daemon.setAddr(new InetSocketAddress(11211));
        daemon.setVerbose(true);
        daemon.start();
    }

    private void stopMemcached() {
        daemon.stop();
    }
}