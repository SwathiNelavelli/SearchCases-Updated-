@Specific
Feature: Verify the Search Cases

Background: 
 Given user enter easytox url for Search Cases
  And enter username as "username" for Search Cases
	And enter password as "password" for Search Cases
	And user click on "Login" button for Search Cases

  Scenario Outline: Verify that user can search for any case by entering search criteria
  When Enter a valid first name in the "<First Name>" field and click 'Search'
  Then All the cases with matching entered first name "<First Name>" should be displayed in the Search Results
   
  When Enter a valid last name in the "<Last Name>" field and click 'Search'
  Then All the cases with matching entered last name "<Last Name>" should be displayed in the Search Results
  
  When Enter a valid DOB in the "<Date of Birth>" field in MM/DD/YYYY format and click 'Search'
  Then All the cases with matching DOB "<Date of Birth>" should be displayed in the Search Results
  
  When Select a Status from the "<Select Status>" drop down and click 'Search'
  Then All the cases in selected status "<Select Status>" should be displayed in the Search Results (Need to Implement)
  
  When Select a Physician from the "<Select Physician>" drop down and click 'Search'
  Then All the cases related to selected physician "<Select Physician>" should be displayed in the Search Results (Need to Implement)
  
  When Enter a valid Case Number in "<Case AccNo>" and click 'Search'
  Then Matching Case Number "<Case AccNo>" should be displayed in the  Search Results
  
  When Enter a valid Medical Record Number in "<Medical RecNo>" and click 'Search'
  Then Matching case "<Medical RecNo>" should be displayed in the Search Results
  
  When Enter values in multiple fields "<First Name>", "<Case AccNo>", "<Medical RecNo>" and click 'Search'
  Then Cases matching all the entered conditions "<First Name>", "<Case AccNo>", "<Medical RecNo>" should be displayed in the Search Results 
  
  When Click Search without entering values in any field
  And All the cases should be displayed in the Search Results (Need to Implement)
  Then Close the Search Cases browser
  Examples:
  |First Name|Last Name|Date of Birth|Select Status|Select Physician|Case AccNo|Medical RecNo|
  |white|apple|05/12/1994|InProcess|Tom Physician|PA17-05|45454|
  
  Scenario Outline: Verify the actions performed against each case in the Search Results
  When Enter any search criteria "<SearchCriteria>" in search box of Case List page
  Then Matching case with entered search criteria "<SearchCriteria>" should be populated in the case list
  
  When Click on Case Accession number for matching search criteria "<SearchCriteria>"
  Then Update Case screen should be displayed for editing
  
  When Case Status is "Ready for Scientist/Processing", "Delete Order" button should be displayed against the case
  Then Click "Delete Order" button,Case gets deleted after receiving confirmation from the user
  
  When Case Status is "Finalized", "Edit Icon" should be displayed for the case
  Then  Click "Edit Icon", Two options are displayed: "Case Correction & Case Revision"
  
  When Select "Case Correction" option
  Then Case screen "Reason for Amendment" should be displayed for editing
  
  When Select 'Case Revision' option
  And Case screen 'Reason for Amendment' should be displayed for editing
  Then Close the Search Cases browser
  Examples:
  |SearchCriteria|
  |mart|
  
  Scenario Outline: Verify the Detail search
  When Click 'Detail Search' button in the 'Find Case' section
  Then 'Detail Search' page with additional search options along with all cases is displayed
  
  When Enter a valid patient last name in the "<Patient Last Name>" field and click 'Search' in 'Detail Search' page table
  Then Matching cases with entered patient last name "<Patient Last Name>" should be displayed in 'Detail Search' page table
  
  When Enter a valid patient first name in the "<Patient First Name>" field and click 'Search' in 'Detail Search' page table
  Then Matching cases with entered patient first name "<Patient First Name>" should be displayed in 'Detail Search' page table
  
  When Enter a valid patient Accession in the "<Accession>" field and click 'Search' in 'Detail Search' page table
  Then Matching cases with entered patient Accession "<Accession>" should be displayed in 'Detail Search' page table
  
  When Enter a valid patient medical record in the "<Medical Record>" field and click 'Search' in 'Detail Search' page table
  Then Matching cases with entered patient medical record "<Medical Record>" should be displayed in 'Detail Search' page table
   
  When Enter a valid patient date of birth in the "<Date Of Birth>" field and click 'Search' in 'Detail Search' page table
  Then Matching cases with entered patient date of birth "<Date Of Birth>" should be displayed in 'Detail Search' page table
  
  When Enter a valid patient status in the "<Status>" field and click 'Search' in 'Detail Search' page table
  Then Matching cases with entered patient status "<Status>" should be displayed in 'Detail Search' page table
  
  When Enter any search criteria "<SearchCriteria>" in 'Detail Search' page search box
  Then Matching cases with entered search criteria "<SearchCriteria>" should be populated in the 'Detail Search' page table
  
  When Click Case Accession number for matching search criteria "<SearchCriteria>" in the 'Detail Search' page
  Then Update Case screen should be displayed for editing
    
  When Case Status is "Ready for Scientist/Processing", "Delete Order" button should be displayed against the case
  Then Click "Delete Order" button,Case gets deleted after receiving confirmation from the user
  
  When Case Status is "Finalized", "Edit Icon" should be displayed for the case
  Then Click "Edit Icon", Two options are displayed: "Case Correction & Case Revision"
  
  When Select "Case Correction" option
  Then Case screen "Reason for Amendment" should be displayed for editing
  
  When Select 'Case Revision' option
  Then Case screen 'Reason for Amendment' should be displayed for editing
  
  When Verify the Report column for 'Finalized' cases , PDF icon should be displayed for viewing the report(Need to Implement)
  Then Upon clicking the PDF icon, case report should be displayed(Need to Implement)
  
  When Click 'Create New Case' icon on the top 
  And User navigates to 'Create New Case' screen
  Then Close the Search Cases browser
  Examples:
  |Patient Last Name|Patient First Name|Accession|Medical Record|Date Of Birth|Status|SearchCriteria|
  |apple|white|PA17-05|45454|05/12/1994|Inprocess|mart|
  
  
  
  
  
  
  
  