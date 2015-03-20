package androidhive.dashboard.test;

import com.aptitudeguru.dashboard.PsychoResults;
import com.aptitudeguru.dashboard.TestPsycho;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidhive.dashboard.R;
import junit.framework.TestCase;

public class TestPsychoTest extends ActivityInstrumentationTestCase2<TestPsycho> {

	Activity psycho;
	
	public TestPsychoTest() {
		super(TestPsycho.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		psycho = getActivity();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@UiThreadTest
	public void testSameAnswer()
	{		
		
		
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
		
		
		Button btn_finish = (Button) psycho.findViewById(R.id.btn_finish);		
		
		EditText mostlikely = (EditText) psycho.findViewById(R.id.mostlikely);
		EditText leastlikely = (EditText) psycho.findViewById(R.id.leastlikely);
		
		//Checking error message when the input is valid
		mostlikely.setText("A");
		leastlikely.setText("B");		
		
		btn_finish.performClick();	
		assertEquals(((TestPsycho) psycho).getErrorMsg(),null);
	}
	
	@UiThreadTest
	public void testTimerStart() 
	{		
		((TestPsycho) psycho).startTimer();
		
		assertEquals(((TestPsycho) psycho).getTimerHasStarted(), true);
		assertTrue(((TestPsycho) psycho).getMinutes() ==  5 && ((TestPsycho) psycho).getSeconds() ==  0);					
	}
	
	@UiThreadTest
	public void testTimerColourAtStart()
	{
    	//TextView timerText = new TextView(psycho);
    	
		assertEquals(((TestPsycho) psycho).getTextColor(), Color.BLACK);
		
		
	}
	
	@UiThreadTest
	public void testTimerWarningColour()
	{		
		((TestPsycho) psycho).startTimer();
		
		try {
			Thread.sleep((1000*60*4)+1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(((TestPsycho) psycho).getTextColor(), Color.RED);
	}
	
}
