package com.auto.methods;

import com.intuit.karate.CallContext;
import com.intuit.karate.Resource;
import com.intuit.karate.core.*;
import cucumber.api.Scenario;

import java.io.File;

public class ExecuteFeatureFile {

    public  void execute(String file, Scenario scenario) throws Exception{
        Feature feature = FeatureParser.parse(new Resource(new File(System.getProperty("user.dir")+"/features/"+file),new File(System.getProperty("user.dir")+"/features/"+file).getPath()));
        CallContext callContext = new CallContext(null, false);
        Engine.scenario = scenario;
        FeatureResult result = Engine.executeFeatureSync(null, feature, null, callContext);
        File files = Engine.saveResultJson(System.getProperty("user.dir")+"/target/cucumber-report",result,null);
        System.out.println(files.getAbsolutePath());
        if(result.isFailed()){
            throw new Exception(result.getErrors().get(0));
        }
    }
}

