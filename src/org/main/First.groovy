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

   String runScript() {
       def command = this.powershellCommandPrefix + getScriptsDirectory() + this.scriptName
       println command
       def proc = command.execute()
       proc.waitForProcessOutput(System.out, System.err)
   }
}