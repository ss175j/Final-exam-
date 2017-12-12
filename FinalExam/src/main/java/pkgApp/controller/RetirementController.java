package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWork;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML
	private TextField txtSaveEachMonth;
	@FXML
	private TextField txtNeedToSave;


	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@SuppressWarnings("restriction")
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		txtYearsToWork.clear();
		txtAnnualReturnWork.clear();
		txtYearsRetired.clear();
		txtAnnualReturnRetired.clear();
		txtRequiredIncome.clear();
		txtMonthlySSI.clear();
		
		
		//	TODO: Clear all the text inputs
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 
		@SuppressWarnings("restriction")
		private boolean isValid() {
			String errorMessage = "";
		
			if (txtYearsToWork.getText() == null || txtYearsToWork.getText().length() == 0) {
	            errorMessage += "Invalid Years \n"; 
	        } else {
	            
	            try {
	                Integer.parseInt(txtYearsToWork.getText());
	            } catch (NumberFormatException e) {
	                errorMessage += "Invalid Years \n"; 
	            }
	        }
		
			if (txtAnnualReturnWork.getText() == null || txtAnnualReturnWork.getText().length() == 0) {
	            errorMessage += "Invalid Annual Return \n"; 
	        } else {
	            
	            try {
	                double x = Double.parseDouble(txtAnnualReturnWork.getText());
	                if (x > 20 || x < 0) {
	                	errorMessage += "Invalid Annual Return\n ";
	                }
	            } catch (NumberFormatException e) {
	                errorMessage += "Invalid Annual Return \n"; 
	            }
	        } 
		
			  if (txtYearsRetired.getText() == null || txtYearsRetired.getText().length() == 0) {
		            errorMessage += "Invalid Years Retired\n"; 
		        } else {
		           
		            try {
		                Integer.parseInt(txtYearsRetired.getText());
		            } catch (NumberFormatException e) {
		                errorMessage += "Invalid Years Retired \n";
		            }
		        }    
			  if (txtAnnualReturnRetired.getText() == null || txtAnnualReturnRetired.getText().length() == 0) {
		            errorMessage += "Invalid Annual Return on Investment while Retired!\n"; 
		        } else {
		            
		            try {
		                double x = Double.parseDouble(txtAnnualReturnRetired.getText());
		                if (x > 3 || x < 0) {
		                	errorMessage += "Invalid Annual Return Retired\n ";
		                }
		            } catch (NumberFormatException e) {
		                errorMessage += "Invalid Annual Return Retired \n"; 
		            }
		        }        
			  if (txtRequiredIncome.getText() == null || txtRequiredIncome.getText().length() == 0) {
		            errorMessage += "Invalid Required Income\n"; 
		        } else {
		           
		            try {
		                Double.parseDouble(txtRequiredIncome.getText());
		            } catch (NumberFormatException e) {
		                errorMessage += "Invalid Required Income\n"; 
		            }
		        }
			  if (txtMonthlySSI.getText() == null || txtMonthlySSI.getText().length() == 0) {
		            errorMessage += "Invalid Monthly SSI\n"; 
		        } else {
		           
		            try {
		                Double.parseDouble(txtMonthlySSI.getText());
		            } catch (NumberFormatException e) {
		                errorMessage += "Invalid Monthly SSI \n"; 
		            }
		        }
			  if (txtSaveEachMonth.getText().length() != 0) {
		            errorMessage += "SaveEachMonth should be empty"; 
		        } 
		        
		        if (txtNeedToSave.getText().length() != 0) {
		            errorMessage += " need to save should be empty \n"; 
		        } 
		        if(errorMessage.length() ==0) {

					return true;
		        } else {
		          
		            @SuppressWarnings("restriction")
					Alert alert = new Alert(AlertType.ERROR);
		            alert.setTitle("Invalid Fields");
		            alert.setHeaderText("Please correct invalid field");
		            alert.setContentText(errorMessage);

		            alert.showAndWait();

		            return false;
		        }
    }  