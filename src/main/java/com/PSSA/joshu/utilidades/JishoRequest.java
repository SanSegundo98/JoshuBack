package com.PSSA.joshu.utilidades;

import lombok.Data;
import org.springframework.http.HttpMethod;

@Data
public class JishoRequest {

	private String url;
	private HttpMethod method;
}
