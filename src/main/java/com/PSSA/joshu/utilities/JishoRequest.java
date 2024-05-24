package com.PSSA.joshu.utilities;

import lombok.Data;
import org.springframework.http.HttpMethod;

@Data
public class JishoRequest {

	private String url;
	private HttpMethod method;
}
