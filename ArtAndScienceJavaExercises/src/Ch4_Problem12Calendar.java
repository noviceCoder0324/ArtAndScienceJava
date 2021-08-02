/*
 * File: Calendar.java
 * -----------------------------
 * This is a program to make a calendar for a month.
 * Textbook page 98. Q 12.
 */

import acm.graphics.*;
import acm.program.*;

public class Calendar extends GraphicsProgram {
	/*The number of days in the month*/
	private static final int DAYS_IN_MONTH = 29;
	
	/*The day of the week on which the month starts*/
	/*(Sunday =0, Monday = 1, Tuesday = 2, and so on.)*/
	private static final int DAY_MONTH_STARTS = 2;
	
	/*The width in pixels of a day on the calendar */
	private static final int DAY_WIDTH = 40;
	
	/*The height in pixels of a day on the calendar */
	private static final int DAY_HEIGHT = 30;
	
	public void run(){
		/*Define how many rows the calendar needs.*/
		int ROW_IN_CALENDAR; 
		if ((DAYS_IN_MONTH + DAY_MONTH_STARTS)% 7 == 0){
			ROW_IN_CALENDAR = (DAYS_IN_MONTH + DAY_MONTH_STARTS)/7;
		}else{
			ROW_IN_CALENDAR = (DAYS_IN_MONTH + DAY_MONTH_STARTS)/7 + 1;
		}

		/*Draw the boxes for all days*/
		int dayX = 0;
		int dayY = 0;
		for(; ROW_IN_CALENDAR > 0; ROW_IN_CALENDAR--){
			for(int c = 0; c < 7; c++){
				GRect day = new GRect(dayX, dayY, DAY_WIDTH, DAY_HEIGHT);
				add (day);
				dayX += DAY_WIDTH;
			}
			dayX = 0;
			dayY += DAY_HEIGHT;
		}
		
		/*Write down the first line of date. */
		int date = 1;
		int firstLineX = DAY_MONTH_STARTS * DAY_WIDTH + 2;
		int firstLineY = 10;
		for (; firstLineX < DAY_WIDTH * 7; firstLineX += DAY_WIDTH){
			GLabel firstLineDate = new GLabel ("" + date, firstLineX, firstLineY);//So smart!
			add(firstLineDate);
			date ++;
		}
		
		/*Write down the rest of the date. */
		int lineX = 2;
		int lineY = DAY_HEIGHT + 10;
		while(date <= DAYS_IN_MONTH){
			for (; lineX < DAY_WIDTH * 7;){
				GLabel otherDate = new GLabel ("" + date, lineX, lineY);
				add(otherDate);
				date ++;
				if (date > DAYS_IN_MONTH)break;
				lineX += DAY_WIDTH;
			}
			lineX = 2;
			lineY += DAY_HEIGHT;
		}
		
	}

}
