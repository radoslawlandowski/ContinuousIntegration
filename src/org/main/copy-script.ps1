param([string] $fileName, [string] $source, [string] $destination)

Write-Output "############ script.ps1 execution start... ############"
Write-Output "############ with arguments: -fileName: '$($fileName)' -source: '$($source)' -destination: '$($destination)' ############"

function checkIfExists($path) {
    return Test-Path $path
}

function PathsExist($pathsToCheck) {
    For($i = 0 ; $i -lt $pathsToCheck.Count ; $i++) {
        if(-NOT (checkIfExists($pathsToCheck[$i]))) {
            Write-Error "The path '$($pathsToCheck[$i])' doesn't exist!"
            throw "WRONG PATH!"
        }
    }
}

function CopyFile($fileName, $source, $destination) {
    PathsExist(@($source, $destination))

    $sourcePath = $($source + $fileName)


    Write-Output "Copying file '$($sourcePath)' to '$($destination)'"
    Copy-Item -Path $sourcePath -Destination $destination
}

CopyFile $fileName $source $destination

Write-Output "############ script.ps1 execution finish... ############"


