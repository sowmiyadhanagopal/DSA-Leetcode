package Leetcode;

public class AngleBetweenHandsofaClock {

        public double angleClock(int hour, int minutes) {
            if(hour==12)
            {
                hour=0;
            }
            double minangle=minutes*6;
            double hourangle=(hour*30)+(minutes*0.5);
            double diff=Math.abs(hourangle-minangle);
            return Math.min(diff,360-diff);
        }
    }

