package test.com.fngame.farm.util;


import com.fngame.farm.model.User;
import com.fngame.farm.util.XlsReader;
import com.fngame.farm.util.XlsUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * XlsUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十二月 15, 2017</pre>
 */
public class XlsUtilTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: creatClass()
     */
    @Test
    public void testCreatClass() throws Exception {
//TODO: Test goes here...
        Class<User> userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType());
            System.out.println(field.getGenericType());
        }
    }

    /**
     * Method: read(FileWriter writer1, File file)
     */


    @Test
    public void testRead() throws Exception {
//TODO: Test goes here... 

/*        XlsUtil.creatClass();*/
        XlsUtil xlsUtil = new XlsUtil();
        xlsUtil.readManager();

    }

    @Test
    public void creatClass() throws Exception {
//TODO: Test goes here...

        XlsUtil.creatClass();


    }
    @Test
    public void rr() throws Exception {
//TODO: Test goes here...

        UUID uuid = UUID.randomUUID();
        String replace = uuid.toString().replace("-", "");
        System.out.println(replace);
    }


} 
