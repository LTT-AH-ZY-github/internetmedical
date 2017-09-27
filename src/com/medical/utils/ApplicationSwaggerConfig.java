package com.medical.utils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;

import com.mangofactory.swagger.models.dto.ApiInfo;

import com.mangofactory.swagger.plugin.EnableSwagger;

import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration

@EnableSwagger

@EnableWebMvc

public class ApplicationSwaggerConfig {

	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * 
	 * Required to autowire SpringSwaggerConfig
	 * 
	 */

	@Autowired

	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {

		this.springSwaggerConfig = springSwaggerConfig;

	}

	/**
	 * 
	 * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
	 * 
	 * framework - allowing for multiple swagger groups i.e. same code base
	 * 
	 * multiple swagger resource listings.
	 * 
	 */

	@Bean

	public SwaggerSpringMvcPlugin customImplementation() {

		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?");

	}

	private ApiInfo apiInfo() {

		ApiInfo apiInfo = new ApiInfo(

				"ums接口文档",

				"这里是所有的ums接口，里边含有说明，请自行测试",

				"My Apps API terms of service",

				"My Apps API Contact Email",

				"My Apps API Licence Type",

				"My Apps API License URL");

		return apiInfo;

	}

}