import jenkins.model.*;
import hudson.model.*;
def folderName = "TestRun_2016-07-08_22-48-58-PM";
def pa = new ParametersAction([
new StringParameterValue("FOLDERNAME_QA_JOB", folderName)
])
Thread.currentThread().executable.addAction(pa);