package com.documentcompany.docservice;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PaperResourceTest {

    @Test
    public void shouldReturnSensibleString() throws Exception {

        // Given

        // When
        String page = new PaperResource().getPage("page", "size", "zoomFactor");

        // Then
        assertThat(page).isEqualTo("Some page text");
    }

}