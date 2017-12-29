/*
package test.com.fngame.farm.manager;

import com.fngame.farm.model.Animal;
import com.fngame.farm.model.Building;
import com.fngame.farm.model.Crops;
import com.fngame.farm.model.User;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.util.XlsUtil;
import org.apache.commons.collections4.SplitMapUtils;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import redis.clients.jedis.Jedis;

import java.util.Set;

*
* ConfigManager Tester.
*
* @author <Authors name>
* @since <pre>十二月 24, 2017</pre>
* @version 1.0


public class ConfigManagerTest {

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

*
*
* Method: getInstance()
*


@Test
public void testGetInstance() throws Exception {


    Jedis jedis = new Jedis("localhost");
    System.out.println("连接成功");
    //查看服务是否运行
    System.out.println("服务正在运行: "+jedis.ping());
 jedis.set("idea", String.valueOf(new User()));

    String idea = jedis.get("idea");
    System.out.println(idea);
    Set<String> keys = jedis.keys("*");

    for (String key : keys) {
        System.out.println(key);
       // jedis.getSet(key);
        String s = jedis.get(key);
        System.out.println("__________________");
        System.out.println(s);
        System.out.println("++++++++++++++++++++++++");
    }
// /TODO: Test goes here...
}

*
*
* Method: getloader(Object o)
*


@Test
public void testGetloader() throws Exception {
    XlsUtil.creatClass();
//TODO: Test goes here... 
}

*
*
* Method: getBuildingConfig(Building o)
*


@Test
public void testGetBuildingConfig() throws Exception {
//TODO: Test goes here... 
}

*
*
* Method: getOrders(PlayerInfo playerInfo, int size)
*


@Test
public void testGetOrders() throws Exception {
//TODO: Test goes here... 
}

*
*
* Method: getCrops(Crops crops)
*


@Test
public void testGetCrops() throws Exception {
//TODO: Test goes here...
    XlsUtil xlsUtil = new XlsUtil();
    xlsUtil.readManager();
}

*
*
* Method: getResp(String resp_code)
*


@Test
public void testGetResp() throws Exception {
//TODO: Test goes here... 
}

*
*
* Method: getAnimalConfig(Animal animal)
*


@Test
public void testGetAnimalConfig() throws Exception {
//TODO: Test goes here... 
}

*
*
* Method: getCraft(Integer baseid)
*


@Test
public void testGetCraft() throws Exception {
//TODO: Test goes here... 
}


} 
*/
