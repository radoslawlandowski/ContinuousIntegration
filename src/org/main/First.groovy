package org.main;

class First {
   String powershellCommandPrefix = "powershell "
   String scriptName = "script.ps1"
   
   String getRootDirectory() {
       return new File("").getAbsolutePath();
   }

   String getScriptsDirectory() {
       def rootDir = getRootDirectory()
       def scriptsDir = rootDir + "/src/org/main/"

       return scriptsDir
   }

   String runScript(command) {
        def sw = new StringWriter()

        Process p = command.execute()
        p.consumeProcessOutputStream(sw)
        p.waitForOrKill(100000)

        def processOutput = sw.toString()
        println processOutput
        return processOutput
   }
}