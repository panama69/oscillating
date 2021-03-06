package net.demo;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import org.junit.*;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;
import java.util.Random;

import unittesting.*;

public class UnstableTest extends UnitTestClassBase {

    public UnstableTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new UnstableTest();
        globalSetup(UnstableTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void someTimesPassesSomeTimesFails() throws ReportException {
        new LogMessages().logMethod(new Object(){});
        Random rand = new Random();
        int x = rand.nextInt(2)+1;

        System.out.println("Using: "+x);

        if (Verify.areEqual(1,x)) {
            Reporter.reportEvent("Check for 1 =1","<br><H1>Simple Number Check</H1><br><b>Ensure 1=1</b>",Status.Passed);
        } else {
            Reporter.reportEvent("Check for 1 =1","<br><H1>Simple Number Check</H1><br><b>Ensure 1=1</b>",Status.Failed);
        }

        Assert.assertEquals(1, x);
    }

}