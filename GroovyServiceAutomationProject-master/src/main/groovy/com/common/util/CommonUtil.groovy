package com.common.util

import java.math.RoundingMode

import com.relevantcodes.extentreports.ExtentTest;

class CommonUtil {
	
	/**
	 *
	 * @param object1
	 * @param object2
	 * @param assertInfo
	 * @param message
	 * @return
	 */
	
	public static compare(message,object1,object2,assertInfo){
		
		if (object1 != null){
			if(object2 != null) {
				assertInfo.assertThat(object1).as(message).isEqualTo(object2)
			} else {
				assertInfo.assertThat(object1).as(message).isEqualTo(object2)
			}
		} else { if(object2 == null) {
				assertInfo.assertThat(object1).as(message).isEqualTo(object2)
			}else{
				assertInfo.assertThat(object1).as(message).isEqualTo(object2)
			}
		}
		return true
	}
	
	/**
	 *
	 * @param message
	 * @param serviceValue
	 * @param dbValue
	 * @param assertInfo
	 * @return
	 */
	static def comparePrice(message,serviceValue,dbValue,assertInfo){
		def obj1 , obj2;
		obj1 = CommonUtil.convertBigDecimalToFourDecimals(serviceValue);
		obj2 = CommonUtil.convertBigDecimalToFourDecimals(dbValue);
		compare(message,obj1,obj2,assertInfo)
	}

	/**
	 * genarateRandomNumber
	 * @return
	 */
	static Integer genarateRandomNumber(){
		int range = (900000000 - 100000000) + 1;
		return (int)(Math.random() * range) + 100000000;
	}
	
	
	/**
	 * convertBigDecimalToFourDecimals
	 * This method will round and convert to BigDecimal
	 * @param input
	 */
	public static BigDecimal convertBigDecimalToFourDecimals(BigDecimal input) {
		if(input == null) {
			return null;
		}
		else {
			return new BigDecimal(input.doubleValue())
			.setScale(2, RoundingMode.HALF_UP);
		}
	}

	/**
	 * convertBigDecimalToFourDecimals
	 * This method will round and convert to BigDecimal
	 * @param input
	 */
	public static BigDecimal convertBigDecimalToFourDecimals(Double input) {
		if(input == null) {
			return null;
		}
		else {
			
			return new BigDecimal(input)
			.setScale(2,  RoundingMode.HALF_UP)
		}
	}

	/**
	 * getTimeDate
	 * @return
	 */
	public static String getTimeDate(){
		Calendar cal=Calendar.getInstance();
		def hour = cal.get(Calendar.HOUR_OF_DAY)
		def min = cal.get(Calendar.MINUTE)
		def sec = cal.get(Calendar.SECOND)
		def timeNDate = hour+min+sec
		return timeNDate
	}
	
	/**
	 * This method will do tolerance what ever user entered value
	 * @param num1
	 * @param num2
	 * @param tolerance
	 * @return isWithinTolerance
	 */
	public static Boolean withinTolerance(num1, num2, tolerance) {
		if(num1 !=null && num2 ==null){
			num2 = 0.0
		} else if (num1 ==null && num2 !=null){
			num1 = 0.0
		}
		  def isWithinTolerance = Math.abs(num1.toBigDecimal()-num2.toBigDecimal()) <= tolerance
		  return isWithinTolerance
	 }
	

}
