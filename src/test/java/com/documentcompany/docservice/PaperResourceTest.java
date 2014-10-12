package com.documentcompany.docservice;

import net.spy.memcached.MemcachedClient;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PaperResourceTest {

    private final MemcachedClient memcachedClient = mock(MemcachedClient.class);

    @Test
    public void shouldReturnMemcacheCachedPage() throws Exception {

        // Given
        String cached = "cached page";

        String page = "p1";
        String size = "A4";
        String zoomFactor = "1.4";

        given(memcachedClient.get(page + size + zoomFactor)).willReturn(cached);

        // When
        String pageContent = getPage(page, size, zoomFactor);

        // Then
        assertThat(pageContent).isEqualTo(cached);
    }

    @Test
    public void shouldReturnSensibleString() throws Exception {

        // Given

        // When
        String page = getPage("page", "size", "zoomFactor");

        // Then
        assertThat(page).isEqualTo("Some page text");
    }

    private String getPage(String page, String size, String zoomFactor) {
        return new PaperResource(memcachedClient).getPage(page, size, zoomFactor);
    }

}