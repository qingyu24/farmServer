 package com.fngame.farm.util;
 


import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;







 
 public final class Functions
 {
   public static String encode(String s)
   {
     if (s == null)
       return "";
     try
     {
       return URLEncoder.encode(s, "UTF-8");
     } catch (Exception ex) {
       ex.printStackTrace();
     }
 
     return "";
   }
 
   public static String decode(String s)
   {
     try {
       return URLDecoder.decode(s, "UTF-8");
     } catch (Exception ex) {
       ex.printStackTrace();
     }
 
     return null;
   }
 
   public static String numShort(Long num)
   {
     if (num == null) {
       return "";
     }
     if (num.longValue() > 100000000L) {
       StringBuffer ret = new StringBuffer();
       ret.append(num.longValue() / 100000000L);
       ret.append("亿");
 
       return ret.toString();
     }
     if (num.longValue() > 10000000L) {
       StringBuffer ret = new StringBuffer();
       ret.append(num.longValue() / 10000000L);
       ret.append("千万");
 
       return ret.toString();
     }
     if (num.longValue() > 10000L) {
       StringBuffer ret = new StringBuffer();
       ret.append(num.longValue() / 10000L);
       ret.append("万");
 
       return ret.toString();
     }
 
     return num.toString();
   }
 
   public static String timeSpan(Long time)
   {
     if (time == null) {
       return "";
     }
     if (time.longValue() < 60L) {
       return new StringBuilder().append(time).append("分钟").toString();
     }
 
     time = Long.valueOf(time.longValue() / 60L);
     if (time.longValue() < 24L) {
       return new StringBuilder().append(time).append("小时").toString();
     }
 
     time = Long.valueOf(time.longValue() / 24L);
     return new StringBuilder().append(time).append("天").toString();
   }
 
   public static String timeSpanSecond(Long time)
   {
     if (time == null) {
       return "";
     }
     if (time.longValue() < 0L) {
       time = Long.valueOf(time.longValue() * -1L);
     }
 
     int fix = 0;
     if (time.longValue() % 1000L > 0L)
       fix = 1;
     else {
       fix = 0;
     }
     time = Long.valueOf(time.longValue() / 1000L + fix);
     if (time.longValue() < 60L) {
       return new StringBuilder().append(time).append("秒").toString();
     }
 
     time = Long.valueOf(time.longValue() / 60L);
     if (time.longValue() < 60L) {
       return new StringBuilder().append(time.longValue() + 1L).append("分钟").toString();
     }
 
     time = Long.valueOf(time.longValue() / 60L);
     if (time.longValue() < 24L) {
       return new StringBuilder().append(time.longValue() + 1L).append("小时").toString();
     }
 
     time = Long.valueOf(time.longValue() / 24L);
     return new StringBuilder().append(time.longValue() + 1L).append("天").toString();
   }
 
   public static String durationSimple(Date datetime)
   {
     if (datetime == null) {
       return "";
     }
     Long time = Long.valueOf(System.currentTimeMillis() - datetime.getTime());
     if (time.longValue() < 0L) {
       time = Long.valueOf(time.longValue() * -1L);
     }
 
     int fix = 0;
     if (time.longValue() % 1000L > 0L)
       fix = 1;
     else {
       fix = 0;
     }
     time = Long.valueOf(time.longValue() / 1000L + fix);
     if (time.longValue() < 60L) {
       return new StringBuilder().append(time).append("秒").toString();
     }
 
     time = Long.valueOf(time.longValue() / 60L);
     if (time.longValue() < 60L) {
       return new StringBuilder().append(time.longValue() + 1L).append("分钟").toString();
     }
 
     time = Long.valueOf(time.longValue() / 60L);
     if (time.longValue() < 24L) {
       return new StringBuilder().append(time.longValue() + 1L).append("小时").toString();
     }
 
     time = Long.valueOf(time.longValue() / 24L);
     return new StringBuilder().append(time.longValue() + 1L).append("天").toString();
   }
 
   public static String durationSimple2(Date datetime)
   {
     if (datetime == null) {
       return "";
     }
     Long time = Long.valueOf(System.currentTimeMillis() - datetime.getTime());
     if (time.longValue() < 0L) {
       time = Long.valueOf(time.longValue() * -1L);
     }
 
     int fix = 0;
     if (time.longValue() % 1000L > 0L)
       fix = 1;
     else {
       fix = 0;
     }
     time = Long.valueOf(time.longValue() / 1000L + fix);
     if (time.longValue() < 60L) {
       return new StringBuilder().append(time).append("秒").toString();
     }
 
     time = Long.valueOf(time.longValue() / 60L);
     if (time.longValue() < 60L) {
       return new StringBuilder().append(time).append("分钟").toString();
     }
 
     time = Long.valueOf(time.longValue() / 60L);
     if (time.longValue() < 24L) {
       return new StringBuilder().append(time).append("小时").toString();
     }
 
     time = Long.valueOf(time.longValue() / 24L);
     return new StringBuilder().append(time).append("天").toString();
   }
 
   public static String duration(Date datetime)
   {
     if (datetime == null) {
       return "";
     }
     Long time = Long.valueOf(System.currentTimeMillis() - datetime.getTime());
     if (time.longValue() < 0L) {
       time = Long.valueOf(time.longValue() * -1L);
     }
     time = Long.valueOf(time.longValue() / 1000L);
     if (time.longValue() < 60L) {
       return new StringBuilder().append(time).append("秒").toString();
     }
 
     time = Long.valueOf(time.longValue() / 60L);
 
     if (time.longValue() < 60L) {
       return new StringBuilder().append(time).append("分钟").toString();
     }
 
     Long ext = Long.valueOf(time.longValue() % 60L);
     time = Long.valueOf(time.longValue() / 60L);
     if (time.longValue() < 24L) {
       return new StringBuilder().append(time).append("小时").append(ext).append("分").toString();
     }
 
     ext = Long.valueOf(time.longValue() % 24L);
     time = Long.valueOf(time.longValue() / 24L);
     return new StringBuilder().append(time).append("天").append(ext).append("小时").toString();
   }
 
   public static String txt(String content)
   {
     if (content == null) {
       return "";
     }
 
     if ("".equals(content)) {
       return "";
     }
 
     content = content.replaceAll("\\\\", "");
     content = content.replaceAll("&lt;", "<");
     content = content.replaceAll("&gt;", ">");
     content = content.replaceAll("&amp;", "&");
     content = content.replaceAll("&quot;", "\"");
     content = content.replaceAll("&apos;", "'");
 
     content = content.replaceAll("&nbsp;", " ");
     content = content.replaceAll("&ldquo;", "\"");
     content = content.replaceAll("&rdquo;", "\"");
     content = content.replaceAll("&[;|\\w]{1,10};", ".");
 
     content = content.replaceAll("<br/>|<br[\\s]+/>", "\n");
     content = content.replaceAll("\r", "");
     content = content.replaceAll("\n{2,}", "\r\n");
 
     int length = content.length();
     char[] ch = content.toCharArray();
     StringBuffer sb = new StringBuffer();
     for (int i = 0; i < length; i++)
       if (ch[i] <= 65533)
       {
         if ((ch[i] >= ' ') || (ch[i] == '\t') || (ch[i] == '\n') || (ch[i] == '\r'))
         {
           switch (ch[i]) {
           case '<':
             sb.append("&lt;");
             break;
           case '>':
             sb.append("&gt;");
             break;
           case '$':
           case '&':
             sb.append("&amp;");
             break;
           case '"':
             sb.append("&quot;");
             break;
           case '\'':
             sb.append("&apos;");
             break;
           default:
             sb.append(ch[i]);
           }
         }
       }
     return sb.toString();
   }
 
   public static String wml(String s) {
     String a = txt(s);
 
     return a.replaceAll("\r\n|\n\r|\n|\r", "<br/>");
   }
 
   public static String xml(String str) {
     if ((str == null) || (str.length() <= 0)) {
       return str;
     }
 
     str = str.replace("&", "&amp;");
 
     return str;
   }
 
   public static String image(String imagePath, String alt, Boolean isShow, Boolean isSelect)
   {
     if ((isShow != null) && (!isShow.booleanValue())) {
       return "";
     }
 
     if (alt == null) {
       alt = ".";
     }
 
     StringBuffer img = new StringBuffer();
     img.append("<img src=\"");
     img.append(imagePath);
     img.append("\" alt=\"");
     img.append(alt);
     if ((isSelect != null) && (isSelect.booleanValue()))
       img.append("\" />");
     else {
       img.append("\" noselect=\"true\" />");
     }
 
     return img.toString();
   }
 
   public static String showWeight(Integer weight) {
     if (weight == null) {
       return "";
     }
     double a = weight.intValue() / 100.0D;
     DecimalFormat df = new DecimalFormat("#######0.00");
     return df.format(a);
   }
 
   public static String showTime(Date time) {
     if (time == null) {
       return "";
     }
     return timeFormat(time, "yyyy-MM-dd HH:mm");
   }
 
   public static String tickFormat(Long tick, String format) {
     if (tick == null) {
       return "";
     }
     Date time = new Date(tick.longValue());
     SimpleDateFormat sdf = new SimpleDateFormat(format);
     return sdf.format(time);
   }
 
   public static String timeFormat(Date time, String format) {
     if (time == null) {
       return "";
     }
 
     SimpleDateFormat sdf = new SimpleDateFormat(format);
     return sdf.format(time);
   }
 
   public static Integer percent(Integer num, Integer total) {
     if (num == null) {
       return Integer.valueOf(0);
     }
     if (total == null) {
       return Integer.valueOf(0);
     }
     int percent = 0;
     if (total.intValue() > 0) {
       percent = num.intValue() * 100 / total.intValue();
     }
 
     return Integer.valueOf(percent);
   }
 
   public static Boolean matchs(String data, String regex) {
     return Boolean.valueOf(data.matches(regex));
   }
 
   public static String brief(String content, Integer num) {
     String ret = txt(content);
     if (ret.length() <= num.intValue()) {
       return ret;
     }
 
     return new StringBuilder().append(ret.substring(0, num.intValue() - 1)).append("...").toString();
   }
 
   public static String durationExact(Long time) {
       time = Long.valueOf(System.currentTimeMillis() - time.longValue());
       if (time.longValue() < 0L) {
           time = Long.valueOf(time.longValue() * -1L);
       }

       String second = "";
       String minute = "";
       String hour = "";
       String day = "";

       long perSecond = 1000L;
       long perMinute = 60L * perSecond;
       long perHour = 60L * perMinute;
       long perDay = 24L * perHour;

       if (time.longValue() >= perDay) {
           day = new StringBuilder().append(time.longValue() / perDay).append("天").toString();
           time = Long.valueOf(time.longValue() % perDay);
       }

       if (time.longValue() >= perHour) {
           hour = new StringBuilder().append(time.longValue() / perHour).append("小时").toString();
           time = Long.valueOf(time.longValue() % perHour);
       }

       if (time.longValue() >= perMinute) {
           minute = new StringBuilder().append(time.longValue() / perMinute).append("分").toString();
           time = Long.valueOf(time.longValue() % perMinute);
       }

       if (time.longValue() >= perSecond) {
           second = new StringBuilder().append(time.longValue() / perSecond).append("秒").toString();
           time = Long.valueOf(time.longValue() % perSecond);
       }

       if (!"".equals(day)) {
           return new StringBuilder().append(day).append(hour).toString();
       }

       if (!"".equals(hour)) {
           return new StringBuilder().append(hour).append(minute).toString();
       }

       if (!"".equals(minute)) {
           return new StringBuilder().append(minute).append(second).toString();
       }

       if (!"".equals(second)) {
           return second;
       }

       return new StringBuilder().append(day).append(hour).append(minute).append(second).toString();
   }
 }