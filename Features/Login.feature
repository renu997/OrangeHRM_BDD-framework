Feature: Login with Valid Credentials

@sanity
 Scenario:Successful Login with Valid Credentials
  Given User Launch browser
  And opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  When User navigate to Login page
  And User enters username as "Admin" and password as "admin123"
  And Click on Login button
  Then User navigate to Home page