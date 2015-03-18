package androidhive.dashboard.test;

import java.lang.reflect.Method;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.test.AndroidTestCase;
import android.test.ServiceTestCase;
import android.test.mock.MockContext;
import android.widget.Button;

import com.aptitudeguru.dashboard.DatabaseHandler;
import com.aptitudeguru.dashboard.PsychoTable;
import com.aptitudeguru.dashboard.TestPsycho;

import junit.framework.TestCase;

public class DatabaseTest extends AndroidTestCase {

	public DatabaseTest() {
		super();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}	
	
	public void test()
	{		
		DatabaseHandler db = new DatabaseHandler(mContext);	
				
		PsychoTable psycho = db.getPsycho(1);		
		
		assertEquals("Apologise that the book is unavailable and suggest he try Morethanpens.co.uk or another online retailer instead.",psycho.getOption1());		
	}
	

}
