package enoca.javaChallenge.shoppingCart.core.shared;

import org.springframework.http.HttpStatusCode;

import lombok.Data;

@Data
public class Response<T> {

	protected T data;
	protected String message;
	protected HttpStatusCode statusCode;
}
