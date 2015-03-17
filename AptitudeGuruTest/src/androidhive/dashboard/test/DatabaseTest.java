package androidhive.dashboard.test;

import java.lang.reflect.Method;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ServiceTestCase;
import android.test.mock.MockContext;

import com.aptitudeguru.dashboard.DatabaseHandler;
import com.aptitudeguru.dashboard.PsychoTable;
import com.aptitudeguru.dashboard.TestPsycho;

import junit.framework.TestCase;

public class DatabaseTest extends TestCase {
	
	
	//PsychoTable psycho;
	
	MockContext context = new MockContext() {
	    public TestPsycho contextThing()
	         {
	      return new TestPsycho();
	    };
	}; 

	public DatabaseTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void test()
	{
		
		
		DatabaseHandler db = new DatabaseHandler(context);
		
		
		
		 db.getPsycho(1);
		
		assertEquals("Hello",db.getTest());
		
	}


}
