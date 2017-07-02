// vars/acme.groovy

class Globals implements Serializable {
    private String name
    
    def setName(value) {
        name = value
    }
    def getName() {
        name
    }
    def caution(message) {
        return "Hello, ${name}! CAUTION: ${message}"
    }
}