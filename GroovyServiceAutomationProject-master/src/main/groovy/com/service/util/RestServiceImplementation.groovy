package com.service.util

import groovy.json.JsonBuilder;
import groovy.util.logging.Log4j;
import groovyx.net.http.ContentType;
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient

@Log4j
class RestServiceImplementation {

	/**
	 * Class Variables
	 */
	private def response
	private JsonBuilder jsonBuilder;
	private def restClient

	public RestServiceImplementation(String defaultURI){
		try {
			restClient = new RESTClient(defaultURI)
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}


	/**
	 * Data Builder Function to Build the JSON Data
	 * @return JSON Object
	 */
	public def getRandomJSONObject(Object jsonMap){
		try {
			return new JsonBuilder(jsonMap).toPrettyString()
		}
		catch(Exception e){
			e.printStackTrace()
			return null;
		}
	}


	/**
	 * This method gets the JSON response on the REST POST call.
	 *
	 * @param jsonInput
	 * @return JSON Response
	 */
	public def getRestPOSTResponse(jsonInput,resourceName) {
		try{
			log.info("URI = " + restClient.defaultURI + resourceName)
			
			def resp = restClient.post( path: resourceName,
			body: jsonInput,
			requestContentType:ContentType.JSON )
			response = resp.responseData
			return resp.responseData
		}
		catch(Exception e){
			e.printStackTrace()
			throw e
		}
		return null;
	}

	/**
	 * This method returns the GET Rest response for the given input ID.
	 *
	 * @param inputSet
	 * @return JSON Response
	 */
	public def getRESTResponse(resourceName) {
		try{
			log.info("URI = " + restClient.defaultURI + resourceName)
			
			def resp = restClient.get(path : resourceName)
			return resp
		}
		catch(Exception e){
			e.printStackTrace()
			throw e
		}
		return null
	}

	/**
	 * 
	 * @param resourceName
	 * @param queryMap
	 * @return
	 */
	public def getRESTResponse(resourceName,queryMap) {
		try{
			log.info("URI = " + restClient.defaultURI + resourceName)
			
			def resp = restClient.get( path : resourceName, query: queryMap)
			return resp
		}
		catch(Exception e){
			e.printStackTrace()
			throw e
		}
		return null
	}


	/**
	 * This method is used to get the response code for PUT Rest request.
	 *
	 * @param jsonInput
	 * @param inputSet
	 * @return JSON Response
	 */
	public def getRestPUTResponse(jsonInput,resourceName) {
		try{
			log.info("URI = " + restClient.defaultURI + resourceName)

			def resp = restClient.put( path: resourceName,
			body: jsonInput,
			requestContentType:ContentType.JSON )
			return resp.responseData
		}
		catch(Exception e){
			e.printStackTrace()
			throw e
		}
		return null
	}


	/**
	 * This method is used to get the response code for PUT Rest request.
	 *
	 * @param jsonInput
	 * @param inputSet
	 * @return JSON Response
	 */
	public def getRestPUTResponse(resourceName) {
		try{
			log.info("URI = " + restClient.defaultURI + resourceName)
			
			def resp = restClient.put( path: resourceName)
			return resp.responseData
		}
		catch(Exception e){
			e.printStackTrace()
			throw e
		}
		return null;
	}

	/**
	 * This method is used to get the response code for DELETE Rest request.
	 *
	 * @param inputSet
	 * @return JSON Response
	 */
	public def getRestDeleteResponse(resourceName) {
		try{
			log.info("URI = " + restClient.defaultURI + resourceName)
			
			def resp = restClient.delete( path: resourceName)
			return resp
		}
		catch(Exception e){
			e.printStackTrace()
			throw e
		}
		return null;
	}
}
