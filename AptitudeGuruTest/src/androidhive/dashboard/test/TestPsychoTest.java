package androidhive.dashboard.test;

import com.aptitudeguru.dashboard.PsychoResults;
import com.aptitudeguru.dashboard.TestPsycho;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;
import androidhive.dashboard.R;
import junit.framework.TestCase;

public class TestPsychoTest extends ActivityInstrumentationTestCase2<TestPsycho> {

	public TestPsychoTest() {
		super(TestPsycho.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@UiThreadTest
	public void testSameAnswer()
	{		
		Activity psycho = getActivity();
		
		Button btn_finish = (Button) psycho.findViewById(R.id.btn_finish);		
		
		EditText mostlikely = (EditText) psycho.findViewById(R.id.mostlikely);
		EditText leastlikely = (EditText) psycho.findViewById(R.id.leastlikely);
		
		//Checking when the input for both fields is the same
		mostlikely.setText("A");
		leastlikely.setText("A");		
		
		btn_finish.performClick();	
		assertEquals(((TestPsycho) psycho).getErrorMsg(),"The most likely and least likely answer must be different");
		
	}
	
	@UiThreadTest
	public void testInvalidMostLikely()
	{		
		Activity psycho = getActivity();
		
		Button btn_finish = (Button) psycho.findViewById(R.id.btn_finish);		
		
		EditText mostlikely = (EditText) psycho.findViewById(R.id.mostlikely);
		EditText leastlikely = (EditText) psycho.findViewById(R.id.leastlikely);
		
		//Checking error message when the input for most likely is invalid
		mostlikely.setText("Z");
		leastlikely.setText("A");		
		
		btn_finish.performClick();	
		assertEquals(((TestPsycho) psycho).getErrorMsg(),"Your input for most likely is invalid. Please enter A, B, C or D.");
		
	}
	
	@UiThreadTest
	public void testInvalidLeastLikely()
	{		
		Activity psycho = getActivity();
		
		Button btn_finish = (Button) psycho.findViewById(R.id.btn_finish);		
		
		EditText mostlikely = (EditText) psycho.findViewById(R.id.mostlikely);
		EditText leastlikely = (EditText) psycho.findViewById(R.id.leastlikely);
		
		//Checking error message when the input for least likely is invalid
		mostlikely.setText("A");
		leastlikely.setText("Z");		
		
		btn_finish.performClick();	
		assertEquals(((TestPsycho) psycho).getErrorMsg(),"Your input for least likely is invalid. Please enter A, B, C or D.");
	}
	
	@UiThreadTest
	public void testValidInput()
	{		
		Activity psycho = getActivity();
		
		Button btn_finish = (Button) psycho.findViewById(R.id.btn_finish);		
		
		EditText mostlikely = (EditText) psycho.findViewById(R.id.mostlikely);
		EditText leastlikely = (EditText) psycho.findViewById(R.id.leastlikely);
		
		//Checking error message when the input is valid
		mostlikely.setText("A");
		leastlikely.setText("B");		
		
		btn_finish.performClick();	
		assertEquals(((TestPsycho) psycho).getErrorMsg(),null);
	}
}
