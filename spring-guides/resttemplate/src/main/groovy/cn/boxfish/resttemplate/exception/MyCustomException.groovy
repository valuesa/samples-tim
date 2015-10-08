package cn.boxfish.resttemplate.exception

import org.apache.commons.io.IOUtils
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.client.DefaultResponseErrorHandler
import org.springframework.web.client.ResponseErrorHandler

/**
 * Created by LuoLiBing on 15/9/30.
 */
class MyCustomException implements ResponseErrorHandler {

    private ResponseErrorHandler myErrorHandler = new DefaultResponseErrorHandler();

    @Override
    boolean hasError(ClientHttpResponse response) throws IOException {
        return myErrorHandler.hasError(response)
    }

    @Override
    void handleError(ClientHttpResponse response) throws IOException {
        String body = IOUtils.toString(response.getBody())
        throw new IOException(body)
    }
}
