package test.com.fngame.farm.interceptor; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* loginInterceptor Tester. 
* 
* @author <Authors name> 
* @since <pre>一月 2, 2018</pre> 
* @version 1.0 
*/ 
public class loginInterceptorTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
* 
*/ 
@Test
public void testPreHandle() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
* 
*/ 
@Test
public void testPostHandle() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) 
* 
*/ 
@Test
public void testAfterCompletion() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) 
* 
*/ 
@Test
public void testAfterConcurrentHandlingStarted() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: Verify(String data, String sign) 
* 
*/ 
@Test
public void testVerify() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = loginInterceptor.getClass().getMethod("Verify", String.class, String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: getSignData(Map<String, String> params) 
* 
*/ 
@Test
public void testGetSignData() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = loginInterceptor.getClass().getMethod("getSignData", Map<String,.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
