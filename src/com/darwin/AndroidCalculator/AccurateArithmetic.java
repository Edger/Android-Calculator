package com.darwin.AndroidCalculator;

import java.math.BigDecimal;

/**
 * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精 确的浮点数运算，包括加减乘除和四舍五入�??
 */
public class AccurateArithmetic {
	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 10;

	// 这个类不能实例化
	private AccurateArithmetic() {
	}

	/**
	 * 提供精确的加法运算�??
	 * 
	 * @param operand12
	 *            被加�?
	 * @param operand22
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(String operand12, String operand22) {
		BigDecimal b1 = new BigDecimal(operand12);
		BigDecimal b2 = new BigDecimal(operand22);
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算�??
	 * 
	 * @param operand1
	 *            被减�?
	 * @param operand2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(String operand1, String operand2) {
		BigDecimal b1 = new BigDecimal(operand1);
		BigDecimal b2 = new BigDecimal(operand2);
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算�??
	 * 
	 * @param operand1
	 *            被乘�?
	 * @param operand2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(String operand1, String operand2) {
		BigDecimal b1 = new BigDecimal(operand1);
		BigDecimal b2 = new BigDecimal(operand2);
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以�?10位，以后的数字四舍五入�??
	 * 
	 * @param operand2
	 *            被除�?
	 * @param operand1
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(String operand2, String operand1) {
		return div(operand2, operand1, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算�?�当发生除不尽的情况时，由scale参数�? 定精度，以后的数字四舍五入�??
	 * 
	 * @param v1
	 *            被除�?
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示�?要精确到小数点以后几位�??
	 * @return 两个参数的商
	 */
	public static double div(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数位四舍五入处理�?
	 * 
	 * @param v
	 *            �?要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
