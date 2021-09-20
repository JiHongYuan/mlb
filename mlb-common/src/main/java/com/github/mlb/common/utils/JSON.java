package com.github.mlb.common.utils;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.mlb.common.exception.JsonProcessingRunTimeException;

import java.io.StringWriter;
import java.text.SimpleDateFormat;

/**
 * @author jihongyuan
 * @date 2020/7/13 15:48
 */
public class JSON {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final XmlMapper XML_MAPPER = new XmlMapper();

	private JSON() {
	}

	static {
		OBJECT_MAPPER
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
				.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}

	public static String toJSONString(Object object) {
		try {
			return OBJECT_MAPPER.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new JsonProcessingRunTimeException(e);
		}
	}

	public static <T> T parseObject(String text, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(text, clazz);
		} catch (JsonProcessingException e) {
			throw new JsonProcessingRunTimeException(e);
		}
	}

	public static String convertXmlToJson(String xml) {
		StringWriter w = new StringWriter();
		try (JsonParser jp = XML_MAPPER.getFactory().createParser(xml);
			 JsonGenerator jg = OBJECT_MAPPER.getFactory().createGenerator(w);) {

			while (jp.nextToken() != null) {
				jg.copyCurrentEvent(jp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return w.toString();
	}


	public static ObjectMapper builderMapper() {
		return OBJECT_MAPPER;
	}

	public static boolean isJSON(String text) {
		try {
			toJSONString(text);
			return true;
		} catch (JsonProcessingRunTimeException e) {
			return false;
		}
	}

}
