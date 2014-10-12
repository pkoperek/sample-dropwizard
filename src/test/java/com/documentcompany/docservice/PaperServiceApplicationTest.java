package com.documentcompany.docservice;

import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaperServiceApplicationTest {

    @Test
    public void shouldRegisterPaperResourceInRunMethod() throws Exception {

        // Given
        PaperServiceConfiguration configuration = new PaperServiceConfiguration();
        JerseyEnvironment jerseyEnvironment = mock(JerseyEnvironment.class);
        Environment environment = mock(Environment.class);
        given(environment.jersey()).willReturn(jerseyEnvironment);

        // When
        new PaperServiceApplication().run(configuration, environment);

        // Then
        verify(jerseyEnvironment).register(any(PaperResource.class));
    }
}