package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTablePage extends Page {
    public By chkSeach = By.xpath("//*[@id = 'searchBox']");
    public By txtRow = By.xpath("//div[@class = 'rt-tr -odd']");
    public By nameRow = By.tagName("//div[@class = 'rt-tr']");
    public By btnAdd = By.id("//*[@id = 'addNewRecordButton']");
    public By txtFirstName = By.id("//*[@id = 'firstName']");
    public By txtLastName = By.id("//*[@id = 'lastName']");
    public By txtEmail = By.id("//*[@id = 'userEmail']");
    public By txtAge = By.id("//*[@id = 'age']");
    public By txtSalary = By.id("//*[@id = 'salary']");
    public By txtDepartment = By.id("//*[@id = 'department']");
    public By btnSubmit = By.id("//*[@id = 'submit']");
    public By txtLine = By.xpath("//div[@class ='rt-tr-group'][1]");

    public WebTablePage(WebDriver dr) {
        super(dr);
    }

    public void clickSearchBox() {
        driver.findElement(chkSeach).click();
    }

    public void inputSearchKeyWord(String keyword) {
        driver.findElement(chkSeach).sendKeys(keyword);
    }

    public boolean isSearchResultCorrect(String keyword) {
        boolean found = false;
        List<WebElement> tableRows = driver.findElements(txtRow);
        for (WebElement row : tableRows) {
            List<WebElement> columns = row.findElements(nameRow);
            for (WebElement column : columns) {
                if (column.getText().contains(keyword)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        return found;
    }
    public void submitNewAccount(String firstName, String lastName, int age, String email, double salary, String department) {
        driver.findElement(btnAdd).click();
        driver.findElement(txtFirstName).sendKeys(firstName);
        driver.findElement(txtLastName).sendKeys(lastName);
        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(txtAge).sendKeys(String.valueOf(age));
        driver.findElement(txtSalary).sendKeys(String.valueOf(salary));
        driver.findElement(txtDepartment).sendKeys(department);
        driver.findElement(btnSubmit).click();
    }

    public boolean isNewAccountAdded(String firstName, String lastName, int age, String email, double salary, String department) {
        boolean found = false;
        List<WebElement> tableRows = driver.findElements(txtRow);
        for (WebElement row : tableRows) {
            WebElement firstNameElement = row.findElement(By.xpath("./td[1]")); // Cột đầu tiên là cột First Name
            WebElement lastNameElement = row.findElement(By.xpath("./td[2]")); // Cột thứ hai là cột Last Name
            WebElement ageElement = row.findElement(By.xpath("./td[3]")); // Cột thứ ba là cột Age
            WebElement emailElement = row.findElement(By.xpath("./td[4]")); // Cột thứ tư là cột Email
            WebElement salaryElement = row.findElement(By.xpath("./td[5]")); // Cột thứ năm là cột Salary
            WebElement departmentElement = row.findElement(By.xpath("./td[6]")); // Cột thứ sáu là cột Department

            String displayedFirstName = firstNameElement.getText();
            String displayedLastName = lastNameElement.getText();
            int displayedAge = Integer.parseInt(ageElement.getText().trim());
            String displayedEmail = emailElement.getText();
            double displayedSalary = Double.parseDouble(salaryElement.getText().trim());
            String displayedDepartment = departmentElement.getText();

            if (displayedFirstName.equals(firstName) && displayedLastName.equals(lastName) &&
                    displayedAge == age && displayedEmail.equals(email) &&
                    displayedSalary == salary && displayedDepartment.equals(department)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
