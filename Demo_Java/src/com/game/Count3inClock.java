package com.game;

import java.text.ParseException;

/*小学数学题：请算出一天内，电子表显示4个3的时刻数，例子：23:36:33*/
public class Count3inClock {
 
	public static void main(String[] args) throws ParseException {
		int num=0;
		for (int hh = 0; hh <= 23; hh++) {// 小时
			for (int mi = 0; mi <= 59; mi++) {// 分钟
				for (int ss = 0; ss <= 59; ss++) {// 秒
					// 串联字符
					String str = Integer.toString(hh) + Integer.toString(mi) + Integer.toString(ss);
					// 字符串转数组
					char[] strArr1 = str.toCharArray();
					// 数3的个数
					int count = 0;
					for (int i = 0; i < strArr1.length; i++) {
						if (strArr1[i]=='3') {
							count++;
						}
					}
					//等于4个
					if (count == 4) {
						num++;
						System.out.println(num+ " | "+String.format("%02d", hh) + ":"
								+ String.format("%02d", mi) + ":" + String.format("%02d", ss));
					}
				}
			}
		}

//
//		Calendar calendar = Calendar.getInstance();// 创建时间
//		calendar.setTime(new Date());
//		calendar.set(Calendar.HOUR_OF_DAY, 0);// 0时
//		calendar.set(Calendar.MINUTE, 0);// 0分
//		calendar.set(Calendar.SECOND, 0);// 0秒
//	
//		String strDateFormat = "HH:mm:ss";// 设置格式
//		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
//
//		int i = 1;
//		while (i <= 60 * 60 * 24) {
//			calendar.add(Calendar.SECOND, 1); // 加1秒
//			Date zero = calendar.getTime(); // 转换类型
//			String time = sdf.format(zero);
//			DateFormater fun = new DateFormater();
//			int count = fun.getCount(time, "3");
//			if (count == 4) {
//				System.out.println(sdf.format(time));
//
//			}
//			i++;
//		}
//
//	}
//
//	public int getCount(String str, String key) {
//
//		int count = 0;
//		int index = 0;
//		while ((index = str.indexOf(key, index)) != -1) {
//			index = index + key.length();
//			count++;
//		}
//		return count;
	}

}
