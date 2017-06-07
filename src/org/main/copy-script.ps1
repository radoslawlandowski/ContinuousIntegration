param([string] $fileName, [string] $source, [string] $destination)

Write-Host "############ script.ps1 execution start... ############" -Foreground "magenta"
Write-Host "############ with arguments: -fileName: '$($fileName)' -source: '$($source)' -destination: '$($destination)' ############"

function checkIfExists($path) {
    return Test-Path $path
}

function PathsExist($pathsToCheck) {
    For($i = 0 ; $i -lt $pathsToCheck.Count ; $i++) {
        if(-NOT (checkIfExists($pathsToCheck[$i]))) {
            throw "The path '$($pathsToCheck[$i])' doesn't exist!"
        }
    }
}

function CopyFile($fileName, $source, $destination) {
    PathsExist(@($fileName, $source, $destination))

    $sourcePath = $($source + $fileName)


    Write-Host "Copying file '$($sourcePath)' to '$($destination)'"
    Copy-Item -Path $sourcePath -Destination $destination
}

CopyFile $fileName $source $destination

Write-Host "############ script.ps1 execution finish... ############" -Foreground "magenta"


