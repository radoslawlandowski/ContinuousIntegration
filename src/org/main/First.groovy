package org.main;

class First {
   String copyScript = "./src/org/main/copy-script.ps1"

   String runScript(scriptInvocation) {
        def command = "powershell ${scriptInvocation}"

        def sw = new StringWriter()

        Process p = command.execute()
        p.consumeProcessOutputStream(sw)
        p.waitForOrKill(100000)

        def processOutput = sw.toString()

        return processOutput
   }

   String runCopyScript(filename, source, dest) {
       def copyScriptWithArgs = "${copyScript} \"${filename}\" \"${source}\" \"${dest}\" *> \"copy-script.log\""

       println copyScriptWithArgs

       return runScript(copyScriptWithArgs)
   }
}