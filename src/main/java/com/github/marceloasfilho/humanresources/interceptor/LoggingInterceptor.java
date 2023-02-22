package com.github.marceloasfilho.humanresources.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        this.logRequest(request, body);
        Long tempoInicial = System.currentTimeMillis();
        ClientHttpResponse response = execution.execute(request, body);
        this.logResponse(response, tempoInicial);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) {
        log.debug("===========================[Request Begin]================================================");
        log.debug("URI         : {}", request.getURI());
        log.debug("Method      : {}", request.getMethod());
        log.debug("Headers     : {}", request.getHeaders());
        log.debug("Request body: {}", new String(body, StandardCharsets.UTF_8));
        log.debug("==========================[Request End]================================================");
    }

    private void logResponse(ClientHttpResponse response, Long tempoInicial) throws IOException {
        Long responseTime = System.currentTimeMillis() - tempoInicial;
        log.debug("============================[Response Begin]==========================================");
        log.debug("Status code  : {}", response.getStatusCode());
        log.debug("Status text  : {}", response.getStatusText());
        log.debug("Headers      : {}", response.getHeaders());
        log.debug("Response time: {}", responseTime);
        log.debug("Response body: {}", StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8));
        log.debug("=======================[Response End]=================================================");
    }
}
