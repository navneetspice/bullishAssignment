package cucumber.stepdef;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;

public class StudentStepDef{
    private RestUtil restUtil;

    @Before
    public void beforeMethod(){
        restUtil=new RestUtil();
    }

    @After
    public void AfterMethod(){
        restUtil.terminateSession();
    }

    @Given("I Launch the get API")
    public void launchGetApi(){
        restUtil.getRequest();
    }

    @Given("I Launch the put API \"([^\"]*)\" \"([^\"]*)\"")
    public void launchPutApi(String id,String firstName){
        Map<Object,Object> testData=new HashMap();
        testData.put("id",Integer.parseInt(id));
        testData.put("firstName",firstName);
        restUtil.putRequest(testData);
    }

    @Given("I Launch the post API \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"")
    public void launchPostApi(String id,String firstName,String lastName,String studentClass,String nationality){
        Map<Object,Object> testData=new HashMap();
        testData.put("id",Integer.parseInt(id));
        testData.put("firstName",firstName);
        testData.put("lastName",lastName);
        testData.put("class",studentClass);
        testData.put("nationality",nationality);
        restUtil.postRequest(testData);
    }

    @Given("I Launch the delete API with id \"([^\"]*)\"")
    public void launchDeleteApi(String id){
        Map<Object,Object> testData=new HashMap();
        testData.put("id",Integer.parseInt(id));
        restUtil.deleteRequest(testData);
    }

    @When("Response code is 200 OK")
    public void validateResponseCode(){
        Assert.assertTrue("response code for api is 200 OK",restUtil.responseCode==200);
    }

}
