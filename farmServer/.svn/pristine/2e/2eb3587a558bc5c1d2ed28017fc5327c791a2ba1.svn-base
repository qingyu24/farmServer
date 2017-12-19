 package com.fngame.farm.util;
 
 import java.util.List;
 import javax.servlet.http.Cookie;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
 public class CookieUtil
 {
       private String cookieAuth = "mg";
       private String pathRoot = "/";
       private int expireTime = 86400;
       private List<String> domains;
    
   public String getCookieAuth()
   {
     return this.cookieAuth;
   }
    
   public void setCookieAuth(String cookieAuth) {
     this.cookieAuth = cookieAuth;
   }
    
   public String getPathRoot() {
     return this.pathRoot;
   }
    
   public void setPathRoot(String pathRoot) {
     this.pathRoot = pathRoot;
   }
    
   public int getExpireTime() {
     return this.expireTime;
   }
    
   public void setExpireTime(int expireTime) {
     this.expireTime = expireTime;
   }
    
   public List<String> getDomains() {
     return this.domains;
   }
    
   public void setDomains(List<String> domains) {
     this.domains = domains;
   }
    
   private void setCookie(HttpServletResponse response, String domain, String path, int time, String name, String value)
   {
     Cookie cookie = new Cookie(name, value);
     cookie.setMaxAge(time);
     if (path != null) {
       cookie.setPath(path);
     }
     if (domain != null) {
       cookie.setDomain(domain);
     }
 
     response.addCookie(cookie);
   }
    
   private String getCookie(HttpServletRequest request, String name)
   {
     Cookie[] cookies = request.getCookies();
     if (cookies == null) {
       return null;
     }
 
     for (Cookie cookie : cookies) {
       if (name.equals(cookie.getName())) {
         return cookie.getValue();
       }
     }
 
     return null;
   }
    
   public void setAuth(HttpServletResponse response, String value)
   {
     value = Functions.encode(value);
     if ((this.domains == null) || (this.domains.size() <= 0)) {
       for (String domain : this.domains) {
         setCookie(response, domain, this.pathRoot, this.expireTime, this.cookieAuth, value);
       }
     }
     setCookie(response, null, this.pathRoot, this.expireTime, this.cookieAuth, value);
   }
    
   public void clearAuth(HttpServletResponse response)
   {
     if ((this.domains == null) || (this.domains.size() <= 0)) {
       for (String domain : this.domains) {
         setCookie(response, domain, this.pathRoot, 0, this.cookieAuth, null);
       }
     }
     setCookie(response, null, this.pathRoot, 0, this.cookieAuth, null);
   }

   public String getAuth(HttpServletRequest request)
   {
     String cookie = getCookie(request, this.cookieAuth);
     if ((cookie == null) || (cookie.length() <= 0)) {
       return null;
     }
     return Functions.decode(cookie);
   }
 }