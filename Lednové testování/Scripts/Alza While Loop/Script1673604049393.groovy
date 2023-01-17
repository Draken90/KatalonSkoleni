import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'alza.Nakupovani.SpustTest'()

CustomKeywords.'alza.Nakupovani.NakupNejdrazsi'('gamepad')

CenaKosiku = WebUI.getText(findTestObject('Object Repository/spanCenaKosiku'))

Cislo = CenaKosiku.findAll('\\d+').toInteger()

SpojeneCislo = Cislo.join()

CelkovaCena = SpojeneCislo.toInteger()

while (CelkovaCena < CilovaCena) {
    WebUI.setText(findTestObject('Object Repository/inputVyhledavani'), 'pračka')

    WebUI.click(findTestObject('Object Repository/buttonHledat'))

    WebUI.click(findTestObject('Object Repository/buttonOdNejdrazsiho'))

    CenaP = WebUI.getText(findTestObject('Object Repository/spanCenaProduktu'))

    Cislo2 = CenaP.findAll('\\d+').toInteger()

    SpojeneCislo2 = Cislo2.join()

    CenaProduktu = SpojeneCislo2.toInteger()

    zustatek = (CilovaCena - CelkovaCena)

    if (zustatek > CenaProduktu) {
        WebUI.click(findTestObject('Object Repository/buttonKoupitPrvniDostupny'))

        CenaKosiku = WebUI.getText(findTestObject('Object Repository/spanCenaKosiku'))

        Cislo = CenaKosiku.findAll('\\d+').toInteger()

        SpojeneCislo = Cislo.join()

        CelkovaCena = SpojeneCislo.toInteger()
    } else {
        CilovaCena = -1
    }
}

println('Zustatek je ' + zustatek)

