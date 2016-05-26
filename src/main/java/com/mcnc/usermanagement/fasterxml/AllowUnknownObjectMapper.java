package com.mcnc.usermanagement.fasterxml;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AllowUnknownObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -8641555460118610255L;

	public AllowUnknownObjectMapper() {
		super();
		disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}
}
