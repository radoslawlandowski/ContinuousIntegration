package org.main;

class First {
   String copyScript = "/var/lib/jenkins/workspace/ContinuousIntegrationExperiments/src/org/main/copy-script.ps1"
   
   String getRootDirectory() {
       return new File("").getAbsolutePath();
   }

   String getScriptsDirectory() {
       def rootDir = getRootDirectory()
       def scriptsDir = rootDir + "/src/org/main/"

       return scriptsDir
   }

   String runScript(scriptInvocation) {

        def command = "powershell ${scriptInvocation}\""

        def sw = new StringWriter()

        Process p = command.execute()
        p.consumeProcessOutputStream(sw)
        p.waitForOrKill(100000)

        def processOutput = sw.toString()

        return processOutput
   }

   String runCopyScript(filename, source, dest) {
       def copyScriptWithArgs = "$copyScript $filename $source $dest"

       return runScript(copyScriptWithArgs)
   }
}