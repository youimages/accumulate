package com.lazite.assist.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
	/**
	 * @Title: getClosestValue
	 * @Description: 获取最接近某个数的那个数 
	 * @param array 保证该数组长度大于1
	 * @param d 需要比较的数
	 * @return
	 * @throws: TODO
	 */
	public static double getClosestValue(double[] array,double d){
		double temp=Math.abs(array[0]-d);
		for (int i = 1; i < array.length; i++) {
			if(Math.abs(array[i]-d)<temp)
				temp=Math.abs(array[i]-d);
		}
		return temp;
	}
	
	/**
	 * @Title: getClosestValue
	 * @Description: 获取最接近某个数在数组中位置
	 * @param array 保证该数组长度大于1
	 * @param d 需要比较的数
	 * @return
	 * @throws: TODO
	 */
	public static int getClosestPosition(double[] array,double d){
		int position = 0;
		double temp=Math.abs(array[0]-d);
		for (int i = 1; i < array.length; i++) {
			if(Math.abs(array[i]-d)<temp)
				position=i;
		}
		return position;
	}
	
	/**
	 * @Title: getClosestValue
	 * @Description: 获取最接近某个数在数组中位置
	 * @param array 保证该数组长度大于1
	 * @param d 需要比较的数
	 * @return
	 * @throws: TODO
	 */
	public static Integer[] getClosestPositions(double[] array,double d){
		List<Integer> positions = new ArrayList<>();
		double temp=Math.abs(array[0]-d);
		
		for (int i = 1; i < array.length; i++) {
			if(Math.abs(array[i]-d)<temp){
				temp=Math.abs(array[i]-d);
			}
		}
		
		for (int i = 1; i < array.length; i++) {
			if(Math.abs(array[i]-d)-temp==0){
				positions.add(i);
			}
		}
		return positions.toArray(new Integer[]{});
	}
	
	/**
	 * 
	 * @Title: getClosestPositions
	 * @Description: 获取符合某个范围的某个数在数组中位置
	 * @param array
	 * @param min
	 * @param max
	 * @return
	 * @throws: TODO
	 */
	public static Integer[] getClosestPositions(double[] array,double min,double max){
		List<Integer> positions = new ArrayList<>();
		
		for (int i = 0; i < array.length; i++) {
			if(array[i]<max&&array[i]>min){
				positions.add(i);
			}
		}
		return positions.toArray(new Integer[]{});
	}
	
	/**  
     * 转换字符串数组到int数组  
     * <p>转换字符串数组到int数组</p>
     * @param strArray
     * @return int[]   
     * @throws  
     */ 
    public static Integer[] getIntArrayFromStringArray(String[] strArray){
    	if(strArray==null)
    		return null;
    	Integer[] result = new Integer[strArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.valueOf(strArray[i]);
        }
        return result;
    }
}
