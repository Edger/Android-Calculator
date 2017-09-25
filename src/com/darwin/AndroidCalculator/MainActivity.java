package com.darwin.AndroidCalculator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

import com.darwin.androidlayoutproject.R;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	String str = "";
	TextView textView;
	Context context = MainActivity.this;
	Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9,
			button_ac, button_dot, button_equal, button_percent, button_delete, button_plus, button_minus,
			button_multiply, button_by;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();

		if (str.isEmpty()) {
			str = "0";
			Display(str);
		}

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			Window window = getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}

		MIUISetStatusBarLightMode(this.getWindow(), true);
		FlymeSetStatusBarLightMode(this.getWindow(), true);
	}

	public void initView() {
		textView = (TextView) findViewById(R.id.textView);
		textView.setMovementMethod(ScrollingMovementMethod.getInstance());
		button_0 = (Button) findViewById(R.id.button_0);
		button_1 = (Button) findViewById(R.id.button_1);
		button_2 = (Button) findViewById(R.id.button_2);
		button_3 = (Button) findViewById(R.id.button_3);
		button_4 = (Button) findViewById(R.id.button_4);
		button_5 = (Button) findViewById(R.id.button_5);
		button_6 = (Button) findViewById(R.id.button_6);
		button_7 = (Button) findViewById(R.id.button_7);
		button_8 = (Button) findViewById(R.id.button_8);
		button_9 = (Button) findViewById(R.id.button_9);
		button_plus = (Button) findViewById(R.id.button_plus);
		button_minus = (Button) findViewById(R.id.button_minus);
		button_multiply = (Button) findViewById(R.id.button_mutiply);
		button_by = (Button) findViewById(R.id.button_by);
		button_ac = (Button) findViewById(R.id.button_ac);
		button_delete = (Button) findViewById(R.id.button_delete);
		button_dot = (Button) findViewById(R.id.button_dot);
		button_percent = (Button) findViewById(R.id.button_percent);
		button_equal = (Button) findViewById(R.id.button_equal);
		button_0.setOnClickListener(this);
		button_1.setOnClickListener(this);
		button_2.setOnClickListener(this);
		button_3.setOnClickListener(this);
		button_4.setOnClickListener(this);
		button_5.setOnClickListener(this);
		button_6.setOnClickListener(this);
		button_7.setOnClickListener(this);
		button_8.setOnClickListener(this);
		button_9.setOnClickListener(this);
		button_plus.setOnClickListener(this);
		button_minus.setOnClickListener(this);
		button_multiply.setOnClickListener(this);
		button_by.setOnClickListener(this);
		button_ac.setOnClickListener(this);
		button_delete.setOnClickListener(this);
		button_dot.setOnClickListener(this);
		button_percent.setOnClickListener(this);
		button_equal.setOnClickListener(this);
	}

	public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
		boolean result = false;
		if (window != null) {
			Class clazz = window.getClass();
			try {
				int darkModeFlag = 0;
				Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
				java.lang.reflect.Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
				darkModeFlag = field.getInt(layoutParams);
				Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
				if (dark) {
					extraFlagField.invoke(window, darkModeFlag, darkModeFlag);// 状态栏透明且黑色字体
				} else {
					extraFlagField.invoke(window, 0, darkModeFlag);// 清除黑色字体
				}
				result = true;
			} catch (Exception e) {

			}
		}
		return result;
	}

	public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
		boolean result = false;
		if (window != null) {
			try {
				WindowManager.LayoutParams lp = window.getAttributes();
				java.lang.reflect.Field darkFlag = WindowManager.LayoutParams.class
						.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
				java.lang.reflect.Field meizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
				darkFlag.setAccessible(true);
				meizuFlags.setAccessible(true);
				int bit = darkFlag.getInt(null);
				int value = meizuFlags.getInt(lp);
				if (dark) {
					value |= bit;
				} else {
					value &= ~bit;
				}
				meizuFlags.setInt(lp, value);
				window.setAttributes(lp);
				result = true;
			} catch (Exception e) {

			}
		}
		return result;
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_0:
			str = Number(str, "0");
			break;
		case R.id.button_1:
			str = Number(str, "1");
			break;
		case R.id.button_2:
			str = Number(str, "2");
			break;
		case R.id.button_3:
			str = Number(str, "3");
			break;
		case R.id.button_4:
			str = Number(str, "4");
			break;
		case R.id.button_5:
			str = Number(str, "5");
			break;
		case R.id.button_6:
			str = Number(str, "6");
			break;
		case R.id.button_7:
			str = Number(str, "7");
			break;
		case R.id.button_8:
			str = Number(str, "8");
			break;
		case R.id.button_9:
			str = Number(str, "9");
			break;
		case R.id.button_plus:
			str = Operator(str, "+");
			break;
		case R.id.button_minus:
			str = Operator(str, "―");
			break;
		case R.id.button_mutiply:
			str = Operator(str, "×");
			break;
		case R.id.button_by:
			str = Operator(str, "÷");
			break;
		case R.id.button_equal:
			str = Equals(str);
			break;
		case R.id.button_dot:
			str = Dot(str, ".");
			break;
		case R.id.button_ac:
			str = "";
			Display(str);
			break;
		case R.id.button_percent:
			str = Percent(str);
			break;
		case R.id.button_delete:
			str = Delete(str);
			break;
		}

		if (str.isEmpty()) {
			str = "0";
			Display(str);
		}
	}

	public String Delete(String str) {
		if (str.contains("＝")) {

		} else if (!str.endsWith(".") && !str.endsWith("+") && !str.endsWith("―") && !str.endsWith("×")
				&& !str.endsWith("÷")) {
			if (str.contains("+") || str.contains("―") || str.contains("×") || str.contains("÷") || str.contains("-")) {
				int indexOfOperator = 0;
				for (int i = str.length() - 1; i > 0; i--) {
					if (str.charAt(i) == '+' || str.charAt(i) == '―' || str.charAt(i) == '×' || str.charAt(i) == '÷') {
						if (str.charAt(i - 1) != 'E') {
							indexOfOperator = i;
							break;
						}
					}
				}
				if (indexOfOperator == 0) {
				} else {
					String subString = str.substring(indexOfOperator + 1, str.length());
					if (subString.contains("E")) {
					} else {
						str = str.substring(0, str.length() - 1);
					}
				}
			} else if (str.length() > 0) {
				str = str.substring(0, str.length() - 1);
			}
		} else if (str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		}
		Display(str);
		return str;
	}

	public String Operator(String str, String operator) {
		if (str.contains("＝")) {
			str = str.substring(str.indexOf("＝") + 1);
		}
		if (str.isEmpty()) {
			str = 0 + operator;
		} else if (str.contains("Infinity")) {

		} else if (str.endsWith(".") || str.endsWith("+") || str.endsWith("―") || str.endsWith("×")
				|| str.endsWith("÷")) {
			str = str.substring(0, str.length() - 1) + operator;
		} else {
			str += operator;
		}
		Display(str);
		return str;
	}

	public String Number(String str, String number) {
		if (str.isEmpty() || str.contains("＝") || str.contains("Infinity")) {
			str = number;
		} else if (str.equals("0")) {
			str = number;
		} else if (str.endsWith("+0") || str.endsWith("―0") || str.endsWith("×0") || str.endsWith("÷0")) {
			str = str.substring(0, str.length() - 1) + number;
		} else {
			str += number;
		}
		Display(str);
		return str;
	}

	public String Dot(String str, String dot) {
		if (str.contains("＝")) {
			str = str.substring(str.indexOf("＝") + 1);
		}
		if (str.isEmpty()) {
		} else if (str.contains("Infinity")) {

		} else if (!str.endsWith(".") && !str.endsWith("+") && !str.endsWith("―") && !str.endsWith("×")
				&& !str.endsWith("÷")) {
			if (str.contains("+") || str.contains("―") || str.contains("×") || str.contains("÷")) {
				int indexOfOperator = 0;
				for (int i = str.length() - 1; i > 0; i--) {
					if (str.charAt(i) == '+' || str.charAt(i) == '―' || str.charAt(i) == '×' || str.charAt(i) == '÷') {
						indexOfOperator = i;
						break;
					}
				}
				String subString = str.substring(indexOfOperator + 1, str.length());
				if (subString.contains(".") || str.contains("E")) {
				} else {
					str = str + ".";
				}
			} else {
				if (!str.contains(".")) {
					str = str + ".";
				}
			}
		}
		Display(str);
		return str;
	}

	public String Percent(String str) {
		if (str.contains("＝")) {
			str = str.substring(str.indexOf("＝") + 1);
		}
		if (str.isEmpty()) {
			str = "0";
		} else if (str.contains("Infinity")) {

		} else if (str.endsWith("+") || str.endsWith("―") || str.endsWith("×") || str.endsWith("÷")) {

		} else if (!str.contains("+") && !str.contains("―") && !str.contains("×") && !str.contains("÷")) {
			if (str.endsWith(".")) {
				str = str.substring(0, str.length() - 1);
			}
			str = Double.toString(AccurateArithmetic.div(str, Integer.toString(100), 1000));
		} else {
			int indexOfOperator = 0;
			String subString = null;

			for (int i = str.length() - 1; i > 0; i--) {
				if (str.charAt(i) == '+' || str.charAt(i) == '―' || str.charAt(i) == '×' || str.charAt(i) == '÷') {
					if (str.charAt(i - 1) != 'E') {
						indexOfOperator = i;
						break;
					}
				}
			}

			if (indexOfOperator == 0) {
				subString = str;
				str = "";
			} else {
				subString = str.substring(indexOfOperator + 1, str.length());
				str = str.substring(0, indexOfOperator + 1);
			}

			if (subString.substring(subString.length() - 1).contains(".")) {
				subString = subString.substring(0, subString.length() - 1);
			}

			subString = Double.toString(AccurateArithmetic.div(subString, Integer.toString(100), 1000));
			str += subString;
		}
		Display(str);
		return str;
	}

	public String Equals(String str) {
		if (str.contains("＝")) {
			str = str.substring(0, str.indexOf('＝'));
		}
		if (str.length() == 0) {
			str = "0";
		} else if (str.endsWith("+") || str.endsWith("―") || str.endsWith("×") || str.endsWith("÷")
				|| str.endsWith(".")) {
			str = str.substring(0, str.length() - 1);
		}
		if (!str.contains("+") && !str.contains("―") && !str.contains("×") && !str.contains("÷")) {
			str = str + "＝" + str;
		} else {
			// 转换为后缀表达式
			Stack<String> stack = new Stack<String>();
			ArrayList<String> arrayList = new ArrayList<String>();
			String tempString = "";

			//在负数之前添0
			if (str.charAt(0) == '―') {
				tempString = "0";
			}

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '+' || str.charAt(i) == '―' || str.charAt(i) == '×' || str.charAt(i) == '÷') {
					arrayList.add(tempString);
					tempString = "";
					if (!stack.empty()) {
						if (str.charAt(i) == '+' || str.charAt(i) == '―') {
							while (!stack.empty()) {
								arrayList.add(stack.pop());
							}
							stack.push(str.charAt(i) + "");
						} else {
							while (!stack.empty() && (stack.peek().equals("×") || stack.peek().equals("÷"))) {
								arrayList.add(stack.pop());
							}
							stack.push(str.charAt(i) + "");
						}
					} else {
						stack.push(str.charAt(i) + "");
					}
				} else {
					tempString += str.charAt(i);
					if (str.charAt(i) == 'E') {
						i += 1;
						tempString += str.charAt(i);
					}
					if (i == str.length() - 1) {
						arrayList.add(tempString);
						tempString = "";
					}
				}
			}

			while (!stack.empty()) {
				arrayList.add(stack.pop());
			}

			for (int i = 0; i < arrayList.size(); i++) {
				// 后缀表达式求值
				if (arrayList.get(i).contains("E")) {
					stack.push(arrayList.get(i));
				} else if (!arrayList.get(i).equals("+") && !arrayList.get(i).equals("―")
						&& !arrayList.get(i).equals("×") && !arrayList.get(i).equals("÷")) {
					stack.push(arrayList.get(i));
				} else {
					if (!stack.empty()) {
						String operand1;
						String operand2;
						String result = "";
						if (arrayList.get(i).equals("+")) {
							operand1 = stack.pop();
							operand2 = stack.pop();
							result = Double.toString(AccurateArithmetic.add(operand1, operand2));
						}
						if (arrayList.get(i).equals("―")) {
							operand1 = stack.pop();
							operand2 = stack.pop();
							result = Double.toString(AccurateArithmetic.sub(operand2, operand1));
						}
						if (arrayList.get(i).equals("×")) {
							operand1 = stack.pop();
							operand2 = stack.pop();
							result = Double.toString(AccurateArithmetic.mul(operand1, operand2));
						}
						if (arrayList.get(i).equals("÷")) {
							operand1 = stack.pop();
							operand2 = stack.pop();
							if (operand1.equals("0")) {
								result = Double.toString(Double.parseDouble(operand2) / Double.parseDouble(operand1));
							} else {
								result = Double.toString(AccurateArithmetic.div(operand2, operand1));
							}
						}
						if (result.endsWith(".0")) {
							result = result.substring(0, result.lastIndexOf("."));
						}
						stack.push(result);
					}
				}
			}
			str = str + "＝" + stack.pop();
		}
		Display(str);
		return str;
	}

	public void Display(String str) {
		if (str.contains("E")) {
			str = str.replaceAll("E", "e");
		}
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'e') {
				i = i + 2;
			}
			if (str.charAt(i) == '＝') {
				String partOne = str.substring(0, i);
				String partTwo = str.substring(i + 1);
				str = partOne + " \n" + str.charAt(i) + "  " + partTwo;
				break;
			}
			if (str.charAt(i) == '+' || str.charAt(i) == '―' || str.charAt(i) == '×' || str.charAt(i) == '÷') {
				String partOne = str.substring(0, i);
				String partTwo = str.substring(i + 1);
				str = partOne + " \n" + str.charAt(i) + "  " + partTwo;
				i = i + 4;
			}
		}
		if (str.endsWith("+") || str.endsWith("―") || str.endsWith("×") || str.endsWith("÷")) {
			str = str.substring(0, str.length() - 1) + " \n" + str.substring(str.length() - 1) + "     ";
		} else {
			str = str + " ";
		}
		textView.setText(str);
	}
}
