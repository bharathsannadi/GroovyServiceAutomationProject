
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import static com.common.util.Constants.*

reportsDir = "target/geb-reports"
reportOnTestFailureOnly = true
cacheDriverPerThread = true

def envWindows = System.getenv()
def MACOS_BROWSER_ADDINS_DIR = "src/main/resources/browserAddIns/"
def BROWSER_ADDINS_DIR = "src\\main\\resources\\browserAddIns\\"
def WIN_CHROME_DRIVER = "src\\main\\resources\\chromedriver.exe"
def MAC_CHROME_DRIVER ="/Applications/Google Chrome.app/Contents/MacOS/Chrome"


def BROWSER_EXTENSIONS_DIR = (System.properties['os.name'] == 'Mac OS X') ? MACOS_BROWSER_ADDINS_DIR : BROWSER_ADDINS_DIR
def CHROME_DRIVER = (System.properties['os.name'] == 'Mac OS X') ? MAC_CHROME_DRIVER : WIN_CHROME_DRIVER

//Chrome is default
//TODO: Add profile to point to that has the correct download director
System.setProperty("webdriver.chrome.driver", CHROME_DRIVER)
DesiredCapabilities capabilities = new DesiredCapabilities()
ChromeOptions options = new ChromeOptions();
options.addArguments("--start-maximized")
options.addArguments("--disable-extensions");
options.addArguments("--test-type");
options.addArguments("--window-size=1280,800")
capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
capabilities.setCapability("chrome.binary", "src//main//resources//chromedriver");
capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions)

driver = {new ChromeDriver(options)}


//System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Chrome")
 //driver = {new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome())}
//def capabilities = DesiredCapabilities.chrome()
//def options = new ChromeOptions()
//chromeOptions.setExperimentalOptions("download.prompt_for_download", false)



//driver = {new SafariDriver()}


//firefox
firebugPath = BROWSER_EXTENSIONS_DIR + "firebug-1.11.1-fx.xpi"
firePathPath = BROWSER_EXTENSIONS_DIR + "FirePath-0.9.7.xpi"

firefoxProfile = new FirefoxProfile()
firefoxProfile.setPreference("browser.download.folderList", 2)
firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel,application/vnd.ms-visio,application/vnd.excel,application/pdf,application/unknown")
//firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.excel")
firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
firefoxProfile.setPreference("browser.cache.disk.enable",false)
firefoxProfile.setPreference("browser.cache.memory.enable",false)
firefoxProfile.setPreference("browser.cache.offline.enable",false)
firefoxProfile.setPreference("network.http.use-cach",false)
firefoxProfile.setPreference("browser.download.dir", FILE_DOWNLOAD_DIR)
firefoxProfile.addExtension(new File(firebugPath))
firefoxProfile.addExtension(new File(firePathPath))
firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.11.1")
firefoxProfile.setPreference("extensions.firepath.currentVersion", "0.9.7")
//driver = {new FirefoxDriver(firefoxProfile)}

 
autoClearCookies = true
 
baseUrl = "http://ec2-54-69-45-83.us-west-2.compute.amazonaws.com/fitbase/"
 
//internet explorer
/*driver = {
			
  System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe")
            def ieCapabilities = DesiredCapabilities.internetExplorer()
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true)
			new InternetExplorerDriver(ieCapabilities)
      
		}*/
 
waiting {
	timeout = 2
	retryInterval = 2
}

environments {
	// when system property 'geb.env' is set to 'win-ie' use a remote IE driver
	win-ie {
		driver = {
			new RemoteWebDriver(new URL("http://windows.ci-server.local"), DesiredCapabilities.internetExplorer())
		}
	}
	chrome {
	  // def chromeDriver = new File('src/main/resources/chromedriver')
	   // downloadDriver(chromeDriver, "http://chromedriver.googlecode.com/files/chromedriver_mac_23.0.1240.0.zip")
	   // System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
		//driver = { new ChromeDriver()  }
	
	}
	firefox {
		driver = {new FirefoxDriver(firefoxProfile)}
	}
}


